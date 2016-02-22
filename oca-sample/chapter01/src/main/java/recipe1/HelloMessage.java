package recipe1;

/**
 * Created by O26 on 22/02/2016.
 */
public class HelloMessage {
    private String message = "";

    public HelloMessage() {
        this.message = "Hello, World";
    }

    public void setMessage(String m) {
        this.message = m;
    }

    public String getMessage() {
        return this.message.toUpperCase();
    }
}
