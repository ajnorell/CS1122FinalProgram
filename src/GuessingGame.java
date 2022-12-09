import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    LinkedBinaryTreeNode<String> root;
    private static Scanner sc = new Scanner(System.in);

    @Override
    public BinaryTreeNode<String> loadTree(String filename){
        try{
            List<String> file_data = Files.readAllLines(Path.of(filename));
            LinkedList<LinkedBinaryTreeNode<String>> nodes = new LinkedList<LinkedBinaryTreeNode<String>>();
             for(String data : file_data) nodes.add(data.startsWith("Q") ? new Question(data.substring(2)) : new Guess(data.substring(2)));
            this.root= nodes.get(0);
             load_helper(nodes);
            return this.root;
        }catch(IOException e){
            System.out.println("Invalid Filename! " + e.getLocalizedMessage());
        }
        return null;
    }

    private static LinkedBinaryTreeNode<String> load_helper(LinkedList<LinkedBinaryTreeNode<String>> nodes){
        LinkedBinaryTreeNode<String> n = nodes.pop();
        if(n instanceof Question){
            BinaryTreeNode<String> l = load_helper(nodes);
            n.setLeft(l);
            l.setParent(n);
            BinaryTreeNode<String> r = load_helper(nodes);
            n.setRight(r);
            r.setParent(n);
        }
        return n;
    }

    @Override
    public void saveTree(String filename){
        ArrayList<String> list = new ArrayList<>();
        save_helper(root, list);
        try{
        Files.write(Path.of(filename), list);
        }catch(Exception e){
            System.out.println("Error saving to file! more info: \n" + e.getLocalizedMessage());
        }
    }

    private static void save_helper(BinaryTreeNode<String> n,List<String> buffer){
        if(n!=null){
            buffer.add( (n instanceof Guess ?  "G:" : "Q:") + n.getData());
            save_helper(n.getLeft(), buffer);
            save_helper(n.getRight(), buffer);
        }
    }

    @Override
    public BinaryTreeNode<String> getRoot() {
        return this.root;
    }


    private static boolean yes_no(String prompt){
        System.in.mark(3);
        System.out.print(prompt + " (y/n): ");
        boolean input = false;
        
        String x = sc.nextLine();
        input = x.toLowerCase().equals("y");
        return input;
    }

    private String ask(String prompt){
        String input = "";
        System.out.print(prompt + ": ");
        input = sc.nextLine();
        return input;
    }

    @Override
    public void play() {
        BinaryTreeNode<String> n = getRoot();
        boolean play = yes_no("Shall we play a game?");
        while(play){
            if(n instanceof Question){
                if(yes_no(n.getData())){
                    n = n.getRight();
                }else{
                    n = n.getLeft();
                }
            }else{
                if(yes_no("Are you thinking of a " + n.getData() + "?")){
                    System.out.println("I win!");
                }else{
                    Guess guess = new Guess(ask("What are you thinking of?"));
                    Question question = new Question(ask("What question seperates a " + n.getData() + " from a " + guess.getData() + "?"));
                    if(yes_no("Is " + guess.getData() + " correct when the answer to " + question.getData() + " is yes?")){
                        if(n.getParent().getRight().equals(n)){
                            n.getParent().setRight(question);
                        }else{
                            n.getParent().setLeft(question);
                        }
                        question.setRight(guess);
                        question.setLeft(n);
                        question.setParent(n.getParent());
                    } 
                }
                play = yes_no("Play Again?");
                n = getRoot();
            }

        }
        this.saveTree("naenae.data");
    }

    public static void main(String[] args) {
    if(args.length != 1) throw new IllegalArgumentException("Exactly one command line argument needed!");
    if(!args[0].contains(".data"))throw new IllegalArgumentException("filename must be of type 'data'");
    GuessingGame game = new GuessingGame();
    game.loadTree(args[0]);
    game.play();
    }
    
}
