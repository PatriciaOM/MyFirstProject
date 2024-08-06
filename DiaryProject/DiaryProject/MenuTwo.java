package DiaryProject;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class MenuTwo {

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
        if(userAnswer.toLowerCase().charAt(0) == 'y'){
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
