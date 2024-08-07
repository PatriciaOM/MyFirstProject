package DiaryProject;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class for creating a new important event.
 */
public class ImportantEvent extends Event {

    /**
     * Class ImportantEvent. Inherits from Event Class
     * @param description The description of event.
     * @param eventDay The day of the event.
     * @param eventHour The hour of the event.
     */
    public ImportantEvent (String description, LocalDate eventDay, LocalTime eventHour){
        super(description, eventDay, eventHour );
        super.colour = StringUtils.IMPORTANT_COLOUR;
    }

    /**
     * Creates an object of ImportantEvent
     */
    @Override
    public void createNewEvent(){
        @SuppressWarnings("unused")
        ImportantEvent myEvent = new ImportantEvent(description, eventDay, eventHour);
    }

}
