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
    @Test
    public void addNrMatricolInvalid() throws Exception {

        try {
            nota = new Nota("", "Istorie", "7");

            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Nr matricol nu poate fi empty");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (NullPointerException e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }


    @Test
    public void addNrMatricolInvalidType() throws Exception {

        try {
            nota = new Nota("Marcel", "Istorie", "7");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Nr matricol nu poate fi string");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (NullPointerException e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }

    @Test
    public void addNrMatricolInvalidLength() throws Exception {

        try {
            nota = new Nota("1230213123", "Istorie", "7");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Nr matricol has invalid legth");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (NullPointerException e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }

    @Test
    public void addmaterieEmplty() throws Exception {

        try {
            nota = new Nota("1000", "", "7");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Materie nu poate fi empty");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (NullPointerException e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }
    @Test
    public void addMaterieInvalidType() throws Exception {
        try {
            nota = new Nota("1000", "123wqe", "7");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Materie has invalid type");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (NullPointerException e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }

    @Test
    public void addNotaEquals0() throws Exception {
        try {
            nota = new Nota("1000", "Istorie", "0");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Nota nu poate fi 0");
        }
        int repoSizeBeforeAdd = noteRepository.count();
        try {
            noteRepository.addNota(nota);
        } catch (Exception e) {
            assertTrue(repoSizeBeforeAdd + 1 != noteRepository.count());
        }
    }

}
