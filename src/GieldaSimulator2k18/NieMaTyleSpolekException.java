package GieldaSimulator2k18;

public class NieMaTyleSpolekException extends Exception{
    /**
     * Konstruktor wyjątku.
     */
    public NieMaTyleSpolekException(){
        super();
    }

    /**
     * Konstruktor wyjątku.
     * @param message opis błędu
     */
    public NieMaTyleSpolekException(String message){
        super(message);
    }

    /**
     * Konstruktor wyjątku.
     * @param message opis błędu
     * @param cause wyjątek będący przyczyną błędu
     */
    public NieMaTyleSpolekException(String message, Exception cause){
        super(message, cause);
    }
}
