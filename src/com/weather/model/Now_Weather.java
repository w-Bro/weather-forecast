package com.weather.model;

//ʵ��������Ϊ��ǰʱ��������״���Լ���ʪ��ѹ������ָ��
public class Now_Weather {
	
	private String cloud;	//����
	private String cond_code;	//ʵ������״������
	private String cond_txt;	//ʵ������״������
	private String fl;	//����¶�
	private String hum;	//���ʪ��
	private String pcpn;	//��ˮ��
	private String pres;	//����ѹǿ
	private String tmp;		//�¶�
	private String vis;		//�ܼ���
	private String wind_deg;	//����Ƕ�
	private String wind_dir;	//����
	private String wind_sc;		//����
	private String wind_spd;	//����
	private LocationAndUpdateTime locationAndUpdateTime;	//��ѯ���ݰ�����λ����Ϣ������ʱ��
	private String suggestion;	//��������
	
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
