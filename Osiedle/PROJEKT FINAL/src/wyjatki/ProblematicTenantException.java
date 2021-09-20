package wyjatki;

import podmioty.osoba;

public class ProblematicTenantException extends Exception {

    public ProblematicTenantException(osoba abc){
        System.out.println("Osoba:" + abc +  " posiadała juz najem pomieszczen: " + abc.listaN );
    }

}
