package note.test;

import note.model.Elev;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by crys_ on 17.04.2018.
 */
public class MediiTest {

    private HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();

    private ClasaRepositoryMock clasaRepositoryMock = new ClasaRepositoryMock(clasa);


    @Test
    public void NoInputGiven() {
        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 0);
    }

    @Test
    public void InputGiver(){
        List<Double> ClasaList = new ArrayList<Double>();
        ClasaList.add(4.2);
        ClasaList.add(5.3);
        HashMap<String, List<Double>> Hashuri = new HashMap<String, List<Double>>();

        Hashuri.put("String1", ClasaList);
        Hashuri.put("String2", ClasaList);

        HashMap<Elev, HashMap<String,List<Double>>> Hashuri2 = new HashMap<Elev, HashMap<String, List<Double>>>();

        Hashuri2.put(new Elev(12,"Marc"), Hashuri);
        Hashuri2.put(new Elev(13,"Marc2"), Hashuri);

        clasa = Hashuri2;

        clasaRepositoryMock = new ClasaRepositoryMock(clasa);

        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 2);
    }

    @Test
    public void noNoteForInput(){
        List<Double> ClasaList = new ArrayList<Double>();
        ClasaList.add(4.2);
        ClasaList.add(5.3);
        HashMap<String, List<Double>> Hashuri = new HashMap<String, List<Double>>();

        Hashuri.put("String1", ClasaList);
        Hashuri.put("String2", ClasaList);

        HashMap<Elev, HashMap<String,List<Double>>> Hashuri2 = new HashMap<Elev, HashMap<String, List<Double>>>();

        Hashuri2.put(new Elev(12,"Marc"), Hashuri);
        Hashuri2.put(new Elev(13,"Marc2"), Hashuri);

        clasa = Hashuri2;

        clasaRepositoryMock = new ClasaRepositoryMock(clasa);

        assertTrue(clasaRepositoryMock.calculeazaMedii().size() == 2);
    }

}
