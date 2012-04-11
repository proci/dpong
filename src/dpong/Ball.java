package dpong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Entity {
	
	private static final int BALL_SIZE = 10;
	
	public Ball() {
		m_vector = new Vector(Setup.WIDTH, Setup.HEIGHT);
		m_xSpeed = 30;
		m_ySpeed = 30;
	}

	@Override
	public boolean collides(Entity p_ent) {
		return false;
	}

	@Override
	public boolean blockAt(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(float interpolation, Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(m_vector.getX()+(int)(m_xSpeed*interpolation), m_vector.getY()+(int)(m_ySpeed*interpolation), BALL_SIZE, BALL_SIZE);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if (m_vector.getX() > Setup.WIDTH-BALL_SIZE || m_vector.getX() < 0 + BALL_SIZE) {
			m_xSpeed *= -1;
		}
		if (m_vector.getY() > Setup.HEIGHT-BALL_SIZE || m_vector.getY() < 0 + BALL_SIZE) {
			m_ySpeed *= -1;
		}
		m_vector.setX(m_vector.getX() + m_xSpeed);
		m_vector.setY(m_vector.getY() + m_ySpeed);
	}

}
