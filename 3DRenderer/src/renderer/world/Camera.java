package renderer.world;

import renderer.point.Point3D;
import renderer.vector.Vector3D;

public class Camera {
	private Point3D pos;
	private double roll, pitch, yaw;
	
	public Camera(Point3D p) {
		this.pos = p;
	}
	
	public void translate(Vector3D v) {
		this.pos.x += v.x;
		this.pos.y += v.y;
		this.pos.z += v.z;
	}
	
	public double getX() {
		return this.pos.x;
	}
	
	public double getY() {
		return this.pos.y;
	}
	
	public double getZ() {
		return this.pos.z;
	}
	
	public Point3D getPos() {
		return this.pos;
	}
}
