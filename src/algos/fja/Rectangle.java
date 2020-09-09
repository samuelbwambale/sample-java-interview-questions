package algos.fja;

public class Rectangle extends Shape {

    private int length;
    private int width;

    public Rectangle() {}

    public Rectangle(int length, int width) {
        this();
        this.length = length;
        this.width = width;
    }

    @Override
    public int calculateArea() {
        return length * width;
    }
}
