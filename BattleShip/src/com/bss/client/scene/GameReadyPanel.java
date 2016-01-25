package com.bss.client.scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bss.client.GameObjects.Grid;
import com.bss.client.GameObjects.Ship;
import com.bss.client.GameObjects.ShipAngle;
import com.bss.client.GameObjects.ShipType;
import com.bss.client.GameObjects.Tile;

import javafx.scene.transform.Scale;
import resources.ResLoader;

public class GameReadyPanel extends JPanel {
	
	
	JLabel shipContainer;
	Image img_shipContainer;
	Image bgImg;
	
	Grid grid;
	Tile[][] tiles;
	
	
	public GameReadyPanel(JFrame frame)
	{
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		
		setLayout(null);
		
		bgImg = toolKit.createImage(ResLoader.getResURL("images/bg.jpg"));
		
		img_shipContainer = toolKit.createImage(ResLoader.getResURL("images/ShipContainer.png"));
		
		shipContainer = new JLabel();
		shipContainer.setIcon(new ImageIcon(img_shipContainer));
		shipContainer.setLocation(930,100);
		shipContainer.setSize(270,500);
		add(shipContainer);
		
		setSize(frame.getWidth(),frame.getHeight());
		
		
		int tStartX = toolKit.getScreenSize().width /3;
		int tStartY = toolKit.getScreenSize().height/3;
		
		
		grid = new Grid(400,256,this);
		
		
		Ship ship = new Ship(ShipType.Frigate, ShipAngle.H, 1);
		ship.setLocation(1095,150);
		add(ship);
		
		Ship ship2 = new Ship(ShipType.Destoryer, ShipAngle.H,2);
		ship2.setLocation(1045,205);
		add(ship);
		
		/*
		 * Set zOrders of Components
		 */
		setComponentZOrder(ship , 1);
		setComponentZOrder(ship2 , 2);
		grid.setGridZOrder(3);
		setComponentZOrder(shipContainer,3);
		
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bgImg, 0, 0,this.getWidth(),this.getHeight(), this);
		paintChildren(g);
		setOpaque(false);
	}

}
