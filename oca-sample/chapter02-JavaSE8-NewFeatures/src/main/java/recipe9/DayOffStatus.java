package recipe9;

import java.io.Serializable;

/**
 * Created by O26 on 23/02/2016.
 */
public class DayOffStatus implements Serializable {

    private static final long serialVersionUID = -4204196706013159398L;
    private Boolean isFamilyBirthDay;
    private Boolean isFamilyVacation;

    private DayOffStatus(){
        isFamilyBirthDay = Boolean.FALSE;
        isFamilyVacation = Boolean.FALSE;
    }

    private static class SingletonHolder {
        private final static DayOffStatus INSTANCE = new DayOffStatus();
    }

    public static DayOffStatus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Security against deserialization
     */
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

    public boolean isFamilyBirthDay() {
        return isFamilyBirthDay;
    }

    public void setFamilyBirthDay(boolean familyBirthDay) {
        isFamilyBirthDay = familyBirthDay;
    }

    public boolean isFamilyVacation() {
        return isFamilyVacation;
    }

    public void setFamilyVacation(boolean familyVacation) {
        isFamilyVacation = familyVacation;
    }
}
