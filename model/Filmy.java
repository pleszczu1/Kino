package KinoBaza.model;

import KinoBaza.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Filmy {

    public Filmy() throws SQLException {

        Scanner input = new Scanner(System.in);
        Controller uck = new Controller();

        System.out.println("----------Witaj w klasie Filmy");

        while (true) {
            System.out.println("P - pokaż filmy, D - dodaj film, U - usuń film, W- wyjście");
            String dec = input.nextLine().toUpperCase();

            if (dec.equals("P")){
                System.out.println("Lista filmów: ");
                uck.showFilmy();
            }
            else if(dec.equals("D")){
                System.out.println("Podaj tytuł filmu: ");
                String film = input.nextLine();
                System.out.println("Podaj id kina w którym jest grany film:");
                int id = input.nextInt();
                input.nextLine();
                uck.addFilmy(film, id);
            }
            else if(dec.equals("U")){
                System.out.println("Podaj ID filmu do usunięcia: ");
                int id = input.nextInt();
                input.nextLine();
                uck.deleteFilmy(id);
            }
            else if(dec.equals("W")){
                break;
            }
        }
    }
}
