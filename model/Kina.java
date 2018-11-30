package KinoBaza.model;

import KinoBaza.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Kina {

    public Kina() throws SQLException {

        Scanner input = new Scanner(System.in);
        Controller uck = new Controller();

        System.out.println("----------Witaj w klasie Kino");

        while (true){
            System.out.println("P - pokaż kina, D - dodaj kino, U - usuń kino, W- wyjście");
            String dec = input.nextLine().toUpperCase();

            if (dec.equals("P")){
                System.out.println("Lista kin: ");
                uck.showKina();
            }
            else if(dec.equals("D")){
                System.out.println("Podaj nazwę kina: ");
                String kino = input.nextLine();
                uck.addKino(kino);
            }
            else if(dec.equals("U")){
                System.out.println("Podaj ID kina do usunięcia: ");
                int id = input.nextInt();
                input.nextLine();
                uck.deleteKino(id);
            }
            else if(dec.equals("W")){
                break;
            }
        }

    }

}
