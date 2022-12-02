package com.company;

import java.io.*;
import java.util.List;

public class FileManagement {

    public void readfile(List<Animal> animalList){

        try {
            FileInputStream fileInputStream = new FileInputStream("myzoo.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean revise=true; // Διαβάζω αρχείο μέχρι να τελειώσουν τα αποθηκευμένα objects.
            while (revise){
                Animal a2=(Animal) objectInputStream.readObject();
                if(a2 != null){
                    animalList.add(a2);
                }
                else {
                    revise=false;
                    objectInputStream.close();
                    fileInputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        }
    }
    public void WriteFile(List<Animal> AnimalList){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("myzoo.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Animal animal : AnimalList) {
                objectOutputStream.writeObject(animal);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Επιτυχής ενέργεια!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
