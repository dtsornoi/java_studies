package com.homework.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UserValidatorTest {
    @Test
    public void mustValidateCorrectEmail(){
        //given
        UserValidator userValidator = new UserValidator("test@test.com", "test.another@test.com");

        //when
        String actual = userValidator.getEmail();
        String expected = "test@test.com";

        String actual2 = userValidator.getAlternativeEmail();
        String expected2 = "test.another@test.com";

        //then
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void mustReturnUnknownWhenFirstIsNullAndSecondIsEmpty(){
        //given
        UserValidator userValidator = new UserValidator(null, "");

        //when
        String actual = userValidator.getEmail();
        String expected = "unknown";

        String actual2 = userValidator.getAlternativeEmail();
        String expected2 = "unknown";

        //then
        assertEquals(expected, actual);
        assertEquals(expected2, expected2);
    }
}