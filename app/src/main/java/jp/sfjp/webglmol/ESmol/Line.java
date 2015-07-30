/*  ESmol - Molecular Viewer for Android

     (C) Copyright 2011 - 2012, biochem_fan

     This file is part of ESmol.

     ESmol is free software: you can redistribute it and/or modify
     it under the terms of the GNU Lesser General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     This program is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU Lesser General Public License for more details.

     You should have received a copy of the GNU Lesser General Public License
     along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package jp.sfjp.webglmol.ESmol;

import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;


public class Line extends Renderable {
	public float width = 2;
	boolean discrete = false;

	public Line(ArrayList<Vector3> points) {
		vertexBuffer = Geometry.getFloatBuffer(Geometry.fromVectorArrayList(points));
	}
	
	public Line(float[] points) {
		vertexBuffer = Geometry.getFloatBuffer(points);
	}
	
	public Line(ArrayList<Vector3> points, ArrayList<Color> colors) {
		if (points.size() > 0) {
			vertexBuffer = Geometry.getFloatBuffer(Geometry.fromVectorArrayList(points));
			colorBuffer = Geometry.colorsToFloatBuffer(colors, 1);
			vertexColors = true;
		}
	}
	
	public Line() {
	}
	
	public void render(GL10 gl, GLView view) {
		gl.glPushMatrix();
		setMatrix(gl);
//		drawChildren(gl);
		gl.glDisable(GL10.GL_LIGHTING);
		
		if (vertexBuffer != null) {
			gl.glLineWidth(width);
			if (vertexColors && colorBuffer != null) { 
				gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
				gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
			} else {
				gl.glColor4f(objectColor.r, objectColor.g, objectColor.b, objectColor.a);
			}

			gl.glVertexPointer(3,GL10.GL_FLOAT, 0, vertexBuffer);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			if (discrete) {
				gl.glDrawArrays(GL10.GL_LINES, 0, vertexBuffer.capacity() / 3);
			} else {
				gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, vertexBuffer.capacity() / 3);
			}
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			
			if (vertexColors) {
				gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
			}
		}
		gl.glPopMatrix();
		gl.glEnable(GL10.GL_LIGHTING);
	}
}
