package algorithm.line;

import java.util.*;

public class Curling {
    public static void main(String[] args) {
        new Curling().solve();
    }

    class Cur implements Comparable<Cur> {
        int dis;
        String name;

        Cur(int dis, String name) {
            this.dis = dis;
            this.name = name;
        }

        @Override
        public int compareTo(Cur o) {
            if (this.dis > o.dis) {
                return 1;
            } else if (this.dis < o.dis) {
                return -1;
            }
            return 0;
        }
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine());

            Queue<Cur> q = new PriorityQueue<>();

            List<Integer> listB = new ArrayList<>();
            List<Integer> listC = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] tmp = sc.nextLine().split(" ");
                int x = Integer.parseInt(tmp[0]);
                int y = Integer.parseInt(tmp[1]);
                int dis = (int) (Math.pow(x, 2)) + (int) (Math.pow(y, 2));

                if(tmp[2].equals("Brown")) {
                    listB.add(dis);
                } else {
                    listC.add(dis);
                }

                q.add(new Cur(dis, tmp[2]));
            }

            Collections.sort(listB);
            Collections.sort(listC);

            int count = 0;
            String cName = q.peek().name;

            if(cName.equals("Brown")) {
                for(int i=0;i<listB.size();i++) {
                    if(listB.get(i) < listC.get(0)) {
                        count++;
                    } else {
                        break;
                    }
                }
            } else {
                for(int i=0;i<listC.size();i++) {
                    if(listC.get(i) < listB.get(0)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(cName + " " + count);
        }
    }
}
