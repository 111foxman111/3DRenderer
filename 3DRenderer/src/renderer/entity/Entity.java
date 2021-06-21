package renderer.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import renderer.shapes.Mesh;

public class Entity implements IEntity {
	
	public List<Mesh> meshes = new ArrayList<Mesh>();

	public Entity(List<Mesh> meshes) {
		this.meshes = meshes;
	}

	@Override
	public void render(Graphics g) {
		meshes = sortMeshes(meshes);
		
		for(Mesh m : meshes) {
			m.render(g);
		}
	}

	@Override
	public void rotate(double xDegrees, double yDegrees, double zDegrees) {
		for(Mesh m : meshes) {
			m.rotate(xDegrees, yDegrees, zDegrees);
		}
	}
	
	public static List<Mesh> sortMeshes(List<Mesh> meshes) {
		List<Mesh> meshesList = new ArrayList<Mesh>();
		
		for(Mesh mesh : meshes) {
			meshesList.add(mesh);
		}
		
		Collections.sort(meshesList, new Comparator<Mesh>() {
			@Override
			public int compare(Mesh p1, Mesh p2) {
				return p2.getAverageX() - p1.getAverageX() < 0 ? 1 : -1;
			}
		});
		
		for(int i = 0; i < meshes.size(); i++) {
			meshes.set(i, meshesList.get(i));
		}
		
		return meshes;
	}

}
