package com.weather.model;

//接口更新时间
public class LocationAndUpdateTime {

	private String cid;	//城市代码	
	private String location;	//地区名称
	private String parent_city;	//地区所属上级地级市
	private String admin_area;		//省份
	private String cnty;	//国家
	private String lat;	//经纬度
	private String lon;
	private String tz;	//时区
	private String loc;	//当地时间，24小时制，格式yyyy-MM-dd HH:mm
	private String utc;	//UTC时间，24小时制，格式yyyy-MM-dd HH:mm
	
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