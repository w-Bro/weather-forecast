package com.ui.frame;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ui.component.WeatherTextLabel;
import com.weather.model.Now_Weather;

/**
 * 显示实况天气的对话框
 * @author 沈淋泽
 *
 */
public class NowWeatherDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//实时天气
	private Now_Weather now_Weather;
	
	//实时温度
	private WeatherTextLabel tmpLabel;
	//体感温度
	private WeatherTextLabel flLabel;
	//天气状况
	private WeatherTextLabel condLabel;
	//温馨提示
	private JTextField suggestionText;
	
	//天气状况图片
	private JLabel condImgLabel;
	
	public NowWeatherDialog(Now_Weather now_Weather) {
		this.now_Weather = now_Weather;
		
		this.setModal(true);
		this.setIconImage(new ImageIcon("image/icon.png").getImage());
		this.setSize(400, 300);
		this.setResizable(false);
		
		tmpLabel = new WeatherTextLabel(0, 0, "实时温度:"+this.now_Weather.getTmp()+"℃");
		flLabel = new WeatherTextLabel(0, 0, "体感温度:"+this.now_Weather.getFl()+"℃");
		condLabel = new WeatherTextLabel(0, 0, this.now_Weather.getCond_txt());
		suggestionText = new JTextField(this.now_Weather.getSuggestion());
		suggestionText.setBackground(null);
		suggestionText.setEditable(false);
		suggestionText.setFont(new Font("微软雅黑", 0, 15));
		suggestionText.setBorder(null);
		suggestionText.setHorizontalAlignment(JTextField.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.add(tmpLabel);
		panel.add(flLabel);
		panel.add(condLabel);
		panel.add(suggestionText);
				
		condImgLabel = new JLabel(new ImageIcon("image/cond_icon_heweather/"+this.now_Weather.getCond_code()+".png"));
		
		this.setLayout(new GridLayout(2, 1));
		this.add(panel);
		this.add(condImgLabel);
	}
}
