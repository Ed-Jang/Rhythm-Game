package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png")); // exit
																															// 버튼
																															// 마우스
																															// 올렸을때
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")); // exit
																														// 버튼
																														// 기본
																														// 이미지
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEntered.png")); // 시작버튼 마우스 올렸을때
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png")); // 시작버튼
																														// 기본
																														// 이미지
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png")); // 종료버튼
																															// 마우스
																															// 올렸을때
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png")); // 종료버튼
																														// 기본
																														// 이미지

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);

	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		// exit 버튼
		exitButton.setBounds(1245, 0, 30, 30); // x좌표, y좌표 , 가로,세로
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); // 마우스가 올라갔을때 Entered이미지로 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);// 마우스 올릴때 효과음
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); // 마우스가 내려갔을때 다시 Basic 이미지로 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 마우스 모양 복귀
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);// 마우스 클릭시 효과음
				buttonPressedMusic.start();
				// 게임 종료 이벤트
				try {
					Thread.sleep(1000);// 클릭시 바로 종료되지 않고 효과음이 나온 후 종료되기 위해 1초정지
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); // 클릭했을때 게임 종료
			}
		});
		add(exitButton);

		// 시작버튼
		startButton.setBounds(40, 200, 400, 100); // x좌표, y좌표 , 가로,세로
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); // 마우스가 올라갔을때 Entered이미지로 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);// 마우스 올릴때 효과음
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); // 마우스가 내려갔을때 다시 Basic 이미지로 변경
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 마우스 모양 복귀
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);// 마우스 클릭시 효과음
				buttonPressedMusic.start();
				// 게임 시작 이벤트
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
			}
		});
		add(startButton);

		// 종료버튼
		quitButton.setBounds(40, 300, 400, 100);// x좌표, y좌표 , 가로, 세로
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); // 마우스가 올라갔을때 Entered이미지로 변경
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 손가락 모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);// 마우스 올릴때 효과음
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); // 마우스가 내려갔을때 다시 Basic 이미지로 변경
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 마우스 모양 복귀
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);// 마우스 클릭시 효과음
				buttonPressedMusic.start();
				// 게임 종료 이벤트
				try {
					Thread.sleep(1000);// 클릭시 바로 종료되지 않고 효과음이 나온 후 종료되기 위해 1초정지
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0); // 클릭했을때 게임 종료
			}
		});
		add(quitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		Music introMusic = new Music("20200913 Golden Ring Mastering.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);// 고정된 이미지는 paintComponents 이용
		this.repaint();

	}
}
