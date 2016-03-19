
public class JavaPoint {
    private int x;
    private int y;

    public JavaPoint(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object other) {
        if (other instanceof JavaPoint) {
            JavaPoint otherJavaPoint = (JavaPoint) other;
            return otherJavaPoint.getX() == getX() && otherJavaPoint.getY() == getY();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (new Integer[]{getX(), getY()}).hashCode();
    }

}