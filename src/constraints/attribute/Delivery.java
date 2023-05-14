package constraints.attribute;

public class Delivery {

    private int distance;
    private boolean isExpress;

    private static final int MAX_DISTANCE = 100;
    private static final int MIN_DISTANCE_EXPRESS = 0;
    private static final int MAX_DISTANCE_EXPRESS = 50;

    public Delivery(int distance, boolean isExpress) {
        setExpress(isExpress);
        setDistance(distance);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        if (isExpress && (distance < MIN_DISTANCE_EXPRESS || distance > MAX_DISTANCE_EXPRESS)) {
            throw new IllegalArgumentException("Express delivery distance out of range");
        }

        if (!isExpress && (distance < 0 || distance > MAX_DISTANCE)) {
            throw new IllegalArgumentException("Delivery distance out of range");
        }
        this.distance = distance;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean isExpress) {
        if (isExpress && distance > MAX_DISTANCE_EXPRESS) {
            throw new IllegalArgumentException("Express delivery distance exceeded maximum limit");
        }
        this.isExpress = isExpress;
    }

}
