package renderer.entity.builder;

import java.util.ArrayList;
import java.util.List;

import renderer.entity.Entity;
import renderer.entity.IEntity;
import renderer.point.Point3D;
import renderer.shapes.Mesh;

public class ComplexEntityBuilder {
	
	public static IEntity createRubix(int dim, int size, int spacing) {
		List<Mesh> meshes = new ArrayList<Mesh>();
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				for(int k = 0; k < dim; k++) {
					meshes.add(BasicEntityBuilder.createCubeMesh(new Point3D((i-(dim/2))*spacing,(j-(dim/2))*spacing,(k-(dim/2))*spacing), size));
				}
			}
		}
		return new Entity(meshes);
	}
}
