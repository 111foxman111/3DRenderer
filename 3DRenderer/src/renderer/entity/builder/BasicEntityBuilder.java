package renderer.entity.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import renderer.entity.Entity;
import renderer.entity.IEntity;
import renderer.point.Point3D;
import renderer.point.PointConverter;
import renderer.shapes.Face;
import renderer.shapes.Mesh;

public class BasicEntityBuilder {
	public static IEntity createCubeEntity(Point3D p, int s) {
		Point3D p1 = new Point3D(s/2+p.x,-s/2+p.y,-s/2+p.z);
		Point3D p2 = new Point3D(s/2+p.x,s/2+p.y,-s/2+p.z);
		Point3D p3 = new Point3D(s/2+p.x,s/2+p.y,s/2+p.z);
		Point3D p4 = new Point3D(s/2+p.x,-s/2+p.y,s/2+p.z);
		Point3D p5 = new Point3D(-s/2+p.x,-s/2+p.y,-s/2+p.z);
		Point3D p6 = new Point3D(-s/2+p.x,s/2+p.y,-s/2+p.z);
		Point3D p7 = new Point3D(-s/2+p.x,s/2+p.y,s/2+p.z);
		Point3D p8 = new Point3D(-s/2+p.x,-s/2+p.y,s/2+p.z);
		
		Mesh mesh = new Mesh(
				new Face(Color.RED,p1,p2,p3,p4),
				new Face(Color.ORANGE,p5,p6,p7,p8),
				new Face(Color.YELLOW,p1,p2,p6,p5),
				new Face(Color.GREEN,p4,p3,p7,p8),
				new Face(Color.BLUE,p1,p4,p8,p5),
				new Face(Color.MAGENTA,p2,p3,p7,p6));
		
		List<Mesh> meshes = new ArrayList<Mesh>();
		meshes.add(mesh);
		
		return new Entity(meshes);
	}
	
	public static Mesh createCubeMesh(Point3D p, int s) {
		Point3D p1 = new Point3D(s/2+p.x,-s/2+p.y,-s/2+p.z);
		Point3D p2 = new Point3D(s/2+p.x,s/2+p.y,-s/2+p.z);
		Point3D p3 = new Point3D(s/2+p.x,s/2+p.y,s/2+p.z);
		Point3D p4 = new Point3D(s/2+p.x,-s/2+p.y,s/2+p.z);
		Point3D p5 = new Point3D(-s/2+p.x,-s/2+p.y,-s/2+p.z);
		Point3D p6 = new Point3D(-s/2+p.x,s/2+p.y,-s/2+p.z);
		Point3D p7 = new Point3D(-s/2+p.x,s/2+p.y,s/2+p.z);
		Point3D p8 = new Point3D(-s/2+p.x,-s/2+p.y,s/2+p.z);
		
		Mesh mesh = new Mesh(
				new Face(Color.YELLOW,p1,p2,p3,p4),
				new Face(Color.WHITE,p5,p6,p7,p8),
				new Face(Color.GREEN,p1,p2,p6,p5),
				new Face(Color.BLUE,p4,p3,p7,p8),
				new Face(Color.RED,p1,p4,p8,p5),
				new Face(Color.ORANGE,p2,p3,p7,p6));
		
		return mesh;
	}
	
	public static IEntity createRubix(int dim, int size, int spacing) {
		List<Mesh> meshes = new ArrayList<Mesh>();
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				for(int k = 0; k < dim; k++) {
					meshes.add(createCubeMesh(new Point3D((i-(dim/2))*spacing,(j-(dim/2))*spacing,(k-(dim/2))*spacing), size));
				}
			}
		}
		return new Entity(meshes);
	}
	
	public static IEntity createDiamondEntity(Point3D center, int s, int edges, Color color) {
		List<Mesh> meshes = new ArrayList<Mesh>();
		
		double innerRatio = 0.8; //Size of inner circle compared to outer circle
		Point3D bottom = new Point3D(center.x,center.y,center.z - s/2);
		Point3D[] outerPoints = new Point3D[edges];
		Point3D[] innerPoints = new Point3D[edges];
		for(int i = 0; i < edges; i++) {
			double theta = 2 * Math.PI / edges * i;
			double xPos = -Math.sin(theta) * s / 2;
			double yPos = Math.cos(theta) * s / 2;
			double zPos = s/2;
			
			outerPoints[i] = new Point3D(center.x+xPos,center.y+yPos,center.z+zPos);
			innerPoints[i] = new Point3D(center.x+xPos*innerRatio,center.y+yPos*innerRatio,center.z+(zPos*(1/innerRatio)));
		}
		
		Face[] faces = new Face[2 * edges + 1];
		for(int i = 0; i < edges; i++) {
			faces[i] = new Face(color,outerPoints[i],bottom,outerPoints[(i+1)%edges]);
		}
		for(int i = 0; i < edges; i++) {
			faces[i+edges] = new Face(color,outerPoints[i],outerPoints[(i+1)%edges],innerPoints[(i+1)%edges],innerPoints[i]);
		}
		faces[edges * 2] = new Face(color, innerPoints);
		
		Mesh mesh = new Mesh(color, true, faces);
		meshes.add(mesh);
		
		return new Entity(meshes);
	}
}
