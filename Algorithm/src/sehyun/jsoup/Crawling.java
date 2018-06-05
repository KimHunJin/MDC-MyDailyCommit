package sehyun.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawling {
    public static void main(String[] args) throws IOException {
        String url = "http://bus.go.kr/busArrivePlanIfoPopup.jsp?station=110000128&busRouteId=100100154&seq=69&stationNm=%EB%8F%99%EC%95%84%EB%B6%88%EC%95%94%EC%95%84%ED%8C%8C%ED%8A%B8&wbustp=N";
//        Document doc = Jsoup.connect("").get();
//
//        System.out.println(doc.html());
//        String text =doc.select("div#teacher_jaranda_introduction.teacher-info.teacher-jaranda-introduction").html();

//        Connection.Response response = Jsoup.connect(url)
//                .method(Connection.Method.GET)
//                .execute();
//        Document google3 = response.parse();
//
//        System.out.println(google3.html());

        Document rawData = Jsoup.connect(url)
                .timeout(5000)
                .get();

        System.out.println(rawData.html());
    }
}
