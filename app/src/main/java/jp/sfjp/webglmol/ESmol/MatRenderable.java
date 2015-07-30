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

public class MatRenderable extends Renderable {
	private ArrayList <float[]> matrices = new ArrayList<float[]>();

	public void addMatrix(float[] mat) {
		float matrix[] = new float[16];

		matrix[0] = mat[0];
		matrix[4] = mat[1];
		matrix[8] = mat[2];
		matrix[12] = mat[3];
		matrix[1] = mat[4];
		matrix[5] = mat[5];
		matrix[9] = mat[6];
		matrix[13] = mat[7];
		matrix[2] = mat[8];
		matrix[6] = mat[9];
		matrix[10] = mat[10];
		matrix[14] = mat[11];
		matrix[3] = mat[12];
		matrix[7] = mat[13];
		matrix[11] = mat[14];
		matrix[15] = mat[15];

		matrices.add(matrix);
	}

	public void render(GL10 gl, GLView view) {
		gl.glPushMatrix();
		setMatrix(gl);

		for (int i = 0, lim = matrices.size(); i < lim; i++) {
			gl.glPushMatrix();
			gl.glMultMatrixf(matrices.get(i), 0);
			drawChildren(gl, view);
			gl.glPopMatrix();
		}		

		gl.glPopMatrix();
	}
}
