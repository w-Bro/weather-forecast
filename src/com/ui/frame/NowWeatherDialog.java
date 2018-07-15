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
 * ��ʾʵ�������ĶԻ���
 * @author ������
 *
 */
public class NowWeatherDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//ʵʱ����
	private Now_Weather now_Weather;
	
	//ʵʱ�¶�
	private WeatherTextLabel tmpLabel;
	//����¶�
	private WeatherTextLabel flLabel;
	//����״��
	private WeatherTextLabel condLabel;
	//��ܰ��ʾ
	private JTextField suggestionText;
	
	//����״��ͼƬ
	private JLabel condImgLabel;
	
	public NowWeatherDialog(Now_Weather now_Weather) {
		this.now_Weather = now_Weather;
		
		this.setModal(true);
		this.setIconImage(new ImageIcon("image/icon.png").getImage());
		this.setSize(400, 300);
		this.setResizable(false);
		
		tmpLabel = new WeatherTextLabel(0, 0, "ʵʱ�¶�:"+this.now_Weather.getTmp()+"��");
		flLabel = new WeatherTextLabel(0, 0, "����¶�:"+this.now_Weather.getFl()+"��");
		condLabel = new WeatherTextLabel(0, 0, this.now_Weather.getCond_txt());
		suggestionText = new JTextField(this.now_Weather.getSuggestion());
		suggestionText.setBackground(null);
		suggestionText.setEditable(false);
		suggestionText.setFont(new Font("΢���ź�", 0, 15));
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
