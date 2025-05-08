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
            insertNode(this.root, value);
        }
    }

    public void insertNode (RBNode<T> aux, T value) {
        boolean foi_inserido = false;
        RBNode<T> novoNo = new RBNode<T> (value);

        if (foi_inserido == true) {
            if (novoNo.getPai().isColor() == false) {
               realizar_operacao(novoNo); 
            }
        }
        else if (aux.getInfo().compareTo(value) > 0) {
            // desce para esquerda
            insertNode(aux.getLeft(), value);
            if (aux.getLeft() == null) {
                aux.setLeft(novoNo);
                novoNo.setPai(aux);
                foi_inserido = true;
            }
        }
        else {
            // desce para esquerda
            insertNode(aux.getRight(), value);
            if (aux.getRight() == null) {
                aux.setRight(novoNo);
                novoNo.setPai(aux);
                foi_inserido = true;
            }
        }
    }

    public void realizar_operacao(RBNode<T> k) {
        RBNode<T> p = k.getPai();
        RBNode<T> g = p.getPai();
        RBNode<T> s;

        // Verificando quem é o tio (s)
        if (g.getLeft() == p) {
            s = g.getRight();
        }
        else {
            s = g.getLeft();
        }

        // false = red
        if (s.isColor() == false) {     // Recolorindo
            recolorir(k, p, g, s);
        }
        else {      // Rotação
            rotacao(k, p, g);
        }
    }

    public void recolorir(RBNode<T> k, RBNode<T> p, RBNode<T> g, RBNode<T> s) {
        k.setColor(false); // red
        p.setColor(true);   // black
        if (g != this.root) {
            g.setColor(false);  // red
        }
        s.setColor(true);   // black

        RBNode<T> bisavo;
        bisavo = g.getPai();
        if (bisavo.isColor() == false) {
            RBNode<T> new_k = g;
            RBNode<T> new_p = new_k.getPai();
            RBNode<T> new_g = new_p.getPai();
            RBNode<T> new_s;
            if (new_g.getLeft() == new_p) {
                new_s = new_g.getRight();
            }
            else {
                new_s = new_g.getLeft();
            }
            recolorir(new_k, new_p, new_g, new_s);
        }
    }

    public void rotacao(RBNode<T> k, RBNode<T> p, RBNode<T> g) {
        if (g.getLeft() == p && p.getLeft() == k) {     // R.S.D
            // p é o A
            // k é o B
            p.setLeft(k.getRight()); 
            k.setRight(p); 
            p = k; 
        }
        else if (g.getRight() == p && p.getRight() == k) {      // R.S.E
            // p é o A
            // k é o B
            p.setRight(k.getLeft()); 
            k.setLeft(p); 
            p = k;  
        }
        else if (g.getLeft() == p && p.getRight() == k) {       // R.D.D
            // k é o C
            // p é o B
            // g é o A
            k = p.getRight(); 
            p.setRight(k.getLeft()); 
            k.setLeft(p); 
            g.setLeft(k.getRight()); 
            k.setRight(g); 
            g = k;
        }
        else if (g.getRight() == p && p.getLeft() == k) {       // R.D.E
            // k é o C
            // p é o B
            // g é o A
            k = p.getLeft(); 
            p.setLeft(k.getRight()); 
            k.setRight(p);
            g.setRight(k.getLeft()); 
            k.setLeft(g); 
            g = k;
        }
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
