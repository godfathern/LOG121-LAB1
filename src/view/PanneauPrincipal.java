package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import composants.Aile;
import composants.Avion;
import composants.Composant;
import composants.Metal;
import composants.Moteur;
import modele.usine.Usine;
import modele.usine.UsineAile;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	//DocumentUsine document = new DocumentUsine();
	public static boolean xml = false;


	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 32;



	//Import usine info : 
	//Usine usine11 = this.document.getUsineByIdAndIconType("11", "vide");
	


	//Import usine image
	//ImageIcon i11 = new ImageIcon(this.usine11.getPath());
    //Usine aile : 
		UsineAile usineAile = new UsineAile("wuwu", "wuwu", "32", "32");

	//Importer images de la demonstration : 
	ImageIcon e0 = new ImageIcon(this.getClass().getResource("/ressources/E0%.png"));//orange
	ImageIcon ua0 = new ImageIcon(this.getClass().getResource("/ressources/UA0%.png"));//red
	ImageIcon um0 = new ImageIcon(this.getClass().getResource("/ressources/UM0%.png"));//vert
	ImageIcon ump0 = new ImageIcon(this.getClass().getResource("/ressources/UMP0%.png"));//bleu
	ImageIcon ut0 = new ImageIcon(this.getClass().getResource("/ressources/UT0%.png"));//violet

	//Metal
	Composant metal = new Metal (new Point (100,32), "/ressources/metal.png" );
	Composant avion = new Avion (new Point (300,192), "/ressources/avion.png");
	Composant aile = new Aile (new Point (258,90), "/ressources/aile.png");
	Composant moteur = new Moteur (new Point (268,300), "/ressources/moteur.png");
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// On ajoute � la position le delta x et y de la vitesse
		//this.position.translate(this.vitesse.x, this.vitesse.y);
		//g.fillRect(this.position.x, this.position.y, this.taille, this.taille);

			
				if(xml == false) {
					g.drawLine(47, 47, 335 ,47);
					g.drawLine(175, 207, 335 ,47);
					g.drawLine(175, 207, 655 ,207);
					g.drawLine(175, 207, 335 ,367);
					g.drawLine(111, 367, 335 ,367);
					g.drawLine(335, 367, 559 ,591);

					//this.ut0.paintIcon(this, g, this.document.getCoordinatesForUsineID("21").x, this.document.getCoordinatesForUsineID("21").y);
					//this.ut0.paintIcon(this, g, 320, 32);

					this.usineAile.getImage().paintIcon(this, g, 320, 32);
					this.usineAile.updateImage();


					this.e0.paintIcon(this, g, 640, 192);
					this.ump0.paintIcon(this, g, 32, 32);
					this.ump0.paintIcon(this, g, 96, 352);
					this.ump0.paintIcon(this, g, 544, 576);
					this.ua0.paintIcon(this, g, 160, 192);
					this.um0.paintIcon(this, g, 320, 352);

			//Display composants
			this.metal.getComposant().paintIcon(this, g, this.metal.getPosition().x, this.metal.getPosition().y);
			this.avion.getComposant().paintIcon(this, g, this.avion.getPosition().x, this.avion.getPosition().y);
			this.aile.getComposant().paintIcon(this, g, this.aile.getPosition().x, this.aile.getPosition().y);
			this.moteur.getComposant().paintIcon(this, g, this.moteur.getPosition().x, this.moteur.getPosition().y);

			//Move metal
			 if (this.metal.getPosition().x <320){
			 	this.metal.getPosition().translate(1, 0);
			 }
			else 
			{
					this.metal.setPosition(new Point (32,32));
				}
				}
		
				
				//Usine usine11 = this.document.getUsineByIdAndIconType("11", "vide");
				//System.out.println("usine11" + this.usine11);
				//this.i11.paintIcon(this,g,this.usine11.getX(),this.usine11.getY());
				

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// public DocumentUsine getDocument() {
	// 	return this.document;
	// }

	// public void setDocument(DocumentUsine document) {
	// 	this.document = document;
	// }

	public Point getPosition() {
		return this.position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getVitesse() {
		return this.vitesse;
	}

	public void setVitesse(Point vitesse) {
		this.vitesse = vitesse;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ImageIcon getE0() {
		return this.e0;
	}

	public void setE0(ImageIcon e0) {
		this.e0 = e0;
	}

	public ImageIcon getUa0() {
		return this.ua0;
	}

	public void setUa0(ImageIcon ua0) {
		this.ua0 = ua0;
	}

	public ImageIcon getUm0() {
		return this.um0;
	}

	public void setUm0(ImageIcon um0) {
		this.um0 = um0;
	}

	public ImageIcon getUmp0() {
		return this.ump0;
	}

	public void setUmp0(ImageIcon ump0) {
		this.ump0 = ump0;
	}

	public ImageIcon getUt0() {
		return this.ut0;
	}

	public void setUt0(ImageIcon ut0) {
		this.ut0 = ut0;
	}









}