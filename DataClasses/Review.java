package DataClasses;

import java.util.Scanner;

public class Review {
    
    public String rating;
    public String description;
    
    public Review(String _rating, String _description){
        this.rating = _rating;
        this.description = _description;
    }

    public void display(){
        System.out.println("Rating: " + this.rating);
        System.out.println("Description: " + this.description);
        System.out.println();
    }
    
    public void edit(Scanner in){
        String input, data;
        while(true){
            System.out.print("Enter field to edit: ");
            input = in.nextLine();
            System.out.print("Enter new data: ");
            data = in.nextLine();
    
            if(input.equalsIgnoreCase("rating")){
                this.rating = data;
            } else if(input.equalsIgnoreCase("description")){
                this.description = data;
            } else {
                System.out.println("Error: invalid attribute");
            }
    
            System.out.print("Enter 'C' to continue editing ");
            input = in.nextLine();
            if(!input.equalsIgnoreCase("C")){
                break;
            }
        }
    }
}