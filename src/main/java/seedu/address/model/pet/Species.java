package seedu.address.model.pet;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Pet's Species in the pet shop helper.
 * Guarantees: immutable; is valid as declared in {@link #isValidSpecies(String)}
 */
public class Species {

    public static final String MESSAGE_CONSTRAINTS =
            "Species should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the species must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String species;

    /**
     * Constructs a {@code Species}.
     *
     * @param species A valid species name.
     */
    public Species(String species) {
        requireNonNull(species);
        checkArgument(isValidSpecies(species), MESSAGE_CONSTRAINTS);
        this.species = species;
    }

    /**
     * Returns true if a given string is a valid species.
     */
    public static boolean isValidSpecies(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return species;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Species // instanceof handles nulls
                && species.equals(((Species) other).species)); // state check
    }

    @Override
    public int hashCode() {
        return species.hashCode();
    }

}
