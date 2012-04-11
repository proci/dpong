package dpong;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

	private final int m_distanceFromBorder = 0;
	private final int m_width = 10;
	private final int m_height = 30;
	
	public Player(int xPos, boolean isOnTheLeftSide){
		int multiplier = 1;
		if(!isOnTheLeftSide){
			multiplier = -1;			
		}
		
		m_vector = new Vector(xPos +(multiplier * m_distanceFromBorder), 300);
	}
	
	public void moveY(int y) {
		int newY = m_vector.getY() + y;
		if (m_vector.getY() <= 0 + m_height/2){
			if(newY > 0)
				m_vector.setY(newY);
			else m_vector.setY(0);
			System.out.println("case0 " + newY);
		}				
		else if(m_vector.getY() >= Setup.HEIGHT - m_height/2){	
			if(newY < Setup.HEIGHT - m_height/2)
				m_vector.setY(newY);
			else m_vector.setY(Setup.HEIGHT - m_height/2);
			System.out.println("case600 " + newY);
		}
		else{
			m_vector.setY(newY);
			System.out.println("normalcase " + newY);
		}		
	}
	
	@Override
	public boolean collides(Entity p_ent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blockAt(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(float interpolation, Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillRect(m_vector.getX(), m_vector.getY(), m_width, m_height);		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
