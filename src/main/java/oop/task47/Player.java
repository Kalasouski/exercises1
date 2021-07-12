package oop.task47;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class Player implements ISaveable {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String weapon = "Sword";
    @Getter
    @Setter
    private int hitPoints;
    @Getter
    @Setter
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        return Arrays.asList(name, weapon, String.valueOf(hitPoints), String.valueOf(strength));
    }

    @Override
    public void read(List<String> list) {
        if (list.size() != 4)
            throw new IllegalArgumentException("List size must be 4");
        this.name = list.get(0);
        this.weapon = list.get(1);
        this.hitPoints = Integer.parseInt(list.get(2));
        this.strength = Integer.parseInt(list.get(3));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
