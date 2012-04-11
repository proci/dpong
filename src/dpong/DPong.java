package dpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import javax.swing.*;

public class DPong extends JFrame implements WindowListener, KeyListener {
	
	private LinkedList<Entity> m_entities;
	private boolean windowClosed = false;
	
	private Image m_image;
	private Graphics m_graphics;
	
	private Player m_player1;
	
	public DPong() {
		this.addWindowListener(this);
		this.addKeyListener(this);
		
		
		this.setIgnoreRepaint(true);
		this.setBackground(Color.BLACK);
		m_entities = new LinkedList<Entity>();
		this.setSize(Setup.WIDTH,Setup.HEIGHT);
		this.setResizable(false);
		this.setTitle("DPong");
		this.setVisible(true);
		
		m_entities.add(new Ball());
		m_player1 = new Player(30, false);
		m_entities.add(m_player1);
		
		
		
		m_image = this.createImage(Setup.WIDTH, Setup.HEIGHT);
		m_graphics = m_image.getGraphics();
	}
	
	public void tick() {
		for (Entity m : m_entities) {
			m.tick();
		}
	}
	
	public void draw(float interpolation) {
		m_graphics.clearRect(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getWidth());
		for (Entity m : m_entities) {
			m.draw(interpolation, m_graphics);
		}
		this.paint(this.getGraphics());
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(m_image, 0, 0, this);
	}
	
	public boolean isClosed() {
		return windowClosed;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		windowClosed = true;
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_I) {
			m_player1.moveY(-10);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_K){
			m_player1.moveY(10);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
