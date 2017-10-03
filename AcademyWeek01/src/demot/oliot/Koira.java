package demot.oliot;

public class Koira extends Elain {

    @Override
    public Elain lisaanny(){
        return new Koira();
    }
    
}
