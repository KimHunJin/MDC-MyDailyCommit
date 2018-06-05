package algorithm.hackerrank;

import java.util.Scanner;

public class Candies {


    static int cccc(int n, int[] arr) {
        int[] c = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1])
                c[i] = c[i - 1] + 1;
            else
                c[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                c[i] = Math.max(c[i], c[i + 1] + 1);
        }
        long sum = 0;
        for (int x : c) {
            sum += x;
        }

        int s = Integer.parseInt(sum + "");

        for(long f : c) {
            System.out.print(f + " ");
        }
        System.out.println();
        return s;
    }

    static int candies(int n, int[] arr) {
        // Complete this function

        return cccc(n,arr);
    }

    void gdf(int n, int[] arr) {
        int candy = 1;
        int[] candyArr = new int[n];
        int candies;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) candy++;
            else if (arr[i] < arr[i - 1]) candy = 1;
            else if (arr[i] == arr[i - 1]) candy = candyArr[i - 1] > 1 ? 1 : candyArr[i - 1] + 1;
            candyArr[i] = candy;
        }
        candy = 1;
        candies = candyArr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) candy++;
            else if (arr[i] < arr[i + 1]) candy = 1;
            else if (arr[i] == arr[i + 1]) candy = candyArr[i + 1] > 1 ? 1 : candyArr[i + 1] + 1;
            candyArr[i] = candy > candyArr[i] ? candy : candyArr[i];
            candies += candyArr[i];
        }

        for (int s : candyArr) {
            System.out.print(s + " ");
        }
        System.out.println();

    }

    private void fff(int n, int[] arr) {
        int candies = 0;
        int[] candyArr = new int[n];

        for (int i = 0; i < n; i++) {
            int candy = 1;
            int before;
            int beforeCandy;
            int after;
            if (i > 0) {
                before = arr[i - 1];
                beforeCandy = candyArr[i - 1];
            } else {
                before = Integer.MAX_VALUE;
                beforeCandy = 1;
            }
            int current = arr[i];
            if (i < n - 1) {
                after = arr[i + 1];
            } else {
                after = Integer.MAX_VALUE;
            }

            if (current > before) {
                candy = beforeCandy + 1;
            }

            if (current < before && current > after) {
                candy++;
            }

            if (current == before) {
                if (beforeCandy > 1) {
                    candy = beforeCandy - 1;
                } else {
                    candy = beforeCandy + 1;
                }
            }

            candyArr[i] = candy;
        }

        for (int i = n - 1; i >= 0; i--) {
            int candy = 1;
            int before;
            int beforeCandy;
            int after;
            if (i < n - 1) {
                before = arr[i + 1];
                beforeCandy = candyArr[i + 1];
            } else {
                before = Integer.MAX_VALUE;
                beforeCandy = 1;
            }
            int current = arr[i];
            if (i > 0) {
                after = arr[i - 1];
            } else {
                after = Integer.MAX_VALUE;
            }

            if (current > before) {
                candy = beforeCandy + 1;
            }

            if (current < before && current > after) {
                candy++;
            }

            if (current == before) {
                if (beforeCandy > 1) {
                    candy = beforeCandy - 1;
                } else {
                    candy = beforeCandy + 1;
                }
            }

            candyArr[i] = candy > candyArr[i] ? candy : candyArr[i];
            candies += candyArr[i];
        }


        for (int s : candyArr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private void candydd(int arr[], int n) {
        int candy = 1;
        int[] candyArr = new int[n];
        int candies;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) candy++;
            else if (arr[i] < arr[i - 1]) candy = 1;
            else if (arr[i] == arr[i - 1]) candy = candyArr[i - 1] > 1 ? 1 : candyArr[i - 1] + 1;
            candyArr[i] = candy;
        }
        candy = 1;
        candies = candyArr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) candy++;
            else if (arr[i] < arr[i + 1]) candy = 1;
            else if (arr[i] == arr[i + 1]) candy = candyArr[i + 1] > 1 ? 1 : candyArr[i + 1] + 1;
            candyArr[i] = candy > candyArr[i] ? candy : candyArr[i];
            candies += candyArr[i];
        }

        for (int s : candyArr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
