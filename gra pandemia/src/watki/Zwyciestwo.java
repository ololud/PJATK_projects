package watki;

import Modele.MyModel;

public class Zwyciestwo implements Runnable {

    private MyModel mod;
    private boolean onOff;
    public Thread t;

    public Zwyciestwo(MyModel model){
        t = new Thread(this);
        this.mod = model;

    }

    @Override
    public void run() {

        this.onOff = true;

        while (this.onOff) {
            try {
                this.t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mod.zarazeniSwiata = mod.getZarazeniSwiata();
            mod.populacjaSwiata = mod.getPopulacjaSwiata();

            if (this.mod.zarazeniSwiata >= this.mod.populacjaSwiata){
                mod.lose = true;
            }else if(this.mod.infectionSpeed <= 0){
                mod.score = mod.score - (mod.zarazeniSwiata/mod.populacjaSwiata);
                mod.win = true;
            }else if(this.mod.zarazeniSwiata <= 0){
                mod.score = mod.score - (mod.zarazeniSwiata/mod.populacjaSwiata);
                mod.win = true;
            }
        }
    }

    public void wylacz (){
        this.onOff = false;
    }
}
