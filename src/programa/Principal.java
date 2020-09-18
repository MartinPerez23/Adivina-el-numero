package programa;

import controlador.Controlador;
import modelo.AdivinaNumero;
import vista.VistaSwing;

public class Principal {

	public static void main(String[] args) {
		VistaSwing v = new VistaSwing("Adivina El Numero");
		AdivinaNumero an = new AdivinaNumero();
		Controlador c = new Controlador(v,an);

		c.iniciar();
	}

}
