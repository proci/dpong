package dpong;

import java.awt.Graphics;

public abstract class Entity {
	
	protected Vector m_vector;
	
	protected int m_xSpeed;
	protected int m_ySpeed;
	
	public abstract boolean collides(Entity p_ent);
	public abstract boolean blockAt(int x, int y);
	
	public abstract void draw(float interpolation, Graphics g);
	public abstract void tick();
	
}
