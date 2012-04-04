package dpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import javax.swing.*;

public class DPong extends JFrame implements WindowListener {
	
	private LinkedList<Entity> m_entities;
	private boolean windowClosed = false;
	
	private Image m_image;
	private Graphics m_graphics;
	
	public DPong() {
		this.addWindowListener(this);
		this.setIgnoreRepaint(true);
		this.setBackground(Color.BLACK);
		m_entities = new LinkedList<Entity>();
		this.setSize(800,600);
		this.setResizable(false);
		this.setTitle("DPong");
		this.setVisible(true);
		m_entities.add(new Ball());
		m_image = this.createImage(800, 600);
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

}
