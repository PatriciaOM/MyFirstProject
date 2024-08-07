package DiaryProject;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class for creating a new normal event.
 */
public class NormalEvent extends Event{

    /**
     * Class NormalEvent. Inherits from Event Class.
     * @param description The description of event.
     * @param eventDay The day of event.
     * @param eventHour The hour of event.
     */
    public NormalEvent (String description, LocalDate eventDay, LocalTime eventHour){
        super(description, eventDay, eventHour);
        super.colour = StringUtils.NORMAL_COLOUR;
    }

    /**
     * Creates an object of NormalEvent.
     */
    @Override
    public void createNewEvent(){
        @SuppressWarnings("unused")
        NormalEvent myEvent = new NormalEvent(description, eventDay, eventHour);
    }
}
