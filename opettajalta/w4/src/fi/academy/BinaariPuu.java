package fi.academy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BinaariPuu implements Set<Integer> {

    PuuSolmu juuri;

    public void tulosta() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder puskuri = new StringBuilder();
        toString(juuri, puskuri);

       return puskuri.toString().trim();
    }

    private void toString(PuuSolmu solmu, StringBuilder puskuri) {
        if(solmu.vasen != null) toString(solmu.vasen, puskuri);
        puskuri.append(String.format(" %d ", solmu.arvo));
        if(solmu.oikea != null) toString(solmu.oikea, puskuri);
    }

    @Override
    public int size() {
        if (juuri == null) return 0;
        return size(juuri);
    }
    private int size(PuuSolmu s) {
        int lkmTamaJaLapset = 1;
        if (s.vasen != null) lkmTamaJaLapset += size(s.vasen);
        if (s.oikea != null) lkmTamaJaLapset += size(s.oikea);
        return lkmTamaJaLapset;
    }

    @Override
    public boolean isEmpty() {
        return juuri == null;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer)) return false;
        return contains(juuri, (Integer)o);
    }

    private boolean contains(PuuSolmu solmu, Integer arvo) {
        if (solmu.arvo == arvo) return true;
        if (solmu.arvo > arvo && solmu.vasen != null)
            return contains(solmu.vasen, arvo);
        else if (solmu.arvo < arvo && solmu.oikea != null)
            return contains(solmu.oikea, arvo);
        return false;
    }


    @Override
    public Iterator<Integer> iterator() {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public Integer[] toArray() {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public boolean add(Integer arvo) {
        if (juuri == null) {
            juuri = new PuuSolmu(arvo);
            return true;
        }
        return add(juuri, arvo);
    }

    private boolean add(PuuSolmu solmu, Integer arvo) {
        if(arvo == solmu.arvo)
            return false;
        if(arvo < solmu.arvo) {
            if (solmu.vasen == null) {
                solmu.vasen = new PuuSolmu(arvo);
                return true;
            }
            return add(solmu.vasen, arvo);
        }
        if (solmu.oikea == null) {
            solmu.oikea = new PuuSolmu(arvo);
            return true;
        }
        return add(solmu.oikea, arvo);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Ei vielä toteutettu");
    }

    @Override
    public void clear() {
        juuri = null;
    }
}

class PuuSolmu {
    PuuSolmu vasen;
    PuuSolmu oikea;
    Integer arvo;
    PuuSolmu(Integer arvo) {
        this.arvo = arvo;
    }
}