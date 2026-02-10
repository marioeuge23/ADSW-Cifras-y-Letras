package es.upm.dit.adsw.cifrasyletras.juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class ValidadorLetras {

   private Set<String> diccionarioDePalabrasValidas;
    
   // Este método lee el fichero de la ruta que se pasa como parámetro y carga el conjunto de palabras válidas en 
   //  diccionarioDePalabrasValidas
   public ValidadorLetras(String rutaDiccionario) {
      diccionarioDePalabrasValidas = new HashSet<>();
      try{
         BufferedReader br = new BufferedReader(new FileReader(rutaDiccionario));
         String linea;
         while ( (linea = br.readLine()) != null ) {
            diccionarioDePalabrasValidas.add(limpiarPalabra(linea));
         }
         br.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

    public boolean esValida(String palabra, String letras) {
        // A implementar
    	List<Character> letrasDisp = new ArrayList<>();
    	for (char c : letras.toCharArray()) {
			letrasDisp.add(c);
		}
    	String palabraLimpia = limpiarPalabra(palabra);
    	
    	for (char c : palabra.toCharArray()) {
    		if (!letrasDisp.remove((Character) c) == false) {
				return false;
			}
    	}
    	
    	if(!diccionarioDePalabrasValidas.contains(palabraLimpia)) {
			return false;
		}else
			return true;
    	
    }

    // Se usa para normalizar palabras.
    public String limpiarPalabra(String palabra) {
       String palabraLimpia = palabra;
       palabraLimpia = palabraLimpia.toLowerCase();
       palabraLimpia = palabraLimpia.trim();
       palabraLimpia = palabraLimpia.replaceAll("á", "a");
       palabraLimpia = palabraLimpia.replaceAll("é", "e");
       palabraLimpia = palabraLimpia.replaceAll("í", "i");
       palabraLimpia = palabraLimpia.replaceAll("ó", "o");
       palabraLimpia = palabraLimpia.replaceAll("ú", "u");
       palabraLimpia = palabraLimpia.replaceAll("ü", "u");
       return palabraLimpia;
    }
}
