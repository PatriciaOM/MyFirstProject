package DiaryProject;
import java.time.LocalDate;
import java.time.LocalTime;

public class ImportantEvent extends Event {
    public ImportantEvent (String description, LocalDate eventDay, LocalTime eventHour){ //constructor inherited
        super(description, eventDay, eventHour );
        super.colour = StringUtils.IMPORTANT_COLOUR;
    }

    @Override
    public void createNewEvent(){
        @SuppressWarnings("unused")
        ImportantEvent myEvent = new ImportantEvent(description, eventDay, eventHour);
    }

}
