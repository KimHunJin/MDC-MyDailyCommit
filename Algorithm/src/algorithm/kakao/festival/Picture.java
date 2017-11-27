package algorithm.kakao.festival;

import java.util.ArrayList;
import java.util.List;

public class Picture {
    public static void main(String[] args) {

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(new Picture().solution3(2, data));
    }

    static int answer;

    static int solution2(int n, String[] data) {
        char[] mb = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        ArrayList<Character> members = new ArrayList<>();
        ArrayList<Character> raw = new ArrayList<>();
        ArrayList<condition> conditions = new ArrayList<>();

        for (char i : mb) {
            members.add(i);
        }
        for (String i : data) {
            condition cdt = new condition(i);
            conditions.add(cdt);
        }

        answer = 0;
        compare(members, conditions, raw);

        return answer;
    }

    static List<String> list = new ArrayList<>();

    static public int solution3(int n, String[] data) {
        int answer = 0;
        solution3(n, data, "", "ACFJMNRT");
        answer = list.size();
        return answer;
    }

    static private void solution3(int n, String[] data, String names, String remainder) {
        if (names.length() == 8) {
            list.add(names);
            return;
        }

        exit:
        for (int i = 0; i < remainder.length(); i++) {
            String namesAfter = names + remainder.charAt(i);
            for (int q = 0; q < n; q++) {
                String send = data[q].charAt(0) + "";
                String receive = data[q].charAt(2) + "";
                String oper = data[q].charAt(3) + "";
                String num = data[q].charAt(4) + "";
                if (!namesAfter.contains(send) || !namesAfter.contains(receive))
                    continue;
                if (oper.equals("=")) {
                    if (Math.abs(namesAfter.indexOf(send) - namesAfter.indexOf(receive)) != Integer.parseInt(num + "") + 1) {
                        continue exit;
                    }
                } else if (oper.equals("<")) {
                    if (Math.abs(namesAfter.indexOf(send) - namesAfter.indexOf(receive)) >= Integer.parseInt(num + "") + 1) {
                        continue exit;
                    }
                } else {
                    if (Math.abs(namesAfter.indexOf(send) - namesAfter.indexOf(receive)) <= Integer.parseInt(num + "") + 1) {
                        continue exit;
                    }
                }
            }
            String remainderAfter = remainder.replaceAll(remainder.charAt(i) + "", "");
            solution3(n, data, namesAfter, remainderAfter);
        }
    }

    private static void compare(ArrayList<Character> members, ArrayList<condition> conditions, ArrayList<Character> raw) {
        if (members.isEmpty()) {
            for (condition i : conditions) {
                if (!i.test(raw)) {
                    return;
                }
            }
            answer++;
        }
        for (int i = 0; i < members.size(); i++) {
            char c = members.get(i);
            raw.add(c);
            members.remove(i);
            compare(members, conditions, raw);
            raw.remove((Character) c);
            members.add(i, c);
        }
    }

    private static class condition {
        char c1, c2, op;
        int val;

        public condition(String data) {
            c1 = data.charAt(0);
            c2 = data.charAt(2);
            op = data.charAt(3);
            val = Integer.parseInt(data.charAt(4) + "");
        }

        public boolean test(ArrayList<Character> raw) {
            int num = Math.abs(raw.indexOf(c1) - raw.indexOf(c2)) - 1;
            switch (op) {
                case '=':
                    if (num == val) {
                        return true;
                    }
                    break;
                case '>':
                    if (num > val) {
                        return true;
                    }
                    break;
                case '<':
                    if (num < val) {
                        return true;
                    }
                    break;
            }

            return false;
        }
    }

    static int solution(int n, String[] data) {
        char[] s = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        int count = 0;

        for (int a = 0; a < s.length; a++) {
            for (int b = 0; b < s.length; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 0; c < s.length; c++) {
                    if (c == a || c == b) {
                        continue;
                    }
                    for (int d = 0; d < s.length; d++) {
                        if (d == c || d == a || d == b) {
                            continue;
                        }
                        for (int e = 0; e < s.length; e++) {
                            if (e == d || e == a || e == b || e == c) {
                                continue;
                            }
                            for (int f = 0; f < s.length; f++) {
                                if (f == e || f == d || f == c || f == b || f == a) {
                                    continue;
                                }
                                for (int g = 0; g < s.length; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) {
                                        continue;
                                    }
                                    for (int h = 0; h < s.length; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) {
                                            continue;
                                        }
                                        String makeS = "" + s[a] + s[b] + s[c] + s[d] + s[e] + s[f] + s[g] + s[h];

                                        boolean isCheck = false;
                                        for (int i = 0; i < data.length; i++) {
                                            char first = data[i].charAt(0);
                                            char second = data[i].charAt(2);
                                            char inequality = data[i].charAt(3);
                                            int distance = data[i].charAt(4) - 48;

                                            int firstIndex = makeS.indexOf(first);
                                            int secondIndex = makeS.indexOf(second);
                                            switch (inequality) {
                                                case '=': {
                                                    if (Math.abs(firstIndex - secondIndex) == distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '>': {
                                                    if (Math.abs(firstIndex - secondIndex) > distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '<': {
                                                    if (Math.abs(firstIndex - secondIndex) < distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                            }
                                            if (isCheck == false) {
                                                break;
                                            }
                                        }
                                        if (isCheck) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return count;
    }
}
