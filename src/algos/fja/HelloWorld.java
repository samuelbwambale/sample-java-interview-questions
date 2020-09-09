package algos.fja;

import java.util.ArrayList;
import java.util.List;

/*
final -

1)When we apply "final" keyword to a variable,the value of that variable remains constant.
(or) Once we declare a variable as final.the value of that variable cannot be changed.

2)It is useful when a variable value does not change during the life time of a program

static -

1)when we apply "static" keyword to a variable ,it means it belongs to class.
2)When we apply "static" keyword to a method,it means the method can be accessed
without creating any instance of the class
 */

public class HelloWorld {

    private static int x;
    private static boolean k;
    private static String y;

    // static means there is only one copy of the variable in memory shared by all instances of the class.
    // The final keyword just means the value can't be changed. Without final,
    // any object can change the value of the variable.
    private static final String HELLOWORLD = "Hello World";
    private List<String> array;

    public static void main(String[] args) {

        System.out.println(x); // 0
        System.out.println(k); // false
        System.out.println(y); // null
        System.out.println(HELLOWORLD);
    }

    public HelloWorld(int x, String y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newValue) {
        this.x = newValue;
    }

    public void addString(String str) {
        if (this.array == null) this.array.add(str);
            this.array.add(str);

    }

}