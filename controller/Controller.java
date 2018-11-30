package KinoBaza.controller;


import KinoBaza.database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

    DBConnect dao = new DBConnect();

    // Klasa Kina

    public void showKina() throws SQLException {
        String pokazSQL = "SELECT * FROM kino ";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(pokazSQL);
        while(rs.next()){
            System.out.println(rs.getInt("ID") + " " + rs.getString("nazwa"));
        }
        st.close();
    }

    public void addKino(String nazwa) throws SQLException {
        String insertSQL = "INSERT INTO kino(nazwa) VALUES (?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, nazwa);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }

    public void deleteKino(int id) throws SQLException {
        String deleteSQL = "DELETE FROM kino WHERE ID=" + id + "";
        PreparedStatement st = dao.getCon().prepareStatement(deleteSQL);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }

    //Klasa Filmy

    public void showFilmy() throws SQLException {
        String pokazSQL = "SELECT f.id, f.nazwa as 'f_nazwa', k.nazwa as 'k_nazwa' FROM filmy f INNER JOIN kino k ON k.id = f.kino_ID";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(pokazSQL);
        while(rs.next()){
            System.out.println(rs.getInt("ID") + " film: " + rs.getString("f_nazwa") + " grają w kinie: " + rs.getString("k_nazwa"));
        }
        st.close();
    }

    public void addFilmy(String film,int id) throws SQLException {
        String insertSQL = "INSERT INTO filmy(nazwa, kino_ID) VALUES (?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, film);
        st.setInt(2, id);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }

    public void deleteFilmy(int id) throws SQLException {
        String deleteSQL = "DELETE FROM filmy WHERE ID=" + id + "";
        PreparedStatement st = dao.getCon().prepareStatement(deleteSQL);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }

    // Klasa Bilety

    public void addBilety(String ilosc, int idFilm) throws SQLException {
        String insertSQL = "INSERT INTO bilety(ilosc, filmy_ID) VALUES (?, ?)";
        PreparedStatement st = dao.getCon().prepareStatement(insertSQL);
        st.setString(1, ilosc);
        st.setInt(2, idFilm);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }

    public void showBilety() throws SQLException {
        String pokazSQL = "SELECT b.ID, b.filmy_ID, b.ilosc, f.nazwa as 'f_nazwa', k.nazwa as 'k_nazwa' FROM bilety b INNER JOIN filmy f ON b.filmy_ID = f.ID INNER JOIN kino k ON f.kino_ID = k.ID";
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery(pokazSQL);
        while(rs.next()){
            System.out.println(rs.getInt("ID") + " film: " + rs.getString("f_nazwa") + " grają w kinie: " + rs.getString("k_nazwa") + " kupiłeś " + rs.getString("ilosc") + " biletów");

        }
        st.close();
    }

    public void deleteBilety(int id) throws SQLException {
        String deleteSQL = "DELETE FROM bilety WHERE ID=" + id + "";
        PreparedStatement st = dao.getCon().prepareStatement(deleteSQL);
        st.execute();
        st.close();

        System.out.println("Czy chcesz zatwierdzić wprowadzone dane: T/N: ");
        Scanner sc = new Scanner(System.in);
        String decyzja = sc.nextLine().toUpperCase();
        if(decyzja.equals("T")){
            dao.getCon().commit();
        }else{
            dao.getCon().rollback();
        }
    }
}
