package GieldaSimulator2k18;

public class NiepoprawnaMarzaException extends Exception{
    /**
     * Konstruktor wyjątku.
     */
    public NiepoprawnaMarzaException(){
        super();
    }

    /**
     * Konstruktor wyjątku.
     * @param message opis błędu
     */
    public NiepoprawnaMarzaException(String message){
        super(message);
    }

    /**
     * Konstruktor wyjątku.
     * @param message opis błędu
     * @param cause wyjątek będący przyczyną błędu
     */
    public NiepoprawnaMarzaException(String message, Exception cause){
        super(message, cause);
    }
}
