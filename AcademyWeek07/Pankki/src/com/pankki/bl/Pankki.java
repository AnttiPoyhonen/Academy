package com.pankki.bl;

public class Pankki {

    private Tili[] tilit;

    public Pankki(Tili[] tilit) {
        this.tilit = tilit;
    }

    public void talleta(int tilinro, double euroa) {
        tilit[tilinro].pano(euroa);
    }

    public boolean nosta(int tilinro, double euroa) {
        return tilit[tilinro].otto(euroa);
    }

    public boolean siirra(int lähtötili, int kohdetili, double euroa) {
        if (tilit[lähtötili].getMaksimiNosto() > euroa
                && tilit[lähtötili].otto(euroa)) {
            tilit[kohdetili].pano(euroa);
            System.out.println("Siirretty " + euroa + " euroa tililtä nro "
                    + lähtötili + " tilille nro " + kohdetili + ".");
            return true;
        } else {
            System.out.println("Ei tarpeeksi rahaa lähtötilillä!");
            return false;
        }
    }


}
