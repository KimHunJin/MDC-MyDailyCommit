package algorithm.kakao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HunJin on 2017-08-26.
 */
public class FriendsColoringBook {
    public static void main(String[] args) {
        new FriendsColoringBook().solve();
    }

    public void solve() {
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        int[][] picture2 = {
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}
        };

        int[][] picture3 = {
                {1, 0},
                {0, 1}
        };

        int[][] picture4 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0}
        };

        int[][] picture5 = {
                {1, 1, 1, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0}
        };

        int[][] picture6 = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                picture6[i][j] = 0;
            }
        }

        picture6[0][0] = 1;
        picture6[99][99] = 1;
        picture6[50][50] = 1;
        picture6[0][99] = 1;
        picture6[99][0] = 1;

        int[] s = solution3(5, 9, picture4);
        System.out.println(s[0] + " : " + s[1]);
    }

    public boolean[][] isCheck = null;

    public int[] solution3(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        isCheck = new boolean[m][n];
        for (int i = 0; i < isCheck.length; i++) {
            for (int j = 0; j < isCheck[i].length; j++) {
                isCheck[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0) {
                    int value = re(i, j, picture, picture[i][j]);
                    if (value > 0) {
                        numberOfArea++;
                        if (value > maxSizeOfOneArea) {
                            maxSizeOfOneArea = value;
                        }
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int re(int x, int y, int[][] picture, int color) {
        if (x < 0 || x > picture.length - 1 || y < 0 || y > picture[0].length - 1 || picture[x][y] != color || isCheck[x][y] == true) {
            return 0;
        } else {
            isCheck[x][y] = true;
            int a = re(x - 1, y, picture, color);
            int b = re(x + 1, y, picture, color);
            int c = re(x, y - 1, picture, color);
            int d = re(x, y + 1, picture, color);
            return a + b + c + d + 1;
        }
    }


    boolean checkList[][];
    int maxY, maxX;

    public int[] solution2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        checkList = new boolean[m][n];
        maxY = m;
        maxX = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkList[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkList[i][j] == true || picture[i][j] == 0) {
                    continue;
                }
                int result = checkPixel(picture, i, j, picture[i][j]);
                if (result != 0) {
                    numberOfArea++;
                    if (maxSizeOfOneArea < result) {
                        maxSizeOfOneArea = result;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }


    public int checkPixel(int[][] picture, int y, int x, int curColor) {
        int color = picture[y][x];
        if (checkList[y][x] == true || color == 0 || color != curColor) {
            return 0;
        }
        checkList[y][x] = true;

        int count = 1;
        if (y > 0) {
            count += checkPixel(picture, y - 1, x, curColor);
        }
        if (y < maxY - 1) {
            count += checkPixel(picture, y + 1, x, curColor);
        }
        if (x > 0) {
            count += checkPixel(picture, y, x - 1, curColor);
        }
        if (x < maxX - 1) {
            count += checkPixel(picture, y, x + 1, curColor);
        }
        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0) {
                    int value = fill(i, j, picture, picture[i][j]);
                    result.add(value);
                    if (value > maxSizeOfOneArea) {
                        maxSizeOfOneArea = value;
                    }
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        numberOfArea = result.size();

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public int fill(int x, int y, int[][] picture, int v) {
        if (picture[x][y] <= 0 || picture[x][y] != v) {
            return 0;
        } else {
            int count = 1;
            picture[x][y] = -1;
            if (x > 0) {
                count += fill(x - 1, y, picture, v);
            }
            if (x < picture.length - 1) {
                count += fill(x + 1, y, picture, v);
            }
            if (y > 0) {
                count += fill(x, y - 1, picture, v);
            }
            if (y < picture[0].length - 1) {
                count += fill(x, y + 1, picture, v);
            }
            return count;

        }
    }
}
