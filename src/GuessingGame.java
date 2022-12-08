import java.util.*;
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
        Scanner scan = new Scanner(System.in);
        String input = null;
        String play = null;
        BinaryTreeNode<String> n = getRoot();

        System.out.print("Shall we play a game? (y/n): ");
        play = scan.next();
        while(play != "y"){

            if(n instanceof Question){
                System.out.print(n.getData() + " (y/n): ");
                input = scan.next();
                if(input == "y"){
                    n = n.getRight();
                    break;
                }
                else if(input == "n"){
                    n = n.getLeft();
                    break;
                }

            }
            else{
                System.out.print("Are you thinking of a " + n.getData() + "? (y/n): ");
                input = scan.next();
                if(input == "y"){
                    System.out.println("I win!");
                    System.out.print("Play again? (y/n): ");
                    play = scan.next();
                }
                else if(input == "n"){
                    System.out.print("What are you thinking of?: ");
                    input = scan.next();
                    Guess<String> guess = Guess(input);
                    System.out.print("\nWhat question seperates a " + n.getData() + " from a " + input + "?");
                    input = scan.nextLine();
                    Question<String> question = Question(input);
                    System.out.print("\nIs " + guess.getData() + " correct when the answer to " + question.getData() + " is yes? (y/n)?: ");
                    input = scan.next();
                    if(input != "y"){
                        n.setLeft(guess);
                        guess.setParent(n);
                        n.setRight(question);
                    }
                    System.out.print("\nPlay again? (y/n): ");
                    play = scan.next();   
                }
            }
            
        }
        scan.close();
        
    }

    public static void main(String[] args) {
    if(args.length != 1){throw new IllegalArgumentException("Exactly one command line argument needed!");}
    if(!args[0].contains(".data")){throw new IllegalArgumentException("filename must be of type 'data'");}
    }
    
}
