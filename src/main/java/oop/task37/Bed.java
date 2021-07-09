package oop.task37;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Bed {
    @Getter
    private final String style;
    @Getter
    private final int pillows;
    @Getter
    private final int height;
    @Getter
    private final int sheets;
    @Getter
    private final int quilt;

    public String make() {
        return "The bed is ready";
    }
}
