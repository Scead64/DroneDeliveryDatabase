package ManagerClasses;

import java.util.ArrayList;
import java.util.Scanner;
import DataClasses.*;


public class MemberManager {
    public static ArrayList<Member> members = new ArrayList<Member>();

    //Member Methods

    public static void add(Scanner in, int id){
        System.out.print("fname: ");
        String fname = in.nextLine();
        System.out.print("lname: ");
        String lname = in.nextLine();
        System.out.print("address: ");
        String address = in.nextLine();
        System.out.print("email: ");
        String email = in.nextLine();
        System.out.print("password: ");
        String password = in.nextLine();
        System.out.print("phone: ");
        String phone = in.nextLine();
        System.out.print("Start Date: ");
        String startDate = in.nextLine();
        Member m = new Member(id, fname,lname,address,email,password,phone,startDate);
        members.add(m);
    }

    public static Member select(Scanner in){
        System.out.print("Enter member userID: ");
        String input = in.nextLine();
        int id;
        try{
            id = Integer.parseInt(input);
            for(Member m: members){
                if(m.userID == id){
                    return m;
                }
            }
            System.out.print("Error: no member with id " + id);
        } catch(NumberFormatException ex) {
            System.out.print("Error: invalid id " + input);
        }
        return null;
    }

    public static void search(Scanner in){
        System.out.print("Enter attribute to search: ");
        String input = in.nextLine();
        System.out.println("Enter data: ");
        String data = in.nextLine();

        if(input.equalsIgnoreCase("fname")){
            for(Member m: members){
                if(m.fname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("lname")){
            for(Member m: members){
                if(m.lname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("address")){
            for(Member m: members){
                if(m.address.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("email")){
            for(Member m: members){
                if(m.email.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("password")){
            for(Member m: members){
                if(m.password.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("phone")){
            for(Member m: members){
                if(m.phone.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("Start date")){
            for(Member m: members){
                if(m.startDate.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else if(input.equalsIgnoreCase("userID")){
            for(Member m: members){
                if(m.fname.equalsIgnoreCase(data)){
                    m.display();
                }
            }
        } else {
            System.out.println("Error: invalid attribute");
        }
    }

    public static void displayAll() {
        for(Member m: members){
            m.display();
        }
    }
}