package com.weather.model;

//�ӿڸ���ʱ��
public class LocationAndUpdateTime {

	private String cid;	//���д���	
	private String location;	//��������
	private String parent_city;	//���������ϼ��ؼ���
	private String admin_area;		//ʡ��
	private String cnty;	//����
	private String lat;	//��γ��
	private String lon;
	private String tz;	//ʱ��
	private String loc;	//����ʱ�䣬24Сʱ�ƣ���ʽyyyy-MM-dd HH:mm
	private String utc;	//UTCʱ�䣬24Сʱ�ƣ���ʽyyyy-MM-dd HH:mm
	
	public void setLoc(String loc) {
        this.loc = loc;
    }
    public String getLoc() {
        return loc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }
    public String getUtc() {
        return utc;
    }
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getParent_city() {
		return parent_city;
	}
	public void setParent_city(String parent_city) {
		this.parent_city = parent_city;
	}
	public String getAdmin_area() {
		return admin_area;
	}
	public void setAdmin_area(String admin_area) {
		this.admin_area = admin_area;
	}
	public String getCnty() {
		return cnty;
	}
	public void setCnty(String cnty) {
		this.cnty = cnty;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getTz() {
		return tz;
	}
	public void setTz(String tz) {
		this.tz = tz;
	}

}