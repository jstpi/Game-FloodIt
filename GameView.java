/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * La classe <b>GameView</b> produit le rendu visuel de l'application. C'est une
 * sous-classe de la clases <b>JFrame</b>. Cette classe utilise une instance de
 * la classe <b>JPanel</b> pour afficher les pastilles du jeu, ainsi que deux
 * instances de la classe <b>JButton</b>. Le gestionnaire d'événement pour les
 * boutons est un objet de la classe <b>GameController</b>.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class GameView extends JFrame {

    private GameController gameController;
    private GameModel model;
    private JPanel board;
    private JPanel colorChoices;
    private JPanel tools;
    private JLabel input;
    private int iconSize;
    private JPanel message;
    private JPanel options;
    private DotButton[][] dots;

    /**
     * Le constructeur de la classe <b>GameView</b>. Construit le rendu visuel
     * de l'application.
     * 
     * @param model
     *            la référence du modèle du jeu (déjà initialisé)
     * @param gameController
     *            la référence du contrôleur
     */

    public GameView(GameModel model, GameController gameController) {
      
      setTitle("Flood it");
      if (((model.getSize() <= 20) && (model.getSize() >= 15)) || (model.getSize() >= 35)) {
      setSize(700,750);
      } else {
      setSize(400,600);
      }
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBackground(Color.WHITE);
      this.model = model;
      this.gameController = gameController;
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      
      board = new JPanel();
      board.setBackground(Color.WHITE);
      board.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      GridLayout tableau = new GridLayout(model.getSize(), model.getSize());
      board.setLayout(tableau);
      createBoard();
      
      c.fill = GridBagConstraints.BOTH;
      c.weighty = 1.0;
      c.weightx = 1.0;
      c.gridwidth = 3;
      c.ipady = 35;
      c.insets = new Insets(20,20,20,20);
      add(board, c);
      
      colorChoices = new JPanel();
      colorChoices.setBackground(Color.WHITE);
      colorChoices.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      
      colorChoices.setLayout(new GridLayout(1,6));
      int color = 0;
      for (int i = 0; i<6; i++){
        DotButton colorButton = new DotButton(color,1);
        colorButton.addActionListener(gameController);
        colorChoices.add(colorButton);
        color++;
      }
      
      c.gridy = 1;
      c.ipady = 10;
      c.insets = new Insets(0,10,0,10);
      add(colorChoices, c);
      
      input = new JLabel();
      c.gridy = 2;
      c.gridwidth = 1;
      c.ipady = 5;
      c.insets = new Insets(10,10,10,10);
      add(input, c);
      
      JButton reset = new JButton("Reset");
      reset.addActionListener(gameController);
      c.gridx = 1;
      add(reset, c);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(gameController);
      c.gridx = 2;
      add(quit, c);
      
      setVisible(true);
      }

    /**
     * Met à jour chaque pastille du jeu (DotButton) en fonction de
     * l'information se trouvant dans le modèle.
     */

    public void update() {
      modifyBoard();
      input.setText("Number of steps: "+ Integer.toString(model.getNumberOfSteps()));
    }
    
    //Ajoute les images selon la bonne couleur, a la board de jeu. 
    public void createBoard() {
      board.removeAll();
      if (model.getSize() > 20) {
          iconSize = 0;
      } else {
        iconSize = 2;
      }
      
      dots = new DotButton[model.getSize()][model.getSize()];
      for (int i=0; i< model.getSize(); i++){
        for (int j=0; j< model.getSize(); j++){
          if (model.isCaptured(i,j)) {
            DotButton pastille = new DotButton(i, j, model.getCurrentSelectedColor(), iconSize);
            dots[i][j] = pastille;
            board.add(pastille);
          } else {
            DotButton pastille = new DotButton(i, j, model.getColor(i,j), iconSize);
            dots[i][j] = pastille;
            board.add(pastille);
            }
          }
      }
    }
    
    private void modifyBoard(){
      int color = model.getCurrentSelectedColor();
      for (int i=0; i< model.getSize(); i++){
        for (int j=0; j< model.getSize(); j++){
          if (model.isCaptured(i,j)) {
            dots[i][j].setColor(color);
            ImageIcon image = dots[i][j].getImage();
            dots[i][j].setIcon(image);
          }
        }
      }
            
    }  

}