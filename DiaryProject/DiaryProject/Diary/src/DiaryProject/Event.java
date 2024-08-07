package DiaryProject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Class for setting the characteristics of all events.
 */
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
    
    /**
     * Abstract class event
     * @param description The description of event.
     * @param eventDay The day of the event.
     * @param eventHour The hour of the event.
     */
    public Event (String description, LocalDate eventDay, LocalTime eventHour){ //main constructor
        this.description = description;
        this.eventDay = eventDay;
        this.eventHour = eventHour;
        total_events++;
        eventDateTime = LocalDateTime.of(eventDay, eventHour);
    }

    /**
     * Abstract method for create an event that needs override
     */
    public abstract void createNewEvent();

    /**
     * Interface that compares the hour of a day
     * @param myEvent Event that you are comparing.
     * @return The events that are in the same day with hour sorted.
     */
    @Override
    public int compareTo(Event myEvent){
        if (this.eventDay.equals(myEvent.eventDay)){
            return this.eventHour.compareTo(myEvent.eventHour);
        } else {
            return this.eventDay.compareTo(myEvent.eventDay);
        }
    }
}
