package algorithm.samsung;

import java.util.Scanner;

public class Supervisor {
    public static void main(String[] args) {
        new Supervisor().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        long result = 0;
        int n = sc.nextInt();

        int[] people = new int[n];

        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        int superVisor = sc.nextInt();
        int visor = sc.nextInt();

        for (int i = 0; i < people.length; i++) {
            if (people[i] > superVisor) {
                people[i] -= superVisor;
                result += 1;
                result += people[i] / visor;
                if (people[i] % visor > 0) {
                    result += 1;
                }
            } else {
                result += 1;
            }
        }

        System.out.println(result);

    }

}
