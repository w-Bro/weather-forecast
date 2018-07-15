package com.weather.model;

//城市信息
public class City {
	
    private  String CityCode;  //	城市/地区编码
    private  String CityEnglish;  	//	英文
    private  String CityChinese;  	//	中文
    private  String CountryCode;  	//	国家代码
    private  String CountryEnglish;  //	国家英文
    private  String CountryChinese;  //	国家中文
    private  String ProvinceEnglish;	//	省英文
    private  String ProvinceChinese;  //	省中文
    private  String SuperiorCityEnglish;  	//	所属上级市英文
    private  String SuperiorCityChinese;  //	所属上级市中文
    private  double Latitude;  	//	纬度
    private  double Longitude;  	//	经度
    private  String Adcode;  	//	地址代码
   
    public String getCityCode(){
    		return this.CityCode;
    }
    
    public void setCityCode(String CityCode){
    	this.CityCode=CityCode;
    }  
   
    public String getCityEnglish(){
    		return this.CityEnglish;
    }
    
    public void setCityEnglish(String CityEnglish){
    	this.CityEnglish=CityEnglish;
    }  
   
    public String getCityChinese(){
    		return this.CityChinese;
    }
    
    public void setCityChinese(String CityChinese){
    	this.CityChinese=CityChinese;
    }  
   
    public String getCountryCode(){
    		return this.CountryCode;
    }
    
    public void setCountryCode(String CountryCode){
    	this.CountryCode=CountryCode;
    }  
   
    public String getCountryEnglish(){
    		return this.CountryEnglish;
    }
    
    public void setCountryEnglish(String CountryEnglish){
    	this.CountryEnglish=CountryEnglish;
    }  
   
    public String getCountryChinese(){
    		return  this.CountryChinese;
    };
    public void setCountryChinese(String CountryChinese){
    	this.CountryChinese=CountryChinese;
    }  
   
    public String getProvinceEnglish(){
    		return this.ProvinceEnglish;
    }
    
    public void setProvinceEnglish(String ProvinceEnglish){
    	this.ProvinceEnglish=ProvinceEnglish;
    }  
   
    public String getProvinceChinese(){
    		return this.ProvinceChinese;
    };
    public void setProvinceChinese(String ProvinceChinese){
    	this.ProvinceChinese=ProvinceChinese;
    }  
   
    public String getSuperiorCityEnglish(){
    		return this.SuperiorCityEnglish;
    }
    
    public void setSuperiorCityEnglish(String SuperiorCityEnglish){
    	this.SuperiorCityEnglish=SuperiorCityEnglish;
    }  
   
    public String getSuperiorCityChinese(){
    		return  this.SuperiorCityChinese;
    }
    public void setSuperiorCityChinese(String SuperiorCityChinese){
    	this.SuperiorCityChinese=SuperiorCityChinese;
    }  
   
    public double getLatitude(){
    		return this.Latitude;
    }
    
    public void setLatitude(double Latitude){
    	this.Latitude=Latitude;
    }  
   
    public double getLongitude(){
    		return this.Longitude;
    }
    
    public void setLongitude(double Longitude){
    	this.Longitude=Longitude;
    }  
   
    public String getAdcode(){
    		return this.Adcode;
    }
    
    public void setAdcode(String Adcode){
    	this.Adcode=Adcode;
    }  
}
