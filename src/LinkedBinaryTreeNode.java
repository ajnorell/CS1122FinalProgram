import java.beans.BeanInfo;
import java.util.ArrayList;

/**
* This file creates the Tree Structure for the Guesses and Questions
*
* @author  AJ Norell
* @author 
* @author
* @author
* CS1122 Fall 2022
* @since   28.11.2022
*/

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E>{

    private E data = null;
    private BinaryTreeNode<E> left = null;
    private BinaryTreeNode<E> right = null;
    private BinaryTreeNode<E> parent = null;


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
        if(getParent() != null){parent.getParent();}
        return node;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BinaryTreeNode<E> getLeft() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BinaryTreeNode<E> getRight() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isParent() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeaf() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasLeftChild() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasRightChild() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getDepth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void removeFromParent() {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }    
}

class Question extends LinkedBinaryTreeNode{

}

class Guess extends LinkedBinaryTreeNode{
    
}