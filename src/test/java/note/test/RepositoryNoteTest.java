package note.test;

import note.model.Nota;
import note.repository.NoteRepository;
import note.repository.NoteRepositoryMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by crys_ on 30.03.2018.
 */
public class RepositoryNoteTest {

    private NoteRepository noteRepository = new NoteRepositoryMock();
    private Nota nota;


    @Test
    public void addNotaAllInputTypesAreValid() throws Exception {

        try {
            nota = new Nota(43, "Istorie", 7);
        } catch (Exception e) {
            assertTrue(true);
        }

        int repoSizeBeforeAdd= noteRepository.count();
        noteRepository.addNota(nota);
        assertTrue(repoSizeBeforeAdd + 1 == noteRepository.count());
    }
   /* @Test
    public void addNrMatricolInvalid() {

        try {
            nota = new Nota(1, "Istorie", 7);
            nota.setNota("");
        } catch (Exception e) {
            assertTrue(true);
            System.out.println("Name can't be string");
        }

        int repoSizeBeforeAdd = repositoryContact.count();
        repositoryContact.addContact(contact);
        assertTrue(repoSizeBeforeAdd + 1 != repositoryContact.count());
    }*/
}
