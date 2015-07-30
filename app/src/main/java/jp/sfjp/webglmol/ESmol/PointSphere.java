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

public class PointSphere extends Renderable{
	public PointSphere(float x, float y, float z, float radius, Color c) {
		vertexBuffer = Geometry.getFloatBuffer(new float[] {0, 0, 0});
		scalex = scaley = scalez = radius;
		posx = x; posy = y; posz = z;
		objectColor = c;
	}
	
	public void render(GL10 gl, GLView view) {
		gl.glPushMatrix();
		setMatrix(gl);
		
		gl.glEnable(GL10.GL_ALPHA_TEST);
		gl.glPointSize(scalex * 15);
		gl.glColor4f(objectColor.r, objectColor.g, objectColor.b, objectColor.a);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glDrawArrays(GL10.GL_POINTS, 0, vertexBuffer.capacity());
		
		gl.glDisable(GL10.GL_ALPHA_TEST);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glPopMatrix();
	}
	
}
