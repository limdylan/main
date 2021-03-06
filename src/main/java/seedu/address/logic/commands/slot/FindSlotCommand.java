package seedu.address.logic.commands.slot;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.general.Command;
import seedu.address.logic.commands.general.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.slot.Slot;
import seedu.address.ui.DisplaySystemType;

/**
 * Finds and lists all slots in the schedule whose contents contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindSlotCommand extends Command {

    public static final String COMMAND_WORD = "findslots";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all slots where pet name matches exactly "
            + "(case-insensitive) or slots that is within the date specified (ignoring timing) and displays them as a "
            + "list with index numbers.\n"
            + "Parameters: [n/PET NAME] [t/DATE [MORE DATES]...]\n"
            + "Example: " + COMMAND_WORD + " n/garfield t/10/11/2020 5/12/2020";

    public static final String MESSAGE_EMPTY_NAME_FIELD = "n/ should not be followed by an empty entry!";

    public static final String MESSAGE_EMPTY_DATETIME_FIELD = "t/ should not be followed by an empty entry!";

    private final Predicate<Slot> predicate;
    private String warningMessage;

    public FindSlotCommand(Predicate<Slot> predicate, String warningMessage) {
        this.predicate = predicate;
        this.warningMessage = warningMessage;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredSlotList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_SLOTS_LISTED_OVERVIEW, model.getFilteredSlotList().size())
                        + warningMessage, false, false, DisplaySystemType.SCHEDULE, false);

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindSlotCommand // instanceof handles nulls
                && predicate.equals(((FindSlotCommand) other).predicate))
                && warningMessage.equals(((FindSlotCommand) other).warningMessage); // state check
    }
}
