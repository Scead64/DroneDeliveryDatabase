package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;


public class ReviewManager {
    public static ArrayList<Review> reviews = new ArrayList<Review>();

    public static void add(Scanner in){
        System.out.print("Rating: ");
        String rating = in.nextLine();
        System.out.print("Description: ");
        String description = in.nextLine();
        Review r = new Review(rating, description);
        reviews.add(r);
    }

    public static Review select(Scanner in){
        System.out.print("Enter Review rating: ");
        String rating = in.nextLine();
        System.out.print("Enter Review description: ");
        String desc = in.nextLine();
        for(Review r: reviews){
            if(r.rating.equals(rating)){
                if(r.description.equals(desc)){
                    return r;
                }
            }
        }
        System.out.print("Error: no Review with rating: " + rating + "\n\t and description: " + desc);
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        for(Review r: reviews){
            if(input.equalsIgnoreCase("Rating") && r.rating.equalsIgnoreCase(data)){
                r.display();
            } else if (input.equalsIgnoreCase("Description") && r.description.equalsIgnoreCase(data)) {
                r.display();
            } else {
                System.out.println("Error: invalid attribute");
            }
        }
    }

    public static void displayAll() {
        for(Review r: reviews){
            r.display();
        }
    }
}