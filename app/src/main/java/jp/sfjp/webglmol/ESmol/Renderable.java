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

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Renderable implements Cloneable {
	public FloatBuffer vertexBuffer, colorBuffer, vertexNormalBuffer;
	public ShortBuffer faceBuffer;
	public float scalex = 1, scaley = 1, scalez = 1;
	public float posx = 0, posy = 0, posz = 0;
	public float rot = 0, rotx = 1, roty = 1, rotz = 0;
	public boolean vertexColors = false;
	public Color objectColor = new Color(1, 0, 0, 1);
	
	public ArrayList<Renderable> children = new ArrayList<Renderable>();
	
	protected void setMatrix(GL10 gl) {
		//if (posx != 0 || posy != 0 || posz != 0)
			gl.glTranslatef(posx, posy, posz);
		//if (rot != 0)
			gl.glRotatef(rot, rotx, roty, rotz);
		//if (scalex != 1 || scaley != 1 || scalez != 1)
			gl.glScalef(scalex, scaley, scalez);
	}
	
	public Renderable(FloatBuffer vertices, ShortBuffer faces) {
		vertexBuffer = vertices;
		faceBuffer = faces;
	}
	
	public Renderable() {
	}
	
	public void drawChildren(GL10 gl, GLView view) {
		for (int i = 0; i < children.size(); i++) {
			children.get(i).render(gl, view);
		}
	}
	
	public void render(GL10 gl, GLView view) {
		gl.glPushMatrix();
		setMatrix(gl);
		drawChildren(gl, view);
		
		if (vertexColors && colorBuffer != null) {
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer); 
		} else {
			gl.glColor4f(objectColor.r, objectColor.g, objectColor.b, objectColor.a);
		}		
		if (vertexBuffer != null && faceBuffer != null) {
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
			if (vertexNormalBuffer != null) {
				gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
				gl.glNormalPointer(GL10.GL_FLOAT, 0, vertexNormalBuffer);
			}
			gl.glDrawElements(GL10.GL_TRIANGLES, faceBuffer.capacity(), GL10.GL_UNSIGNED_SHORT, faceBuffer);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		}
		if (vertexColors) {
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		}
		gl.glPopMatrix();
	}
}
