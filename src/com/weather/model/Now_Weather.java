package com.weather.model;

//实况天气即为当前时间点的天气状况以及温湿风压等气象指数
public class Now_Weather {
	
	private String cloud;	//云量
	private String cond_code;	//实况天气状况代码
	private String cond_txt;	//实况天气状况代码
	private String fl;	//体感温度
	private String hum;	//相对湿度
	private String pcpn;	//降水量
	private String pres;	//大气压强
	private String tmp;		//温度
	private String vis;		//能见度
	private String wind_deg;	//风向角度
	private String wind_dir;	//风向
	private String wind_sc;		//风力
	private String wind_spd;	//风速
	private LocationAndUpdateTime locationAndUpdateTime;	//查询数据包含的位置信息及更新时间
	private String suggestion;	//天气建议
	
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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
	
	public void setFl(String fl) {
	     this.fl = fl;
	 }
	 public String getFl() {
	     return fl;
	 }
	
	public void setHum(String hum) {
	     this.hum = hum;
	 }
	 public String getHum() {
	     return hum;
	 }
	
	public void setPcpn(String pcpn) {
	     this.pcpn = pcpn;
	 }
	 public String getPcpn() {
	     return pcpn;
	 }
	
	public void setPres(String pres) {
	     this.pres = pres;
	 }
	 public String getPres() {
	     return pres;
	 }
	
	public void setTmp(String tmp) {
	     this.tmp = tmp;
	 }
	 public String getTmp() {
	     return tmp;
	 }
	
	public void setVis(String vis) {
	     this.vis = vis;
	 }
	 public String getVis() {
	     return vis;
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
	public LocationAndUpdateTime getLocationAndUpdateTime() {
		return locationAndUpdateTime;
	}
	public void setLocationAndUpdateTime(LocationAndUpdateTime locationAndUpdateTime) {
		this.locationAndUpdateTime = locationAndUpdateTime;
	}
}
