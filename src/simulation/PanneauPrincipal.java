package simulation;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import simulation.matiere.Metal;
import simulation.usine.UsineAile;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 32;

	//Importer images de la demonstration : 
	ImageIcon e0 = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));//orange
	ImageIcon ua0 = new ImageIcon(this.getClass().getResource("/ressources/UA0%.png"));//red
	ImageIcon um0 = new ImageIcon(this.getClass().getResource("/ressources/UM0%.png"));//vert
	ImageIcon ump0 = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));//bleu
	ImageIcon ut0 = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));//violet


	//Usine Aile :
	UsineAile usineAile = new UsineAile(new Point (320,32));


	//Metal
	Metal metal = new Metal (new Point (32,32));
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// On ajoute � la position le delta x et y de la vitesse
		this.position.translate(this.vitesse.x, this.vitesse.y);
		g.fillRect(this.position.x, this.position.y, this.taille, this.taille);

				//Display lines
				g.drawLine(47, 47, 335 ,47);
				g.drawLine(175, 207, 335 ,47);
				g.drawLine(175, 207, 655 ,207);
				g.drawLine(175, 207, 335 ,367);
				g.drawLine(111, 367, 335 ,367);
				g.drawLine(335, 367, 559 ,591);
		
				//Display images 
				this.e0.paintIcon(this, g, 640, 192);
				this.ump0.paintIcon(this, g, 32, 32);
				this.ump0.paintIcon(this, g, 96, 352);
				this.ump0.paintIcon(this, g, 544, 576);
				this.ua0.paintIcon(this, g, 160, 192);
				this.um0.paintIcon(this, g, 320, 352);



			this.usineAile.getImage().paintIcon(this, g, 320, 32);
			this.usineAile.updateImage();


			
			//Display metal
			this.metal.getMetal().paintIcon(this, g, this.metal.getPosition().x, this.metal.getPosition().y);

			//Move metal
			if (this.metal.getPosition().x <320){
				this.metal.getPosition().translate(1, 0);
			}
			else 
				{
					this.metal.setPosition(new Point (32,32));
				}
			
	}





}