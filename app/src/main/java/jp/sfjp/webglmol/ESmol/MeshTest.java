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

import javax.microedition.khronos.opengles.GL10;

public class MeshTest extends Renderable {
	public MeshTest() {
		float vertices[] = {0, 0, 0,    0, 5, 0,    5, 0, 0,    5, 5, 0,    5, 0, 0,    5, 5, 0,    5, 0, -5,    5, 5, -5};
		float normals[] = {0, 0, -1,    0, 0, -1,   0, 0, -1,   0, 0, -1,   1, 0, 0,    1, 0, 0,   1,  0, 0,   1, 0, 0};
		short faces[] = {0, 1, 2,  2, 1, 3,  4, 5, 6,  6, 5, 7};
		
		vertexBuffer = Geometry.getFloatBuffer(vertices);
		faceBuffer = Geometry.getShortBuffer(faces);
		vertexNormalBuffer = Geometry.getFloatBuffer(normals);
	}
	
	public void render(GL10 gl) {
		gl.glPushMatrix();
		setMatrix(gl);
		
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glNormalPointer(GL10.GL_FLOAT, 0, vertexNormalBuffer);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
//		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		gl.glDrawElements(GL10.GL_TRIANGLES, faceBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, faceBuffer);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		/*
		if (vertexColors && colorBuffer != null) {
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		} else {
			gl.glColor4f(objectColor.r, objectColor.g, objectColor.b, objectColor.a);
		}		
		if (vertexBuffer != null && faceBuffer != null) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
			if (faceNormalBuffer != null) {
				gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
				gl.glNormalPointer(GL10.GL_FLOAT, 0, faceNormalBuffer);
			}
			gl.glDrawElements(GL10.GL_TRIANGLES, faceBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, faceBuffer);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		}
		if (vertexColors) {
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		}*/
		gl.glPopMatrix();
	}
}
