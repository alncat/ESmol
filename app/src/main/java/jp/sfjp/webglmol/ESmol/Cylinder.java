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

public class Cylinder extends Renderable {

	public Cylinder(float x1, float y1, float z1, float x2, float y2, float z2, float radius, Color color) {
		
		vertexBuffer = CylinderGeometry.getVertexBuffer();
		faceBuffer = CylinderGeometry.getFaceBuffer();
		vertexNormalBuffer = CylinderGeometry.getVertexNormalBuffer();
		objectColor = color;
		//		colorBuffer = SphereGeometry.getFaceNormalBuffer();
		//		vertexColors = true;

		double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
		if (dist < 0.001) return;
		
		posx = x1; posy = y1; posz = z1;
		if (Math.abs(x1 - x2) > 0.0001 || Math.abs(y1 - y2) > 0.001){
			rot = (float) (180 / Math.PI * Math.acos((z2 - z1) / dist));
			rotx = y1 - y2;
			roty = x2 - x1;
			rotz = 0;
		} else {
			rot = (float) (180 / Math.PI * Math.acos((z2 - z1) / dist));
			rotx = 1;
			roty = 0;
			rotz = 0;
		}
		
		scalex = scaley = radius; scalez = (float) dist;
	}
}
