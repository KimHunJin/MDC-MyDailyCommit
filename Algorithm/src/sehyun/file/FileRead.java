package sehyun.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead {

    static String filename = "file/수정중.txt";

    public static void main(String[] args) {

        int count = 1;
////        Pattern p = Pattern.compile("\\d\\d\\d\\d\\.\\d\\d\\.\\d\\d");
//        Pattern p2 = Pattern.compile("^(\\d\\d)?(\\d\\d)^(.)$(0?[1-9]|1[012])^(.)$?(0[1-9]|[12][0-9]|3[01])?");
        String pattern = "^(19|20)?\\d{2}\\.(0[1-9]|1[0-2])(\\.)?(0[1-9]|[12][0-9]|3[01])?";
        Pattern p2 = Pattern.compile(pattern);

        String test = "2017.01.22";
//        Matcher t = p2.matcher(test);
//        System.out.println(t.find());

        Matcher t2 = p2.matcher(test);
//
        System.out.println(t2.find());

        String s = "";
        List<String> arr = new ArrayList<>();
        String make = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {

//
            while ((s = br.readLine())!=null) {
                String[] lines = s.split(" ");
                for(String line : lines) {
                    Matcher m = p2.matcher(line);
                    if(m.find()) {
                        arr.add(make);
                        make = line + " ";
                    } else {
                        make += line + " ";
                    }
                }
                count++;
            }

            FileOutputStream output = new FileOutputStream("file/out.txt");
            for(int i=0;i<arr.size();i++) {
                String data = arr.get(i).trim()+"\r\n";
                output.write(data.getBytes());
            }
            output.close();

        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
