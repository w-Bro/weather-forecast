package com.weather.model;

//24小时内逐三小时的预报数据
public class Hourly_Weather {

   private String cloud;	//	云量，百分比
   private String cond_code;	//	天气状况代码
   private String cond_txt;	//	天气状况代码
   private String dew;	//		露点温度
   private String hum;	//		相对湿度
   private String pop;	//	降水概率，百分比
   private String pres;	//	大气压强
   private String time;	//	预报时间，格式yyyy-MM-dd HH:mm
   private String tmp;	//		温度
   private String wind_deg;	//	风向360角度
   private String wind_dir;	//		风向
   private String wind_sc;	//		风力
   private String wind_spd;	//	风速，公里/小时
   private LocationAndUpdateTime locationAndUpdateTime;	//查询数据包含的位置信息及更新时间
   
   public LocationAndUpdateTime getLocationAndUpdateTime() {
	return locationAndUpdateTime;
}
public void setLocationAndUpdateTime(LocationAndUpdateTime locationAndUpdateTime) {
	this.locationAndUpdateTime = locationAndUpdateTime;
}
public void setCloud(String cloud) {
        this.cloud = cloud;
    }
    public String getCloud() {
        return cloud;
    }

   public void setCond_code(String cond_code) {
        this.cond_code = cond_code;
    }
    public String getCond_code() {
        return cond_code;
    }

   public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }
    public String getCond_txt() {
        return cond_txt;
    }

   public void setDew(String dew) {
        this.dew = dew;
    }
    public String getDew() {
        return dew;
    }

   public void setHum(String hum) {
        this.hum = hum;
    }
    public String getHum() {
        return hum;
    }

   public void setPop(String pop) {
        this.pop = pop;
    }
    public String getPop() {
        return pop;
    }

   public void setPres(String pres) {
        this.pres = pres;
    }
    public String getPres() {
        return pres;
    }

   public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

   public void setTmp(String tmp) {
        this.tmp = tmp;
    }
    public String getTmp() {
        return tmp;
    }

   public void setWind_deg(String wind_deg) {
        this.wind_deg = wind_deg;
    }
    public String getWind_deg() {
        return wind_deg;
    }

   public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }
    public String getWind_dir() {
        return wind_dir;
    }

   public void setWind_sc(String wind_sc) {
        this.wind_sc = wind_sc;
    }
    public String getWind_sc() {
        return wind_sc;
    }

   public void setWind_spd(String wind_spd) {
        this.wind_spd = wind_spd;
    }
    public String getWind_spd() {
        return wind_spd;
    }

}