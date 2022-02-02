package cademy.training;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private  static MobilePhone mobilePhone = new MobilePhone("9199992412");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printAction();
        while(!quit){
            System.out.println("\n Enter Action: (6 to show available actions)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nShutting Down....");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;


            }

        }



    }

    private static void  addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number");
        String  phone = sc.nextLine();
        Contact newContact = Contact.createContact(phone, name);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added" + name + " phone = " + phone) ;
        }else{
            System.out.println("cannot add contact into because name is already on file");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String name =sc.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = sc.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated record");
        }else {
            System.out.println("Error updating record");
        }

    }



    private static void startPhone(){
        System.out.println("Starting phone.....");
    }

    private static void printAction(){
        System.out.println("\n Available action \npress");
        System.out.println("0 - to shutdown\n " +  "1- to print contacts\n" + " 2- add contact \n " + " 3 - update contact " + "4 - remove existing contact" + " 5 - query if contact exist" + "6 - to print a list of available action");
        System.out.println("Choose your action");
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name");
        String name = sc.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }

    }

    private static void queryContact() {
        System.out.println("Enter existing contact name");
        String name = sc.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number is  " + existingContactRecord.getPhoneNumber());
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }

    }
}
