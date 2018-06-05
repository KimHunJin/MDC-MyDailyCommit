package junbsub;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class DataProcess {
    private List<Model> models;
    private Database db;

    private Calendar calendar = Calendar.getInstance();
    private Date date = calendar.getTime();
    private String pubDateTime = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));

    DataProcess(List<Model> models) {
        this.models = models;
        db = new Database();
    }

    void startProcess() {
        process();
    }

    private void process() {
        for (Model m : models) {
            String corDate = m.getCorDate();
            List<ParsingModel> list = m.getModelList();

            for (ParsingModel pm : list) {
                String dateTime;
                switch (pm.getHour()) {
                    case "24": {
                        corDate = (Long.parseLong(corDate) + 1) + "";
                        dateTime = corDate + "000000";
                        break;
                    }
                    case "3": {
                        dateTime = corDate + "030000";
                        break;
                    }
                    case "6": {
                        dateTime = corDate + "060000";
                        break;
                    }
                    case "9": {
                        dateTime = corDate + "090000";
                        break;
                    }
                    case "12": {
                        dateTime = corDate + "120000";
                        break;
                    }
                    case "15": {
                        dateTime = corDate + "150000";
                        break;
                    }
                    case "18": {
                        dateTime = corDate + "180000";
                        break;
                    }
                    case "21": {
                        dateTime = corDate + "210000";
                        break;
                    }
                    default: {
                        dateTime = "00000000000000";
                        break;
                    }
                }
                insertData(dateTime, pm);
            }
        }
    }

    private void insertData(String dateTime, ParsingModel pm) {

        boolean isInsert = db.select(pm.getLocation(), dateTime);
        if (isInsert) {
            db.insert(pm.getLocation(), dateTime, pm.getTemp(), pm.getPop(), pubDateTime, pm.getWeather());
        } else {
            db.update(pm.getLocation(), dateTime, pm.getTemp(), pm.getPop(), pubDateTime, pm.getWeather());
        }
    }
}
