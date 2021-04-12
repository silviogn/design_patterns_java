package Section2;

class Rectangle {
    protected int width;
    protected int height;

    public Rectangle() {
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    // According the author the square class y not necessary and a solution could be in this case create the
    // method is square for example
    public boolean isSquare() {
        return width == height;
    }

}

// According to the author another solution for the square problem could be create a class
// to be used as a factory, an implement the call for build the objects according to what is necessary.

class RectangleFactory {

    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }

}

class Square extends Rectangle {

    public Square() {
    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(width);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(height);
    }
}


public class C_LiskovSubstitutionPrinciple {

    static void userIt(Rectangle r) {
        int width = r.getHeight();
        r.setWidth(10);
        System.out.println("Expected area of " + width * 10 + " got " + r.getArea());

    }


    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        userIt(rc);

        Square sq = new Square();
        sq.setWidth(5);
        userIt(sq);

        // Implementation of the solution to demostrate the Liskov Substitution principle

        Rectangle rectangle = RectangleFactory.newRectangle(10, 20);
        Rectangle square = RectangleFactory.newSquare(10);

    }
}
























