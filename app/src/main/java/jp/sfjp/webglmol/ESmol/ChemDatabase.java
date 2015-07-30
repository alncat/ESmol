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

public class ChemDatabase {
	private static HashMap<String, Color> ElementColors;
	public static Color defaultColor = new Color(0xCCCCCC);
	private static HashMap<String, Float> vdwRadii;
	private static float defaultRadius = 1.5f;
	
	private ChemDatabase() {
	}

	
	public static Color getColor(String elem) {
		if (ElementColors == null) initialize();
		
		Color c = ElementColors.get(elem);
		if (c == null) return defaultColor;
		return c;
	}
	
	public static float getVdwRadius(String elem) {
		if (vdwRadii == null) initialize();
		
		Float f = vdwRadii.get(elem);
		if (f == null) return defaultRadius;
		return (float)f;
	}
	
	private static void initialize() {
		ElementColors = new HashMap<String, Color>();
		ElementColors.put("H", new Color(0x888888));
		ElementColors.put("C", new Color(0xAAAAAA));
		ElementColors.put("O", new Color(0xCC0000));
		ElementColors.put("N", new Color(0x0000CC));
		ElementColors.put("S", new Color(0xCCCC00));
		ElementColors.put("P", new Color(0x6622CC));
		ElementColors.put("F", new Color(0x00CC00));
		ElementColors.put("CL", new Color(0x00CC00));
		ElementColors.put("BR", new Color(0x882200));
		ElementColors.put("FE", new Color(0xCC6600));
		ElementColors.put("CA", new Color(0x8888AA));

		// Reference: A. Bondi, J. Phys. Chem., 1964, 68, 441.
		vdwRadii = new HashMap<String, Float>();
		vdwRadii.put("H", 1.2f);
		vdwRadii.put("LI", 1.82f);
		vdwRadii.put("NA", 2.27f);
		vdwRadii.put("K", 2.75f);
		vdwRadii.put("C", 1.7f);
		vdwRadii.put("N", 1.55f);
		vdwRadii.put("O", 1.52f);
		vdwRadii.put("F", 1.47f);
		vdwRadii.put("P", 1.80f);
		vdwRadii.put("S", 1.80f);
		vdwRadii.put("CL", 1.75f);
		vdwRadii.put("BR", 1.85f);
		vdwRadii.put("SE", 1.90f);
		vdwRadii.put("ZN", 1.39f);
		vdwRadii.put("CU", 1.4f);
		vdwRadii.put("NI", 1.63f);			
	}
}
