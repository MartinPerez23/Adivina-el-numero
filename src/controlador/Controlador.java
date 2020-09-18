package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.AdivinaNumero;
import vista.VistaSwing;

public class Controlador {

	
	private VistaSwing vista;
    private AdivinaNumero an;
	
    //constructor
	public Controlador(VistaSwing vista, AdivinaNumero an) {
        this.vista = vista;
        this.an = an;
    }
	//metodos
	public void iniciar() {
			
		this.an.generarNumeroAleatorio();
		this.vista.setIntentos(an.getIntentos());
		this.vista.clickEnBotonAceptar(new ClickEnBotonAceptar());
		this.vista.clickEnBotonReiniciar(new ClickEnBotonReiniciar());
		this.vista.tipeoTeclado(new TipeoTeclado());
	    this.vista.iniciarVista();
	}
	
	private void comprobacionDelJTextField(String texto) {
		try {
			if(Integer.parseInt(texto) > an.NUMERO_MAX) {
				vista.mostrarMensaje("Trata de poner un numero menor a "+ an.NUMERO_MAX);
				vista.limpiarNumeroIngresado();
			}
			if(Integer.parseInt(texto) < an.NUMERO_MIN) {
				vista.mostrarMensaje("Trata de poner un numero mayor a "+ an.NUMERO_MIN);
				vista.limpiarNumeroIngresado();
			}
			
        } catch (NumberFormatException excepcion) {
            if(!texto.isEmpty()) {
            	vista.mostrarMensajeError("Ingrese solo numeros positivos!");
            }
            vista.limpiarNumeroIngresado();
        }
		
	}
	
////////////////////////////////// LISTENERS //////////////////////////////////
	
	private class ClickEnBotonAceptar implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(!vista.getTextoIngresado().isEmpty()) {
				if(an.checkearNumero(Integer.parseInt(vista.getTextoIngresado()))) {
					vista.mostrarMensaje("Ya ingresaste ese numero!");
					vista.limpiarNumeroIngresado();
				}else if(an.getNumero() == Integer.parseInt(vista.getTextoIngresado())) {				
						vista.mostrarMensaje("ganaste!");
						vista.gameOver();
						vista.limpiarNumeroIngresado();
				}else{
						
						vista.perderVida();						
											
						an.agregarNumeroIngresado(Integer.parseInt(vista.getTextoIngresado()));						
						
						vista.mostrarNumerosIngresados(an.getNumerosIngresados());																
						
						if(vista.sinVidas()) {
							
							vista.mostrarMensaje("Perdiste!");
							vista.gameOver();
							
						}else if(an.getNumero() > Integer.parseInt(vista.getTextoIngresado())) {
							
							vista.mostrarMensaje("Apunta mas alto");						
							
						}else{
								vista.mostrarMensaje("Apunta mas bajo");
						}
						
						vista.limpiarNumeroIngresado();
						
					}				
			}	else {
						vista.mostrarMensaje("Ingrese un numero entre el " + an.NUMERO_MIN + " y el " + an.NUMERO_MAX);
					}
		}
	}
	
	private class TipeoTeclado implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
			comprobacionDelJTextField(vista.getTextoIngresado());
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
				
		}
		
	}
	
	private class ClickEnBotonReiniciar implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			vista.reiniciarJuego();
			an.generarNumeroAleatorio();
			an.limpiarNumerosIngresados();
		}
	}
}//fin controlador


