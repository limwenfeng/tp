package seedu.duke.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.CheckInCommand;
import seedu.duke.commands.CheckoutCommand;
import seedu.duke.commands.ClearCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.FindCommand;
import seedu.duke.commands.ListCheckedInCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.common.Messages;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.NoArgumentPassedException;
import seedu.duke.exceptions.PersonNotFoundException;
import seedu.duke.exceptions.WrongFlagException;
import seedu.duke.person.Id;
import seedu.duke.person.Name;
import seedu.duke.person.Phone;

import java.util.Locale;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.testutil.SamplePersons.JOHN;
import static seedu.duke.testutil.SamplePersons.JOHN_DIFF_ID;
import static seedu.duke.testutil.SamplePersons.JOHN_NO_PHONE;
import static seedu.duke.testutil.SampleTrackingList.SAMPLE_TRACKING_LIST;

public class ParserTest {




    @Test
    public void checkInParser_parsedCorrectly() {
        String name = JOHN.getName().getNameString().toLowerCase();
        String id = JOHN.getId().getIdString();
        String[] result = {name,id};

        assertArrayEquals(Parser.splitTextIntoTwoFields("John 123A"), result);

    }

    @Test
    public void parseCommand_checker() throws NoArgumentPassedException, WrongFlagException, InvalidCommandException {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                Parser.parseCommand("checkin"));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }



    @Test
    public void parseCheckIn_noName() throws WrongFlagException, NoArgumentPassedException {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                Parser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckIn_Exceptions() {
        Throwable exception = assertThrows(WrongFlagException.class, () ->
                Parser.parseCheckIn("n/Jon 123"));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);

        exception = assertThrows(NoArgumentPassedException.class, () ->
                Parser.parseCheckIn(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);
    }

    @Test
    public void parseCheckIn_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckInCommand checkInCommand = (CheckInCommand) Parser.parseCommand("checkin n/ John i/ 123A");
        assertEquals("checkin", checkInCommand.COMMAND);

        checkInCommand = (CheckInCommand) Parser.parseCommand("checkin n/John i/123A p/12345678");
        assertEquals("checkin", checkInCommand.COMMAND);
    }

    @Test
    public void parseCheckOut_Exceptions() {
        Throwable exception = assertThrows(NoArgumentPassedException.class, () ->
                Parser.parseCheckOut(""));
        assertEquals(exception.getMessage(), Messages.NO_ARGUMENT);

    }

    @Test
    public void parseCheckOut_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        CheckoutCommand checkoutCommand = (CheckoutCommand) Parser.parseCommand("checkout n/John i/123A");
        assertEquals("checkout", checkoutCommand.COMMAND);
        checkoutCommand = (CheckoutCommand) Parser.parseCommand("checkout i/123A");
        assertEquals("checkout", checkoutCommand.COMMAND);
    }

    @Test
    public void parseFindException_checker() {
        Throwable exception = assertThrows(WrongFlagException.class, () ->
                Parser.parseFind(""));
        assertEquals(exception.getMessage(), Messages.WRONG_FLAG);
    }

    @Test
    public void parseFind_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        Parser.parseCommand("checkin n/Jon i/123A");
        FindCommand findCommand = (FindCommand) Parser.parseCommand("find i/123A");
        assertEquals("find", findCommand.COMMAND);
    }

    @Test
    public void parseList_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ListCommand listCommand = (ListCommand) Parser.parseCommand("listall");
        assertEquals("listall", listCommand.COMMAND);
    }

    @Test
    public void parseListCheckedOut_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ListCheckedInCommand listCheckedInCommand = (ListCheckedInCommand) Parser.parseCommand("list");
        assertEquals("list", listCheckedInCommand.COMMAND);
    }

    @Test
    public void parseExit_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ExitCommand exitCommand = (ExitCommand) Parser.parseCommand("exit");
        assertEquals("exit", ExitCommand.COMMAND);
    }

    @Test
    public void parseClear_testCommand() throws NoArgumentPassedException,
            WrongFlagException, InvalidCommandException {
        ClearCommand clearCommand = (ClearCommand) Parser.parseCommand("clear");
        assertEquals("clear", ClearCommand.COMMAND);
    }

    @Test
    public void parseWrongCommand_Exception() {
        Throwable exception = assertThrows(InvalidCommandException.class, () ->
                Parser.parseCommand(""));
        assertEquals(exception.getMessage(), Messages.INVALID_COMMAND);
    }
}
