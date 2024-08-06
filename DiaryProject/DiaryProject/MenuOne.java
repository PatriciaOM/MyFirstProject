package DiaryProject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MenuOne {
    private static final int WEEK_MIN = 0;
    private static final int WEEK_MAX = 53;
    private static final int DAY_MIN = 0;
    private static final int DAY_MAX = 7;
    private static final int FIRST_POSITION = 0;
    private static final int ACTUAL_YEAR = 2024;
    static Event myEvent;

    public static void menuOne(Scanner scan, Event[][][] myDiary) {

        String eventDescription, userDay, userHour, priority = "", userNewEvent;
        LocalDate eventDay;
        LocalTime eventHour;
        LocalDateTime completeDate;
        int weekNumber, day, i = 0;
        boolean newEvent = false, correctAnswer = false, eventAdded = false;
        Event newEventToAdd = null;

        do {
            // setting variables that we need for constructor
            eventDescription = StringUtils.askForString(StringUtils.ENTER_DESCRIPTION, scan);
            userDay = StringUtils.askForString(StringUtils.ENTER_DAY, scan);
            eventDay = LocalDate.parse(userDay);
            userHour = StringUtils.askForString(StringUtils.ENTER_HOUR, scan);
            eventHour = LocalTime.parse(userHour);

            // other variables that we need for the date
            completeDate = LocalDateTime.of(eventDay, eventHour);
            WeekFields weekFields = WeekFields.of(Locale.getDefault()); // default with the locale rules
            weekNumber = completeDate.get(weekFields.weekOfWeekBasedYear()); // setting the week number
            DayOfWeek dayOfWeekNumber = completeDate.getDayOfWeek(); // setting the day of week
            day = dayOfWeekNumber.getValue(); // setting the day of week number

            if (weekNumber > WEEK_MIN && weekNumber < WEEK_MAX && day > DAY_MIN && day < DAY_MAX && eventDay.getYear() == ACTUAL_YEAR) { // checking errors
                // setting type of event
                priority = StringUtils.askForString((StringUtils.ENTER_PRIORITY + StringUtils.YES_NO), scan);
                if (priority.toLowerCase().charAt(FIRST_POSITION) == StringUtils.YES.charAt(FIRST_POSITION)) {
                    newEventToAdd = new ImportantEvent(eventDescription, eventDay, eventHour); //save the event
                } else if (priority.toLowerCase().charAt(FIRST_POSITION) == StringUtils.NO.charAt(FIRST_POSITION)){
                    newEventToAdd = new NormalEvent(eventDescription, eventDay, eventHour);
                } else {
                    System.out.println(StringUtils.ERROR);
                }
                //check if the position is full or empty
                for (;i < myDiary[weekNumber - 1][day - 1].length; i++) {
                    if (myDiary[weekNumber - 1][day - 1][i] == null) {
                        myDiary[weekNumber - 1][day - 1][i] = newEventToAdd;
                        eventAdded = true;
                        break;
                    }
                }
                if (!eventAdded) {
                    System.out.println(StringUtils.NO_SPACE);
                } else {
                    Arrays.sort(myDiary[weekNumber-1][day-1], FIRST_POSITION, i+1);
                }
            } else {
                System.out.println(StringUtils.ERROR);
                if (eventDay.getYear() != ACTUAL_YEAR) {
                    System.out.println(StringUtils.WRONG_YEAR);
                }
            }
            // introduce new event
            do { // check correct answer's loop
                userNewEvent = StringUtils.askForString((StringUtils.NEW_EVENT + " " + StringUtils.YES_NO), scan);
                if (userNewEvent.toLowerCase().charAt(FIRST_POSITION) == StringUtils.YES.charAt(FIRST_POSITION)) {
                    correctAnswer = true;
                } else if (userNewEvent.toLowerCase().charAt(0) == StringUtils.NO.charAt(FIRST_POSITION)) {
                    System.out.println(StringUtils.FINISH_ENTER_EVENT);
                    newEvent = true;
                    correctAnswer = true;
                } else {
                    System.out.println(StringUtils.ERROR);
                    correctAnswer = false;
                }
            } while (!correctAnswer);
        } while (!newEvent);
    }

    public static Event returnEvent() {
        return myEvent;
    }

}
