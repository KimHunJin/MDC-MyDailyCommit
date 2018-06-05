package sehyun.subject;

/**
 * Created by HunJin on 2016-11-15.
 */
public class RectangleTest {

    public static void main(String[] args) throws Exception{
        Rectangle r1 = new Rectangle(100, 30);
        Rectangle r2 = new Rectangle(200, 10);

        int result = r1.compareTo(r2);
        if (result > 0)
            System.out.println(r1 + " is bigger than " + r2);
        else if (result < 0)
            System.out.println(r1 + " is smaller than " + r2);
        else
            System.out.println(r1 + " is equal to " + r2);

        System.out.println("Creating an Array of Rectangle-------");
        // create an array of Rectangles - Rects[] with length = 5

        Object[] Rects = new Rectangle[5];

        Rects[0] = new Rectangle(50, 120);
        Rects[1] = new Rectangle(10, 200);
        Rects[2] = new Rectangle(200, 105);
        Rects[3] = new Rectangle(150, 300);
        Rects[4] = new Rectangle(10, 20);

        System.out.println("Before Sorting ----------------------");
        for (int i = 0; i < Rects.length; i++)
            System.out.println(Rects[i]);

        java.util.Arrays.sort(Rects);

        System.out.println("After Sorting ----------------------");
        for (int i = 0; i < Rects.length; i++)
            System.out.println(Rects[i]);
    }
}
