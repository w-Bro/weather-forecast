package com.weather.model;

//������Ϣ
public class City {
	
    private  String CityCode;  //	����/��������
    private  String CityEnglish;  	//	Ӣ��
    private  String CityChinese;  	//	����
    private  String CountryCode;  	//	���Ҵ���
    private  String CountryEnglish;  //	����Ӣ��
    private  String CountryChinese;  //	��������
    private  String ProvinceEnglish;	//	ʡӢ��
    private  String ProvinceChinese;  //	ʡ����
    private  String SuperiorCityEnglish;  	//	�����ϼ���Ӣ��
    private  String SuperiorCityChinese;  //	�����ϼ�������
    private  double Latitude;  	//	γ��
    private  double Longitude;  	//	����
    private  String Adcode;  	//	��ַ����
   
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
