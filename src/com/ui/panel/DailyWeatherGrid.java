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
 * 单行的每日天气格子
 * @author 沈淋泽
 *
 */
public class DailyWeatherGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Daily_Weather daily_Weather;
	
	//显示预报日期
	private WeatherTextLabel timeLabel;
	//显示天气状况图标
	private JLabel condImg;
	//天气状况
	private WeatherTextLabel condLabel;
	//温度
	private WeatherTextLabel tmpLabel;
	//降水概率
	private WeatherTextLabel popLabel;
	//风力
	private WeatherTextLabel windLael;
	
	
	public DailyWeatherGrid(Daily_Weather daily_Weather) {
		this.daily_Weather = daily_Weather;
		
		this.setLayout(new GridLayout(1, 6, 10, 0));
		this.setBorder(BorderFactory.createEtchedBorder());
		
		timeLabel = new WeatherTextLabel(0, 0, new Color(204,204,204), this.daily_Weather.getDate());
		timeLabel.setFont(new Font("微软雅黑", 1, 15));
		
		ImageIcon imageIcon = new ImageIcon("image/cond_icon_heweather/"+this.daily_Weather.getCond_code_d()+".png");
		Image image = imageIcon.getImage();
		image = image.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		imageIcon.setImage(image);
		condImg = new JLabel();
		condImg.setIcon(imageIcon);
		
		condLabel = new WeatherTextLabel(0, 0, this.daily_Weather.getCond_txt_d());
		tmpLabel = new WeatherTextLabel(0, 0, this.daily_Weather.getTmp_min()+"℃/"+this.daily_Weather.getTmp_max()+"℃");
		popLabel = new WeatherTextLabel(0, 0, "降水概率:"+this.daily_Weather.getPop()+"%");
		windLael = new WeatherTextLabel(0, 0, this.daily_Weather.getWind_dir()+","+this.daily_Weather.getWind_sc()+"级");
		
		this.add(timeLabel);
		this.add(condImg);
		this.add(windLael);
		this.add(condLabel);
		this.add(tmpLabel);
		this.add(popLabel);
	}
	
}
