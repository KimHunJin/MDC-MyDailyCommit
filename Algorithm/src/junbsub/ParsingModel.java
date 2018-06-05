package junbsub;

import java.util.List;

class ParsingModel {
    private String location;
    private String hour;
    private String pop;
    private String temp;
    private String weather;

    ParsingModel(String location, String hour, String pop, String temp, String weather) {
        this.location = location;
        this.hour = hour;
        this.pop = pop;
        this.temp = temp;
        this.weather = weather;
    }

    String getLocation() {
        return location;
    }

    String getHour() {
        return hour;
    }

    String getPop() {
        return pop;
    }

    String getTemp() {
        return temp;
    }

    String getWeather() {
        return weather;
    }
}

class Model {
    private String corDate;
    private List<ParsingModel> modelList;

    Model(String corDate, List<ParsingModel> modelList) {
        this.corDate = corDate;
        this.modelList = modelList;
    }

    String getCorDate() {
        return corDate;
    }

    List<ParsingModel> getModelList() {
        return modelList;
    }
}
