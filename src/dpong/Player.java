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
		if (newY > 0 && newY < 600-m_height)
			m_vector.setY(newY);
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
