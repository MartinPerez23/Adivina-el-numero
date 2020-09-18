package modelo;

import java.util.ArrayList;
import java.util.Random;

public class AdivinaNumero {
	
	public final int INTENTOS = 7;
	public final int NUMERO_MAX = 100;
	public final int NUMERO_MIN = 0;
	private int numero;
	private ArrayList<Integer> numerosIngresados; 
	
	public AdivinaNumero(){
		this.numerosIngresados = new ArrayList<>();
	}
	public Integer getIntentos() {
		return this.INTENTOS;		
	}
	
	public Integer getNumero() {
		return this.numero;
	}
	
	public boolean checkearNumero(int numero) {
		return numerosIngresados.contains(numero);		
	}
	
	public ArrayList<Integer> getNumerosIngresados(){
		return this.numerosIngresados;
	}
	
	public void agregarNumeroIngresado(int numero){
		this.numerosIngresados.add(numero);
	}
	public void limpiarNumerosIngresados() {
		this.numerosIngresados.clear();
	}
	
	public void generarNumeroAleatorio() {
		
		Random rnd = new Random();
		this.numero = this.NUMERO_MIN + rnd.nextInt((this.NUMERO_MAX + 1) - this.NUMERO_MIN);
		
	}
}
