package notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HunJin on 2017-04-09.
 */
public class ForEach {
    public static void main(String[] args) {
        int[][] av = {{1,1},{2,2},{1,2}};

        List<Integer> list = new ArrayList();
        List<Integer> list2 = new ArrayList();

        for(int i=0;i<av.length;i++) {
            if(list.isEmpty()) {
                list.add(av[i][0]);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (av[i][0] == list.get(j)) {
                        list.remove(j);
                    } else {
                        list.add(av[i][0]);
                    }
                }
            }
            if(list2.isEmpty()) {
                list2.add(av[i][1]);
            } else {
                for (int j = 0; j < list2.size(); j++) {
                    if (av[i][1] == list2.get(j)) {
                        list2.remove(j);
                    } else {
                        list2.add(av[i][1]);
                    }
                }
            }
        }

        for(int i=0;i<list.size();i++) {
            System.out.println("list 1 : " + list.get(i));
        }
        for(int i=0;i<list2.size();i++) {
            System.out.println("list 2 : " + list2.get(i));
        }
    }
}
