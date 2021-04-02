package it.polito.tdp.anagram.model;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

	public List<String> anagrammi(String parola) {
		
		List<String> risultato=new ArrayList<String>();
		permuta("", parola, 0,risultato) ; // LANCIA la ricorsione
		//*1 POSSIBILITA*: cancella dalla lista le parole non valide (leggendo il dizionario) --> METTO IN UN SET, elimina i duplicati
		return risultato ;
		
	}
	
	// livello = lunghezza della soluzione parziale
	// livello iniziale = 0
	// parziale = stringa che contiene l'anagramma incompleto in fase di costruzione
	// lettere = le lettere della parola iniziale che ancora non abbiamo utilizzato
	//           (=== il sotto-problema che dobbiamo risolvere)
	
	private void permuta(String parziale, String lettere, int livello,List<String> risultato) {
		if( lettere.length()==0 ) { // caso terminale 
			// la soluzione parziale è anche una soluzione completa!!
			//System.out.println(parziale) ;
			//*2 POSSIBILITA*: if(parziale e' una parola valida?) -> evito di aggiungere qualcosa che poi devo cancellare -> devo pero' dare accesso al dizionario alla funzione recursiva: complicato
				//creazione della lista esterna alla funzione perche' vogliamo un'unica lista che contenga tutte le permutazioni!(qui facciamo solo .add)
			risultato.add(parziale); //quando arrivo al caso terminale, aggiungo al risultato
		} else {
			// fai ricorsione
			// sottoproblema == una lettera (un singolo carattere) di 'lettere'
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
					// togli il carattere pos da lettere
				//*3 POSSIBILITA*: if (nuova parziale e' un PREFISSO valido di almeno una parola nel dizionario)
				//"aqz" -> no ; "car" -> si (carro, carrello,...)
				permuta(nuovaParziale, nuovaLettere, livello+1,risultato) ;
				
				// Backtracking (NON SERVE)
				// rimetti a posto 'parziale'
				// rimetti a posto 'lettere'
				
			}
		}
	}
	
}
