package watki;

import Modele.MyModel;

public class Komunikacja implements Runnable {

    private MyModel mod;
    private boolean onOff;
    public Thread t;

    public Komunikacja(MyModel model){
        t = new Thread(this);
        this.mod = model;

    }

    @Override
    public void run() {
        this.onOff = true;
        while (this.onOff) {
            try {
                this.t.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mod.infekuj();
        }
    }

    public void wylacz (){
        this.onOff = false;
    }

}
