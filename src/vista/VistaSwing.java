package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import imagenes.Corazon;


public class VistaSwing extends JFrame{
	private static final long serialVersionUID = 1L;
	

	/**
     * @author Perez Martin
     * Github: https://github.com/MartinPerez23
     * 
     */
	
	ArrayList<Corazon> corazones = new ArrayList<>();
	
	private int numeroCorazones;
	
	//paleta de colores
	private final Color COLOR_PRINCIPAL = Color.decode("#00e676");
	private final Color COLOR_OSCURO = Color.decode("#00b248");
	private final Color COLOR_CLARO = Color.decode("#66ffa6");
	
	//constructor
	public VistaSwing(String titulo) {
        super(titulo);
	}

	public void iniciarVista() {
		//estos componentes irian en el constructor pero si los pongo ahi no se muestran los corazones
		initComponents(); //inicio los componentes
		setLocationRelativeTo(null); //centro la VistaSwing a la pantalla
		setVisible(true); //hago visible la VistaSwing
	}
	
	public void mostrarNumerosIngresados(ArrayList<Integer> numeros) {
		
		String texto = textoMostrarNumeros.getText();
			
			if(texto.isEmpty()) {
				texto = Integer.toString(numeros.get(0));		
			}else {
				texto = "";
				for (Integer numero : numeros) {
					texto = texto + " " + numero;
				}
			}				
		textoMostrarNumeros.setText(texto);
		
	}
	
	public void perderVida() {
		int c = 1;
		for (Corazon corazon : corazones) {
			if(corazon.getLleno() && c == 1) {
				corazon.perderCorazon();
				panelDerecho.repaint();
				c--;
			}
		}
	}
	
	public void reiniciarJuego() {
		this.textoMostrarNumeros.setText("");
		for (Corazon corazon : corazones) {
			corazon.recuperarCorazones();
			panelDerecho.repaint();
			this.botonAceptar.setVisible(true);
			this.textoIngresoNumero.setFocusable(true);
		}
	}
	
	public void gameOver() {
		this.botonAceptar.setVisible(false);
		this.textoIngresoNumero.setFocusable(false);
	}
	
	public boolean sinVidas() {
		int c = 1;
		for (Corazon corazon : corazones) {	
			if(!corazon.getLleno() && c == this.numeroCorazones) {
				return true;	
			}else {
				c++;
			}		
		}
		return false;
	}
	
	public void setIntentos(int intentos) {
		this.numeroCorazones = intentos;
	}
	
	public String getTextoIngresado(){
		return this.textoIngresoNumero.getText();
	}
	
	public void limpiarNumeroIngresado(){
		this.textoIngresoNumero.setText("");
	}
	
	public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
	
	public void clickEnBotonAceptar(ActionListener al) {
		this.botonAceptar.addActionListener(al);
		this.textoIngresoNumero.addActionListener(al);
	}
	
	public void clickEnBotonReiniciar(ActionListener al) {
		this.botonReiniciar.addActionListener(al);
	}
	
	public void tipeoTeclado(KeyListener kl) {
		this.textoIngresoNumero.addKeyListener(kl);
	}
	
	private void crearCorazones() {
		 for	(int i=0;i < this.numeroCorazones; i++) {
	        	corazones.add(new Corazon());	
		 }
	}
	
	private void agregarCorazonesAPanel(JPanel panel) {
		 for (Corazon imagenCorazon : corazones) {
			 panel.add(imagenCorazon);
		 }	 
	}
	
	private void initComponents() {
		
		//para cerrar programa con la ventana
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600,500);
        
        
        //modificacion de variables
        //labels
        
        labelTitulo.setText("Adivina El Número");
        labelTitulo.setFont(new Font("Roboto",  Font.BOLD, 48)); 
        labelTitulo.setHorizontalAlignment(JTextField.CENTER);
        
        labelIntroduceNumero.setText("Ingrese un Número");
        labelIntroduceNumero.setFont(new Font("Roboto",Font.BOLD,28));
        labelIntroduceNumero.setVerticalAlignment(JTextField.BOTTOM);
        labelIntroduceNumero.setHorizontalAlignment(JTextField.CENTER);
                
        labelNumerosIngresados.setText("Numeros Ingresados");
        labelNumerosIngresados.setFont(new Font("Roboto",  Font.BOLD, 28)); 
        labelNumerosIngresados.setHorizontalAlignment(JTextField.CENTER);
        labelNumerosIngresados.setVerticalAlignment(JTextField.BOTTOM);
        
        //textfields
        
        textoIngresoNumero.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD, 28));
        textoIngresoNumero.setColumns(10);
        textoIngresoNumero.setForeground(Color.GREEN);
        textoIngresoNumero.setHorizontalAlignment(JTextField.CENTER);
        textoIngresoNumero.setBackground(Color.BLACK);
        textoIngresoNumero.setBorder(null);
        
        textoMostrarNumeros.setFont(new Font("Roboto",  Font.BOLD, 28));
        textoMostrarNumeros.setEnabled(false);
        textoMostrarNumeros.setHorizontalAlignment(JTextField.CENTER);
        textoMostrarNumeros.setBackground(Color.BLACK);
        textoMostrarNumeros.setBorder(null);
        
        textoIntentos.setText("Vidas:");
        textoIntentos.setForeground(Color.black);
        textoIntentos.setColumns(5);
        textoIntentos.setEditable(false);
        textoIntentos.setBackground(this.COLOR_OSCURO);
        textoIntentos.setHorizontalAlignment(JTextField.CENTER);
        textoIntentos.setFont(new Font("DIALOG",  Font.BOLD, 20));
        textoIntentos.setBorder(null);
        
        //buttons
        
        botonAceptar.setText("Aceptar");
        botonAceptar.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        botonAceptar.setBackground(Color.GREEN);
        
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        botonReiniciar.setForeground(Color.WHITE);
        botonReiniciar.setBackground(Color.DARK_GRAY);
        
        //panel superior
        
        panelSuperior.setBackground((this.COLOR_PRINCIPAL));
        panelSuperior.add(labelTitulo);
        
        //panel central
        
        panelCentral.setBackground(this.COLOR_CLARO);
        panelCentral.setLayout(layoutCentral);
        panelCentral.add(labelIntroduceNumero);
        panelCentral.add(textoIngresoNumero);
        panelCentral.add(labelNumerosIngresados);
        panelCentral.add(textoMostrarNumeros);
        
        
        // 	Panel inferior
        
        panelInferior.setBackground(this.COLOR_PRINCIPAL);
        
        panelInferior.add(botonAceptar);
        panelInferior.add(botonReiniciar);

        //panel derecho
               
        panelDerecho.setLayout(layoutDerecho);
        panelDerecho.setBackground(this.COLOR_OSCURO);
        panelDerecho.add(textoIntentos);

        this.crearCorazones();
        this.agregarCorazonesAPanel(panelDerecho);
        panelDerecho.repaint();
        
        //ordeno en la vista los paneles
        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);
        this.add(panelDerecho, BorderLayout.EAST);
        
        

	}

	//declarar variables

	JPanel panelSuperior = new JPanel();
	JPanel panelInferior = new JPanel();
	JPanel panelCentral = new JPanel();
	JPanel panelDerecho = new JPanel();
	
	GridLayout layoutCentral = new GridLayout(4,1);
	GridLayout layoutDerecho = new GridLayout(0,1);

	JButton	botonAceptar = new JButton();
	JButton	botonReiniciar = new JButton();
	
	JTextField	textoIngresoNumero = new JTextField();	
	JTextField textoMostrarNumeros = new JTextField();
	JTextField textoIntentos = new JTextField();
	
	JLabel labelTitulo = new JLabel();
	JLabel labelNumerosIngresados = new JLabel();
	JLabel labelIntroduceNumero = new JLabel();
	

}
