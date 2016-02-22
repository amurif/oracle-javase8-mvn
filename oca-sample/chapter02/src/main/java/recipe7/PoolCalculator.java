package recipe7;

/**
 * Created by O26 on 22/02/2016.
 */
public class PoolCalculator implements Volume {

    private double width;
    private double length;
    private double minDepth;
    private double maxDepth;

    public PoolCalculator() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double calculateVolume() {
        double avgDepth = (minDepth + maxDepth) / 2;
        return avgDepth * length * width;
    }

    public double calculateGallons(Volume vol) {
        return 7.48 * vol.calculateVolume();
    }

    public double getMinDepth() {
        return minDepth;
    }

    public void setMinDepth(double minDepth) {
        this.minDepth = minDepth;
    }

    public double getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(double maxDepth) {
        this.maxDepth = maxDepth;
    }

}
