package algorithm.nhn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NHNTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> pocket = new ArrayList();
        List<String> result = new ArrayList();

        String[] number = sc.nextLine().split(" ");

        for(int i=0;i<number.length;i++) {
            if(pocket.size() < 3) {
                pocket.add(0,number[i]);
            } else {
                if(pocket.contains(number[i])) {
                    pocket.remove(number[i]);
                    pocket.add(0,number[i]);
                } else {
                    result.add(pocket.get(2));
                    pocket.remove(2);
                    pocket.add(0,number[i]);
                }
            }
        }
        if(result.size() == 0 ) {
            System.out.println(0);
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
