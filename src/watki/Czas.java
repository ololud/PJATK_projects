package watki;

import Modele.MyModel;

import java.util.GregorianCalendar;

public class Czas implements Runnable{


    private boolean onOff;
    public Thread t;
    private MyModel mod;

    public Czas(MyModel model){

        this.mod = model;
        t = new Thread(this);
    }

    @Override
    public void run() {
        this.onOff = true;
        while (this.onOff){
            try {
                this.t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mod.zegar.addSek();
        }
    }

    public void wylacz(){
        this.onOff = false;
    }
}

