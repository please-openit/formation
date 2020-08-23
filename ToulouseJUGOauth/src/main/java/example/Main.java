package example;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.filter.Filter;
import net.fortuna.ical4j.filter.PeriodRule;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "example")

public class Main {
    public static void main(String[] args) throws IOException, ParserException {




        InputStream fin = new URL("https://calendar.google.com/calendar/ical/1ug5b966tff9uoab59pem2p62s%40group.calendar.google.com/private-4705b936c5804f94a6f4aba8f960fc1b/basic.ics").openStream();
        CalendarBuilder builder = new CalendarBuilder();

        Calendar calendar = builder.build(fin);

// create a period starting now with a duration of one (1) day..
        java.util.Calendar today = java.util.Calendar.getInstance();
        today.set(java.util.Calendar.HOUR_OF_DAY, 0);
        today.clear(java.util.Calendar.MINUTE);
        today.clear(java.util.Calendar.SECOND);

// create a period starting now with a duration of one (1) day..
        Period period = new Period(new DateTime(today.getTime()), Duration.ofDays(1));
        Filter filter = new Filter(new PeriodRule(period));

        List<VEvent> eventsToday = new ArrayList(filter.filter(calendar.getComponents(Component.VEVENT)));

        for(VEvent c : eventsToday){
            PropertyList<Property> attendees =  c.getProperties("ATTENDEE");
            String email = "";
            for(Property p : attendees){
                email = p.getParameter("CN").getValue();
            }
            c.getName();
        }

        SpringApplication.run(Main.class, args);
    }
}
