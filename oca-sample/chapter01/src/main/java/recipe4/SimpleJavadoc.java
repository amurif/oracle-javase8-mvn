package recipe4;

import java.math.BigInteger;

/**
 * Created by O26 on 22/02/2016.
 */
public class SimpleJavadoc {
    /**
     * Accepts an unlimited number of values and
     * returns the sum.
     *
     * @param nums Must be an array of BigInteger values.
     * @return Sum of all numbers in the array.
     */
    public static BigInteger addNumbers(BigInteger[] nums) {
        BigInteger result = new BigInteger("0");
        for (BigInteger num:nums){
            result = result.add(num);
        }
        return result;
    }
}
