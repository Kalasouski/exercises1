package oop.task32;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Setter
    @Getter
    private int x;
    @Setter
    @Getter
    private int y;

    public double distance(int x, int y) {
        return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
    }

    public double distance(Point p) {
        return distance(p.x,p.y);
    }

    public double distance() {
        return distance(0,0);
    }


}
