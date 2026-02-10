package es.upm.dit.adsw.cifrasyletras.cifras;

import java.util.List;
import java.util.Scanner;

public class CifrasHumano implements Cifras {

    private Scanner sc;

    public CifrasHumano(Scanner sc) {
        this.sc = sc;
    }

    // Código a implementar
    public String obtenerCifra(int objetivo, List<Integer> numeros) {
    	String cifra= sc.nextLine();
		cifra.trim();
		return cifra;
		
    }
}