/* The aim of software is to provide an automated portal for gymkhana at IIT-Guwahati
    Copyright (C) 2013  Arihant Sethia

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package gymkhana;

public class Parse {

	public static String venueauth(String v) {

		String s = null;
		if(v.equals("dBT"))
			s= "hodbt";
		if(v.equals("dCL"))
			s= "hodcl";
		if(v.equals("dCST"))
			s= "hodcst";
		if(v.equals("dCE"))
			s= "hodce";
		if(v.equals("dCSE"))
			s= "hodcse";
		if(v.equals("dOD"))
			s= "hodod";
		if(v.equals("dEEE"))
			s= "hodeee";
		if(v.equals("dHSS"))
			s= "hodssh";
		if(v.equals("dMNC"))
			s= "hodmnc";
		if(v.equals("dME"))
			s= "hodme";
		if(v.equals("dEP"))
			s= "hodep";
		if(v.equals("au"))
			s= "dosa";
		if(v.equals("mau"))
			s= "dosa";
		if(v.equals("lt"))
			s= "doaa";
		if(v.equals("mch"))
			s= "dosa";
		if(v.equals("fch"))
			s= "dosa";
		
		return s;
	}

	public static String venueroom(String v) {
		String s = null;
		if(v.equals("dBT"))
			s= "Seminar Room Dept. Of Biotechnology";
		if(v.equals("dCL"))
			s= "Dept. of Chemical Engineering";
		if(v.equals("dCST"))
			s= "Dept. of Chemical Science & Technology";
		if(v.equals("dCE"))
			s= "Dept. of Civil Engineering";
		if(v.equals("dCSE"))
			s= "Dept. of Computer Science & Engg.";
		if(v.equals("dOD"))
			s= "Dept. of Design";
		if(v.equals("dEEE"))
			s= "Dept. of Electronics & Electrical Engg.";
		if(v.equals("dHSS"))
			s= "Dept. of Humanities and Social Sciences";
		if(v.equals("dMNC"))
			s= "Dept. of Mathematics";
		if(v.equals("dME"))
			s= "Dept. of Mechanical Engineering";
		if(v.equals("dEP"))
			s= "Dept. of Mathematics";
		if(v.equals("au"))
			s= "Auditorium";
		if(v.equals("mau"))
			s= "Mini-Auditorium";
		if(v.equals("lt"))
			s= "doaa";
		if(v.equals("mch"))
			s= "Manas Community Hall";
		if(v.equals("fch"))
			s= "Faculty Community Hall";

		return s;
	}
}