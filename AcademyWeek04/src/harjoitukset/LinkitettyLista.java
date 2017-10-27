package harjoitukset;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkitettyLista implements List {

    private Solmu pää; // Listan alku
    private Solmu häntä; // Listan loppu

    @Override
    public int size() {
        
        int size = 0;
        
        Solmu s = pää;
        
        if (s == null) {
            return size;
        }
        
        for(;;) {            
            size++;
            
            if (s.onSeuraava()) {
                s = s.getSeuraava();
            } else break;
        }
        
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (pää == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Solmu s = pää;
        
        for(;;) {            
            if (((Solmu)o).equals(s)) {
                return true;
            }
            
            if (s.onSeuraava()) {
                s = s.getSeuraava();
            } else return false;
        }
    }

    @Override
    public Object[] toArray() {

    }

    @Override
    public Object[] toArray(Object[] a) {

    }

    @Override
    public boolean add(Object e) {
        
        Solmu s = (Solmu)e;
        
        if(this.pää == null) {
            this.pää = s;
            this.häntä = s;
            return true;
        }
        
        Solmu vanha = this.häntä;
        vanha.setSeuraava(s);
        s.setEdellinen(vanha);
        this.häntä = s;
        
        return true;

    }

    @Override
    public boolean remove(Object o) {
        Solmu s = this.pää;
        
        for(;;) {            
            if (((Solmu)o).equals(s)) {
                                
                Solmu pre, post;
                
                if(s == this.pää && s == this.häntä) {
                    this.pää = null;
                    this.häntä = null;
                } else if(s == this.pää) {
                    post = s.getSeuraava();
                    
                    this.pää = post;
                    post.setEdellinen(null);
                } else if(s == this.häntä) {
                    pre = s.getEdellinen();
                    
                    this.häntä = pre;
                    pre.setSeuraava(null);                    
                } else {
                    pre = s.getEdellinen();
                    post = s.getSeuraava();
                    
                    
                }
                
                
                
                return true;
            }
            
            if (s.onSeuraava()) {
                s = s.getSeuraava();
            } else return false;
        }

    }

    @Override
    public boolean containsAll(Collection c) {

    }

    @Override
    public boolean addAll(Collection c) {

    }

    @Override
    public boolean addAll(int index, Collection c) {

    }

    @Override
    public boolean removeAll(Collection c) {

    }

    @Override
    public boolean retainAll(Collection c) {

    }

    @Override
    public void clear() {
        
        this.pää = null;
        this.häntä = null;

    }

    @Override
    public Object get(int index) {

    }

    @Override
    public Object set(int index, Object element) {

    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

    }

    @Override
    public int indexOf(Object o) {

    }

    @Override
    public int lastIndexOf(Object o) {

    }


}
