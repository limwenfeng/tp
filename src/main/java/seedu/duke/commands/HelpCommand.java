package seedu.duke.commands;

import seedu.duke.person.TrackingList;

import static seedu.duke.common.Messages.CHECKIN_HELP;
import static seedu.duke.common.Messages.CHECKOUT_HELP;
import static seedu.duke.common.Messages.CLEAR_HELP;
import static seedu.duke.common.Messages.EDIT_CAPACITY_HELP;
import static seedu.duke.common.Messages.EXIT_HELP;
import static seedu.duke.common.Messages.FIND_BY_ID_HELP;
import static seedu.duke.common.Messages.LIST_ALL_HELP;
import static seedu.duke.common.Messages.LIST_CHECKED_IN_HELP;
import static seedu.duke.common.Messages.USER_GUIDE_LINK_HELP;

public class HelpCommand extends Command {

    public static final String COMMAND = "help";
    public static final String HELP_MESSAGE = "COMMAND SUMMARY:\n" + CHECKIN_HELP + System.lineSeparator()
            + LIST_ALL_HELP + System.lineSeparator() + LIST_CHECKED_IN_HELP + System.lineSeparator()
            + FIND_BY_ID_HELP + System.lineSeparator() + CHECKOUT_HELP + System.lineSeparator()
            + CLEAR_HELP + System.lineSeparator() + EDIT_CAPACITY_HELP + System.lineSeparator()
            + EXIT_HELP + System.lineSeparator() + USER_GUIDE_LINK_HELP + System.lineSeparator();

    @Override
    public CommandOutput execute(TrackingList trackingList) {
        return new CommandOutput(HELP_MESSAGE, COMMAND);
    }

}
