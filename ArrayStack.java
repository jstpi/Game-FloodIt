/** Auteurs: Jérémie St-Pierre et Sarah Roy-Molgat
 *  Numéros d'étudiant: 8628942 et 7656949
 *  Cours: ITI1521
 *  Travail pratique: 3
 * /

//Droit d'auteur à Marcel Turcotte (cette implémentation à été développée pendant le cours de ITI1521).
*/

public class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int top;

    //Constructeur
    public ArrayStack( int capacity ) {
        elems = (E[]) new Object[ capacity ];
        top = 0;
    }
    
    //Implementations de push(), pop(), isEmpty() et peek(), tq le necessite l'interface. 
    public boolean isEmpty() {
        return ( top == 0 );
    }
    
    public E peek() {
        return elems[ top-1 ];
    }

    public E pop() {
        E saved = elems[ --top ];
        elems[ top ] = null; 
        return saved;
    }

    public void push( E element ) {
      if (top == elems.length) { // augmente la taille.
        E[] newArray;
        newArray = (E[]) new Object[ elems.length * 2 ];
        for (int i=0; i<top; i++) {
          newArray[i] = elems[i];
        }
        elems = newArray;
      }
      elems[ top++ ] = element;
    }
}