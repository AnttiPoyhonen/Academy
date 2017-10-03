package demot.oliot;

public class Kissa extends Object {
    private final String rotu;
    private String nimi;
    private int ikä;

    public Kissa(String rotu) {
        this.rotu = rotu;
        nimi = "<nimetön>";
    }

    public Kissa() {
        this("maatiainen");
//        rotu = "maatiainen";
//        nimi = "nimetön";
    }

    public Kissa(int ikä) {
        this("maatiainen");
        setIkä(ikä);
    }

    public void kuseksi() {

    }

    public String getRotu() {
        return rotu;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getIkä() {
        return ikä;
    }

    public void setIkä(int ikä) {
        if (ikä < 0 )
            return;
        this.ikä = ikä;
    }

    @Override
    public String toString() {
        return "Kissa{" +
                "rotu='" + rotu + '\'' +
                ", nimi='" + nimi + '\'' +
                ", ikä=" + ikä +
                '}';
    }
}
