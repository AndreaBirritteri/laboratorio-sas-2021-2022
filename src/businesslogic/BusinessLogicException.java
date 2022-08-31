package businesslogic;

public class BusinessLogicException extends Throwable {
    public BusinessLogicException(String s) {
        System.err.println(s);
    }
}
