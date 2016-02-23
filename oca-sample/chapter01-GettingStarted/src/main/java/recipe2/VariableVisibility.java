package recipe2;

/**
 * Created by O26 on 22/02/2016.
 */
public class VariableVisibility {
    public static boolean oneValueForAllObjects = false;
    private long visibleOnlyInThisClass;
    double visibleFromEntirePackage;

    void setLong(long val) {
        visibleOnlyInThisClass = val;
    }

    long getLong() {
        return visibleOnlyInThisClass;
    }
}
