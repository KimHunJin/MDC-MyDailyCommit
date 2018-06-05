package algorithm.line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class NeerShop {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
            int userX = Integer.parseInt(tokens.nextToken());
            int userY = Integer.parseInt(tokens.nextToken());
            int shopCount = Integer.parseInt(tokens.nextToken());

            List<ShopInfo> list = new ArrayList<>();
            for (int i = 0; i < shopCount; i++) {
                tokens = new StringTokenizer(br.readLine().trim());
                int shopX = Integer.parseInt(tokens.nextToken());
                int shopY = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                int coupon = Integer.parseInt(tokens.nextToken());

                ShopInfo s = new ShopInfo();
                s.x = shopX;
                s.y = shopY;
                s.distance = (((int) (Math.hypot(shopX-userX, shopY-userY)))/100)*100;
                s.name = name;
                s.coupon = coupon;
                list.add(s);
            }

            Comparator<ShopInfo> comparator = new Comparator<ShopInfo>() {
                @Override
                public int compare(ShopInfo o1, ShopInfo o2) {
                    int result = 0;
                    if (o1.distance < o2.distance) {
                        result = -1;
                    } else if (o1.distance > o2.distance) {
                        result = 1;
                    } else {
                        if (o1.coupon > o2.coupon) {
                            result = -1;
                        } else if (o1.coupon < o2.coupon) {
                            result = 1;
                        } else {
                            for (int i = 0; i < o1.name.length(); i++) {
                                if (o1.name.charAt(i) < o2.name.charAt(i)) {
                                    result = -1;
                                    break;
                                } else if (o1.name.charAt(i) > o2.name.charAt(i)) {
                                    result = 1;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    return result;
                }
            };
            list.sort(comparator);

            for (ShopInfo si : list) {
                System.out.println(si.x + " " + si.y + " " + si.name + " " + si.coupon);
            }
        }
    }

    static class ShopInfo {
        int x;
        int y;
        int distance;
        String name;
        int coupon;
    }
}
