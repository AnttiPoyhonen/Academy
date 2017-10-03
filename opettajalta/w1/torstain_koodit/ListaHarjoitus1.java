package fi.academy.torstai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaHarjoitus1 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("maanantai");
        lista.add("tiistai");
        lista.add("keskiviikko");
        lista.add("torstai");
        lista.add("perjantai");
        lista.add("lauantai");
        lista.add("sunnuntai");
        tulostaLista(lista);

        // JOTAIN
        for(Iterator<String> it = lista.iterator() ; it.hasNext() ; ) {
            String alkio = it.next();
            if (alkio.substring(0, 1).equalsIgnoreCase("T"))
                it.remove();
        }
        System.out.println("---------------------");
        tulostaLista(lista);
    }

    private static void tulostaLista(List<?> lista) {
        for (Object pva: lista) {
            System.out.println(pva);
        }
    }
}
