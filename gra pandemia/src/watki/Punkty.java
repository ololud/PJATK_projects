package watki;

import Modele.MyModel;

public class Punkty implements Runnable {

    private MyModel mod;
    private boolean onOff;
    public Thread t;

    public Punkty(MyModel model){
        t = new Thread(this);
        this.mod = model;

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
            if(this.mod.score > 0)
            this.mod.score--;
            else
                this.wylacz();
        }
    }
    public void wylacz (){
        this.onOff = false;
    }
}
