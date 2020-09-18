package imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Corazon extends JPanel{

	private static final long serialVersionUID = 3L;
	
	ImageIcon img;
	private boolean lleno;
	
	public Corazon() {
		this.lleno = true;
		this.img = new ImageIcon(getClass().getResource("/recursos/ImagenCorazonLleno.png"));			
	}
	
	public void perderCorazon() {
		this.lleno = false;
		img = new ImageIcon(getClass().getResource("/recursos/ImagenCorazonVacio.png"));
	}
	
	public void recuperarCorazones() {
		this.lleno = true;
		img = new ImageIcon(getClass().getResource("/recursos/ImagenCorazonLleno.png"));
	}
	
	public boolean getLleno() {
		return lleno;
	}
	
	public void paint(Graphics grafico) {
		
		Dimension height = getSize();

		grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
		
		setOpaque(false);
		super.paintComponent(grafico);
		}
}

 

 

