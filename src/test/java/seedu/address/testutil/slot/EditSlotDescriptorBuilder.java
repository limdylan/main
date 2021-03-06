package seedu.address.testutil.slot;

import static seedu.address.commons.util.DateTimeUtil.DATETIME_FORMAT;
import static seedu.address.testutil.pet.TypicalPets.getTypicalPetTracker;

import java.time.Duration;
import java.time.LocalDateTime;

import seedu.address.logic.commands.slot.EditSlotCommand.EditSlotDescriptor;
import seedu.address.model.PetTracker;
import seedu.address.model.pet.Name;
import seedu.address.model.slot.Slot;

/**
 * A utility class to help with building EditSlotDescriptor objects.
 */
public class EditSlotDescriptorBuilder {

    private PetTracker typicalPetTracker = getTypicalPetTracker();
    private EditSlotDescriptor descriptor;

    public EditSlotDescriptorBuilder() {
        descriptor = new EditSlotDescriptor();
    }

    public EditSlotDescriptorBuilder(EditSlotDescriptor descriptor) {
        this.descriptor = new EditSlotDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditSlotDescriptor} with fields containing {@code pet}'s details
     */
    public EditSlotDescriptorBuilder(Slot slot) {
        descriptor = new EditSlotDescriptor();
        descriptor.setPet(slot.getPet());
        descriptor.setDateTime(slot.getDateTime());
        descriptor.setDuration(slot.getDuration());
    }

    /**
     * Sets the {@code Pet} of the {@code EditSlotDescriptor} that we are building.
     */
    public EditSlotDescriptorBuilder withPet(String name) {
        descriptor.setPet(typicalPetTracker.getPet(new Name(name)));
        return this;
    }

    /**
     * Sets the {@code LocalDateTime} of the {@code EditSlotDescriptor} that we are building.
     */
    public EditSlotDescriptorBuilder withDateTime(String dateTime) {
        descriptor.setDateTime(LocalDateTime.parse(dateTime, DATETIME_FORMAT));
        return this;
    }

    /**
     * Sets the {@code Duration} of the {@code EditSlotDescriptor} that we are building.
     */
    public EditSlotDescriptorBuilder withDuration(String dateOfBirth) {
        descriptor.setDuration(Duration.ofMinutes(Long.parseLong(dateOfBirth)));
        return this;
    }

    public EditSlotDescriptor build() {
        return descriptor;
    }
}
