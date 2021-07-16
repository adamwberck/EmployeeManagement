public class Circle extends Shape{
    private double radius;

    public Circle(String color) {
        super(color);
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
