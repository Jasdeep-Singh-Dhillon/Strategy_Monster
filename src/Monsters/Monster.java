package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {

    private Integer hp;
    private Integer xp;
    Integer agi;
    Integer def;
    Integer str;
    Attack attack;
    private Integer maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
        agi = 10;
        def = 10;
        str = 10;
    }

    public Integer attackTarget(Monster target) {
        Integer damage = attack.attack(target);
        if(hp > 0) {
            target.takeDamage(damage);

        } else {
            target.takeDamage(0);
            damage = 0;
        }
        return damage;
    }

    boolean takeDamage(Integer attack) {
        if(attack > 0) {
            hp = hp - attack;
            System.out.println("The creature was hit for " + attack + " damage");

            if (hp <= 0) {
                hp = 0;
                System.out.println("Oh no! the creature has perished");
            }
        }
        System.out.println(this);
        return hp>0;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getAgility() {
        return agi;
    }

    public Integer getDefense() {
        return def;
    }

    public Integer getStrength() {
        return str;
    }

    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(getHp(), monster.getHp()) && Objects.equals(getXp(), monster.getXp()) && Objects.equals(agi, monster.agi) && Objects.equals(def, monster.def) && Objects.equals(str, monster.str) && Objects.equals(attack, monster.attack) && Objects.equals(getMaxHP(), monster.getMaxHP()) && Objects.equals(getItems(), monster.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHp(), getXp(), agi, def, str, attack, getMaxHP(), getItems());
    }

    @Override
    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }
}
