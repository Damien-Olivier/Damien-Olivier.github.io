
public class ExceptionDivPolyNul extends Exception {
    private static String message = "Division par zéro";

    ExceptionDivPolyNul() {
        super(message);
    }

    ExceptionDivPolyNul(String s) {
        super(s);
    }
}
