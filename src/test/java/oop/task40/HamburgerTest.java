package oop.task40;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HamburgerTest {
    @ParameterizedTest
    @MethodSource
    void givenItemizeHamburgerMethodWhenSettingDifferentAdditionsThenReturnsCorrespondingTotalPrice(String name,
                                                                                                    String meat,
                                                                                                    String breadRollType,
                                                                                                    double price,
                                                                                                    String name1,
                                                                                                    double price1,
                                                                                                    String name2,
                                                                                                    double price2,
                                                                                                    String name3,
                                                                                                    double price3,
                                                                                                    String name4,
                                                                                                    double price4,
                                                                                                    double expectedPrice
    ) {
        Hamburger hamburger = new Hamburger(name, meat, breadRollType, price);
        hamburger.addHamburgerAddition1(name1, price1);
        hamburger.addHamburgerAddition2(name2, price2);
        hamburger.addHamburgerAddition3(name3, price3);
        hamburger.addHamburgerAddition4(name4, price4);
        assertEquals(expectedPrice, hamburger.itemizeHamburger());
    }

    private static Stream<Arguments> givenItemizeHamburgerMethodWhenSettingDifferentAdditionsThenReturnsCorrespondingTotalPrice() {
        return Stream.of(
                arguments("BigMac", "ham", "wheat", 8.5, "Cheese", 0.5, "", 0, "", 0, "", 0, 9.0),
                arguments("BigNasty", "chicken", "wheat", 10.5, "Cheese", 0.5, "", 0, "", 0, "", 0, 11.0)
        );
    }
}