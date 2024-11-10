package tree;

import lista.Nodo;
import Excepciones.EmptyException;

public interface Tree<T> {

    boolean add(T element);

    boolean remove(T element);

    void inorder();

    void preorder();

    void amplitudSearch();

    void deepSearch();

    int heigth();

    boolean isEmpty() throws EmptyException;

    boolean isThere() throws EmptyException;

    Nodo<T> search(T element) throws EmptyException;


}
