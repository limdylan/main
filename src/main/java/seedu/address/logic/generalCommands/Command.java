package seedu.address.logic.generalCommands;

import seedu.address.logic.generalCommands.exceptions.CommandException;
import seedu.address.model.PshModel;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute(PshModel model) throws CommandException;

}