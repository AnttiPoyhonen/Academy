package fi.academy;
    
public class LaitonIkaException extends Exception {

    // Exception referencing super(), works
    public LaitonIkaException(){
        
    }
    
    // Exception w/ message
    public LaitonIkaException(String str){
        super(str);
    }
    
    // Exception w/ msg and cause
    public LaitonIkaException(String str, Throwable cause){
        super(str, cause);
    }
    
}
