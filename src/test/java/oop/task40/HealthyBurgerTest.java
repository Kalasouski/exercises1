package oop.task40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HealthyBurgerTest {
    @ParameterizedTest
    @MethodSource
    void givenItemizeHamburgerMethodWhenSettingDifferentAdditionsThenReturnsCorrespondingTotalPrice(String meat,
                                                                                                    double price,
                                                                                                    String name1,
                                                                                                    double price1,
                                                                                                    String name2,
                                                                                                    double price2,
                                                                                                    double expectedPrice
    ) {
        HealthyBurger hamburger = new HealthyBurger(meat, price);
        hamburger.addHealthyAddition1(name1, price1);
        hamburger.addHealthyAddition2(name2, price2);
        assertEquals(expectedPrice, hamburger.itemizeHamburger());
    }

    private static Stream<Arguments> givenItemizeHamburgerMethodWhenSettingDifferentAdditionsThenReturnsCorrespondingTotalPrice() {
        return Stream.of(
                arguments("ham", 5.0, "Salad", 0.4, "Bacon", 0.3, 5.7)
        );
    }
}