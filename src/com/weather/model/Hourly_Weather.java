package com.weather.model;

//24Сʱ������Сʱ��Ԥ������
public class Hourly_Weather {

   private String cloud;	//	�������ٷֱ�
   private String cond_code;	//	����״������
   private String cond_txt;	//	����״������
   private String dew;	//		¶���¶�
   private String hum;	//		���ʪ��
   private String pop;	//	��ˮ���ʣ��ٷֱ�
   private String pres;	//	����ѹǿ
   private String time;	//	Ԥ��ʱ�䣬��ʽyyyy-MM-dd HH:mm
   private String tmp;	//		�¶�
   private String wind_deg;	//	����360�Ƕ�
   private String wind_dir;	//		����
   private String wind_sc;	//		����
   private String wind_spd;	//	���٣�����/Сʱ
   private LocationAndUpdateTime locationAndUpdateTime;	//��ѯ���ݰ�����λ����Ϣ������ʱ��
   
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