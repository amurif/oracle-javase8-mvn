package recipe7;

/**
 * Created by O26 on 22/02/2016.
 */
public interface Volume {
    double calculateVolume();

    /**
     * Calculate pool volume given depth values and measurement values. For
     * a pool with variable depth, the minDepth should be depthValues[0], and
     * the maxDepth should be passed as depthValues[1].
     * <p/>
     * This interface can accept multiple measurement values, but it expects
     * measurementValues[0] == length, or measurementValues[0] == radius
     * measurementValues[1] == width
     *
     * @param depthValues
     * @param measurementValues
     * @return volume
     */
    default double calculateVolume(Double[] depthValues, Double[] measurementValues) {
        double length;
        double width;
        double radius;
        double minDepth;
        double maxDepth;
        double avgDepth = 0;

        if (depthValues.length > 1) {
            minDepth = depthValues[0];
            maxDepth = depthValues[1];
            avgDepth = (minDepth + maxDepth) / 2;
        } else if (depthValues.length == 1) {
            avgDepth = depthValues[0];
        }
        if (measurementValues.length > 1) {
            length = measurementValues[0];
            width = measurementValues[1];
            radius = 0;
        } else {
            length = 0;
            width = 0;
            radius = measurementValues[0];
        }
        if (radius == 0) {
            return length * width * avgDepth;
        } else {
            return (radius * radius) * 3.14 * avgDepth;
        }
    }
}