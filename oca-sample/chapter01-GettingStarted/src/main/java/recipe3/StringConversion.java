package recipe3;

/**
 * Created by O26 on 22/02/2016.
 */
public class StringConversion {
    private double pi;
    private String stringValue;

    public StringConversion(){
        pi = Double.parseDouble("3.14");
        stringValue = String.valueOf(pi);
    }

    public double getPi() {
        return pi;
    }

    public String getStringValue() {
        return stringValue;
    }
}
