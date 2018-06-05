package junbsub;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class Parsing {

    private static final String URL = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=";

    private List<Model> parsingList = new ArrayList<>();

    Parsing() {
        parsingData();
    }

    List<Model> getParsingList() {
        return parsingList;
    }

    // 파싱하여 데이터를 리스트에 담는다.
    private void parsingData() {
        List<String> locationList = new LocationNumber().getLocation();
        for (String s : locationList) {
            String kURL = URL + s;
            try {
                Document doc = Jsoup.connect(kURL).get();
                Elements loc = doc.select("data");
                Elements rootHeader = doc.select("header");

                String corDateTime = rootHeader.select("tm").html();
                corDateTime = corDateTime.substring(0, 8);

                List<ParsingModel> parsingModelList = new ArrayList<>();

                for (Element element : loc) {

                    String hour = element.select("hour").html();
                    String pop = element.select("pop").html();
                    String temp = element.select("temp").html();
                    String weather = element.select("wfKor").html();
                    ParsingModel parsingModel = new ParsingModel(s, hour, pop, temp, weather);
                    parsingModelList.add(parsingModel);
                }

                Model model = new Model(corDateTime, parsingModelList);
                parsingList.add(model);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
