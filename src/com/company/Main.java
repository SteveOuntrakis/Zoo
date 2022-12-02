package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.company.RegistrationCheck.*;

public class Main extends FileManagement {

    public static void main(String[] args) {
        List<Animal> AnimalList = new ArrayList<>();//Με την έναρξη της εφαρμογής, δηλώνω λίστα ώστε να διαβάζει από αρχείο ότι υπάρχει ήδη και να μπορώ να επεξεργαστώ.

        FileManagement fileManagement =new FileManagement();//Στην κλάση αυτή, υπάρχει μία μέθοδος για ανάγνωση και μία για εγγραφή σε αρχείο.

        fileManagement.readfile(AnimalList);//Διαβάζω file.

        boolean flag=true;//Flag, ώστε να μπορώ να κάνω συνεχής επανάληψη του μηνύματος, αν ο χρήστης δεν επιλέξει κάποια δυνατότητα.
        while (flag) {
            flag=false;
            System.out.println(
                    " _____________________________________________________________________\n" +
                            "|              Καλώς ορίσατε στον ζωολογικό μας κήπο.                 |\n" +
                            "|Για να συνεχίσετε παρακαλώ επιλέξτε μία από τις παρακάτω δυνατότητες:|\n" +
                            "|_____________________________________________________________________|\n" +
                            "1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n" +
                            "2. Προσθήκη νέου ζώου\n" +
                            "3. Αναζήτηση ζώου με βάση το όνομα\n" +
                            "4. Αναζήτηση ζώου με βάση τον κωδικό\n" +
                            "5. Επεξεργασία ζώου με βάση τον κωδικό\n" +
                            "6. Διαγραφή ζώου με βάση τον κωδικό\n" +
                            "7. Έξοδος από την εφαρμογή\n" +
                            "_____________________________________________________________________");

            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();

            Animal a1 = new Animal();

            if (code.equals("1")) {
                for (Animal animal : AnimalList) {
                    System.out.println(" Κωδικός:"+animal.getId()+"\n Όνομα:"+animal.getName()+"\n Ομοταξία:"+animal.getClassis()+"\n Βάρος:"+animal.getWeight()+"\n Μέγιστη ηλικία:"+animal.getMax_age()+"\n -------------------------------");
                }
            }

            else if (code.equals("2")) {
                //id
                giveId(AnimalList,scanner,a1);
                //name
                giveName(scanner,a1);
                //classis
                giveClassis(scanner,a1);
                //weight
                giveWeight(scanner,a1);
                //max_age
                giveMax_Age(scanner,a1);
                //add to list, write on file:
                AnimalList.add(a1);
                fileManagement.WriteFile(AnimalList);
            }

            else if (code.equals("3")) {
                boolean found=false;// αν δε βρεθεί το ζώο, τότε μήνυμα!
                System.out.println("Αναζήτηση ζώου με βάση το όνομα:");
                String name = scanner.nextLine();
                for (Animal animal : AnimalList) {
                    if (name.equals(animal.getName())){
                        System.out.println("\n Κωδικός:"+animal.getId()+"\n Όνομα:"+animal.getName()+"\n Ομοταξία:"+animal.getClassis()+"\n Βάρος:"+animal.getWeight()+"\n Μέγιστη ηλικία:"+animal.getMax_age()+"\n -------------------------------");
                        found=true;
                    }
                }
                if(!found){
                    System.out.println("Δε βρέθηκε το συγκεκριμένο όνομα στον κατάλογο!\n");
                }
            }

            else if (code.equals("4")) {
                boolean found=false;// αν δε βρεθεί το ζώο, τότε μήνυμα!
                boolean not_integer=true;//Μέχρι να βάλει κάποιον ακέραιο για κωδικό!
                while(not_integer){
                    try{
                        System.out.println("Αναζήτηση ζώου με βάση τον κωδικό:");
                        int id = Integer.valueOf(scanner.nextLine());
                        for (Animal animal : AnimalList) {
                            if (id==animal.getId()){
                                System.out.println(" Κωδικός:"+animal.getId()+"\n Όνομα:"+animal.getName()+"\n Ομοταξία:"+animal.getClassis()+"\n Βάρος:"+animal.getWeight()+"\n Μέγιστη ηλικία:"+animal.getMax_age()+"\n ________________________________");
                                found=true;
                            }
                        }
                        if(!found){
                            System.out.println("Δε βρέθηκε ο συγκεκριμένος κωδικός στον κατάλογο!\n");
                        }
                        not_integer=false;
                    }
                    catch(NumberFormatException e){
                        System.out.println("Παρακαλώ συμπληρώστε ακέραιο αριθμό.");
                        not_integer=true;
                    }
                }
            }

            else if (code.equals("5")) {
                boolean flag_id = true; //Όσο δε βρίσκω κωδικό στο αρχείο, διαβάζω εγγραφές.
                while (flag_id) {
                    try {
                        System.out.println("Συμπληρώστε Κωδικό. Η τιμή πρέπει να είναι θετικός ακέραιος αριθμός, μικρότερο των 4 ψηφίων και ΜΟΝΑΔΙΚΟΣ.");
                        String input = scanner.nextLine();
                        int id = Integer.parseInt(input);
                        boolean has_id=false;// Έλεγχος αν ο κωδικός υπάρχει ήδη στον κατάλογο.
                        for (Animal animal : AnimalList) {
                            if (id == animal.getId()){
                                has_id=true;
                                AnimalList.remove(animal);
                                a1.setId(id);
                                flag_id=false;
                                break;
                            }
                        }
                        while(!has_id){
                            System.out.println("Δε βρέθηκε ο συγκεκριμένος κωδικός στον κατάλογο\n " +
                                    "θέλετε επανάληψη της διαδικασίας? y/n");
                            //Αν βάλει λάθος κωδικό, ερωτάτε ο χρήστης σε περίπτωση που μπερδεύτηκε.
                            String revise=scanner.nextLine();
                            if(revise.equals("y")) {
                                flag_id=true;
                                has_id=true;
                            }
                            else if (revise.equals("n")){
                                flag_id=false;
                                break;
                            }
                            else{
                                has_id=false;
                            }
                        }

                    } catch (NumberFormatException e) {
                        flag_id = true;
                    }
                }
                //name
                giveName(scanner,a1);
                //classis
                giveClassis(scanner,a1);
                //weight
                giveWeight(scanner,a1);
                //max_age
                giveMax_Age(scanner,a1);

                //Add to list, write on file:
                AnimalList.add(a1);
                fileManagement.WriteFile(AnimalList);
            }

            else if (code.equals("6")) {

                boolean found=false;// αν δε βρεθεί το ζώο, τότε μήνυμα!
                boolean not_integer=true;//Μέχρι να βάλει κάποιον ακέραιο για κωδικό!

                while(not_integer) {
                    try {
                        System.out.println("Διαγράψτε ζώο με βάση τον κωδικό:");
                        String input = scanner.nextLine();
                        int id = Integer.valueOf(input);
                        for (Animal animal : AnimalList) {
                            if (id == animal.getId()) {
                                AnimalList.remove(animal);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Δε βρέθηκε ο συγκεκριμένος κωδικός στον κατάλογο!\n");
                        }
                        not_integer = false;
                        fileManagement.WriteFile(AnimalList);

                    } catch (NumberFormatException e) {
                        System.out.println("Παρακαλώ συμπληρώστε ακέραιο αριθμό.");
                        not_integer = true;
                    }
                }
            }

            else if (code.equals("7")) {
                System.out.println("Πραγματοποιήθηκε έξοδος από το σύστημα.\n" +
                        "Ευχαριστούμε για την χρήση της εφαρμογής!");
                break;
            }

            else {
                System.out.println("Λάθος είσοδος!!!!\n");
                flag = true;
            }

            //Ερώτηση για να γυρίσω σε μενού η να τερματίσω την εφαρμογή.
            // Διευκολύνει τον χρήστη να δει πρώτα τα αποτελέσματα και να του εμφανίζεται απευθείας το μενού μετά από την ολοκλήρωση κάποιας διαδικασίας.

            while (!flag) {
                System.out.println("Θέλετε να γυρίσετε πίσω στο αρχικό μενού? y/n");
                String go_back = scanner.nextLine();
                if (go_back.equals("y")) {
                    flag = true;
                } else if (go_back.equals("n")) {
                    break;
                } else {
                    System.out.println("Λάθος είσοδος");
                    flag = false;
                }
            }
        }
    }

}
