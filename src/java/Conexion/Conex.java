
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conex {
    static String bd = "porteria";
    static String user = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost:3306/" + bd;
    
    Connection conn = null;
    
    public Conex(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Exito en Conexion");
            }
        } catch (Exception e) {
            System.out.println("Error en Conexion" + e);
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar() throws Exception{
        conn.close();
    }
}
