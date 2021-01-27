/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * Un objet de la classe <b>GameController</b> sert de contrôleur pour cette
 * application. Sa méthode <b>selectColor</b> est appelée chaque fois que
 * l'usager sélectionne une nouvelle couleur. Il faut alors faire les
 * changements liés à l'opération «flood id» (inondation), mettre à jour le
 * modèle et informer la vue.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class GameController implements ActionListener {

    private GameModel model;
    private GameView view;
    private int size;
    private boolean allowsClicks = false;
    private GameView view2;

    /**
     * Initialisation du contrôleur. Il faut entre autres créer le modèle et la
     * vue.
     * 
     * @param size
     *            la taille du jeu.
     */

    public GameController(int size) {

      model = new GameModel(size);
      view = new GameView(model, this);
      view.update();
      setAllowsClicks(true);

    }

    /**
     * Remise à zéro du jeu.
     */
    
    public void reset() {
      
      model.reset();
      view.createBoard();
      view.update();
      view.setVisible(true);
    }

    /**
     * Fonction de rappel. Cette méthode est appellée lorsque l'usager
     * sélectionne une couleur, ou qu'il appuit sur les boutons Quit ou Reset.
     *
     * @param e
     *            la référence d'un objet de la classe ActionEvent.
     */

    public void actionPerformed(ActionEvent e) {
      
      if (e.getActionCommand().equals("Reset")){
        setAllowsClicks(false);
        reset(); //Reset de la vue et du jeu.
        setAllowsClicks(true);
      } else if (e.getActionCommand().equals("Play Again")){
        setAllowsClicks(false);
        reset(); //Reset de la vue et du jeu, apres la victoire. 
        setAllowsClicks(true);
      } else if (e.getActionCommand().equals("Quit")){
        System.exit(0); //Termine le programme. 
      } else if (e.getSource() instanceof DotButton) {
        DotButton src = (DotButton) e.getSource();//Lorsqu'un choix de couleur est fait.
        //S'assure que la couleur choisie est nouvelle.
        if ((allowsClicks()) && (src.getColor() != model.getCurrentSelectedColor())) { 
          setAllowsClicks(false);
          selectColor(src.getColor()); //Lance la methode floodIt.
          view.update();
        }
        setAllowsClicks(true);
      }
    }

    /**
     * Cette méthode est appelée chaque fois que l'usager sélectionne une
     * nouvelle couleur. Si la couleur est différente de la couleur déjà
     * sélectionnée, on applique la logique du jeu en capturant le plus grand
     * nombre possible de pastilles. La méthode vérifie ensuite si le jeu est
     * terminé, auquel cas, la méthode félicite le joueur, affiche le nombre de
     * tours, et lui offre deux options, redémarrer ou quitter.
     * 
     * @param color
     *            la couleur sélectionner par le joueur.
     */
    
    public void selectColor(int color) {
      
        model.setCurrentSelectedColor(color);
        model.step(); //Augmente le nombre de tours. 
        floodIt(model.getCurrentSelectedColor()); //Lance la methode floodIt. 
      
      if(model.isFinished()){ //Verifie si le jeu est fini, envoie le message.
        setAllowsClicks(false);
        view.update();
        
        Object[] options = { "Play Again", "Quit" };
        
        int winMessage = JOptionPane.showOptionDialog(view, "Congratulations, you won in "
        + Integer.toString(model.getNumberOfSteps()) + " steps! Would you like to play again?",
        "Won", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);   
       
        if (winMessage == 0) {
          setAllowsClicks(false);
          reset();
          setAllowsClicks(true);
        } else if (winMessage == 1) {
          System.exit(0);
        }     
      }
    }

    private boolean allowsClicks() { //Sert a ne pas faire d'actions pendant que le programme effectue des changements.
      return allowsClicks;
    }
    
    private void setAllowsClicks(boolean allowClicks) {
      this.allowsClicks = allowClicks;
    }
    
    //On creer une stack des pastille conquise et on verifie les pastilles adjacentes a chacune d'elles.
    private void floodIt(int color) {
      
      Stack<DotInfo> capturedDots = new ArrayStack<DotInfo>(model.getSize()*model.getSize()); 
      for (int i=0; i< model.getSize(); i++){
        for (int j=0; j< model.getSize(); j++){
          if (model.isCaptured(i,j) == true) {
            capturedDots.push(model.get(i,j));
            }
           } 
          }
      while (!capturedDots.isEmpty()) {
        DotInfo dot = capturedDots.pop();
        int j = (dot.getY() + 1);
        int i = (dot.getX() + 1);
        int y = (dot.getY() - 1);
        int x = (dot.getX() - 1);
        
        //Verifie les pastilles à droite.
        if ((j < model.getSize()) && (model.getColor(dot.getX(), j) == color) && !(model.isCaptured(dot.getX(),j))) {
          model.capture(dot.getX(),j);
          capturedDots.push(model.get(dot.getX(), j));
        } 
        
        //Verifie les pastilles en bas.
        if ((i < model.getSize()) && (model.getColor(i, dot.getY()) == color) && !(model.isCaptured(i, dot.getY()))) {
          model.capture(i,dot.getY());
          capturedDots.push(model.get(i, dot.getY()));
        }
        
        //Verifie les pastilles à gauche.
        if ((y >= 0 ) && (model.getColor(dot.getX(), y) == color) && !(model.isCaptured(dot.getX(),y))) {
          model.capture(dot.getX(),y);
          capturedDots.push(model.get(dot.getX(), y));
        }
        
        //Verifie les pastilles en haut.
        if ((x >= 0) && (model.getColor(x, dot.getY()) == color) && !(model.isCaptured(x, dot.getY()))) {
          model.capture(x,dot.getY());
          capturedDots.push(model.get(x, dot.getY()));
        }
      }   
    }
}