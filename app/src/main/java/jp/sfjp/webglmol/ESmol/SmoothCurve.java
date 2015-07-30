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

public class SmoothCurve extends Line {
	public SmoothCurve(ArrayList<Vector3> points, ArrayList<Color> colors, float curveWidth) {
		this(points, colors, curveWidth, 5);
	}
	
	public SmoothCurve(ArrayList<Vector3> points, ArrayList<Color> colors, float curveWidth, int div) {
		if (points.size() > 1) {
			vertexBuffer = Geometry.getFloatBuffer(Geometry.Subdivide(points, div));
			colorBuffer = Geometry.colorsToFloatBuffer(colors, div);
			vertexColors = true;
			width = curveWidth;
//			Log.d("SmoothCurve", "original N = " + points.size() + ", subdivided N = " + vertexBuffer.capacity());
		}
	}

}
