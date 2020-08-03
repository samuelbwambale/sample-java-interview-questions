package algos.fja;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(4,3);
        System.out.println("Area of a Rectangle: " + rectangle.calculateArea());

        Shape square = new Square(3);
        System.out.println("Area of a Square: " + square.calculateArea());

    }
}
