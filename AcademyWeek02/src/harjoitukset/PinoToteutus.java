package harjoitukset;

import fi.academy.harjoitukset.Pino;
import java.util.ArrayList;

public class PinoToteutus implements Pino {

    private final ArrayList l = new ArrayList<>();
    
    @Override
    public int size() {
        return l.size();
    }

    @Override
    public void push(Object t) {
        l.add(0, t);
    }

    @Override
    public Object pop() {
        if (l.size() == 0) {
            return null;
        }
        return l.remove(0);
    }
    
    @Override
    public Object peek() {
        if (l.size() == 0) {
            return null;
        }
        return l.get(0);
    }

    @Override
    public void clear() {
        if (l.size() == 0) {
            return;
        }
        for (int i = l.size()-1; i >= 0; i--) {
            l.remove(i);
        }
    }

    @Override
    public boolean isEmpty() {
        if (l.size() == 0) {
            return true;
        } else return false;
    }

}
