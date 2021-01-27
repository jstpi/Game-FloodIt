/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * Une classe auxilliaire (<em>helper</em>) pour le modèle afin de sauvegarder
 * la couleur d'une pastille et sont état (conquise ou pas), ainsi que sa
 * position sur la grille (x,y).
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {
    private int x;
    private int y;
    private boolean dotTaken; 
    private int dotColor;

    /**
     * Le constructeur initialise les variables d'instances.
     * 
     * @param x
     *            la coordonnée en x.
     * @param y
     *            la coordonnée en y.
     * @param color
     *            la couleur initiale.
     */
    
    public DotInfo(int x, int y, int color) {
        this.x = x;
        this.y = y;
        dotColor = color; 
        dotTaken = false;
    }

    /**
     * Une méthode d'accès pour l'attribut x.
     * 
     * @return la valeur de l'attribut x.
     */
    
    public int getX() {
        return x;
    }

    /**
     * Une méthode d'accès pour l'attribut y.
     * 
     * @return la valeur de l'attribut y.
     */
    
    public int getY() {
        return y;
    }

    /**
     * Méthode d'accès en écriture (setter) pour l'attribut captured.
     * 
     * @param captured
     *            la nouvelle valeur pour l'attribut captured
     */
    
    public void setCaptured(boolean captured) {
        dotTaken = true;
    }

    /**
     * Méthode d'accès en lecture pour l'attribut captured.
     *
     * @return captured la valeur de l'attribut.
     */
    
    public boolean isCaptured() {
        return dotTaken;
    }

    /**
     * Méthode d'accès en lecture pour l'attribut color.
     *
     * @return color la valeur de l'attribut.
     */
    
    public int getColor() {
        return dotColor;
    }
}