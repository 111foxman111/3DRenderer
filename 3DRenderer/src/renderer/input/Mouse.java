package renderer.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	public int mouseX = -1;
	public int mouseY = -1;
	public int mouseB = -1;
	
	public int getX() {
		return this.mouseX;
	}
	
	public int getY() {
		return this.mouseY;
	}
	
	public ClickType getButton() {
		switch(this.mouseB) {
			case 1:
				return ClickType.LeftClick;
			case 3: 
				return ClickType.RightClick;
			default:
				return ClickType.Unknown;
		}
	}
	
	public void resetButton() {
		this.mouseB = -1;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.mouseB = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.mouseB = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
