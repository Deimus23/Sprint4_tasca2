package cat.itacademy.s04.t02.n01.S04T02N01.exception;

public class FruitNotFoundException extends RuntimeException {
    public FruitNotFoundException(String message) {
        super(message);
    }
}
