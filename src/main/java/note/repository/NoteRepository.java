package note.repository;

import java.util.List;

import note.model.Nota;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws Exception;
	public List<Nota> getNote(); 
	public void readNote(String fisier);
	public int count();
	
}
