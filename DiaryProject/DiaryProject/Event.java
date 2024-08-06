package DiaryProject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Event implements Comparable<Event>{ //interfaces
    //class constant
    static final DateTimeFormatter format = DateTimeFormatter.ofPattern(StringUtils.DATE_PATTERN); //formatDate
    //object variables
    protected String description;
    protected LocalTime eventHour;
    protected LocalDate eventDay;
    protected int priority;
    protected String colour;
    protected LocalDateTime eventDateTime;
    //class variable
    static int total_events = 0;
    

    public Event (String description, LocalDate eventDay, LocalTime eventHour){ //main constructor
        this.description = description;
        this.eventDay = eventDay;
        this.eventHour = eventHour;
        total_events++;
        eventDateTime = LocalDateTime.of(eventDay, eventHour);
    }

    public abstract void createNewEvent(); //abstract method that needs override

    @Override
    public int compareTo(Event myEvent){ //interface that compares the hour of a day
        if (this.eventDay.equals(myEvent.eventDay)){
            return this.eventHour.compareTo(myEvent.eventHour);
        } else {
            return this.eventDay.compareTo(myEvent.eventDay);
        }
    }
}
