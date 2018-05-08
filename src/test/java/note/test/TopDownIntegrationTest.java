package note.test;

import note.controller.NoteController;
import note.model.Elev;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import note.repository.NoteRepository;
import note.repository.NoteRepositoryMock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by crys_ on 08.05.2018.
 */
public class TopDownIntegrationTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private NoteController ctrl;
    private HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
    private ClasaRepositoryMock clasaRepositoryMock = new ClasaRepositoryMock(clasa);
    private NoteRepository noteRepository = new NoteRepositoryMock();
    private Nota nota;

    @Before
    public void init() {
        ctrl = new NoteController();
    }

    @Test
    public void test1() throws Exception {
        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
    }

    @Test
    public void InputGiver() {
        List<Double> ClasaList = new ArrayList<Double>();
        ClasaList.add(4.2);
        ClasaList.add(5.3);
        HashMap<String, List<Double>> Hashuri = new HashMap<String, List<Double>>();

        Hashuri.put("String1", ClasaList);
        Hashuri.put("String2", ClasaList);

        HashMap<Elev, HashMap<String, List<Double>>> Hashuri2 = new HashMap<Elev, HashMap<String, List<Double>>>();

        Hashuri2.put(new Elev(12, "Marc"), Hashuri);
        Hashuri2.put(new Elev(13, "Marc2"), Hashuri);

        clasa = Hashuri2;

        clasaRepositoryMock = new ClasaRepositoryMock(clasa);

        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 2);
    }

    @Test
    public void addNotaAllInputTypesAreValid() throws Exception {
        try {
            nota = new Nota(43, "Istorie", 7);
        } catch (Exception e) {
            System.out.print(e.toString());
            assertTrue(true);
        }
        int repoSizeBeforeAdd = noteRepository.count();
        noteRepository.addNota(nota);
        assertTrue(repoSizeBeforeAdd + 1 == noteRepository.count());
    }
    @Test
     public void TopDownIntegrationTest() throws Exception {


        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());


        List<Double> ClasaList = new ArrayList<Double>();
        ClasaList.add(4.2);
        ClasaList.add(5.3);
        HashMap<String, List<Double>> Hashuri = new HashMap<String, List<Double>>();

        Hashuri.put("String1", ClasaList);
        Hashuri.put("String2", ClasaList);

        HashMap<Elev, HashMap<String, List<Double>>> Hashuri2 = new HashMap<Elev, HashMap<String, List<Double>>>();

        Hashuri2.put(new Elev(12, "Marc"), Hashuri);
        Hashuri2.put(new Elev(13, "Marc2"), Hashuri);

        clasa = Hashuri2;

        clasaRepositoryMock = new ClasaRepositoryMock(clasa);

        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 2);


      /*  try {
            nota = new Nota(43, "Istorie", 7);
        } catch (Exception e) {
            System.out.print(e.toString());
            assertTrue(true);
        }
        int repoSizeBeforeAdd = noteRepository.count();
        noteRepository.addNota(nota);
        assertTrue(repoSizeBeforeAdd + 1 == noteRepository.count());*/
    }
@Test
    public void TopDownIntegrationTestB() throws Exception {


        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());


        List<Double> ClasaList = new ArrayList<Double>();
        ClasaList.add(4.2);
        ClasaList.add(5.3);
        HashMap<String, List<Double>> Hashuri = new HashMap<String, List<Double>>();

        Hashuri.put("String1", ClasaList);
        Hashuri.put("String2", ClasaList);

        HashMap<Elev, HashMap<String, List<Double>>> Hashuri2 = new HashMap<Elev, HashMap<String, List<Double>>>();

        Hashuri2.put(new Elev(12, "Marc"), Hashuri);
        Hashuri2.put(new Elev(13, "Marc2"), Hashuri);

        clasa = Hashuri2;

        clasaRepositoryMock = new ClasaRepositoryMock(clasa);

        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 2);

        try {
            nota = new Nota(43, "Istorie", 7);
        } catch (Exception e) {
            System.out.print(e.toString());
            assertTrue(true);
        }
        int repoSizeBeforeAdd = noteRepository.count();
        noteRepository.addNota(nota);
        assertTrue(repoSizeBeforeAdd + 1 == noteRepository.count());
    }

}
