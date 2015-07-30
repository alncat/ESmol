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

public class Atom {
	public String resn = "", elem = "", chain = "", atom = "", ss = "c";
	public float x = 0, y = 0, z = 0, b = 0;
	public int resi, serial;
	public Color color = ChemDatabase.defaultColor;
	public boolean hetflag;
	public ArrayList<Integer> bonds = null, bondOrder = null;

	public final int isConnected(Atom atom) {
		int s = -1;
		if (bonds != null && (s = bonds.indexOf(atom.serial)) != -1) return bondOrder.get(s);

		//if (this.protein.sdf && (atom1.hetflag || atom2.hetflag)) return 0; // CHECK: or should I ?
		
		float distSquared = (x - atom.x) * (x - atom.x) + (y - atom.y) * (y - atom.y) + (z - atom.z) * (z - atom.z);
		if (Float.isNaN(distSquared)) return 0;
		if (distSquared < 0.5) return 0;
		if (distSquared > 1.3 && (atom.elem.equals("H") || elem.equals("H"))) return 0;
		if (distSquared < 3.42 && (atom.elem.equals("S") || elem.equals("S"))) return 1;
		if (distSquared > 2.78) return 0;
//		Log.d("isConnected", "bond between " + serial + " and " + atom.serial + ", dist^2 = " + distSquared);		
		return 1;
	}
}
