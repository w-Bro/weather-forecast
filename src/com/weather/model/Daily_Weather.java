package com.weather.model;


//3-10������Ԥ��
public class Daily_Weather {

   private String cond_code_d;	//	��������״������
   private String cond_code_n;	//	�������״������
   private String cond_txt_d;	//	��������״������
   private String cond_txt_n;	//	�������״������
   private String date;	//		Ԥ������
   private String hum;	//		���ʪ��
   private String mr;	//	����ʱ��
   private String ms;	//		����ʱ��
   private String pcpn;	//		��ˮ��
   private String pop;	//		��ˮ����
   private String pres;	//	����ѹǿ
   private String sr;	//		�ճ�ʱ��
   private String ss;	//		����ʱ��
   private String tmp_max;	//		����¶�
   private String tmp_min;	//		����¶�
   private String uv_index;	//	������ǿ��ָ��
   private String vis;	//	�ܼ��ȣ���λ������
   private String wind_deg;	//	����360�Ƕ�
   private String wind_dir;	//		����
   private String wind_sc;	//		����
   private String wind_spd;	//		���٣�����/Сʱ
   private LocationAndUpdateTime locationAndUpdateTime;	//��ѯ���ݰ�����λ����Ϣ������ʱ��
   
   public LocationAndUpdateTime getLocationAndUpdateTime() {
	return locationAndUpdateTime;
}
public void setLocationAndUpdateTime(LocationAndUpdateTime locationAndUpdateTime) {
	this.locationAndUpdateTime = locationAndUpdateTime;
}
public void setCond_code_d(String cond_code_d) {
        this.cond_code_d = cond_code_d;
    }
    public String getCond_code_d() {
        return cond_code_d;
    }

   public void setCond_code_n(String cond_code_n) {
        this.cond_code_n = cond_code_n;
    }
    public String getCond_code_n() {
        return cond_code_n;
    }

   public void setCond_txt_d(String cond_txt_d) {
        this.cond_txt_d = cond_txt_d;
    }
    public String getCond_txt_d() {
        return cond_txt_d;
    }

   public void setCond_txt_n(String cond_txt_n) {
        this.cond_txt_n = cond_txt_n;
    }
    public String getCond_txt_n() {
        return cond_txt_n;
    }

   public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

   public void setHum(String hum) {
        this.hum = hum;
    }
    public String getHum() {
        return hum;
    }

   public void setMr(String mr) {
        this.mr = mr;
    }
    public String getMr() {
        return mr;
    }

   public void setMs(String ms) {
        this.ms = ms;
    }
    public String getMs() {
        return ms;
    }

   public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }
    public String getPcpn() {
        return pcpn;
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

   public void setSr(String sr) {
        this.sr = sr;
    }
    public String getSr() {
        return sr;
    }

   public void setSs(String ss) {
        this.ss = ss;
    }
    public String getSs() {
        return ss;
    }

   public void setTmp_max(String tmp_max) {
        this.tmp_max = tmp_max;
    }
    public String getTmp_max() {
        return tmp_max;
    }

   public void setTmp_min(String tmp_min) {
        this.tmp_min = tmp_min;
    }
    public String getTmp_min() {
        return tmp_min;
    }

   public void setUv_index(String uv_index) {
        this.uv_index = uv_index;
    }
    public String getUv_index() {
        return uv_index;
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

}