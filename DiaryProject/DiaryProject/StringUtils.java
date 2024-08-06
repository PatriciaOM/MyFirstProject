package DiaryProject;

import java.util.Scanner;

public class StringUtils {
    // String that uses in all program
    protected static final String HEADER = "************************************************************************";
    protected static final String ERROR = "An error has occurred";
    protected static final String YES_NO = "Yes or no";
    protected static final String YES = "yes";
    protected static final String NO = "no";
    protected static final String ARRAY_ERROR = "Your Diary is empty";
    protected static final String DAY_EMPTY = "This day is empty";
    protected static final String NO_IMPORTANT_EVENTS = "You don't have important events";
    protected static final String NO_NORMAL_EVENTS = "You don't have normal events";
    protected static final String NEW_EVENT = "Would you like introduce new event?";
    protected static final String LIKE_TO_DO = "What do you would like to do? Introduce the number: \n";
    protected static final String MENU_OPTIONS = LIKE_TO_DO + "\t1. Create new event\n"
            + "\t2. Consult events\n\t3. Exit";
    protected static final String SUBMENU_OPTIONS = LIKE_TO_DO + "\t1. View important events\n\t2. View normal events \n\t3. View all events \n\t4. View events by day\n\t5. Return to main menu";
    protected static final String MENU_ONE = "Create event";
    protected static final String MENU_TWO = "Consult event";
    protected static final String ENTER_DESCRIPTION = "Introduce the description of the event you want to set:";
    protected static final String ENTER_DAY = "What day is the event? The correct format is: yyyy-mm-dd";
    protected static final String ENTER_HOUR = "What hour? The correct format is: hh:mm";
    protected static final String ENTER_PRIORITY = "Is this an important event? ";
    protected static final String ONLY_IMPORTANT = "Do you want to view only important events? " + YES_NO;
    protected static final String FINISH_ENTER_EVENT = "Ok. Finishing enter new events.";
    protected static final String DATE_PATTERN = "'The date is setted at: 'E', 'yyyy'/'MM'/'dd', 'kk':'mm'h'";
    protected static final String DATE_HOUR_FAILS = ": Date or hour invalid";
    protected static final String OPTION_INVALID = ": Option invalid";
    protected static final String WRONG_YEAR = "We cannot set event for another year";
    protected static final String RETURN_MAIN_MENU = "Do you want to return to the main menu? " + YES_NO;
    protected static final String NORMAL_COLOUR = "Green";
    protected static final String IMPORTANT_COLOUR = "Red";
    protected static final String FINISH_PROGRAM = "Finishing program";

    public static boolean checkString(String text) { // checking if string is not null or empty
        boolean ok = false;
        if (text != null && text.length() != 0) {
            ok = true;
        } else {
            System.out.println(ERROR);
        }
        return ok;
    }

    public static String askForString(String text_message, Scanner scan) { // asking for string
        String userString;
        do {
            System.out.println(text_message);
            userString = scan.nextLine();
        } while (!checkString(userString));
        return userString;
    }
}
