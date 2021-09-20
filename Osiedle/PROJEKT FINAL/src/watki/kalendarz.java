package watki;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class kalendarz  {

    public GregorianCalendar kalendarz;

    void add(GregorianCalendar calendar){
        this.kalendarz = calendar;
    }

    @Override
    public String toString() {
        return this.kalendarz.get(Calendar.YEAR) + " " + this.kalendarz.get(Calendar.MONTH) + " " + this.kalendarz.get(Calendar.DATE);
    }
}
