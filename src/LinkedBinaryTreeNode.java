import java.beans.BeanInfo;
import java.util.ArrayList;

/**
 * This file creates the Tree Structure for the Guesses and Questions
 *
 * @author AJ Norell
 * @author
 * @author
 * @author
 *         CS1122 Fall 2022
 * @since 28.11.2022
 */

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

    private E data = null;
    private BinaryTreeNode<E> left = null;
    private BinaryTreeNode<E> right = null;
    private BinaryTreeNode<E> parent = null;
    BinaryTreeNode<E> temp = null;

    public LinkedBinaryTreeNode(E data) {
        this.data = data;

    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data = data;

    }

    @Override
    public BinaryTreeNode<E> getRoot() {
        temp = this;
        while (temp.getParent() != null) {
            temp = this.getParent();
        }
        return temp;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    @Override
    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = parent;
    }

    @Override
    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        left = child;

    }

    @Override
    public BinaryTreeNode<E> getRight() {
        return right;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {
        right = child;

    }

    @Override
    public boolean isParent() {
        if (hasRightChild() || hasLeftChild()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isLeaf() {
        if (this.hasRightChild() || this.hasLeftChild()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasLeftChild() {
        if (left == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasRightChild() {
        if (right == null) {
            return false;
        }
        return true;
    }

    @Override
    public int getDepth() {
        int count = 0;
        temp = this;
        while(temp.getParent() != null){
            count++;
            temp = temp.getParent();
        }
        return count;
    }

    @Override
    public int getHeight() {
        int leftHeight = getLeft().getHeight();
        int rightHeight = getRight().getHeight();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public int size() {
        return (getLeft().size() + 1 + getRight().size());
    }

    @Override
    public void removeFromParent() {
        if(this.getRoot() == this){return;}
    }

    @Override
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void traversePreorder(BinaryTreeNode.Visitor visitor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void traversePostorder(BinaryTreeNode.Visitor visitor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void traverseInorder(BinaryTreeNode.Visitor visitor) {
        //TODO Auto-generated method stub
    }

    public String toString(){
        return "";
    }
}

class Question<E> extends LinkedBinaryTreeNode<E> {
    public Question(E data) {
        super(data);
        // TODO Auto-getnerated construtor stub
    }

    public String toString(){
        return "";
    }
}

class Guess<E> extends LinkedBinaryTreeNode<E> {

    public Guess(E data) {
        super(data);
        setLeft(null);
        setRight(null);
    }

    public String toString(){
        return "";
    }
}