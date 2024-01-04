package com.AdressBookSystem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private List<PersonalDetails> list1 = new ArrayList<>();

    public void addNewContact(PersonalDetails PDItems) {
        if (list1.stream().anyMatch(contact -> contact.getFirstName().equals(PDItems.getFirstName()))) {
            System.out.println("Duplicate found -> not added : " + PDItems.getFirstName());
        } else {
            list1.add(PDItems);
        }
    }

    public void displayAddedContact(){
        if (list1.isEmpty()){
            System.out.println("Address Book is Empty");
        }else{
            System.out.println();
            System.out.println("Personal Details list :");
            for (PersonalDetails personalDetails : list1) {
//                System.out.println("Contact Details are :" );
                System.out.println(personalDetails);
            }
        }
    }

    public void editFirstName(String input, String output){
        for ( PersonalDetails contact : list1){
            if (contact.getFirstName().toLowerCase().equals(input.toLowerCase())){
                contact.setFirstName(output);
            }
        }
    }
    public void deleteContact(int index){
        list1.remove(index);
    }

    public List<PersonalDetails> searchByCity(String city) {
        return list1.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<PersonalDetails> searchByState(String state) {
        return list1.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Scanner sysInput= new Scanner(System.in);
        System.out.println("Welcome to AddressBook Program");
        System.out.println();
        AddressBook B = getAddressBook();

        System.out.println("Enter First Name to edit : ");
        String inputString = sysInput.next();
        System.out.println();
        System.out.println("Enter Name :");
        String editString = sysInput.next();

        B.editFirstName(inputString,editString);
        System.out.println(B);
        B.displayAddedContact();

        System.out.println();
        System.out.println("Enter index Number to delete");
        int toDelete = sysInput.nextInt();

        B.deleteContact(toDelete-1);
        B.displayAddedContact();

        System.out.println();
        System.out.println("Search by City : ");
        String citySearch = sysInput.next();
        List<PersonalDetails> personsInCity = B.searchByCity(citySearch);
        System.out.println("Persons in "+citySearch+" :");
        personsInCity.forEach(System.out::println);

        System.out.println();
        System.out.println("Search by State : ");
        String stateSearch = sysInput.next();
        List<PersonalDetails> personsInState = B.searchByState(stateSearch);
        System.out.println("Persons in "+stateSearch+" :");
        personsInState.forEach(System.out::println);
        


    }

    private static AddressBook getAddressBook() {
        PersonalDetails p = new PersonalDetails("Dev","Patel","Olpad","Olpad","Gujrat","531620","7388103726","patelmayuraaa@gmail.com",1);
        PersonalDetails p1 = new PersonalDetails("Yash","Sharode","Udhana","Udhana","GJ","402460","1103135819","yashSharode@gmail.com",2);
        PersonalDetails p2 = new PersonalDetails("Akshay","Sushir","Udhana","Udhana","Gujrat","565022","0998701818","Akshaysushir@gmail.com",3);
        PersonalDetails p3 = new PersonalDetails("Vaibhav","Singh","Olpad","Olpad","GJ","242922","8006719208","vaibhavsingh@gmail.com",4);
        PersonalDetails p4 = new PersonalDetails("Karitk","Gohil","Olpad","Olpad","Gujrat","849135","8532437705","KartikGohil@gmail.com",5);
        PersonalDetails p5 = new PersonalDetails("Dev","Patel","Olpad","Olpad","Gujrat","595853","9046782898","patelmayuraaa@gmail.com",6);
        AddressBook B =new AddressBook(

        );
        B.addNewContact(p);
        B.addNewContact(p1);
        B.addNewContact(p2);
        B.addNewContact(p3);
        B.addNewContact(p4);
        B.addNewContact(p5);
        B.displayAddedContact();
        return B;
    }

}