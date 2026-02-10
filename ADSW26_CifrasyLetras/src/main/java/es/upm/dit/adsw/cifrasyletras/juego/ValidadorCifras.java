package es.upm.dit.adsw.cifrasyletras.juego;

import java.util.ArrayList;
import java.util.List;

public class ValidadorCifras {

    // Método auxiliar para comprobar números usados
    public boolean numerosUsadosValidos(String expresion, List<Integer> numerosDisponibles) {
      List<Integer> numerosSinUsar = new ArrayList<>(numerosDisponibles);
      String[] tokens = expresion.split(" ");
      for(int i = 0; i < tokens.length; i+=2 ) {
        try {
          Integer n = Integer.parseInt(tokens[i]);
          if ( !numerosSinUsar.remove(n) ) {
            System.out.println("Número no disponible: " + n);
            return false;
          }
        } catch (NumberFormatException e) {
          System.out.println("Token no es un número: " + tokens[i]);
          return false;
        }
      }
      return true;
    }

    public boolean esValida(String expresion, List<Integer> numerosDisponibles) {
        String[] partes = expresion.split(" = ");
    
        int resultado =  0;
        try {
          resultado = Integer.parseInt(partes[0]);
        } catch (NumberFormatException e) {
          System.out.println("Resultado no es un número: " + partes[0]);
          return false;
        }
    
        if ( !numerosUsadosValidos(partes[1], numerosDisponibles) ) {
          return false;
        }
    
        String[] tokens = partes[1].split(" ");
        // A implementar: Calcular la expresión (tokens) e ir comprobando sus restricciones
        int resultadoCalculado = Integer.parseInt(tokens[0]);
        for (int i=1; i<tokens.length; i+=2) {
        	String op = tokens[i];
        	int nextNum= Integer.parseInt(tokens[i+1]);
        	switch (op) {
				case "+":
					resultadoCalculado += nextNum;
					break;
				case "-":
					resultadoCalculado -= nextNum;
					break;
				case "*":
					resultadoCalculado *= nextNum;
					break;
				case "/":
					if (nextNum == 0 || resultadoCalculado % nextNum != 0) {
						System.out.println("División no válida");
						return false;
					}else {
						resultadoCalculado /= nextNum;
					}
					break;
				default:
					System.out.println("Operador no válido, solo se permiten +, -, *, /");
					return false;
					
			}
        }
        
        return resultadoCalculado == resultado;
        
    }
}