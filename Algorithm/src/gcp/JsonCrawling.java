package gcp;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonCrawling {
    private static final String PATH = "file/results-20180331-020104.json";

    private static final String BaseURL = "https://www.googleapis.com/customsearch/v1?cx=005851474369958139785%3Af7ohain-vus&searchType=image&key=AIzaSyCMICjcAo9i_UGbRcQ_b22m4lYKIAT4GXc";

    private DBConnect dbConnect;

    public static void main(String[] args) {
        JsonCrawling jc = new JsonCrawling();
        jc.dbConnect = new DBConnect();
        jc.readFile(PATH);
    }

    private void readFile(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String s;

            while ((s = in.readLine()) != null) {
                readJsonFile(s.trim());
            }
            in.close();
            dbConnect.close();
        } catch (IOException e) {
            System.err.println(e); // 에러가 있다면 메시지 출력
            System.exit(1);
        }
    }

    private int rank = 1;

    private void readJsonFile(String json) throws IOException {

        Gson gson = new Gson();
        Names n = gson.fromJson(json, Names.class);
        String name = n.getNames_step_1_name();
        String gender = n.getNames_step_1_gender();
        String url = BaseURL + "&q=" + name;
//        dbConnect.insertNameData("insert into INFO values(" + rank + ",'" + name + "','" + gender + "'," + rank + ");");
        readJsonURL(url);
    }

    private void readJsonURL(String url) {
        try {
            String json = readUrl(url);
            Gson gson = new Gson();
            Search search = gson.fromJson(json, Search.class);
            int n = search.getItems().length;
            for (int i = 0; i < n; i++) {
                String imgUrl = search.getItems()[i].getLink();
                System.out.println(imgUrl);
//                dbConnect.insertNameData("insert into IMAGEINFO values(" + rank + ",'" + imgUrl + "', null" + ");");
            }

            rank++;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}

class Search {
    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}

class Item {
    private Image image;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

class Image {
    private String thumbnailLink;

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }
}


class Names {
    private String names_step_1_name;
    private String names_step_1_gender;
    private String namesstep1totalpopulat_1;

    public String getNames_step_1_name() {
        return names_step_1_name;
    }

    public void setNames_step_1_name(String names_step_1_name) {
        this.names_step_1_name = names_step_1_name;
    }

    public String getNames_step_1_gender() {
        return names_step_1_gender;
    }

    public void setNames_step_1_gender(String names_step_1_gender) {
        this.names_step_1_gender = names_step_1_gender;
    }

    public String getNamesstep1totalpopulat_1() {
        return namesstep1totalpopulat_1;
    }

    public void setNamesstep1totalpopulat_1(String namesstep1totalpopulat_1) {
        this.namesstep1totalpopulat_1 = namesstep1totalpopulat_1;
    }
}
