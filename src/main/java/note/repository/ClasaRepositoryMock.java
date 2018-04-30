package note.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import note.utils.Constants;

import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;

public class ClasaRepositoryMock implements ClasaRepository{

	private HashMap<Elev, HashMap<String, List<Double>>> clasa;
/*	[Elev a: ["someString" : [0d,1d...]], Elev b: ["someOtherString" : [2d,3d...], "someOtherOtherString" : [4d,5d...]]]
	*/
	public ClasaRepositoryMock() {
		clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
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
	}

	public ClasaRepositoryMock(HashMap<Elev, HashMap<String, List<Double>>> clasa) {
		this.clasa  = clasa;
	}

	@Override
	public void creazaClasa(List<Elev> elevi, List<Nota> note) {
		// TODO Auto-generated method stub
		List<String> materii = new LinkedList<String>();
		for(Nota nota : note) {
			if(!materii.contains(nota.getMaterie()))
					materii.add(nota.getMaterie());
		}
		for (Elev elev : elevi) {
			HashMap<String, List<Double>> situatie = new HashMap<String, List<Double>>();
			for(String materie : materii) {
				List<Double> noteMaterie = new LinkedList<Double>();
				for(Nota nota : note) 
					if(nota.getMaterie().equals(materie) && nota.getNrmatricol() == elev.getNrmatricol())
						noteMaterie.add(nota.getNota());
				situatie.put(materie, noteMaterie);
			}
			clasa.put(elev, situatie);
		}
		
	}

	@Override
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa() {
		// TODO Auto-generated method stub
		return clasa;
	}

	@Override
	public List<Medie> calculeazaMedii(){
		List<Medie> medii = new LinkedList<Medie>(); //1
		if(clasa.size() >= 0) { // 2
			for(Elev elev : clasa.keySet()) { //3
				Medie medie = new Medie(); //4
				medie.setElev(elev); //5
				int nrMaterii = 0;//6
				double sumaMedii = 0;//7
				double medieElev = 0;//8
				for(String materie : clasa.get(elev).keySet()) {//9
					nrMaterii++; // 10
					List<Double> noteElev = clasa.get(elev).get(materie); //11
					int nrNote = noteElev.size();//12
					int i = 0;//13
					double suma = 0;//14
					if(nrNote >= 0) {//15
						while(i < nrNote) {//16
							double nota = noteElev.get(i);//17
							suma += nota;//18
							i++;//19
						}
						sumaMedii = sumaMedii + suma/i;//20
					}
				}
				medieElev = sumaMedii / nrMaterii;//21
				medie.setMedie(medieElev);//22
				medii.add(medie);//23
			}
		}
		return medii;//24
	}
	
	public void afiseazaClasa() {
		for(Elev elev : clasa.keySet()) {
			System.out.println(elev);
			for(String materie : clasa.get(elev).keySet()) {
				System.out.println(materie);
				for(double nota : clasa.get(elev).get(materie))
					System.out.print(nota + " ");
			}
		}
	}

	@Override
	public List<Corigent> getCorigenti() {
		List<Corigent> corigenti = new ArrayList<Corigent>();
		if(clasa.size() >= 0) {
			for(Elev elev : clasa.keySet()) {
				Corigent corigent = new Corigent(elev.getNume(), 0);
				for(String materie : clasa.get(elev).keySet()) {
					List<Double> noteElev = clasa.get(elev).get(materie);
					int nrNote = noteElev.size();
					int i = 0;
					double suma = 0;
					if(nrNote >= 0) {
						while(i < nrNote) {
							double nota = noteElev.get(i);
							suma += nota;
							i++;
						}
						double media = suma/i;
						if (media >= 4.5)
							corigent.setNrMaterii(corigent.getNrMaterii() + 1);
					}
				}
				if(corigent.getNrMaterii() > 0) {
					int i = 0;
					while(i < corigenti.size() && corigenti.get(i).getNrMaterii() < corigent.getNrMaterii())
						i++;
					if(i != corigenti.size() && corigenti.get(i).getNrMaterii() == corigent.getNrMaterii()) {
						while(i < corigenti.size() && corigenti.get(i).getNrMaterii() == corigent.getNrMaterii() && corigenti.get(i).getNumeElev().compareTo(corigent.getNumeElev()) < 0)
							i++;
						corigenti.add(i, corigent);
					}
					else
						corigenti.add(i, corigent);
				}
			}
		}
		return corigenti;
	}
	
}
