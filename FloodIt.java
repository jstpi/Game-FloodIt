/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * La classe <b>FloodIt</b> lance l'application.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class FloodIt {

    /**
     * Méthode principale. Cette méthode crée une instance de la classe
     * <b>GameController</b> et ainsi lance l'exécution de l'application.
     * L'usager peut donner la taille du jeu sur la ligne de commande. La taille
     * minimale valide est 10. S'il n'y a aucune valeur sur la ligne de commande
     * ou si la valeur est inférieure à 10, utilsez la valeur 12 comme taille.
     * 
     * @param args
     *            référence vers un tableau de chaînes de cartères (les éléments
     *            passé sur la ligne de commande)
     */
    public static void main(String[] args) {
      StudentInfo student = new StudentInfo();
      
      int size;
      GameController controller;
      
      if (args.length == 0){
        size = 12; //Size par defaut.
      } else {
        size = Integer.parseInt(args[0]);
      }
      
      if (size < 10 || size > 50){ //Nous avons choisi de limiter la grandeur de notre board. 
                                   //Notre choix de Layout rendait l'affichage de grande baord, plutot difficile. 
        controller = new GameController(12);//Size par defaut. 
      } else {
        controller = new GameController(size);
      }
    }
}
