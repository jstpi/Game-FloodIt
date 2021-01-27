/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

/**
 * Le type abstrait de données (TAD) Stack (pile). Une pile est une structure de
 * données linéaire suivant le protocole last-in-first-out
 * (dernier-ajouté-premier-retiré). Stack est un type paramétré.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public interface Stack<E> {

    /**
     * Détermine si la pile est vide ou nom.
     *
     * @return true si la pile est vide et false sinon.
     */

    public abstract boolean isEmpty();

    /**
     * Retourne la référence de l'objet sur le dessus de la pile, sans changer
     * le contenu de la pile. Stack.
     *
     * @return la référence de l'élément du dessus de la pile.
     */

    public abstract E peek();

    /**
     * Retire et retourne l'élément du dessus de la pile.
     *
     * @return la référence de l'élément retiré.
     */

    public abstract E pop();

    /**
     * Ajoute un élément sur cette pile.
     *
     * @param element
     *            la référence de l'élément à ajouter.
     */

    public abstract void push(E element);

}