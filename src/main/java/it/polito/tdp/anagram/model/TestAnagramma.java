package it.polito.tdp.anagram.model;

import java.util.List;

public class TestAnagramma {

	public static void main(String args[]) {
		Anagram a = new Anagram();
		List<String> anagrammi;
		anagrammi= a.anagrammi("dog") ;
		System.out.println(anagrammi);
		anagrammi= a.anagrammi("cinque") ;
		System.out.println(anagrammi);
	}
	
}
