package KinoBaza;

import KinoBaza.controller.Controller;
import KinoBaza.model.Bilety;
import KinoBaza.model.Filmy;
import KinoBaza.model.Kina;

import java.sql.SQLException;
import java.util.Scanner;

public class RunKino {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        Controller uck = new Controller();

        while(true) {
            System.out.println("K - zarządzanie kinami, F - zarządzanie filammi, B - kup bilety, W - wyjście");
            String dec = input.nextLine().toUpperCase();

            if(dec.equals("K")){

                Kina kino = new Kina();
            }
            else if(dec.equals("F")){
                Filmy film = new Filmy();
            }
            else if(dec.equals("B")){
                Bilety bilet = new Bilety();
            }
            else if(dec.equals("W")){
                break;
            }

        }
    }
}
