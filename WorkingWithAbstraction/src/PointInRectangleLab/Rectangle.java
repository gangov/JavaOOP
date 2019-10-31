package PointInRectangleLab;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.getPositionX() >= this.bottomLeft.getPositionX() && point.getPositionX() <= topRight.getPositionX()
                && point.getPositionY() >= this.bottomLeft.getPositionY() && point.getPositionY() <= topRight.getPositionY();
    }
}
