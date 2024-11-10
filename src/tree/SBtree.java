package tree;

import lista.Nodo;
import Excepciones.EmptyException;

import java.util.ArrayList;
import java.util.List;

public class SBtree<T extends Comparable<T>> implements Tree<T> {
    private Nodo<T> root;

    public SBtree() {
        this(null);

    }

    public SBtree(T element) {
        this.root = new Nodo<>(element);
    }

    @Override
    public boolean add(T element) {
        if (element != null) {
            if (root.getValue() == null) {
                root.setValue(element);
            } else {
                Nodo<T> _root = root;
                add(_root, element);

            }
        }
        return true;
    }

    public boolean add(Nodo<T> root, T element) {

        if (root.getValue().compareTo(element) == -1) {
            if (root.getRight() == null) {
                Nodo<T> nodo = new Nodo<>(element);
                nodo.setLevel(root.getLevel() + 1);
                root.setRight(nodo);
            } else {
                add(root.getRight(), element);
            }

        } else {
            if (root.getLeft() == null) {
                Nodo<T> nodo = new Nodo<>(element);
                nodo.setLevel(root.getLevel() + 1);
                root.setLeft(nodo);
            } else {
                add(root.getLeft(), element);

            }
        }

        return true;
    }

    @Override
    public boolean remove(T element) {
        return remove(root, element);
    }

    private boolean remove(Nodo<T> root, T element) {

        try {
            isEmpty();
            Nodo<T> saizq = root.getLeft();
            Nodo<T> sader = root.getRight();
            if (root.getValue().equals(element)) {
                // voy a borrar la raiz
                if (root.getRight() != null) {
                    root = root.getRight();
                    if (saizq != null) {
                        Nodo<T> smallestR = search(root, true);
                        smallestR.setLeft(saizq);

                    }
                } else {
                    if (saizq == null) root.setValue(null);
                    root = saizq;
                }
                if (root.getValue().compareTo(element) <= -1) {
                    remove(root.getRight(), element);

                } else {
                    remove(root.getLeft(), element);

                }


            }
        } catch (EmptyException e) {
            e.getMessage();
        }
        return false;
    }

    private Nodo<T> search(Nodo<T> root, boolean b) {
        if (b) {
            if (root.getLeft() == null) return root;
            return search(root.getLeft(), b);
        } else {
            if (root.getRight() == null) return root;
            return search(root.getLeft(), b);
        }
    }

    @Override
    public void inorder() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public void amplitudSearch() {

    }

    @Override
    public void deepSearch() {

    }

    @Override
    public int heigth() {
        return 0;
    }

    @Override
    public boolean isEmpty() throws EmptyException {
        if (root.getValue() == null) {
            throw new EmptyException("El arbol está vacío");
        }
        return false;
    }

    @Override
    public boolean isThere() throws EmptyException {
        return false;
    }

    @Override
    public Nodo<T> search(T element) throws EmptyException {
        return null;
    }

    public void treePrinter() {
        try {
            isEmpty();
            TreePrinter printer = new TreePrinter();
            List<String> idnt = new ArrayList<>();
            printer.printFullTree(root, "-", idnt, true);

        } catch (EmptyException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
}
