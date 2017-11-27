package algorithm.kakao;

import java.util.Stack;

/**
 * Created by HunJin on 2017-08-05.
 */
public class HeavenLoad {
    int mod = 20170805;

    public static void main(String[] args) {
//        int[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(solution3(6, 3, map));
    }

    public static class Position {
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    static int solution4(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] cMap = new int[m][n];
        for(int i=0;i<n;i++) {
            if(cityMap[0][i] == 0) {
                cMap[0][i] = 1;
            }
        }


        return answer;

    }


    static int solution3(int m, int n, int[][] cityMap) {
        int answer = 0;

        answer = re(0, 0, cityMap, 3);

        return answer;
    }

    static int re2(int m, int n, int[][] cityMap) {
        int[] s = new int[m];
        for (int i = 0; i < cityMap.length; i++) {
            if (cityMap[i][0] == 1) {
                s[i] = 0;
            } else if (cityMap[i][0] == 2) {
                s[i] = 1;
            }
        }


        return 1;
    }

    static int re(int m, int n, int[][] cityMap, int type) {
        if (m == cityMap.length - 1 && n == cityMap[0].length - 1) {
            return 1;
        } else {
            if (m > cityMap.length - 1 || n > cityMap[0].length - 1) {
                return 0;
            } else {
                if (cityMap[m][n] == 0) {
                    return re(m + 1, n, cityMap, 3) + re(m, n + 1, cityMap, 4);
                } else if (cityMap[m][n] == 1) {
                    return 0;
                } else {
                    if (type == 3) {
                        return re(m + 1, n, cityMap, 3);
                    } else {
                        return re(m, n + 1, cityMap, 4);
                    }
                }
            }
        }
    }


    static int solution2(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] original;

        original = cityMap.clone();

        int i = 0;
        int j = 0;
        Stack<Position> s = new Stack<>();
        s.push(new Position(i, j));
        cityMap[0][0] = 4;
        i++;
        while (!s.isEmpty() || cityMap[0][0] != 1) {


            if (i > cityMap.length - 1 || j > cityMap[0].length - 1) {
                i = s.peek().x;
                j = s.peek().y;
                s.pop();
            }
            if (cityMap[i][j] == 0) {
                cityMap[i][j] = 4;
                s.push(new Position(i, j));
                i++;
            } else if (cityMap[i][j] == 1) {
                i = s.peek().x;
                j = s.peek().y;
                s.pop();
            } else if (cityMap[i][j] == 2) {
                if (s.peek().x == i) {
                    j++;
                } else if (s.peek().y == j) {
                    i++;
                }
            } else if (cityMap[i][j] == 4) {
                cityMap[i][j] = 1;
                s.push(new Position(i, j));
                j++;
            }
            if (i == cityMap.length - 1 && j == cityMap[0].length - 1) {
                answer++;
                System.out.println("도착");
                i = s.peek().x;
                j = s.peek().y;
                s.pop();
            }

            for (int k = 0; k < cityMap.length; k++) {
                for (int l = 0; l < cityMap[k].length; l++) {
                    System.out.print(cityMap[l][k] + " ");
                }
                System.out.println();
            }

            System.out.println();
            System.out.println();
        }

        return answer;
    }

    static int solution(int m, int n, int[][] cityMap) {
        Stack<Position> s = new Stack();
        int answer = 0;
        int i = 0;
        int j = 0;
        int loop = caseNumber(m, n);
        while (loop > 0) {
            if (cityMap[i][j] == 0) {
                if (i + 1 > cityMap.length - 1) {
                    i = s.peek().x;
                    j = s.peek().y;
                    s.pop();
                    loop--;
                    if (j + 1 > cityMap[i].length - 1) {
                        i = s.peek().x;
                        j = s.peek().y;
                        s.pop();
                        loop--;
                    } else {
                        j++;
                        s.push(new Position(i, j));
                    }
                } else {
                    i++;
                    s.push(new Position(i, j));
                }
            }
            if (cityMap[i][j] == 1) {
                i = s.peek().x;
                j = s.peek().y;
                s.pop();
            }
            if (cityMap[i][j] == 2) {
                if (i == s.peek().x) {
                    j++;
                }
                if (j == s.peek().y) {
                    i++;
                }
                s.push(new Position(i, j));
            }
        }

        return answer;
    }

    static int caseNumber(int m, int n) {
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int sum = m + n;
        int za = sum - max;

        int returnValue = 0;

        for (int i = 0; i < za; i++) {
            returnValue += sum / min;
            sum--;
            min--;
        }

        return returnValue;
    }
}
