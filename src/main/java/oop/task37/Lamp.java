package oop.task37;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Lamp {
    @Getter
    private final String style;
    @Getter
    private final boolean battery;
    @Getter
    private final int globRating;

    public String turnOn() {
        return "The lamp is turned on";
    }


}
