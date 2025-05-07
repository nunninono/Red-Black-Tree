package RedBlackGenerica;

public class RBTree <T extends Comparable<T>>{
    private RBNode<T> root;

    // Verifica se a arvore está vazia
    public boolean isEmpty() {
        return root == null;
    }

    public void inserir(T value) {
        if (isEmpty() == true) {
            this.root = new RBNode<T> (value);
            this.root.setColor(true);  // setBlack
        }
        else {
            this.root = insertNode(this.root, value);
        }
    }

    public RBNode<T> insertNode (RBNode<T> node, T value) {

        while (node != null) {
            
        }

        return node;
    }

    public void balancear(RBNode<T> k) {
        RBNode<T> p = k.getPai();
        RBNode<T> g = p.getPai();
        RBNode<T> s;
    }

    public void emOrdem() {
        if (isEmpty() == true){
            System.out.println("Sua RedBlack está vazia!!");
        }
        else {
            this.passeioEmOrdem(this.root);
        }
    }

    public void passeioEmOrdem(RBNode<T> node) {
        if (node != null) {
            passeioEmOrdem(node.getLeft());
            System.out.println(node.getInfo());
            passeioEmOrdem(node.getRight());
        }
    }
}
