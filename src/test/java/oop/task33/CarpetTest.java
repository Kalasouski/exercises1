package oop.task33;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarpetTest {
    @ParameterizedTest(name = "When cost={0} then exception")
    @ValueSource(doubles = {-1,-100})
    void givenCarpetConstructorWhenSettingNegativeValueThenThrowsException(double cost) {
        assertThrows(IllegalArgumentException.class, () -> new Carpet(cost));
    }
}