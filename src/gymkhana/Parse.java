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