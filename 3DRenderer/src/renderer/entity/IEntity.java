package renderer.entity;

import java.awt.Graphics;

public interface IEntity {
	void render(Graphics g);
	
	void rotate(double xDegrees, double yDegrees, double zDegrees);
}
