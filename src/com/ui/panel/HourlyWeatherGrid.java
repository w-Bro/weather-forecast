package com.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ui.component.WeatherTextLabel;
import com.weather.model.Hourly_Weather;

/**
 * 单个小时天气信息格子
 * @author 沈淋泽
 *
 */
public class HourlyWeatherGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//要显示的天气信息
	private Hourly_Weather hourly_Weather;
	
	//预报时间
	private WeatherTextLabel timeLabel;
	//天气状况
	private WeatherTextLabel condLabel;
	//温度
	private WeatherTextLabel tmpLabel;
	//风力
	private WeatherTextLabel windLael;
	//天气状况图片
	private JLabel condImg;
	
	public HourlyWeatherGrid(Hourly_Weather hourly_Weather) {
		this.hourly_Weather = hourly_Weather;
		
		this.setLayout(new BorderLayout(0,15));
		this.setBorder(BorderFactory.createEtchedBorder());
		
		timeLabel = new WeatherTextLabel(100, 40, new Color(204,204,204), this.hourly_Weather.getTime());
		timeLabel.setFont(new Font("微软雅黑", 1, 12));
		condLabel = new WeatherTextLabel(80, 20,this.hourly_Weather.getCond_txt());
		tmpLabel = new WeatherTextLabel(80, 20, this.hourly_Weather.getTmp()+"℃");
		windLael = new WeatherTextLabel(80, 20,this.hourly_Weather.getWind_sc()+"级\n");
		Panel panel = new Panel(new BorderLayout(5,5));
		panel.add(condLabel, BorderLayout.NORTH);
		panel.add(tmpLabel, BorderLayout.CENTER);
		panel.add(windLael, BorderLayout.SOUTH);
		condImg = new JLabel(new ImageIcon("image/cond_icon_heweather/"+this.hourly_Weather.getCond_code()+".png"));
		
		this.add(timeLabel, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(condImg, BorderLayout.SOUTH);
	}
}
