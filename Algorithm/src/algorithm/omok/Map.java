package algorithm.omok;

/**
 * Created by HunJin on 2017-06-13.
 */

/**
 * 참고 코드
 * http://message0412.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%98%A4%EB%AA%A9%EA%B2%8C%EC%9E%84-%EB%A7%8C%EB%93%A4%EA%B8%B0
 **/
public class Map {

    private short[][] map;// 맵의 배열 1일때 흑,-1일때 백, 0일때 돌이 안놓여짐
    private Gravity gr;
    private final short BLACK = 1;
    private final short WHITE = -1;
    private boolean checkBNW = true;// 흑백차례확인 흑돌 먼저 = user 먼저

    public Map(MapSize ms) {
        map = new short[ms.getSize()][];
        for (int i = 0; i < map.length; i++) {
            map[i] = new short[ms.getSize()];
        }
    }

    public short getBlack() {
        return BLACK;
    }

    public short getWhite() {
        return WHITE;
    }

    public short getXY(int y, int x) {
        return map[y][x];

    }

    public boolean getCheck() {
        return checkBNW;
    }

    public void changeCheck() {
        if (checkBNW) {
            checkBNW = false;
        } else {
            checkBNW = true;
        }
    }

    public void setMap(int y, int x) {
        // checkBNW를 확인해 true일 때 map에 BLACK, false일 때 WHITE저장

        if (checkBNW) {
            map[y][x] = BLACK;
        } else {
            map[y][x] = WHITE;
        }
    }

    // 승리확인
    public boolean winCheck(int x, int y) {
        if (winCheckL(x, y) || winCheckLD(x, y) || winCheckLU(x, y)
                || winCheckR(x, y)

                || winCheckRD(x, y) || winCheckRU(x, y) || winCheckUp(x, y)
                || winCheckDown(x, y)

                || winCheckOneDown(x, y) || winCheckOneL(x, y)
                || winCheckOneLD(x, y) || winCheckOneLU(x, y)

                || winCheckOneR(x, y) || winCheckOneRD(x, y)
                || winCheckOneUp(x, y) || winCheckOneRU(x, y)

                || winCheckCenterLU(x, y) || winCheckCenterRL(x, y)
                || winCheckCenterRU(x, y) || winCheckCenterUD(x, y)) {
            return true;
        } else {

            return false;
        }
    }

    // 위쪽
    public boolean winCheckUp(int x, int y) {
        try {
            for (int i = y; i < y + 5; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckDown(int x, int y) {
        try {
            for (int i = y; i > y - 5; i--) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckRU(int x, int y) {
        try {
            for (int i = y, z = x; i > y - 5; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckLU(int x, int y) {
        try {
            for (int i = y, z = x; i > y - 5; i--, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckR(int x, int y) {
        try {
            for (int z = x; z < x + 5; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckL(int x, int y) {
        try {
            for (int i = y, z = x; z > x - 5; z--) {
                if (map[y][x] != map[i][z] || i > 19 || z > 19 || i < 0
                        || z < 0)
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckRD(int x, int y) {
        try {
            for (int i = y, z = x; i < y + 5; i++, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean winCheckLD(int x, int y) {
        try {
            for (int i = y, z = x; i < y + 5; i++, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 위쪽
    public boolean winCheckOneUp(int x, int y) {
        try {
            for (int i = y - 1; i < y + 4; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 아래쪽
    public boolean winCheckOneDown(int x, int y) {
        try {
            for (int i = y + 1; i > y - 4; i--) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 오른쪽 위 대각선

    public boolean winCheckOneRU(int x, int y) {
        try {
            for (int i = y + 1, z = x - 1; i > y - 4; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 왼쪽 위 대각선

    public boolean winCheckOneLU(int x, int y) {
        try {
            for (int i = y + 1, z = x + 1; i > y - 4; i--, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 오른쪽
    public boolean winCheckOneR(int x, int y) {
        try {
            for (int z = x - 1; z < x + 4; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 왼쪽
    public boolean winCheckOneL(int x, int y) {
        try {
            for (int z = x + 1; z > x - 4; z--) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 오른쪽 아래 대각선
    public boolean winCheckOneRD(int x, int y) {
        try {
            for (int i = y - 1, z = x - 1; i < y + 4; i++, z++) {
                if (map[y][x] != map[i][z] || i > 19 || z > 19 || i < 0
                        || z < 0)
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 한칸 왼쪽 아래 대각선
    public boolean winCheckOneLD(int x, int y) {
        try {
            for (int i = y - 1, z = x + 1; i < y + 4; i++, z--) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            return false;
        }
        return true;
    }

    // 센터 업다운

    public boolean winCheckCenterUD(int x, int y) {
        try {
            for (int i = y - 2; i < y + 3; i++) {
                if (map[y][x] != map[i][x])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 센터 라이트 레프트

    public boolean winCheckCenterRL(int x, int y) {
        try {
            for (int z = x - 2; z < x + 3; z++) {
                if (map[y][x] != map[y][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 센터 라이트 대각선

    public boolean winCheckCenterRU(int x, int y) {
        try {
            for (int i = y + 2, z = x - 2; i > y - 3; i--, z++) {
                if (map[y][x] != map[i][z])
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // 센터 레프트 대각선
    public boolean winCheckCenterLU(int x, int y) {
        try {
            for (int i = y + 2, z = x + 2; i > y - 4; i--, z--) {
                if (map[y][x] != map[i][z])

                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            return false;
        }
        return true;
    }

}
