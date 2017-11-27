package algorithm.nhn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NHNE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] orderby = sc.nextLine().split(" ");
        int people = Integer.parseInt(sc.nextLine(), 10);

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            String[] k = sc.nextLine().split(" ");
            Person person = new Person();
            person.sex = k[0];
            person.age = Integer.parseInt(k[1]);
            if (k.length > 2) {
                person.option = k[2];
            }
            list.add(person);
        }
        for (int i = orderby.length - 1; i < orderby.length; i++) {
            sort(list, Integer.parseInt(orderby[i]));
        }

        for(int i=0;i<list.size();i++) {
            String s = list.get(i).sex + " " + list.get(i).age + " " + list.get(i).option;
            System.out.println(s.trim());
        }
    }

    static void sort(List<Person> list, int order) {
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                switch (order) {
                    case 1: {
                        if (o1.sex.equals("F") && o2.sex.equals("M")) {
                            return 1;
                        } else if (o1.sex.equals("M") && o2.sex.equals("F")) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                    case 2: {
                        if (o1.age <= 7 && o2.age > 7) {
                            return 1;
                        } else if (o1.age > 7 && o2.age <= 7) {
                            return -1;
                        } else if (o1.age <= 7 && o2.age <= 7) {
                            return 0;
                        } else {
                            if (o1.age > o2.age) {
                                return 1;
                            } else if (o1.age < o2.age) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                    case 3: {
                        if ((o1.option.equals("PW") && o2.option.equals("DP")) || (o1.option.equals("PW") && o2.option.equals("P")) || (o1.option.equals("PW") && o2.option.equals(""))) {
                            return 1;
                        } else if (o1.option.equals("DP") && o2.option.equals("PW")) {
                            return -1;
                        } else if (o1.option.equals("DP") && o2.option.equals("P")) {
                            return 1;
                        } else if ((o1.option.equals("P") && o2.option.equals("PW")) || (o1.option.equals("P") && o2.option.equals("DP"))) {
                            return -1;
                        } else if ((o1.option.equals("") && o2.option.equals("PW")) ||
                                (o1.option.equals("") && o2.option.equals("DP")) ||
                                (o1.option.equals("") && o2.option.equals("P"))) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        };
        list.sort(comparator);
    }

    static class Person {
        String sex;
        int age;
        String option = "";
    }
}
