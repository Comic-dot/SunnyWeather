package com.sunnyweather.android.logic.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class DailyResponse {
    public Result result;
    public String status;

    public static class Result {
        public Daily daily;

    }
    public static class Daily {
        List<Temperature> temperatures;
        List<Skycon> skycon;
        @SerializedName("life_index")
        public LifeIndex lifeIndex;
    }
    public static class Skycon {
        public String value;
        public Date date;
    }
    public static class Temperature {
        public float max;
        public float min;
    }
    public static class LifeDescription {
        public String desc;
    }
    public static class LifeIndex{
        public List<LifeDescription> coldRisk;
        public List<LifeDescription> carWashing;
        public List<LifeDescription> ultraviolet;
        public List<LifeDescription> derssing;
    }
}
