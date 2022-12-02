package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistrationCheck {

    public static void giveId(List<Animal> AnimalList, Scanner scanner, Animal a1){
        boolean flag_id = true;
        while (flag_id) {
            try {
                System.out.println("Συμπληρώστε Κωδικό. Η τιμή πρέπει να είναι θετικός ακέραιος αριθμός, μικρότερο των 4 ψηφίων και ΜΟΝΑΔΙΚΟΣ.");
                String input = scanner.nextLine();
                int id = Integer.parseInt(input);
                boolean has_id=false;// Έλεγχος αν ο κωδικός υπάρχει ήδη στον κατάλογο.
                for (Animal animal : AnimalList) {
                    if (id == animal.getId()){
                        has_id=true;
                    }
                }
                if (!has_id){
                    if (id > 0 && id < 1000) {
                        a1.setId(id);
                        flag_id = false;
                    } else {
                        flag_id = true;
                    }
                }
                else
                {
                    System.out.println("Ο κωδικός υπάρχει ήδη στον κατάλογο, παρακαλώ τοποθετήστε νέο κωδικό!\n");
                }

            } catch (NumberFormatException e) {
                flag_id = true;
            }
        }
    }
    public static void giveName(Scanner scanner,Animal a1){
        boolean flag_name = true;
        while(flag_name){
            System.out.println("Συμπληρώστε ένα όνομα");
            String name = scanner.nextLine();
            if (!name.isEmpty()){
                flag_name=false;
                if(Pattern.matches("[a-zA-Z]+",name)){
                    a1.setName(name);
                }
                else
                {
                    System.out.println("Το όνομα δεν επιτρέπεται να περιέχει αριθμούς,σύμβολα και κενά");
                    flag_name=true;
                }
            }
        }
    }
    public static void giveClassis(Scanner scanner,Animal a1){
        boolean flag_classis = true;
        while (flag_classis){
            System.out.println("Συμπληρώστε μια ομοταξία");
            String classis = scanner.nextLine();
            if(!classis.isEmpty()){
                flag_classis=false;
                if(Pattern.matches("[a-zA-Z]+",classis)){
                    a1.setClassis(classis);
                }
                else
                {
                    System.out.println("Η ομοταξία δεν επιτρέπεται να περιέχει αριθμούς,σύμβολα και κενά");
                    flag_classis=true;
                }
            }
        }
    }
    public static void giveWeight(Scanner scanner,Animal a1){
        boolean flag_weight = true;
        while (flag_weight) {
            try {
                System.out.println("Συμπληρώστε βάρος.Το βάρος πρέπει να είναι θετικό, μεγαλύτερο από 0.1 κιλά και μικρότερο απο 10000 κιλά ");//ελαφρύτερο κάποιο είδος πουλιού, βαρύτερο ελέφαντας.
                String input = scanner.nextLine();
                double weight = Double.parseDouble(input);
                if (weight > 0.1 && weight < 10000) {
                    a1.setWeight(weight);
                    flag_weight = false;
                } else {
                    flag_weight = true;
                }
            } catch (NumberFormatException e) {
                flag_weight = true;
            }
        }
    }
    public static void giveMax_Age(Scanner scanner,Animal a1){
        boolean flag_age = true;
        while (flag_age) {
            try {
                System.out.println("Συμπληρώστε μέγιστη ηλικία. Η ηλικία πρέπει να είναι θετικός ακέραιος αριθμός, μεγαλύτερος από 0 και μικρότερος απο 251");//Τεράστια χελώνα 250 έτη.
                String input = scanner.nextLine();
                int age = Integer.parseInt(input);
                if (age > 0 && age < 251) {
                    a1.setMax_age(age);
                    flag_age = false;
                } else {
                    flag_age = true;
                }
            } catch (NumberFormatException e) {
                flag_age = true;
            }
        }
    }
}
