package fi.academy.torstai.live;

import java.util.Comparator;

public class HenkiloVertailija implements Comparator<Henkilo> {

    @Override
    public int compare(Henkilo o1, Henkilo o2) {
        return o1.getIka()-o2.getIka();
    }
}
