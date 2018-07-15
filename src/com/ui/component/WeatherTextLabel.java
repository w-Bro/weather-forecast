package com.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

/***
 * �Զ���Label��������ʾ������Ϣ
 * @author ������
 *
 */
public class WeatherTextLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherTextLabel(int width,int height, String text) {
		super(text);
		this.setFont(new Font("΢���ź�", 0, 15));
		this.setPreferredSize(new Dimension(width, height));
		this.setHorizontalAlignment(CENTER);
	}
	
	public WeatherTextLabel(int width,int height, Color color, String text) {
		super(text);
		this.setFont(new Font("΢���ź�", 0, 15));
		this.setOpaque(true);
		this.setBackground(color);
		this.setPreferredSize(new Dimension(width, height));
		this.setHorizontalAlignment(CENTER);
	}
}
