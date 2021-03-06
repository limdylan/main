package seedu.address.model.pet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class DateOfBirthTest {

    @Test
    void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DateOfBirth(null));
    }

    @Test
    void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new DateOfBirth(invalidDate));
    }

    @Test
    void isValidDateOfBirth() {
        // Non-dates
        assertFalse(DateOfBirth.isValidDateOfBirth(" ")); // just empty space
        assertFalse(DateOfBirth.isValidDateOfBirth("not a date")); // a sentence

        // Badly formatted dates
        assertFalse(DateOfBirth.isValidDateOfBirth("7-Mar-2020")); // d MMM yyyy
        assertFalse(DateOfBirth.isValidDateOfBirth("2020-03-10")); // yyyy mm dd
        assertFalse(DateOfBirth.isValidDateOfBirth("10-3-20")); // d-M-yy
        assertFalse(DateOfBirth.isValidDateOfBirth("7_3_2020")); // bad seperator
        assertFalse(DateOfBirth.isValidDateOfBirth("7-3-2020")); // bad seperator
        assertFalse(DateOfBirth.isValidDateOfBirth("2020")); // year only
        assertFalse(DateOfBirth.isValidDateOfBirth("7-3")); // date and month only

        // Good dates
        assertTrue(DateOfBirth.isValidDateOfBirth("7/3/2020")); // d/M/yyyy
        assertTrue(DateOfBirth.isValidDateOfBirth("07/03/2020")); // dd/MM/yyyy
        assertTrue(DateOfBirth.isValidDateOfBirth("7/03/2020")); // d/MM/yyyy
        assertTrue(DateOfBirth.isValidDateOfBirth("07/3/2020")); // dd/M/yyyy
    }
}
