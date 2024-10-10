package modelo;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;


public class Array {

    private Connection conexion;
    public Map<String, Recursos> recursosLegales = new HashMap<>();

    public Array() {
        conexion = Conexion.Conecta(); // Usa tu clase 'Conexion' para obtener la conexión
        System.out.println("Conexión establecida con la base de datos.");
    }

    private void actualizarDatos() {
        // Este método no es necesario para la base de datos, pero podrías usarlo para actualizaciones específicas si fuera necesario.
    }

    public String agregarRecurso(String codigo, Recursos recurso) {
        String mensaje;

        try {
            String query = "INSERT INTO RecursosLegales (codigo, recurso, escrito) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codigo);
            ps.setString(2, recurso.getRecurso());
            ps.setString(3, recurso.getEscrito());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Recurso legal agregado con éxito.";
            } else {
                mensaje = "Error al agregar el recurso legal.";
            }
        } catch (SQLException e) {
            mensaje = "Error en la inserción: " + e.getMessage();
        }

        return mensaje;
    }

    public String buscarRecursoLegal(int numero) {
        String mensaje = "";

        try {
            String query = "SELECT * FROM RecursosLegales WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String recurso = rs.getString("recurso");
                String escrito = rs.getString("escrito");
                mensaje = "Recurso encontrado: " + recurso + "\nEscrito: " + escrito;
                JOptionPane.showInputDialog(mensaje);
            } else {
                mensaje = "El recurso legal no se encuentra en la lista.";
                JOptionPane.showInputDialog(mensaje);
            }
        } catch (SQLException e) {
            mensaje = "Error en la búsqueda: " + e.getMessage();
        }

        return mensaje;
    }

    public String modificarRecursoLegal(int numero, String nuevoRecurso, String nuevoEscrito) {
        String mensaje;

        try {
            String query = "UPDATE RecursosLegales SET recurso = ?, escrito = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevoRecurso);
            ps.setString(2, nuevoEscrito);
            ps.setInt(3, numero);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Recurso legal modificado correctamente.";
            } else {
                mensaje = "El recurso legal no se encontró en la lista.";
            }
        } catch (SQLException e) {
            mensaje = "Error en la actualización: " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarRecursoLegal(int numero) {
        String mensaje;

        try {
            String query = "DELETE FROM RecursosLegales WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, numero);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Recurso legal eliminado correctamente.";
            } else {
                mensaje = "El recurso legal no se encontró en la lista.";
            }
        } catch (SQLException e) {
            mensaje = "Error en la eliminación: " + e.getMessage();
        }

        return mensaje;
    }

    public String recorrer() {
        StringBuilder mensaje = new StringBuilder();

        try {
            String query = "SELECT * FROM RecursosLegales";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String recurso = rs.getString("recurso");
                String escrito = rs.getString("escrito");

                mensaje.append("Código: ").append(codigo)
                        .append(", Recurso: ").append(recurso)
                        .append(", Escrito: ").append(escrito)
                        .append("\n");
            }

            JOptionPane.showInputDialog(mensaje.toString());
        } catch (SQLException e) {
            return "Error al recuperar los datos: " + e.getMessage();
        }

        return mensaje.toString();
    }
}
