package repository;

public class DatabaseActionExeption extends RuntimeException{
    public DatabaseActionExeption(final Throwable cause){
        super(cause);
    }
}
