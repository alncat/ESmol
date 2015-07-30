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

import java.util.HashMap;

public class Protein {
	public float a, b, c, alpha, beta, gamma;
	public float ax, ay, az, bx, by, bz, cx, cy, cz;
	public String spacegroup;
	public boolean sdfFile = false;
	public Atom [] atoms = new Atom[100001];
	public HashMap<Integer, float[]> symmetryMatrices = new HashMap<Integer, float[]>();
	public HashMap<Integer, float[]> biomtMatrices = new HashMap<Integer, float[]>();
}
