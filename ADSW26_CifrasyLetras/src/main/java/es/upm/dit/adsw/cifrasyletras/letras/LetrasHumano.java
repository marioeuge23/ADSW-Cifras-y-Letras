package es.upm.dit.adsw.cifrasyletras.letras;

import java.util.Scanner;

public class LetrasHumano implements Letras {

    private Scanner sc;

    public LetrasHumano(Scanner sc) {
        this.sc = sc;
    }

    // Código a implementar
    public String obtenerPalabra(String letras) {
    	String palabra= sc.nextLine();
    	palabra.trim();
		return palabra;
    }
}