package DataBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hp
 */
public class pruebasJdbc {
    
    private Connection conexion = null;
    private String name = "crud_spring";
    private String user = "root";
    private String password = "1234";
    private String host = "localhost";
    private String port = "3306";
    
    public Connection establecerConexion(){
        if (conexion != null) {
            return conexion;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }  
    public static void main(String[] args) {
        pruebasJdbc prueba = new pruebasJdbc();
        prueba.establecerConexion();
    }
}
