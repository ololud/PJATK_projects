package Podmioty;

//Od kiedy zegar jest podmiotem? Nie wiem.

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Zegar {

    private GregorianCalendar cal;

    public Zegar(){

        cal = new GregorianCalendar();
        cal.set(2000,12,1,0,0,0);

    }

    public GregorianCalendar addSek() {

        this.cal.add(Calendar.SECOND, 1);
        return cal;
    }

    public String toString(){

        return ("CZAS GRY: " + this.cal.get(Calendar.MINUTE)+":" + this.cal.get(Calendar.SECOND));
    }

}
