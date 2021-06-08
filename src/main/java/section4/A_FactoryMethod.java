package section4;

import java.security.cert.PolicyNode;

public class A_FactoryMethod {
    public static void main(String[] args){
        Point p = Point.PointFactory.newCartesianPoint(1,2);
    }
}

enum Coordinatesystem{
    CARTESIAN,
    POLAR
}


// simple implementation

class Point {
    private double x, y;

    private Point(double a, double b) {
        this.x = x;
        this.y = y;
    }

    public static class PointFactory{
        public static Point newCartesianPoint(double x, double y){
            return new Point(x,y);
        }

        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }
}




