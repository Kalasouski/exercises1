package oop.task37;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Bedroom {
    @Getter
    private final String name;

    @Getter
    private final Wall wall1, wall2, wall3, wall4;

    @Getter
    private final Ceiling ceiling;

    @Getter
    private final Bed bed;

    @Getter
    private final Lamp lamp;

    private String makeBed(){
        return "The bad is being made\n"+bed.make();
    }
}
