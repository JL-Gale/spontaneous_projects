package com.jlgale;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbConector dbConector = new DbConector();
        int operation = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select the operation");
            System.out.println("1)Salve\n2)Delete\n3)Update\n4)See\n5)Exit");
            operation = sc.nextInt();
            switch (operation) {
                case 1: {
                    //Guardar - CREATE
                    // Consulta SQL
                    String query = "INSERT INTO test (fecha) VALUES (CURRENT_DATE)";
                    try(Connection cn = dbConector.conexion()) {
                        try(PreparedStatement pstmt = cn.prepareStatement(query)) {
                            pstmt.executeUpdate();
                            System.out.println("A new record was created");
                        }
                    } catch (SQLException | ClassNotFoundException e){
                        System.err.println("Error: "+e.getMessage());
                    }
                    break;
                }
                case 2: {
                    mostrar(dbConector);
                    System.out.println("Enter the id you want to deleted");
                    int id = sc.nextInt();
                    String query = "DELETE FROM test WHERE id = "+id;
                    try(Connection cn = dbConector.conexion()) {
                        try(PreparedStatement pstmt = cn.prepareStatement(query)) {
                            int row = pstmt.executeUpdate();
                            if (row > 0) {
                                System.out.println("The record is deleted");
                            } else {
                                System.out.println("Registration ID not found");
                            }
                        }
                    } catch (SQLException  | ClassNotFoundException e){
                        System.err.println("Error: "+e.getMessage());
                    }
                    System.out.println("");
                    break;
                }
                case 3: {
                    try(Connection cn = dbConector.conexion()) {
                        try(PreparedStatement pstmt = cn.prepareStatement("UPDATE test SET fecha = ? WHERE id = ?")) {
                            System.out.println("Enter the ID");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter the new date value in YYYY-MM-DD format");
                            String date = sc.nextLine();

                            pstmt.setInt(2, id);
                            pstmt.setString(1, date);

                            // Ejecutar la actualización
                            int filasAfectadas = pstmt.executeUpdate();

                            // Verificar si la actualización fue exitosa
                            if (filasAfectadas > 0) {
                                System.out.println("Update successful");
                            } else {
                                System.out.println("The user with the specified ID was not found.");
                            }
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(" ");
                    break;
                }
                case 4: {
                    mostrar(dbConector);
                    System.out.println(" ");
                    break;
                }
                case 5: {
                    System.out.println("Bye");
                    return;
                }
                default:
                    System.out.println("Error when choosing the options");
            }
        }
    }

    static void mostrar(DbConector dbConector) {
        try(Connection cn = dbConector.conexion()) {
            try(PreparedStatement pstmt = cn.prepareStatement("SELECT * FROM test")) {
                try(ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String date = rs.getString("fecha");
                        System.out.println("Id: "+id+" Fecha: "+date);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}