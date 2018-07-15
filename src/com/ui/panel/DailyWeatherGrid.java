package com.ui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ui.component.WeatherTextLabel;
import com.weather.model.Daily_Weather;

/**
 * ���е�ÿ����������
 * @author ������
 *
 */
public class DailyWeatherGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Daily_Weather daily_Weather;
	
	//��ʾԤ������
	private WeatherTextLabel timeLabel;
	//��ʾ����״��ͼ��
	private JLabel condImg;
	//����״��
	private WeatherTextLabel condLabel;
	//�¶�
	private WeatherTextLabel tmpLabel;
	//��ˮ����
	private WeatherTextLabel popLabel;
	//����
	private WeatherTextLabel windLael;
	
	
	public DailyWeatherGrid(Daily_Weather daily_Weather) {
		this.daily_Weather = daily_Weather;
		
		this.setLayout(new GridLayout(1, 6, 10, 0));
		this.setBorder(BorderFactory.createEtchedBorder());
		
		timeLabel = new WeatherTextLabel(0, 0, new Color(204,204,204), this.daily_Weather.getDate());
		timeLabel.setFont(new Font("΢���ź�", 1, 15));
		
		ImageIcon imageIcon = new ImageIcon("image/cond_icon_heweather/"+this.daily_Weather.getCond_code_d()+".png");
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		imageIcon.setImage(image);
		condImg = new JLabel();
		condImg.setIcon(imageIcon);
		
		condLabel = new WeatherTextLabel(0, 0, this.daily_Weather.getCond_txt_d());
		tmpLabel = new WeatherTextLabel(0, 0, this.daily_Weather.getTmp_min()+"��/"+this.daily_Weather.getTmp_max()+"��");
		popLabel = new WeatherTextLabel(0, 0, "��ˮ����:"+this.daily_Weather.getPop()+"%");
		windLael = new WeatherTextLabel(0, 0, this.daily_Weather.getWind_dir()+","+this.daily_Weather.getWind_sc()+"��");
		
		this.add(timeLabel);
		this.add(condImg);
		this.add(windLael);
		this.add(condLabel);
		this.add(tmpLabel);
		this.add(popLabel);
	}
	
}
