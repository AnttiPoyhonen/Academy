package harjoituksia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaHarjoitus1 {
    
        static String[] lista = new String[10];
        static List listaAll = new ArrayList();
        static List<String> listaString = new ArrayList<>();
        static List<Integer> listaInt = new ArrayList<Integer>();
        static String poistettava = null;
    
    public static void main(String[] args){
                
        lisaaAlkiot();
        
        tulostaAlkiot();
        
        // add and remove from listaString, w/ checks
        
        listaString.add(2, "Antti");
        listaString.add(2, "Tommi");
        
        tulostaLista(listaString);
        
        poistettava = "An";
        poistaAlkio(poistettava, listaString);
        poistaAlkio("2", listaString);
        poistaAlkio("4", listaString);
        
        tulostaLista(listaString);
                
    }

    private static void lisaaAlkiot() {
                
        for(int i = 0; i < 5; i++) {
            Integer j = (Integer) i;
            String s = j.toString();
            lista[i] = s;
        }
        
        listaAll.add("A");
        listaAll.add("B");
        listaAll.add("C");
        listaAll.add("D");
        listaAll.add("E");
                
        for(int i = 1; i <= 5; i++) {
            Integer j = (Integer) i;
            String s = j.toString();
            listaString.add(s);
        }
        
        for(int i = 1; i <= 5; i++) {
            listaInt.add(i);
        }
                
    }

    private static void tulostaAlkiot() {
        
        // Array
        System.out.println("String-Array:");
        for(String s : lista) {
            System.out.println(s);
        }
        System.out.println("");

        // ArrayList (without type)
        System.out.println("ArrayList:");  // functional forEach!
        listaAll.forEach((o) -> {
            System.out.println(o.toString());
            });
        System.out.println("");
        
        // ArrayList (String)
        System.out.println("String-ArrayList:");
        for(String s : listaString) {
            System.out.println(s);
        }
        System.out.println("");
        
        // ArrayList (Integer)        
        System.out.println("Integer-ArrayList:");
        tulostaLista(listaInt);
    }

    private static void poistaAlkio(String poistettava, List<String> lista) {
        
        // go through list and remove if it is a String starting with parameter
        for(Iterator<String> i = lista.iterator() ; i.hasNext() ; ) {
            String alkio = i.next();
            if (alkio.startsWith(poistettava)) {
                i.remove();
            }
            
            /* COULD BE:
            if(alkio.substring(0, poistettava.length()).equals(poistettava)) {
                lista.remove(alkio);
            }
            */
        }
        
    }

    private static void tulostaLista(List<?> lista) {
               
        for(Object o : lista) {
            System.out.println(o);
        }
        System.out.println("");
        
    }
    
}
