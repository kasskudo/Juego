/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


// TODO: Auto-generated Javadoc
/**
 * The Class ConectorDB.
 *
 * @author David
 */
public class ConectorDB {
    
    /** The conexion. */
    private Connection conexion = null;
    
    /** The servidor. */
    private String servidor = "";
    
    /** The database. */
    private String database = "Juego"; 
    
    /** The usuario. */
    private String usuario = "root";
    
    /** The password. */
    private String password = "Beyblade_1990";
    
    /** The url. */
    private String url = "";
    
    /**
     * Instantiates a new conector DB.
     *
     * @param servidor the servidor
     * @param database the database
     * @param usuario the usuario
     * @param password the password
     */
    public ConectorDB(String servidor, String database, String usuario, String password){
        try{
            this.servidor = servidor; 
            this.database = database;
            this.url = "jdbc:mysql://" + servidor + "/" + database;
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a la base de datos" + url + "..........ok");
        } catch(SQLException ex){
            System.out.println(ex);
        } catch (ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
    
    /**
     * Gets the conexion.
     *
     * @return the conexion
     */
    public Connection getConexion(){
        return conexion;
    }
    
    /**
     * Cerrar conexion.
     *
     * @return the connection
     */
    public Connection cerrarConexion(){
    try{
    conexion.close();
        System.out.println("Cerrando la conexcion a " + url + ".....ok");
        
    } catch(SQLException ex){
        System.out.println(ex);
    }
    conexion = null;
    return conexion;
    }
    
  
    
}
