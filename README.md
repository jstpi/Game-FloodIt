# Jeu Flood It
Project pour le cours ITI1521 de l'Université d'Ottawa. Ce project est une implémentation en Java du jeu FloodIt à l’aide du modèle MVC. Ce jeu est affiché avec l'interface Java Swing.

## Instruction du jeu
### Context
Le but du jeu est de remplir toutes les cases de la grille de la même couleur en changeant la couleur du débordement. Tout cela a pour défi de ce faire compléter avec le moins de coup possible.

### Pièce du jeu
* **Bille**: élément d'une case qui peut être de 6 couleurs

![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-0.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-1.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-2.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-3.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-4.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-5.png?raw=true)

* **Grille**: conteneur de 12 x 12 bille à remplir



* **Palette**: outils pour choisir le changement de couleur du débordement
* **Débordement**: ensemble de bille controllable par le changement de couleur du joueur

### Flot de jeu
Le jeu débute avec une grille généré de façon aléatoire, puis le joueur commencer avec l'ensemble de débordement étant seulement la bille au coins en haut et à gauche. Voici l'exemble d'un coup de débordement de couleurs:

**Position de victoire:**

**Défis du nombre de coup**:


## Exécuter le jeu
```
> javac FloodIt.java
> java FloodIt
```

## Membre du projet
* Jeremie St-Pierre
* Sarah Roy-Molgat
