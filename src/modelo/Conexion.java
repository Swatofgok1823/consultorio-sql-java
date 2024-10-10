package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String db = "cjjava";
    private static String url = "jdbc:mysql://127.0.0.1:3306/" + db;
    private static String user = "root";
    private static String pass = "1123038259";

    private static Connection conec = null;

    public static Connection Conecta() {
        try {
            // Registrar el controlador (opcional en versiones recientes)
            Class.forName("com.mysql.cj.jdbc.Driver");

            conec = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión Ok");
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e);
        }
        return conec;
    }

}

