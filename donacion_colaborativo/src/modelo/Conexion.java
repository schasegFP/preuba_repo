/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
/**
 *
 * @author Alumno Tarde
 */
class Conexion {
    
    Connection dbConn;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";   
    String user = "system";
    String pass = "1234";
    
    public Connection conectar(){
        try {
            dbConn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con la base de datos");
            System.exit(1);
        }
        return dbConn;
    }
    
}
