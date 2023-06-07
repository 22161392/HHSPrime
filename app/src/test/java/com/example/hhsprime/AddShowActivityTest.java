package com.example.hhsprime;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddShowActivityTest {

    @Test
    void testStringNotEmptyNoNumbers() {
        // Arrange
        AddShowActivity addShowActivity = new AddShowActivity();
        String testString = "l33t";

        // Act
        boolean result = addShowActivity.stringNotEmptyNoNumbers(testString);

        // Assert
        Assertions.assertFalse(result);
    }
}