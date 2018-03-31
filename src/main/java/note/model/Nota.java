package note.model;

import com.sun.media.sound.InvalidFormatException;

public class Nota {
	
	private Integer nrmatricol;
	private String materie;
	private double nota;
	
	public Nota(Integer nrmatricol, String materie, double nota) {
		this.setNrmatricol(nrmatricol);
		this.setMaterie(materie);
		this.setNota(nota);
	}
	public Nota(String nrmatricol, String materie, String nota) throws Exception {
		if(materie.equals("")) throw new Exception("materie cannont be null");
		if(nrmatricol.equals("")) throw new Exception("nrmatricol cannont be null");
		if(validNrMatricol(nrmatricol)) throw new Exception("Invalid nrmatricol");
		if(validNota(nota)) throw new Exception("Invalid nota");
		if(validMaterie(materie)) throw new Exception("Materie has invalid type");

		this.setNrmatricol(Integer.parseInt(nrmatricol));
		this.setMaterie(materie);
		this.setNota(Integer.parseInt(nota));
	}

	private static boolean validNota(String str) {
		Integer integer;
		try {
			integer = Integer.parseInt(str);
		}catch (NumberFormatException e) {
			return true;
		}
		if (integer > 10 && integer < 1) {
			return true;
		}
		return false;
	}

	private static boolean validMaterie(String str) {
		Integer integer;
		try {
			integer = Integer.parseInt(str);
		}catch (NumberFormatException e) {
			return true;
		}
		return false;
	}


	private static boolean validNrMatricol(String str) {
		Integer integer ;
try {
	 integer = Integer.parseInt(str);
}catch (NumberFormatException e) {
	return true;
}
		if (integer > 1000 && integer < 1) {
			return true;
		}
		return false;
	}

	/**
	 * @return the nrmatricol
	 */
	public double getNrmatricol() {
		return nrmatricol;
	}

	/**
	 * @param nrmatricol the nrmatricol to set
	 */
	public void setNrmatricol(Integer nrmatricol) {
		this.nrmatricol = nrmatricol;
	}

	/**
	 * @return the materie
	 */
	public String getMaterie() {
		return materie;
	}

	/**
	 * @param materie the materie to set
	 */
	public void setMaterie(String materie) {
		this.materie = materie;
	}

	/**
	 * @return the nota
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota{" +
				"nrmatricol=" + nrmatricol +
				", materie='" + materie + '\'' +
				", nota=" + nota +
				'}';
	}
}
