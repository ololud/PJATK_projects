package watki;

import Modele.MyModel;

public class Zarazenia implements Runnable {

    private MyModel model;
    private boolean onOff;
    public Thread t;


    public Zarazenia(MyModel mod){
        t = new Thread(this);
        this.model = mod;

    }

    @Override
    public void run() {
        this.onOff = true;
        while (this.onOff) {
            try {
                this.t.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.model.panstwa.size(); i++){
                this.model.panstwa.get(i).epidemia(this.model.infectionSpeed);
            }
        }
    }

    public void wylacz() { this.onOff = false; }
}
