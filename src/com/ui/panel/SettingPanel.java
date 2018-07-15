package com.ui.panel;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ui.frame.MainFrame;
import com.ui.frame.NowWeatherDialog;
import com.weather.dao.CityDao;
import com.weather.model.Daily_Weather;
import com.weather.model.Hourly_Weather;
import com.weather.model.Now_Weather;
import com.weather.util.WeatherUtil;

@SuppressWarnings({"rawtypes","unchecked"})
public class SettingPanel extends JPanel{

	/**
	 * �������������壬���ڷ���ѡ����е�������������ť
	 */
	
	private static final long serialVersionUID = 1L;
	
	private MainFrame mainFrame;
	
	//ѡ��ʡ��
	private JComboBox provinceComboBox;
	//ѡ�����
	private JComboBox cityComBox;
	//ѡ�����
	private JComboBox areaComBox;
	//�Զ���λ��ť
	private JLabel autoIpImg;
	//��ѯ��ť
	private JButton queryBtn;
	//ʵ������
	private JButton nowBtn;
	//ʵ�������Ի���
	private NowWeatherDialog nowWeatherDialog;

	private String province;	
	private String city;
	private String area;
	
	public SettingPanel(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		this.setSize(1000, 100);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		List<String> provinces = new CityDao().getProvinceName();
		DefaultComboBoxModel provincesComboBoxModel = new DefaultComboBoxModel<>(provinces.toArray());
		
		provinceComboBox = new JComboBox();
		cityComBox = new JComboBox();
		areaComBox = new JComboBox();
		autoIpImg = new JLabel();
		queryBtn = new JButton("��ѯ");
		nowBtn = new JButton("ʵ������");
		
		cityComBox.addItem("��ѡ�����");
		autoIpImg.setIcon(new ImageIcon("image/auto_ip.png"));
    	autoIpImg.setToolTipText("�Զ���λ��������");	
		
		provinceComboBox.setModel(provincesComboBoxModel);
		this.add(provinceComboBox);
		this.add(cityComBox);
		this.add(areaComBox);
		this.add(queryBtn);
		this.add(autoIpImg);
		this.add(nowBtn);
		
		provinceComboBox.setPreferredSize(new Dimension(100, 30));
		cityComBox.setPreferredSize(new Dimension(100, 30));
		areaComBox.setPreferredSize(new Dimension(100, 30));
		queryBtn.setPreferredSize(new Dimension(80, 35));
		nowBtn.setPreferredSize(new Dimension(100, 35));
		
		provinceComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					province = provinceComboBox.getSelectedItem().toString();
					List<String> citys = new CityDao().getCityName(province);
					DefaultComboBoxModel cityComboxModel = new DefaultComboBoxModel<>(citys.toArray());
					cityComBox.removeAllItems();
					areaComBox.removeAllItems();
					cityComBox.setModel(cityComboxModel);
				}
			}
		});
		
		cityComBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					city = cityComBox.getSelectedItem().toString();
					List<String> areas = new CityDao().getAreaName(province, city);
					DefaultComboBoxModel areaComboxModel = new DefaultComboBoxModel<>(areas.toArray());
					areaComBox.removeAllItems();
					areaComBox.setModel(areaComboxModel);
				}
				
			}
		});
		
		autoIpImg.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				updateAuto_ip();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
            	setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                repaint();
			}
			
		});
	
		queryBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				updateWeatherInfo();
			}
			
		});
	
		nowBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				nowWeatherDialog.setLocationRelativeTo(mainFrame);
				nowWeatherDialog.setVisible(true);
			}
			
		});
	}
	
	/**
	 * �����ѯ��ťʱ����������Ϣ���
	 */
	public void updateWeatherInfo() {
		province = provinceComboBox.getSelectedItem().toString();
		if(province.equals("��ѡ��ʡ��")) {
			JOptionPane.showMessageDialog(SettingPanel.this, "��ѡ��ʡ��");
			return;
		}
		city = cityComBox.getSelectedItem().toString();
		if(city.equals("��ѡ�����")) {
			JOptionPane.showMessageDialog(SettingPanel.this, "��ѡ�����");
			return;
		}
		Now_Weather now_Weather = new Now_Weather();
		List<Hourly_Weather> hourly_Weathers = new ArrayList<>();
		List<Daily_Weather> daily_Weathers = new ArrayList<>();
		
		if(areaComBox.getItemCount() == 0) {
			now_Weather = WeatherUtil.getNowWeather(city+","+province);
			hourly_Weathers = WeatherUtil.getHourlyWeathers(city+","+province);
			daily_Weathers = WeatherUtil.getDailyWeathers(city+","+province);
		}else {
			area = areaComBox.getSelectedItem().toString();
			now_Weather = WeatherUtil.getNowWeather(area+","+city);
			hourly_Weathers = WeatherUtil.getHourlyWeathers(area+","+city);
			daily_Weathers = WeatherUtil.getDailyWeathers(area+","+city);
		}
		nowWeatherDialog = new NowWeatherDialog(now_Weather);
		mainFrame.setWeatherInfo(now_Weather, hourly_Weathers, daily_Weathers);
	}
	
	/**
	 * ����Զ���λʱ����������Ϣ����Լ�����λ��������
	 */
	public void updateAuto_ip() {
		Now_Weather now_Weather = WeatherUtil.getNowWeather("auto_ip");
		List<Hourly_Weather> hourly_Weathers = WeatherUtil.getHourlyWeathers("auto_ip");
		List<Daily_Weather> daily_Weathers = WeatherUtil.getDailyWeathers("auto_ip");
		
		province = now_Weather.getLocationAndUpdateTime().getAdmin_area();
		provinceComboBox.setSelectedItem(province);
		List<String> citys = new CityDao().getCityName(province);
		DefaultComboBoxModel cityComboxModel = new DefaultComboBoxModel<>(citys.toArray());
		cityComBox.removeAllItems();
		areaComBox.removeAllItems();
		cityComBox.setModel(cityComboxModel);
		if(new CityDao().isSpecialCity(province)) {
			city = now_Weather.getLocationAndUpdateTime().getLocation();
			cityComBox.setSelectedItem(city);
		}
		else {
			city = now_Weather.getLocationAndUpdateTime().getParent_city();
			cityComBox.setSelectedItem(city);
			List<String> areas = new CityDao().getAreaName(province, city);
			DefaultComboBoxModel areaComboxModel = new DefaultComboBoxModel<>(areas.toArray());
			area = now_Weather.getLocationAndUpdateTime().getLocation();
			areaComBox.removeAllItems();
			areaComBox.setModel(areaComboxModel);
			areaComBox.setSelectedItem(area);
		}
						
		nowWeatherDialog = new NowWeatherDialog(now_Weather);
		mainFrame.setWeatherInfo(now_Weather, hourly_Weathers, daily_Weathers);
	}
}
