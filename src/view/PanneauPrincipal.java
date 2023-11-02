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
import composants.Avion;
// import composants.Aile;
// import composants.Avion;
import composants.Composant;
import composants.Metal;
//import composants.Moteur;
import composants.Moteur;
import modele.usine.Entrepot;
import modele.usine.UsineAile;
import modele.usine.UsineAile1;
import modele.usine.UsineAssemblage;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere1;
import modele.usine.UsineMatiere2;
import modele.usine.UsineMatiere3;
import modele.usine.UsineMoteur;

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
	UsineMatiere1 usineMatiere1 = UsineMatiere1.getInstance();
	UsineMatiere2 usineMatiere2 = UsineMatiere2.getInstance(); 
	UsineMatiere3 usineMatiere3 = UsineMatiere3.getInstance();
	UsineAile1 usineAile = UsineAile1.getInstance();
	UsineAssemblage usineAssemblage = UsineAssemblage.getInstance();
	UsineMoteur usineMoteur = UsineMoteur.getInstance();
	Entrepot entrepot = Entrepot.getInstance();

	// Importer images de la demonstration :
	ImageIcon e0 = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));// orange
	

	public PanneauPrincipal() {

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (xml == false) {
			g.drawLine(47, 47, 335, 47);
			g.drawLine(175, 207, 335, 47);
			g.drawLine(175, 207, 655, 207);
			g.drawLine(175, 207, 335, 367);
			g.drawLine(111, 367, 335, 367);
			g.drawLine(335, 367, 559, 591);

			this.usineMatiere1.getImage().paintIcon(this, g, 32, 32);
			this.usineMatiere2.getImage().paintIcon(this, g, 96, 352);
			this.usineMatiere2.getImage().paintIcon(this, g, 544, 576);

			this.usineAile.getImage().paintIcon(this, g, 320, 32);
			this.usineAssemblage.getImage().paintIcon(this, g, 160, 192);
			this.usineMoteur.getImage().paintIcon(this, g, 320, 352);
			this.entrepot.getImage().paintIcon(this, g, 640, 192);
		

	

			// Display and move metals :
			for (int i = 0; i < (this.usineMatiere1.getMetals().size()); i++) {
				Metal metal = this.usineMatiere1.getMetals().get(i);
				metal.getImage().paintIcon(this, g, metal.getPosition().x, metal.getPosition().y);
				if (metal.getPosition().x < 320) {
					metal.getPosition().translate(4, 0);
					metal.checkPosition(this.usineAile);
				} else {
					metal.setPosition(new Point(800, 800));
					this.usineMatiere1.getMetals().remove(metal);
				}
			}

			for (int i = 0; i < (this.usineAile.getAiles().size()); i++) {
				Aile aile = this.usineAile.getAiles().get(i);
				aile.getImage().paintIcon(this, g, aile.getPosition().x,
				aile.getPosition().y);
			if (aile.getPosition().x > 160 && aile.getPosition().y < 192 ){
				aile.getPosition().translate(-4, 4);
				aile.checkPosition(this.usineAssemblage);
			} else {
				aile.setPosition(new Point(800, 800));
				this.usineAile.getAiles().remove(aile);
			}
				
			}



				for (int i = 0; i < (this.usineMatiere2.getMetals().size()); i++) {
				Metal metal = this.usineMatiere2.getMetals().get(i);
				metal.getImage().paintIcon(this, g, metal.getPosition().x, metal.getPosition().y);
				if (metal.getPosition().x < 320) {
					metal.getPosition().translate(4, 0);
					metal.checkPosition(this.usineMoteur);
				} else {
					metal.setPosition(new Point(800, 800));
					this.usineMatiere2.getMetals().remove(metal);
				}
			}



				for (int i = 0; i < (this.usineMatiere3.getMetals().size()); i++) {
				Metal metal = this.usineMatiere3.getMetals().get(i);
				metal.getImage().paintIcon(this, g, metal.getPosition().x, metal.getPosition().y);
				if (metal.getPosition().x > 320) {
					metal.getPosition().translate(-4, -4);
					metal.checkPosition(this.usineMoteur);
				} else {
					metal.setPosition(new Point(800, 800));
					this.usineMatiere3.getMetals().remove(metal);
				}
			}


			for (int i = 0; i < (this.usineMoteur.getMoteurs().size()); i++) {
				Moteur moteur = this.usineMoteur.getMoteurs().get(i);
				moteur.getImage().paintIcon(this, g, moteur.getPosition().x,
				moteur.getPosition().y);
			if (moteur.getPosition().x > 160){
				moteur.getPosition().translate(-8, -8);
				moteur.checkPosition(this.usineAssemblage);
			} else {
				moteur.setPosition(new Point(800, 800));
				this.usineMoteur.getMoteurs().remove(moteur);
			}
				
			}



			for (int i = 0; i < (this.usineAssemblage.getAvions().size()); i++) {
				Avion avion = this.usineAssemblage.getAvions().get(i);
				avion.getImage().paintIcon(this, g, avion.getPosition().x,
				avion.getPosition().y);
			if (avion.getPosition().x <640){
				avion.getPosition().translate(4, 0);
			} else {
				avion.setPosition(new Point(800, 800));
				this.usineAssemblage.getAvions().remove(avion);
			}
				
			}





		}

	}

}