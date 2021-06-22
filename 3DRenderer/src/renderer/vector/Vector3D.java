package renderer.vector;

import renderer.point.Point3D;

public class Vector3D {
	public double x, y, z;
	
	public Vector3D() {
		this.x = this.y = this.z = 0;
	}
	
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vector3D fromPolar(double xDegrees, double yDegrees, double magnitude) {
		return new Vector3D(
				Math.cos(Math.toRadians(xDegrees)) * Math.cos(Math.toRadians(yDegrees)),
				Math.sin(Math.toRadians(xDegrees)) * Math.cos(Math.toRadians(yDegrees)),
				Math.sin(Math.toRadians(yDegrees))
				); //Math may be incorrect
	}
	
	public Vector3D(Point3D p1, Point3D p2) {
		this.x = p1.x - p2.x;
		this.y = p1.y - p2.y;
		this.z = p1.z - p2.z;
	}
	
	public static double dot(Vector3D v1, Vector3D v2) {
		return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
	}
	
	public static Vector3D cross(Vector3D v1, Vector3D v2) {
		return new Vector3D(
				v1.y*v2.z - v1.z*v2.y,
				v1.x*v1.z - v1.z*v2.z,
				v1.x*v2.y - v1.y*v2.x
				);
	}

	public static Vector3D normalize(Vector3D v) {
		 double magnitude = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
		 return new Vector3D(v.x/magnitude,v.y/magnitude,v.z/magnitude);
	}
}
