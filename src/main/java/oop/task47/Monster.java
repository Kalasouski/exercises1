package oop.task47;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Monster implements ISaveable {
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    int hitPoints;
    @Getter
    @Setter
    int strength;

    @Override
    public List<String> write() {
        return Arrays.asList(name,String.valueOf(hitPoints),String.valueOf(strength));
    }

    @Override
    public void read(List<String> list) {
        if(list==null)
            throw new NullPointerException("list must be non-null");
        if(list.size()!=3)
            throw new IllegalArgumentException("List size must be 3");
        this.name = list.get(0);
        this.hitPoints = Integer.parseInt(list.get(1));
        this.strength = Integer.parseInt(list.get(2));
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}