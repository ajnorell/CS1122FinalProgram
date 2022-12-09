import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.function.Function;

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
        BinaryTreeNode<E> n = this;
        while(n.getParent()!= null) n = n.getParent();
        return n;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return this.parent;
    }

    public void setParent(BinaryTreeNode<E> node) {
        this.parent = node;
    }

    @Override
    public BinaryTreeNode<E> getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        this.left = child;
        
    }

    @Override
    public BinaryTreeNode<E> getRight() {
        return this.right;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {
        this.right = child;
    }

    @Override
    public boolean isParent() {
        return this.left != null || this.right != null;
    }

    @Override
    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    @Override
    public boolean hasLeftChild() {
        return this.left != null;
    }

    @Override
    public boolean hasRightChild() {
        return this.right != null;
    }

    @Override
    public int getDepth() {
        int count = 0;
        BinaryTreeNode<E> temp = this;
        while(temp.getParent() != null){
            count++;
            temp = temp.getParent();
        }
        return count;
    }

    @Override
    public int getHeight() {
        int l = 0, r = 0;
        if(this.getRight() != null) r = this.getRight().getHeight();
        if(this.getLeft() != null) l = this.getLeft().getHeight();
        return Math.max(l,r) + 1;
    }

    @Override
    public int size() {
        int total = 1;
        if(this.getRight() != null) total += this.getRight().size();
        if(this.getLeft() != null) total += this.getLeft().size();
        return total;
    }

    @Override
    public void removeFromParent() {
        this.getParent().setLeft(this.parent.getLeft() == this ? null : this.parent.getLeft());
        this.getParent().setRight(this.parent.getRight() == this ? null : this.parent.getRight());
        if(this.getRight()!=null) this.getRight().setParent(this.getParent());
        if(this.getLeft()!=null) this.getLeft().setParent(this.getParent());
    }

    
    @Override
    public ArrayList<BinaryTreeNode<E>> pathTo(BinaryTreeNode<E> descendant) {
        BinaryTreeNode<E> n = descendant;
        ArrayList<BinaryTreeNode<E>> list = new ArrayList<BinaryTreeNode<E>>();
        while(n != this){
            list.add(n); 
            n = n.getParent();
        }
        return list;
    }






    @Override
    public ArrayList<BinaryTreeNode<E>> pathFrom(BinaryTreeNode<E> ancestor) {
        BinaryTreeNode<E> n = this;
        ArrayList<BinaryTreeNode<E>> list = new ArrayList<BinaryTreeNode<E>>();
        list.add(n);
        while(n != ancestor){ 
            n = n.getParent();
            list.add(n);
        }
        return list;
    }


    private void recursive_inorder_traverse(BinaryTreeNode<E> node, Function<BinaryTreeNode<E>,E> f){
        if(node != null){
            recursive_inorder_traverse(node.getLeft(), f);
            f.apply(node);
            recursive_inorder_traverse(node.getRight(), f);
        }
    }

    private void recursive_preorder_traverse(BinaryTreeNode<E> node, Function<BinaryTreeNode<E>,E> f){
        if(node != null){
            recursive_preorder_traverse(node.getRight(), f);
            f.apply(node);
            recursive_preorder_traverse(node.getLeft(), f);
        }
    }







    @Override
    public void traversePreorder(BinaryTreeNode.Visitor visitor) {
        this.recursive_preorder_traverse(this, v -> {visitor.visit(v); return null;});
    }

    @Override
    public void traversePostorder(BinaryTreeNode.Visitor visitor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void traverseInorder(BinaryTreeNode.Visitor visitor) {
        this.recursive_inorder_traverse(this, v -> {visitor.visit(v); return null;});
    }    
}
