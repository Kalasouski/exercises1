package oop.task31;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Wall {
    @Getter
    double width;
    @Getter
    double height;

    public Wall(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        if (width < 0)
            this.width = 0;
        else
            this.width = width;
    }

    public void setHeight(double height) {
        if (height < 0)
            this.height = 0;
        else
            this.height = height;
    }

    public double getArea() {
        return width*height;
    }
}
