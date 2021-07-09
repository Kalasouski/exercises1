package oop.task35;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @ParameterizedTest(name = "When radius={0} then exception")
    @ValueSource(doubles = {-1, -100})
    void givenCircleConstructorWhenSettingNegativeValueThenThrowsException(double radius) {
        assertThrows(IllegalArgumentException.class, () -> new Circle(radius));
    }
}