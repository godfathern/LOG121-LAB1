package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import composants.Aile;
// import composants.Aile;
// import composants.Avion;
import composants.Composant;
import composants.Metal;
//import composants.Moteur;

import modele.usine.UsineAile;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere2;
import modele.usine.UsineMatiere3;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	// DocumentUsine document = new DocumentUsine();
	public static boolean xml = false;

	// Variables temporaires de la demonstration:
	private Point position = new Point(0, 0);
	private Point vitesse = new Point(1, 1);
	private int taille = 32;

	// Import usine info :
	// Usine usine11 = this.document.getUsineByIdAndIconType("11", "vide");

	// Import usine image
	// ImageIcon i11 = new ImageIcon(this.usine11.getPath());
	// Usine aile :
	UsineAile usineAile = new UsineAile("wuwu", "wuwu", "32", "32");
	UsineMatiere1 usineMatiere1 = UsineMatiere1.getInstance();

	// Importer images de la demonstration :
	ImageIcon e0 = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));// orange
	ImageIcon ua0 = new ImageIcon(this.getClass().getResource("/ressources/UA0%.png"));// red
	ImageIcon um0 = new ImageIcon(this.getClass().getResource("/ressources/UM0%.png"));// vert
	ImageIcon ump0 = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));// bleu
	ImageIcon ut0 = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));// violet

	// Metal
	// Composant avion = new Avion(new Point(300, 192), "/ressources/avion.png");
	// Composant aile = new Aile(new Point(258, 90), "/ressources/aile.png");
	// Composant moteur = new Moteur(new Point(268, 300), "/ressources/moteur.png");

	public PanneauPrincipal() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// On ajoute � la position le delta x et y de la vitesse
		// this.position.translate(this.vitesse.x, this.vitesse.y);
		// g.fillRect(this.position.x, this.position.y, this.taille, this.taille);

		if (xml == false) {
			g.drawLine(47, 47, 335, 47);
			g.drawLine(175, 207, 335, 47);
			g.drawLine(175, 207, 655, 207);
			g.drawLine(175, 207, 335, 367);
			g.drawLine(111, 367, 335, 367);
			g.drawLine(335, 367, 559, 591);

			this.usineMatiere1.getImage().paintIcon(this, g, 32, 32);
			this.usineMatiere1.updateImage();
			this.usineAile.getImage().paintIcon(this, g, 320, 32);
			this.usineAile.updateImage();

			UsineMatiere2.getInstance().getImage().paintIcon(this, g, 96, 352);
			UsineMatiere3.getInstance().getImage().paintIcon(this, g, 544, 576);

			this.e0.paintIcon(this, g, 640, 192);

			// this.ump0.paintIcon(this, g, 96, 352);
			// this.ump0.paintIcon(this, g, 544, 576);
			this.ua0.paintIcon(this, g, 160, 192);
			this.um0.paintIcon(this, g, 320, 352);

			// this.avion.getComposant().paintIcon(this, g, this.avion.getPosition().x,
			// this.avion.getPosition().y);
			// this.aile.getComposant().paintIcon(this, g, this.aile.getPosition().x,
			// this.aile.getPosition().y);
			// this.moteur.getComposant().paintIcon(this, g, this.moteur.getPosition().x,
			// this.moteur.getPosition().y);

			// Display and move metals :
			for (int i = 0; i < (this.usineMatiere1.getMetals().size()); i++) {

				Metal metal = this.usineMatiere1.getMetals().get(i);
				System.out.println(metal);
				
				metal.addObserver(this.usineAile);
				metal.getImage().paintIcon(this, g, metal.getPosition().x, metal.getPosition().y);
				if (metal.getPosition().x < 320) {
					metal.getPosition().translate(4, 0);
					metal.checkPosition(this.usineAile);
					System.out.println("pos met : " + metal.getPosition());
					System.out.println("Pos Aile : " + this.usineAile.getPosition());
				} else {
					metal.setPosition(new Point(500, 500));
				}
				
				
			}
			this.usineAile.produceAile();
			for (int i = 0; i < (this.usineAile.getAiles().size()); i++) {
				Aile aile = this.usineAile.getAiles().get(i);
				aile.getImage().paintIcon(this, g, aile.getPosition().x,
				aile.getPosition().y);
				aile.getPosition().translate(-1, 1);

			}

		}

	}

}