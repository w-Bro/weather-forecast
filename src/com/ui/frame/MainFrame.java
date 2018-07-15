package com.ui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ui.panel.DailyWeatherGrid;
import com.ui.panel.HourlyWeatherGrid;
import com.ui.panel.SettingPanel;
import com.weather.model.Daily_Weather;
import com.weather.model.Hourly_Weather;
import com.weather.model.Now_Weather;

/**
 * ������
 * @author ������
 *
 */
public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SettingPanel settingPanel;
	private JPanel hourlyWeatherPanel;
	private JPanel dailyWeatherPanel;
	private final JLabel DATA_SOURCE_LABEL = new JLabel("������Դ�ںͷ�����");
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("����Ԥ��");
		this.setSize(1000, 600);
		this.setIconImage(new ImageIcon("image/icon.png").getImage());
		//������ʾ
		this.setLocationRelativeTo(null);
		//����رհ�ť�ر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		this.setLayout(new BorderLayout(5, 10));
		
		settingPanel = new SettingPanel(this);
		hourlyWeatherPanel = new JPanel();
		dailyWeatherPanel = new JPanel();
		this.add(settingPanel,BorderLayout.NORTH);

		this.settingPanel.updateAuto_ip();
	}
	
	/**
	 * ˢ��������Ϣ��ʾ���
	 * @param now_Weather
	 * @param hourly_Weathers
	 * @param daily_Weathers
	 */
	public void setWeatherInfo(Now_Weather now_Weather, List<Hourly_Weather> hourly_Weathers, List<Daily_Weather> daily_Weathers) {
		
		this.remove(hourlyWeatherPanel);
		this.remove(dailyWeatherPanel);
		
		hourlyWeatherPanel = new JPanel();
		dailyWeatherPanel = new JPanel();
		
		hourlyWeatherPanel.setLayout(new GridLayout(1,8,5,0));
		hourlyWeatherPanel.setSize(new Dimension(1200, 300));
		if(hourly_Weathers != null) {
			for(Hourly_Weather hourly_Weather : hourly_Weathers) {
				hourlyWeatherPanel.add(new HourlyWeatherGrid(hourly_Weather));
			}
		}
		this.add(hourlyWeatherPanel,BorderLayout.CENTER);
		hourlyWeatherPanel.updateUI();	//ˢ��UI
		hourlyWeatherPanel.repaint();	//�ػ�
		
		if(daily_Weathers != null) {
			dailyWeatherPanel.setLayout(new GridLayout(4, 1, 0, 5));
			dailyWeatherPanel.setPreferredSize(new Dimension(1000, 200));
			for(Daily_Weather daily_Weather : daily_Weathers) {
				dailyWeatherPanel.add(new DailyWeatherGrid(daily_Weather));
			}
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,25));
			JLabel updateTimeLabel = new JLabel("����ʱ��:"+now_Weather.getLocationAndUpdateTime().getLoc());
			panel.add(updateTimeLabel);
			panel.add(DATA_SOURCE_LABEL);
			dailyWeatherPanel.add(panel);
		}	
		this.add(dailyWeatherPanel, BorderLayout.SOUTH);
		dailyWeatherPanel.updateUI();
		dailyWeatherPanel.repaint();
	}
}
