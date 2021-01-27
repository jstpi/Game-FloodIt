/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * Un objet de la classe <b>GameModel</b> représente l'état du jeu. En
 * particulier, il faut sauvegarder les information suivantes:
 * <ul>
 * <li>L'état de chaque pastille de la grille de jeu (couleur, conquise ou
 * pas).</li>
 * <li>La taille du jeu.</li>
 * <li>Le nombre de tours.</li>
 * <li>La couleur courante.</li>
 * </ul>
 *
 * Le modèle fournit toutes les méthodes d'accès nécessaires pour que le
 * contrôleur et la vue puissent faire leur travail. *
 * 
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

import java.util.Random;

public class GameModel {

    /**
     * Valeurs prédéfinies qu'on utilise pour DotInfo.
     */
  
    public static final int COLOR_0 = 0;
    public static final int COLOR_1 = 1;
    public static final int COLOR_2 = 2;
    public static final int COLOR_3 = 3;
    public static final int COLOR_4 = 4;
    public static final int COLOR_5 = 5;
    public static final int NUMBER_OF_COLORS = 6;

    private int size;
    private int numTurns;
    private int currentColor; 
    private DotInfo[][] dots;
    private static Random generator;

    /**
     * Initialisation de l'objet.
     * 
     * @param size
     *            la taille du jeu.
     */
    
    public GameModel(int size) {
      
      this.size = size;
      generator = new Random();
      dots = new DotInfo[size][size];

      for (int i = 0; i < size; i++) {
        for (int j = 0; j <size; j++){
          int u = generator.nextInt(6);
          dots[i][j] = new DotInfo(i, j, u);
        }
      }
      dots[0][0].setCaptured(true);
      numTurns = 0;
      currentColor = 0;
    }

    /**
     * Remise à zéro du modèle.
     */
    
    public void reset() {
      dots = new DotInfo[size][size];
      
      for (int i = 0; i < size; i++) {
        for (int j = 0; j <size; j++){
          int u = generator.nextInt(6);
          dots[i][j] = new DotInfo(i, j, u);
          }
      }
      dots[0][0].setCaptured(true);
      numTurns = 0;
      currentColor = 0;
    }

    /**
     * Méthode d'accès pour l'attribut size.
     * 
     * @return la valeu de l'attribut size.
     */
    
    public int getSize() {
      return size;
    }

    /**
     * Retourne la couleur de la pastille à la position spécifiée.
     * 
     * @param i
     *            coordonnée en x.
     * @param j
     *            coordonnée en y.
     * @return la couleur de la pastille (i,j).
     */
    
    public int getColor(int i, int j) {     
      return dots[i][j].getColor();
    }

    /**
     * Retourne true si la pastille (i,j) est conquise et false sinon.
     * 
     * @param i
     *            coordonnée en x.
     * @param j
     *            coordonnée en y.
     * @return l'état de la pastille (i,j).
     */
    
    public boolean isCaptured(int i, int j) {
      return dots[i][j].isCaptured();
    }

    /**
     * Change l'état de la pastille (i,j).
     * 
     * @param i
     *            coordonnée en x.
     * @param j
     *            coordonnée en y.
     */
    
    public void capture(int i, int j) {
      dots[i][j].setCaptured(true);
    }

    /**
     * Retourne le nombre de tours depuis la dernière remise à zéro.
     * 
     * @return le nombre de tours.
     */
    
    public int getNumberOfSteps() {
      return numTurns;
    }

    /**
     * Change la couleur sélectionnée.
     * 
     * @param val
     *            la nouvelle couleur sélectionnée.
     */
    
    public void setCurrentSelectedColor(int val) {
      currentColor = val;
    }

    /**
     * Retourne la couleur sélectionnée.
     * 
     * @return a couleur sélectionnée.
     */
    
    public int getCurrentSelectedColor() {
      return currentColor; 
    }

    /**
     * Retourne la référence de l'objet DotInfo à la position (i,j) de la
     * grille.
     *
     * @param i
     *            coordonnée en x.
     * @param j
     *            coordonnée en y.
     *
     * @return la référence de l'objet DotInfo à la position (i,j) de la grille.
     */
    
    public DotInfo get(int i, int j) {
      return dots[i][j];
    }

    /**
     * Incrémente de un le nombre de tours.
     */
    
    public void step() {
      numTurns++;
    }

    /**
     * Cette méthode <b>isFinished</b> retourne true si et seulement si le jeu
     * est terminé, c'est à dire que toutes les pastilles font partie de
     * l'ensemble conquises.
     *
     * @return true si le jeu est terminé, false sinon.
     */
    
    public boolean isFinished() {
      boolean found = false;
      for (int i = 0; (i<size) && (found == false); i++) {
        for (int j = 0; (j<size) && (found==false); j++){
           if (isCaptured(i,j) == false) {
              found = true; 
             }
          } 
        }
      return !found;
    }

    /**
     * Une représentation sous forme de chaîne de cartères du modèle.
     *
     * @return une représentation sous forme de chaîne de cartères du modèle.
     */
    
    public String toString() {
      String str = "" ;
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
           str = str + get(i,j).getColor();
           }
        str = str + '\n';
      }
      return str;
    }  
}