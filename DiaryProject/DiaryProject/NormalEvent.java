package DiaryProject;

import java.time.LocalDate;
import java.time.LocalTime;

public class NormalEvent extends Event{
    public NormalEvent (String description, LocalDate eventDay, LocalTime eventHour){ //constructor inherited
        super(description, eventDay, eventHour);
        super.colour = StringUtils.NORMAL_COLOUR;
    }

    @Override
    public void createNewEvent(){
        @SuppressWarnings("unused")
        NormalEvent myEvent = new NormalEvent(description, eventDay, eventHour);
    }
}
