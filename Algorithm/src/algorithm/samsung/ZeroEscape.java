package algorithm.samsung;

import java.util.Scanner;

public class ZeroEscape {
    public static void main(String[] args) {
        new ZeroEscape().solve();
    }

    private int redX, redY, blueX, blueY, holeX, holeY;

    int result = Integer.MAX_VALUE;

    private static final char WALL = '#';
    private static final char ROAD = '.';
    private static final char HOLE = 'O';
    private static final char RED = 'R';
    private static final char BLUE = 'B';

    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    private static final int FAIL = 100;

    private void solve() {
        char[][] map = input();

        moveInit(map);
    }

    private void moveInit(char[][] map) {
        int rx = redX;
        int ry = redY;
        int bx = blueX;
        int by = blueY;


//        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 4; i++) {
            char[][] maze = initMap(map);
            result = Math.min(result, move(maze, rx, ry, bx, by, i, 1));
        }

        if (result == FAIL) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private char[][] initMap(char[][] map) {
        int sizeX = map.length;
        int sizeY = map[0].length;
        char[][] maze = new char[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                maze[i][j] = map[i][j];
            }
        }
        return maze;
    }

    private int move(char[][] map, int rx, int ry, int bx, int by, int dir, int count) {
        boolean isSuccess = false;
        boolean isFind = false;

        if (count > 10) {
            return FAIL;
        }

        if(result < count) {
            return FAIL;
        }

        switch (dir) {
            case LEFT: {
                boolean isRedLeft = ry < by;
                while (map[rx][ry - 1] != WALL) {
                    map[rx][ry] = ROAD;
                    ry--;

                    if (map[rx][ry] == HOLE) {
                        isFind = true;
                        isSuccess = true;
                        break;
                    }
                }

                while (map[bx][by - 1] != WALL) {
                    map[bx][by] = ROAD;
                    by--;

                    if (map[bx][by] == HOLE) {
                        isFind = true;
                        isSuccess = false;
                        break;
                    }
                }


                if (rx == bx && ry == by && !isFind) {
                    if (isRedLeft) {
                        by++;
                    } else {
                        ry++;
                    }
                }

                map[rx][ry] = RED;
                map[bx][by] = BLUE;

                break;
            }
            case RIGHT: {
                boolean isRedRight = ry > by;
                while (map[rx][ry + 1] != WALL) {
                    map[rx][ry] = ROAD;
                    ry++;

                    if (map[rx][ry] == HOLE) {
                        isFind = true;
                        isSuccess = true;
                        break;
                    }

                }

                while (map[bx][by + 1] != WALL) {
                    map[bx][by] = ROAD;
                    by++;

                    if (map[bx][by] == HOLE) {
                        isFind = true;
                        isSuccess = false;
                        break;
                    }

                }

                if (rx == bx && ry == by && !isFind) {
                    if (isRedRight) {
                        by--;
                    } else {
                        ry--;
                    }
                }
                map[rx][ry] = RED;
                map[bx][by] = BLUE;
                break;
            }
            case UP: {
                boolean isRedTop = rx < bx;
                while (map[rx - 1][ry] != WALL) {
                    map[rx][ry] = ROAD;
                    rx--;

                    if (map[rx][ry] == HOLE) {
                        isFind = true;
                        isSuccess = true;
                        break;
                    }
                }

                while (map[bx - 1][by] != WALL) {
                    map[bx][by] = ROAD;
                    bx--;

                    if (map[bx][by] == HOLE) {
                        isFind = true;
                        isSuccess = false;
                        break;
                    }
                }

                if (rx == bx && ry == by && !isFind) {
                    if (isRedTop) {
                        bx++;
                    } else {
                        rx++;
                    }
                }
                map[rx][ry] = RED;
                map[bx][by] = BLUE;
                break;
            }
            case DOWN: {
                boolean isRedDown = rx > bx;
                while (map[rx + 1][ry] != WALL) {
                    map[rx][ry] = ROAD;
                    rx++;
                    if (map[rx][ry] == HOLE) {
                        isFind = true;
                        isSuccess = true;
                        break;
                    }
                }

                while (map[bx + 1][by] != WALL) {
                    map[bx][by] = ROAD;
                    bx++;
                    if (map[bx][by] == HOLE) {
                        isFind = true;
                        isSuccess = false;
                        break;
                    }
                }

                if (rx == bx && ry == by && !isFind) {
                    if (isRedDown) {
                        bx--;
                    } else {
                        rx--;
                    }
                }
                map[rx][ry] = RED;
                map[bx][by] = BLUE;
                break;
            }
        }

//        int result = Integer.MAX_VALUE;



        if (!isFind) {
            for (int i = 1; i <= 4; i++) {
                char[][] maze = initMap(map);
                if (i != dir) {
                    result = Math.min(result, move(maze, rx, ry, bx, by, i, count + 1));
                }
            }
            return result;
        } else {
            if (isSuccess) {
                return count;
            } else {
                return FAIL;
            }
        }
    }

    private char[][] input() {

        Scanner sc = new Scanner(System.in);
        String dump = sc.nextLine();
        String[] d = dump.split(" ");

        int row = Integer.parseInt(d[0]);
        int col = Integer.parseInt(d[1]);

        char[][] maze = new char[row][col];

        for (int i = 0; i < row; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == RED) {
                    redX = i;
                    redY = j;
                }
                if (c == BLUE) {
                    blueX = i;
                    blueY = j;
                }
                if (c == HOLE) {
                    holeX = i;
                    holeY = j;
                }
                maze[i][j] = c;
            }
        }
        return maze;
    }
}
