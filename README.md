# Jeu Flood It
Projet pour le cours ITI1521 de l'Université d'Ottawa. Ce projet est une implémentation en Java du jeu FloodIt à l’aide du modèle MVC. Ce jeu est affiché avec l'interface Java Swing.

## Instruction du jeu
### Context
Le but du jeu est de remplir toutes les cases de la grille de la même couleur en changeant la couleur du débordement. Tout cela a pour défi de se faire compléter avec le moins de coup possible.

### Pièce du jeu
* **Bille**: élément d'une case qui peut être de 6 couleurs

![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-0.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-1.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-2.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-3.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-4.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/data/M/ball-5.png?raw=true)

* **Grille**: conteneur de 12 x 12 billes à remplir

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/grid.png?raw=true)

* **Palette**: outils pour choisir le changement de couleur du débordement

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/palet.png?raw=true)

* **Débordement**: ensemble de billes contrôllables par le changement de couleur du joueur

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/flood.png?raw=true)

### Flot de jeu
Le jeu débute avec une grille générée de façon aléatoire, puis le joueur commence avec l'ensemble de débordement étant seulement la bille au coin en haut et à gauche. Voici l'exemple d'un coup de débordement de couleurs:

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/flood1.png?raw=true)
![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/flood2.png?raw=true)

**Position de victoire:**

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/win.png?raw=true)

**Défis du nombre de coup**:

![](https://github.com/jstpi047/Game-FloodIt/blob/main/images/challenge.png?raw=true)

## Executer le jeu
1. Installer un [Java SE Development Kit](https://www.oracle.com/java/technologies/java-se-glance.html)
2. Télécharger ce code source
3. Exécuter ces commandes dans le fichier du projet:
```
> javac FloodIt.java
> java FloodIt
```

## Membre du projet
* Jeremie St-Pierre
* Sarah Roy-Molgat
