package renderer.point;

public class Point3D {
	public static final Point3D origin = new Point3D(0,0,0);
	
	public double x,y,z;
	public double xOffset, yOffset, zOffset;
	
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.xOffset = this.yOffset = this.zOffset = 0;
	}
	
	public double getAdjustedX() {
		return this.x + this.xOffset;
	}
	
	public double getAdjustedY() {
		return this.y + this.yOffset;
	}
	
	public double getAdjustedZ() {
		return this.z + this.zOffset;
	}

	public static double dist(Point3D p1, Point3D p2) {
		double x2 = (p1.x - p2.x) * (p1.x - p2.x);
		double y2 = (p1.y - p2.y) * (p1.y - p2.y);
		double z2 = (p1.z - p2.z) * (p1.z - p2.z);
		return Math.sqrt(x2 + y2 + z2);
	}
}
