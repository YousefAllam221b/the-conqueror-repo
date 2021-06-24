package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import listeners.HomeViewListener;

public class HomeView extends JFrame implements ActionListener
{
	Image backgroundImage;
	JButton startGame;
	HomeViewListener listener;
	JTextField enterYourNameField;
	Label welcome;

	public void setListener(HomeViewListener listener)
	{
		this.listener = listener;
	}

	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		startGame.repaint();
	}

	public HomeView()
	{

		backgroundImage = new ImageIcon("resources/startScreen.jpg").getImage();
		new JFrame();
		this.setSize(1280, 720);

		welcome = new Label("Enter Your Name");
		welcome.setAlignment(Label.CENTER);
		startGame = new JButton("Start Game");
		enterYourNameField = new JTextField();
		enterYourNameField.setPreferredSize(new Dimension(100, 25));
		enterYourNameField.setHorizontalAlignment(JTextField.CENTER);

		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel filler = new JPanel();
		topPanel.setLayout(new BorderLayout());
		JPanel welcomePanel = new JPanel();

		bottomPanel.setPreferredSize(new Dimension(0, 330));
		topPanel.setPreferredSize(new Dimension(0, 320));

		startGame.setForeground(Color.WHITE);
		startGame.setBackground(Color.DARK_GRAY);
		startGame.setFocusable(false);
		startGame.addActionListener(this);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(midPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);

		topPanel.add(filler, BorderLayout.CENTER);
		topPanel.add(welcomePanel, BorderLayout.SOUTH);
		welcomePanel.add(welcome, BorderLayout.CENTER);
		midPanel.add(enterYourNameField);
		bottomPanel.add(startGame, BorderLayout.CENTER);

		this.setTitle("The Conquerer");
		this.setResizable(false);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.validate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == startGame)
		{
			if (!enterYourNameField.getText().equals(""))
			{
				listener.onStartGame(enterYourNameField.getText());
				startGame.setEnabled(false);
				enterYourNameField.setEditable(false);
			}
			else
			{
				welcome.setText("ENTER A NAME !!!");
				welcome.setForeground(Color.red);
			}
		}

	}

}
