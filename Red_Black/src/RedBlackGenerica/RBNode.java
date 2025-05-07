package RedBlackGenerica;

public class RBNode <T extends Comparable<T>> {
    private RBNode <T> left;
    private T info;
    private RBNode <T> pai;
    private boolean color;   // true: black | false: red
    private RBNode <T> right;

    public RBNode(T info) {
        this.info = info;
        this.color = false;
        this.left = null;
        this.right = null;
        this.pai = null;
    }

    public RBNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBNode<T> left) {
        this.left = left;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public RBNode<T> getPai() {
        return pai;
    }

    public void setPai(RBNode<T> pai) {
        this.pai = pai;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBNode<T> getRight() {
        return right;
    }

    public void setRight(RBNode<T> right) {
        this.right = right;
    }
}
