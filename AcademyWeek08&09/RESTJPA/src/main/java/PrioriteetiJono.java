
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PrioriteetiJono extends HashMap<String, LinkedList> {

    LinkedList<Object> elintärkeä = new LinkedList<>();
    LinkedList<Object> tärkeä = new LinkedList<>();
    LinkedList<Object> turha = new LinkedList<>();

    public void lisää(Object o) {
        this.lisää("", o);
    }

    public void lisää(String tärkeys, Object o) {

        switch (tärkeys) {
            case "elintärkeä":
            case "ELINTÄRKEÄ":
                elintärkeä.add(o);
                break;
            case "tärkeä":
            case "TÄRKEÄ":
                tärkeä.add(o);
                break;
            case "turha":
            case "TURHA":
                turha.add(o);
                break;
            default:
                System.out.println("Lisätty tärkeyteen 'turha'. Huolehdithan oikean tärkeyden valinnasta!");
                turha.add(o);
                break;
        }

    }

    public int koko() {
        return elintärkeä.size() + tärkeä.size() + turha.size();
    }
    
    public Object poistaJonosta(Object o) {
        
        if (elintärkeä.contains(o)) return elintärkeä.remove(o);
        else if (tärkeä.contains(o)) return tärkeä.remove(o);
        else if (turha.contains(o)) return turha.remove(o);
        else {
            System.out.println("Poistettavaa kohdetta ei löytynyt.");
            return null;
        }
        
    }
    
    public void poistaTurhat() {
        turha = new LinkedList<>();
    }
    
    public void poistaTärkeydestä(String tärkeys) {
        
        switch (tärkeys) {
            case "elintärkeä":
            case "ELINTÄRKEÄ":
                elintärkeä = new LinkedList<>();
                break;
            case "tärkeä":
            case "TÄRKEÄ":
                tärkeä = new LinkedList<>();
                break;
            default:
                turha = new LinkedList<>();
                break;
        }
    }
    
    public List<Object> listaaKaikki() {
        
        List<Object> lista = new LinkedList<>();
        
        lista.addAll(elintärkeä);
        lista.addAll(tärkeä);
        lista.addAll(turha);
        
        return lista;
    }

    public Object ensimmäinen() {
        
        if (!elintärkeä.isEmpty()) {
            return elintärkeä.get(0);
        } else if (!tärkeä.isEmpty()) {
            return tärkeä.get(0);
        } else if (!turha.isEmpty()) {
            return turha.get(0);
        } else {
            return null;
        }
    }
    
    public Object viimeinen() {
        
        if (!turha.isEmpty()) {
            return turha.get(turha.size()-1);
        } else if (!tärkeä.isEmpty()) {
            return tärkeä.get(tärkeä.size()-1);
        } else if (!elintärkeä.isEmpty()) {
            return elintärkeä.get(elintärkeä.size()-1);
        } else {
            return null;
        }
        
    }

    public Object ensimmäinenPrioriteetista(String tärkeys) {

        switch (tärkeys) {
            case "elintärkeä":
            case "ELINTÄRKEÄ":
                return elintärkeä.get(0);
            case "tärkeä":
            case "TÄRKEÄ":
                return tärkeä.get(0);
            default:
                return turha.get(0);
        }

    }

}
