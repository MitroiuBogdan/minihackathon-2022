package com.coding.problem20;

/**
 * You have four points defined in 2D space p1, p2, p3 and p4.
 * Return true if the four points construct a square.
 * <p>
 * The provided class Point contains the coordinates x and y.
 * <p>
 * A valid square has four equal sides with positive length
 * and four equal angles (90-degree angles).
 * <p>
 * Example 1:
 * Input: p1 = (0,0), p2 = (1,1), p3 = (1,0), p4 = (0,1)
 * Output: true
 * <p>
 * Example 2:
 * Input: p1 = (0,0), p2 = (1,1), p3 = (1,0), p4 = (0,12)
 * Output: false
 * <p>
 * Example 3:
 * Input: p1 = (1,0), p2 = (-1,0), p3 = (0,1), p4 = (0,-1)
 * Output: true
 * <p>
 * Constraints:
 * -10000 <= xi, yi <= 10000
 */
public class SquareChecker {

    public boolean isValidSquare(Point p1, Point p2, Point p3, Point p4) {
        double distance14 = getDistance(p1, p4);
        double distance12 = getDistance(p1, p2);
        double distance13 = getDistance(p1, p3);

        if (distance12 == 0 && distance13 == 0 && distance14 == 0) {
            return false;
        }
        if ((distance14 == getRootSquare(distance12, distance13) && distance12 == distance13) ||
                (distance12 == getRootSquare(distance14, distance13) && distance14 == distance13) ||
                (distance13 == getRootSquare(distance12, distance14) && distance12 == distance14)) {
            return true;
        }
        return false;
    }

    public double getRootSquare(double d1, double d2) {
        return Math.sqrt(Math.pow(d1, 2) + Math.pow(d2, 2));
    }

    public double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        if (-10000 > x || -10000 > y || 10000 < x || 10000 < y)
            throw new IllegalArgumentException("Invalid point coordinates.");

        this.x = x;
        this.y = y;
    }
}
