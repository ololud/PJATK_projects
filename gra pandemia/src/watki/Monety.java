package watki;

import Modele.MyModel;

public class Monety implements Runnable {

    private MyModel mod;
    private boolean onOff;
    public Thread t;

    public Monety(MyModel model){
        t = new Thread(this);
        this.mod = model;

    }

    @Override
    public void run() {
        this.onOff = true;
        while (this.onOff) {
            try {
                this.t.sleep(24000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mod.money();
        }
    }

    public void wylacz (){
        this.onOff = false;
    }
}
