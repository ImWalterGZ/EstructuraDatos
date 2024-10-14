package lista;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Lista<T> {

    private Nodo<T> root, tail;
    private long length;

    public LinkedList(T value){
        // C'est le même
        this.root = new Nodo<>();
        this.tail = new Nodo<>();
        this.length = 0;
        if (value != null){
            length++;
            Nodo<T> nuevo = new Nodo<>(value);
            root.setRight(nuevo);
            tail.setLeft(nuevo);
        }


    }

    public LinkedList(Nodo<T> nodo){
        length++;
        root.setRight(nodo);
        tail.setLeft(nodo);
    }

    public LinkedList(){
        this((T) null);
    }


    // Hagamos una clase anonima para hacer iteradores
    // Al hacerlos directo en la clase en lugar de implementarlos
    // Quiero utilizar el iterador para recorrerlo por un for each
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            Nodo<T> copy = root.getRight(), sub_node;

            @Override
            public boolean hasNext(){
                if (copy == null) return false;
                sub_node = copy;
                copy = copy.getRight();
                return true;
            }
            @Override
            public T next(){
                return sub_node.getValue();
            }
        };
    }

    @Override
    public boolean isEmpty() throws NoSuchElementException {
        if (root.getRight() == null){
            throw new NoSuchElementException("La lista está vacía");
        }
        return false;
    }

    @Override
    public Nodo<T> getLastElement() {
        return getLastElement(root);
    }

    private Nodo<T> getLastElement(Nodo<T> root){
        if (root.getRight() == null){
            return root;
        }
        return getLastElement(root.getRight());
    }

    @Override
    public Nodo<T> getPrevElement(T value) {
        Nodo<T> tmp = null;
        try{
        isEmpty();
        tmp = getPrevElement(root, value);
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        return tmp;
    };
    private Nodo<T> getPrevElement(Nodo<T> root, T value){
        if (root.getRight().getValue() == value){
            return root;
        }
        else return getPrevElement(root.getRight(), value);
    };


    @Override
    public Nodo<T> getElement() {
        return null;
    }

    @Override
    public Nodo<T> getElementAt() {
        return null;
    }

    @Override
    public boolean isThere(T value) {
        return false;
    }

    @Override
    public boolean isThere(Nodo<T> node) {
        return false;
    }

    @Override
    public void add(T value) {
        if (value != null){

                Nodo<T> nouveau = new Nodo<>(value);
                Nodo<T> last = getLastElement();

                last.setRight(nouveau);
                tail.setLeft(nouveau);
                length++;


        }

    }

    @Override
    public void add(Nodo<T> node) {



    }

    @Override
    public void remove(T value) {

    }

    @Override
    public void remove(Nodo<T> node) {

    }

    @Override
    public void addAt(int position, T value) {

    }

    @Override
    public void addAt(int position, Nodo<T> node) {

    }

    @Override
    public void addAfter(int position, T value) {

    }

    @Override
    public void addAfter(int position, Nodo<T> node) {

    }

    @Override
    public void addBefore(int position, Nodo<T> node) {

    }

    @Override
    public void addBefore(int position, T value) {

    }

    @Override
    public void removeAfter(int position, T value) {

    }

    @Override
    public void removeAfter(int position, Nodo<T> node) {

    }

    @Override
    public void removeBefore(int position, T value) {

    }

    @Override
    public void removeBefore(int position, Nodo<T> node) {

    }

    @Override
    public void addStart(T value) {

    }

    @Override
    public void addStart(Nodo<T> node) {

    }

    @Override
    public long getLength() {
        return 0;
    }

    @Override
    public void removeAll(T value) {

    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "root=" + root +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
