/**
* This is the where the Logic for the Guessing Takes place
*
* @author  AJ Norell
* @author 
* @author
* @author
* CS1122 Fall 2022
* @since   28.11.2022
*/

public class GuessingGame implements Game{

    @Override
    public BinaryTreeNode<String> loadTree(String filename) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveTree(String filename) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public BinaryTreeNode<String> getRoot() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {
    if(args.length != 1){throw new IllegalArgumentException("Exactly one command line argument needed!");}
    if(!args[0].contains(".data")){throw new IllegalArgumentException("filename must be of type 'data'");}
    }
    
}
