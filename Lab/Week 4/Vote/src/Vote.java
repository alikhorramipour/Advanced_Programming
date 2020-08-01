import ir.huri.jcal.JalaliCalendar;

/**
 * this class represents a vote.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Vote {
    private Person person;
    private String date;

    public Vote(Person person) {
        this.person = person;
        JalaliCalendar jalaliCalendar = new JalaliCalendar(1396, 12, 21);
        this.date = jalaliCalendar.getYear() + "/" + jalaliCalendar.getMonth() + "/" + jalaliCalendar.getDay();
    }
}
