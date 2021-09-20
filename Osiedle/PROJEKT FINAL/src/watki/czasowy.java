package watki;

import java.util.GregorianCalendar;

public class czasowy implements Runnable {

    private kalendarz Kalendarz;
    private boolean onOff;
    public Thread t;

    public czasowy(kalendarz Kalendarz){
        t = new Thread(this);
        this.Kalendarz = Kalendarz;
        }

    @Override
    public void run() {
        this.onOff = true;
        GregorianCalendar tmp = (GregorianCalendar) GregorianCalendar.getInstance();
        while (this.onOff){
            Kalendarz.add(tmp);
            try {
                this.t.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tmp.add(5, 1);
        }
        System.out.println("Watek czasu przerwano!");
    }

    public void wylacz (){
        this.onOff = false;
    }
}
