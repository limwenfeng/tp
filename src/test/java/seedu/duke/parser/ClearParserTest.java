package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.ClearCommand;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidIdException;
import seedu.duke.exceptions.InvalidIntegerException;
import seedu.duke.exceptions.InvalidNameFormatException;
import seedu.duke.exceptions.InvalidPhoneNumberException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.exceptions.WrongFlagException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearParserTest {

    Parser parser = new Parser();

    @Test
    public void parseClear_testCommand() throws NoArgumentPassedException,

            WrongFlagException, InvalidCommandException, InvalidIdException,
            InvalidPhoneNumberException, InvalidNameFormatException,
            StorageOperationException, InvalidIntegerException, PersonNotFoundException {

        ClearCommand clearCommand = (ClearCommand) parser.parseCommand("clear");
        assertEquals("clear", ClearCommand.COMMAND);
    }
}
