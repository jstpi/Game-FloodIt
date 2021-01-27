/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * Un <b>JButton</b> spécialisé afin de représenter une pastille du jeu. Affiche
 * l'une des six couleurs.
 * 
 * Les icônes sont sauvegardées dans le répertoire data. Il y a 3 tailles:
 * normale (N), moyenne (M), et petite (S).
 *
 * Les images sont: ball-0.png (grise), ball-1.png (orange), ball-2.png (bleu),
 * ball-3.png (verte) ball-4.png (violet) ball-5.png (rouge).
 *
 * <a href=
 * "http://developer.apple.com/library/safari/#samplecode/Puzzler/Introduction/Intro.html%23//apple_ref/doc/uid/DTS10004409"
 * >Based on Puzzler by Apple</a>.
 * 
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

import javax.swing.*;
import java.awt.*;

public class DotButton extends JButton {
    private int row;
    private int column;
    private int color;
    private int iconSize;
    private final int SMALL_SIZE = 0;
    private final int NORMAL_SIZE = 1;
    private final int MEDIUM_SIZE = 2;

    /**
     * Inialise cet objet.
     * 
     * @param row
     *            rangée.
     * @param column
     *            colonne.
     * @param color
     *            couleur.
     * @param iconSize
     *            taille de l'icône : SMALL_SIZE, NORMAL_SIZE ou MEDIUM_SIZE.
     */

    //Constructeur des images de la board. 
    public DotButton(int row, int column, int color, int iconSize) {
      this.row = row;
      this.column = column;
      this.color = color;
      this.iconSize = iconSize;
        
      setBackground(Color.WHITE);   
      setIcon(getImage());
      setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
      setBorderPainted(false);   
    }

    /**
     * Un second constructeur. Dans ce cas-ci, vous devez utiliser les valeur -1
     * et -1 comme rangée et colonne.
     * 
     * @param color
     *            couleur
     * @param iconSize
     *            taille de l'icône : SMALL_SIZE, MEDIUM_SIZE ou MEDIUM_SIZE
     */
    
    //Constructeur des choix de couleurs.
    public DotButton(int color, int iconSize) {
        this.color = color;
        this.iconSize = iconSize;
        row = -1;
        column = -1;
        
        setBackground(Color.WHITE);   
        setIcon(getImage());
    }

    /**
     * Change la valeur de l'attribut color et met à jour l'image.
     * 
     * @param color
     *            la nouvelle couleur
     */

    public void setColor(int color) {
        this.color = color; //Pour l'update de l'image, voir setImage(). 
    }

    /**
     * Retourne la valeur de l'attribut color.
     *
     * @return color
     */
    
    public int getColor() {
        return color;
    }

    /**
     * Retourne la valeur de l'attribut row.
     * 
     * @return la valeur de l'attribut row.
     */

    public int getRow() {
        return row;
    }

    /**
     * Retourne la valeur de l'attribut column.
     * 
     * @return la valeur de l'attribut column.
     */

    public int getColumn() {
        return column;
    }

    //Acces aux image dans le fichier data. 
    public ImageIcon getImage() {
     ImageIcon image;
     if (iconSize == SMALL_SIZE){
      image = new ImageIcon(DotButton.class.getResource("/data/S/ball-"+ Integer.toString(getColor()) + ".png" ));
     } else if (iconSize == MEDIUM_SIZE) {
       image = new ImageIcon(DotButton.class.getResource("/data/M/ball-"+ Integer.toString(getColor()) + ".png" ));
     } else {
       image = new ImageIcon(DotButton.class.getResource("/data/N/ball-"+ Integer.toString(getColor()) + ".png" ));
     }
     return image;
    }   
}