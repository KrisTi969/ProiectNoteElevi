package note.repository;

import java.util.HashMap;
import java.util.List;

import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;

public interface ClasaRepository {
	
	public void creazaClasa(List<Elev> elevi, List<Nota> note);
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	public List<Medie> calculeazaMedii();
	public void afiseazaClasa();
	public List<Corigent> getCorigenti();
}
