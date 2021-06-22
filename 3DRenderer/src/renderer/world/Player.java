package renderer.world;

import renderer.entity.EntityManager;
import renderer.point.Point3D;
import renderer.vector.Vector3D;

public class Player {
	public static Camera camera;
	private double moveSpeed = 10;
	
	public Player() {
		Player.camera = new Camera(new Point3D(0,0,0));
	}
	
	public void moveUp(EntityManager e) {
		camera.translate(new Vector3D(0, 0, -moveSpeed));
		e.translate(new Vector3D(0, 0, -moveSpeed));
	}
	
	public void moveDown(EntityManager e) {
		camera.translate(new Vector3D(0, 0, moveSpeed));
		e.translate(new Vector3D(0, 0, moveSpeed));
	}
	
	public void moveLeft(EntityManager e) {
		camera.translate(new Vector3D(0, moveSpeed, 0));
			e.translate(new Vector3D(0, moveSpeed, 0));
	}
	
	public void moveRight(EntityManager e) {
		camera.translate(new Vector3D(0, -moveSpeed, 0));
		e.translate(new Vector3D(0, -moveSpeed, 0));
	}
	
	public void moveForward(EntityManager e) {
		camera.translate(new Vector3D(moveSpeed, 0, 0));
		e.translate(new Vector3D(moveSpeed, 0, 0));
	}
	
	public void moveBackward(EntityManager e) {
		camera.translate(new Vector3D(-moveSpeed, 0, 0));
		e.translate(new Vector3D(-moveSpeed, 0, 0));
	}
}
