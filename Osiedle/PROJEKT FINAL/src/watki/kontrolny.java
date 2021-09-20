
package watki;

import nieruchomosci.osiedle;

import java.util.List;


public class kontrolny implements Runnable {

    private boolean onOff;
    public Thread t;
    private kalendarz Tmp;
    private List<osiedle> LisaO;


    public kontrolny (kalendarz tmp, List<osiedle> lisaO){
        t = new Thread(this);
        this.LisaO = lisaO;
        this.Tmp = tmp;
    }

    @Override
    public void run() {
        this.onOff = true;
            while (onOff) {
                try {
                    this.t.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LisaO.forEach(osiedle -> osiedle.listaBlok.forEach(blok -> blok.listaM.forEach(mieszkanie -> mieszkanie.weryfikacja(Tmp))));
                LisaO.forEach(osiedle -> osiedle.listaPark.forEach(miejscePark -> miejscePark.weryfikacja(Tmp)));
            }
    }

    public void wylacz() {
        this.onOff = false;
    }
}


