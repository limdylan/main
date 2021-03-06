package seedu.address.logic.parser.slot;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PET;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.slot.DeleteSlotCommand;

class DeleteSlotParserTest {

    private DeleteSlotParser parser = new DeleteSlotParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new DeleteSlotCommand(INDEX_FIRST_PET));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSlotCommand.MESSAGE_USAGE));
    }
}
