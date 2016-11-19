package sehyun;

/**
 * Created by HunJin on 2016-11-15.
 */
public class Rectangle implements Comparable {

    int width = 0;
    int height = 0;

    public int getArea() {
        return width * height;
    }

    Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }


    @Override
    public int compareTo(Object other) {
        Rectangle r2 = (Rectangle) other;
        return this.getArea() > r2.getArea() ? 1 : this.getArea() == r2.getArea() ? 0 : -1;
    }
}
