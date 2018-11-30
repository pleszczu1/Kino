package KinoBaza.model;

import KinoBaza.controller.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class Bilety {


    public Bilety() throws SQLException {
        Scanner input = new Scanner(System.in);
        Controller uck = new Controller();

        System.out.println("----------Witaj w klasie Bilety");

        while (true) {
            System.out.println("K - kup bilet, P - pokaż bilety, U - usuń bilet, W- wyjście");
            String dec = input.nextLine().toUpperCase();

            if(dec.equals("K")){
                System.out.println("Podaj id filmu na jaki chcesz kupoć bilety: ");
                int idFilm = input.nextInt();
                input.nextLine();
                System.out.println("Podaj ilość biletów:");
                String ilosc = input.nextLine();
                uck.addBilety(ilosc, idFilm);
            }
            else if (dec.equals("P")){
                System.out.println("Lista filmów: ");
                uck.showBilety();
            }
            else if(dec.equals("U")){
                System.out.println("Podaj ID filmu do usunięcia: ");
                int id = input.nextInt();
                input.nextLine();
                uck.deleteBilety(id);
            }
            else if(dec.equals("W")){
                break;
            }

        }
    }

}
