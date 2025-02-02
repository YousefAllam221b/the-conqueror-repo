package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buildings.ArcheryRange;
import engine.City;
import engine.Game;
import listeners.CityViewListener;

public class CityView extends TemplateView implements ActionListener
{
	private City currentCity;
	private CityViewListener listener;
	
	
	public City getCurrentCity() {
		return currentCity;
	}
	
	
	public void setCurrentCity(City currentCity) {
		this.currentCity = currentCity;
	}



	private JLabel buildLabel = new JLabel("Click to Build");
	private JLabel upgradeLabel = new JLabel("Click to Upgrade");
	private JLabel recruitLabel = new JLabel("Click to Recruit");
	
	
	private JButton barracksButton = new JButton("No Barracks Cost: 2000");
	private JButton barracksLvlButton = new JButton("Level : 0");
	private JButton barracksRecruitButton = new JButton("No unit");
	
	
	private JButton archeryRangeButton = new JButton("No ArcheryRange Cost: 1500");
	private JButton archeryRangeLvlButton = new JButton("Level : 0");
	private JButton archeryRangeRecruitButton = new JButton("No unit");
	
	
	private JButton stableButton = new JButton("No Stable Cost: 1500");
	private JButton stableLvlButton = new JButton("Level : 0");
	private JButton stableRecruitButton = new JButton("No unit");
	
	
	private JButton marketButton = new JButton("No Market Cost: 1500");
	private JButton marketLvlButton = new JButton("Level : 0");
	
	
	private JButton farmButton = new JButton("No Farm Cost: 1000");
	private JButton farmLvlButton = new JButton("Level : 0");
	
	
	private JLabel fillerLabel = new JLabel("");
	private JPanel midPanel = new JPanel();
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JPanel fillerPanel = new JPanel();
	
	
	
	
	
	public void setUpButton2(JButton theButton, String path )
	{
		theButton.setIcon(new ImageIcon("resources/" + path));
		theButton.setForeground(Color.WHITE);
		theButton.setBackground(Color.DARK_GRAY);
		theButton.setFocusable(false);
		theButton.repaint();
	}
	
	public CityView(Game theGame)
	{
		super(theGame);
		
		// components
		setUpLabel(upgradeLabel);
		setUpLabel(buildLabel);
		setUpLabel(recruitLabel);

		setUpButton(archeryRangeButton);
		setUpButton(archeryRangeLvlButton);
		setUpButton(archeryRangeRecruitButton);
		setUpButton(barracksButton);
		setUpButton(barracksLvlButton);
		setUpButton(barracksRecruitButton);
		setUpButton(stableButton);
		setUpButton(stableLvlButton);
		setUpButton(stableRecruitButton);
		setUpButton(marketButton);
		setUpButton(marketLvlButton);
		setUpButton(farmButton);
		setUpButton(farmLvlButton);
		
		//adding listeners
		
		archeryRangeButton.addActionListener(this);
		stableButton.addActionListener(this);
		barracksButton.addActionListener(this);
		farmButton.addActionListener(this);
		marketButton.addActionListener(this);	
		
		archeryRangeLvlButton.addActionListener(this);
		stableLvlButton.addActionListener(this);
		barracksLvlButton.addActionListener(this);
		farmLvlButton.addActionListener(this);
		marketLvlButton.addActionListener(this);
		
		archeryRangeLvlButton.setEnabled(false);
		stableLvlButton.setEnabled(false);
		barracksLvlButton.setEnabled(false);
		farmLvlButton.setEnabled(false);
		marketLvlButton.setEnabled(false);
		
		// panels
		midPanel.setLayout(new GridLayout(0, 3));
		midPanel.setPreferredSize(new Dimension(0, 200));
		
		// add
		
		add(midPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		midPanel.add(buildLabel);
		midPanel.add(upgradeLabel);
		midPanel.add(recruitLabel);
		
		midPanel.add(archeryRangeButton);
		midPanel.add(archeryRangeLvlButton);
		midPanel.add(archeryRangeRecruitButton);
		midPanel.add(barracksButton);
		midPanel.add(barracksLvlButton);
		midPanel.add(barracksRecruitButton);
		midPanel.add(stableButton);
		midPanel.add(stableLvlButton);
		midPanel.add(stableRecruitButton);
		
		midPanel.add(marketButton);
		midPanel.add(marketLvlButton);
		midPanel.add(fillerLabel);
		midPanel.add(farmButton);
		midPanel.add(farmLvlButton);
		
		
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == archeryRangeButton)
		{
			listener.onBuild("ArcheryRange");
		}
		else if (e.getSource() == barracksButton)
		{
			listener.onBuild("Barracks");
		}
		else if (e.getSource() == stableButton)
		{
			listener.onBuild("Stable");
		}
		else if (e.getSource() == farmButton)
		{
			listener.onBuild("Farm");
		}
		else if (e.getSource() == marketButton)
		{
			listener.onBuild("Market");
		}
		if (e.getSource() == marketLvlButton)
		{
			listener.onUpgrade("Market");
		}
		else if (e.getSource() == farmLvlButton)
		{
			listener.onUpgrade("Farm");
		}
		else if (e.getSource() == stableLvlButton)
		{
			listener.onUpgrade("Stable");
		}
		else if (e.getSource() == barracksLvlButton)
		{
			listener.onUpgrade("Barracks");		
		}
		else if (e.getSource() == archeryRangeLvlButton)
		{
			listener.onUpgrade("ArcheryRange");
		}	
	}

	public JButton getBarracksButton() {
		return barracksButton;
	}


	public void setBarracksButton(JButton barracksButton) {
		this.barracksButton = barracksButton;
	}


	public JButton getBarracksLvlButton() {
		return barracksLvlButton;
	}


	public void setBarracksLvlButton(JButton barracksLvlButton) {
		this.barracksLvlButton = barracksLvlButton;
	}


	public JButton getArcheryRangeButton() {
		return archeryRangeButton;
	}


	public void setArcheryRangeButton(JButton archeryRangeButton) {
		this.archeryRangeButton = archeryRangeButton;
	}


	public JButton getArcheryRangeLvlButton() {
		return archeryRangeLvlButton;
	}


	public void setArcheryRangeLvlButton(JButton archeryRangeLvlButton) {
		this.archeryRangeLvlButton = archeryRangeLvlButton;
	}


	public JButton getStableButton() {
		return stableButton;
	}


	public void setStableButton(JButton stableButton) {
		this.stableButton = stableButton;
	}


	public JButton getStableLvlButton() {
		return stableLvlButton;
	}


	public void setStableLvlButton(JButton stableLvlButton) {
		this.stableLvlButton = stableLvlButton;
	}


	public JButton getMarketButton() {
		return marketButton;
	}


	public void setMarketButton(JButton marketButton) {
		this.marketButton = marketButton;
	}


	public JButton getMarketLvlButton() {
		return marketLvlButton;
	}


	public void setMarketLvlButton(JButton marketLvlButton) {
		this.marketLvlButton = marketLvlButton;
	}


	public JButton getFarmButton() {
		return farmButton;
	}


	public void setFarmButton(JButton farmButton) {
		this.farmButton = farmButton;
	}


	public JButton getFarmLvlButton() {
		return farmLvlButton;
	}


	public void setFarmLvlButton(JButton farmLvlButton) {
		this.farmLvlButton = farmLvlButton;
	}


	public CityViewListener getListener() {
		return listener;
	}

	public void setListener(CityViewListener listener) {
		this.listener = listener;
	}


	public JButton getBarracksLvlLabel() {
		return barracksLvlButton;
	}


	public void setBarracksLvlLabel(JButton barracksLvlLabel) {
		this.barracksLvlButton = barracksLvlLabel;
	}


	public JButton getArcheryRangeLvllLabel() {
		return archeryRangeLvlButton;
	}


	public void setArcheryRangeLvllLabel(JButton archeryRangeLvllLabel) {
		this.archeryRangeLvlButton = archeryRangeLvllLabel;
	}


	public JButton getStableLvlLabel() {
		return stableLvlButton;
	}


	public void setStableLvlLabel(JButton stableLvlLabel) {
		this.stableLvlButton = stableLvlLabel;
	}


	public JButton getMarketLvlLabel() {
		return marketLvlButton;
	}


	public void setMarketLvlLabel(JButton marketLvlLabel) {
		this.marketLvlButton = marketLvlLabel;
	}


	public JButton getFarmLvlLabel() {
		return farmLvlButton;
	}


	public void setFarmLvlLabel(JButton farmLvlLabel) {
		this.farmLvlButton = farmLvlLabel;
	}
	
}