package DiaryProject;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class for managing the option 2 in main menu.
 */
public class MenuTwo {
    private static final int FIRST_POSITION = 0;

    /**
     * Manages option 1 in submenu. Shows only important events.
     * @param myDiary The array that keeps events.
     */
    public static void subMenuOne(Event[][][] myDiary) {
        boolean myDiaryNotEmpty = false;
        for (Event[][] e : myDiary) { // for-each show events
            for (Event[] events : e) {
                for (Event myEvent : events) {
                    if (myEvent instanceof ImportantEvent) {
                        System.out.println(myEvent.description + ". " + myEvent.eventDateTime.format(Event.format));
                        myDiaryNotEmpty = true;
                    }
                }
            }
        }
        if (!myDiaryNotEmpty) {
            System.out.println(StringUtils.NO_IMPORTANT_EVENTS);
        }
    }

    /**
     * Manages option 2 in submenu. Shows only normal events.
     * @param myDiary The array that keeps events.
     */
    public static void subMenuTwo(Event[][][] myDiary) {
        boolean myDiaryNotEmpty = false;
        for (Event[][] e : myDiary) {
            for (Event[] events : e) {
                for (Event myEvent : events) {
                    if (myEvent instanceof NormalEvent) {
                        System.out.println(myEvent.description + ". " + myEvent.eventDateTime.format(Event.format));
                        myDiaryNotEmpty = true;
                    }
                }
            }
        }
        if (!myDiaryNotEmpty) {
            System.out.println(StringUtils.NO_NORMAL_EVENTS);
        }
    }

    /**
     * Manages option 3 in submenu. Shows all events.
     * @param myDiary The array that keeps events.
     */
    public static void subMenuThree(Event[][][] myDiary) {
        boolean myDiaryNotEmpty = false;
        for (Event[][] e : myDiary) {
            for (Event[] events : e) {
                for (Event myEvent : events) {
                    if (myEvent != null) {
                        System.out.println(myEvent.description + ". " + myEvent.eventDateTime.format(Event.format));
                        myDiaryNotEmpty = true;
                    }
                }
            }
        }
        if (!myDiaryNotEmpty) {
            System.out.println(StringUtils.ARRAY_ERROR);
        }
    }

    /**
     * Manages option 4 in submenu. Shows by day and sorted by hour.
     * It can shows only important events or all events.
     * @param myDiary The array that keeps events.
     * @param scan The Scanner object to read user input.
     */
    public static void subMenuFour(Event[][][] myDiary, Scanner scan) {
        //variables
        LocalDate eventDay;
        String userDay, userAnswer;
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber, day;
        boolean myDiaryNotEmpty = false;

        userDay = StringUtils.askForString(StringUtils.ENTER_DAY, scan);
        eventDay = LocalDate.parse(userDay);
        weekNumber = eventDay.get(weekFields.weekOfWeekBasedYear()); // get the week
        day = eventDay.getDayOfWeek().getValue(); // get the day
        userAnswer = StringUtils.askForString(StringUtils.ONLY_IMPORTANT, scan);
        if(userAnswer.toLowerCase().charAt(FIRST_POSITION) == 'y'){
            for (int i = 0; i < myDiary[weekNumber - 1][day - 1].length; i++) {
                if (myDiary[weekNumber - 1][day - 1][i] != null && myDiary[weekNumber - 1][day - 1][i] instanceof ImportantEvent) { //only if instance of importantEvent
                    System.out.println(myDiary[weekNumber - 1][day - 1][i].description + ". "
                            + myDiary[weekNumber - 1][day - 1][i].eventDateTime.format(Event.format));
                    myDiaryNotEmpty = true;
                }
            }
        } else {
            for (int i = 0; i < myDiary[weekNumber - 1][day - 1].length; i++) {
                if (myDiary[weekNumber - 1][day - 1][i] != null) {
                    System.out.println(myDiary[weekNumber - 1][day - 1][i].description + ". "
                            + myDiary[weekNumber - 1][day - 1][i].eventDateTime.format(Event.format));
                    myDiaryNotEmpty = true;
                }
            }
        }
        if (!myDiaryNotEmpty) {
            System.out.println(StringUtils.DAY_EMPTY);
        }
    }
}
