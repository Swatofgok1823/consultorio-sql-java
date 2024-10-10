package modelo;

import java.sql.*;
import java.util.Map;

public class HashMap {

    private Connection conexion;

    public HashMap() {
        conexion = Conexion.Conecta(); // Usa tu clase 'Conexion' para obtener la conexión
        System.out.println("Conexión establecida con la base de datos.");
    }

    public String agregarElemento(String key, Consultorio consultorio) {
        String mensaje;

        try {
            String query = "INSERT INTO Consultorios (codigo, nombreUsuario, tipoCaso, activo_noActivo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, key);
            ps.setString(2, consultorio.getNombreUsuario());
            ps.setString(3, consultorio.getTipoCaso());
            ps.setString(4, consultorio.getActivo_noActivo());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Caso registrado con éxito";
            } else {
                mensaje = "Error al registrar el caso";
            }
        } catch (SQLException e) {
            mensaje = "Error en la inserción: " + e.getMessage();
        }

        return mensaje;
    }

    public String recorrerLista() {
        StringBuilder mostrarLista = new StringBuilder();

        try {
            String query = "SELECT * FROM Consultorios";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                mostrarLista.append("Código: ").append(rs.getString("codigo"))
                        .append(", Usuario: ").append(rs.getString("nombreUsuario"))
                        .append(", Tipo de Caso: ").append(rs.getString("tipoCaso"))
                        .append(", Activo: ").append(rs.getString("activo_noActivo"))
                        .append("\n");
            }
        } catch (SQLException e) {
            return "Error al recuperar lista: " + e.getMessage();
        }

        return mostrarLista.toString();
    }

    public String buscarCodigo(String codigo) {
        StringBuilder mensaje = new StringBuilder();

        try {
            String query = "SELECT * FROM Consultorios WHERE codigo = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mensaje.append("Código: ").append(rs.getString("codigo"))
                        .append(", Usuario: ").append(rs.getString("nombreUsuario"))
                        .append(", Tipo de Caso: ").append(rs.getString("tipoCaso"))
                        .append(", Activo: ").append(rs.getString("activo_noActivo"))
                        .append("\n");
            } else {
                mensaje.append("Caso no encontrado.");
            }
        } catch (SQLException e) {
            return "Error en la búsqueda: " + e.getMessage();
        }

        return mensaje.toString();
    }

    public String eliminar(String codigo) {
        String mensaje;

        try {
            String query = "DELETE FROM Consultorios WHERE codigo = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codigo);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Caso eliminado con éxito";
            } else {
                mensaje = "El caso no se encontró en el sistema";
            }
        } catch (SQLException e) {
            mensaje = "Error en la eliminación: " + e.getMessage();
        }

        return mensaje;
    }

    public String modificarNombre(String nombreUsuario, String nuevonombre) {
        String mensaje;

        try {
            String query = "UPDATE Consultorios SET nombreUsuario = ? WHERE nombreUsuario = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevonombre);
            ps.setString(2, nombreUsuario);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Nombre modificado con éxito";
            } else {
                mensaje = "El usuario no se encontró en el sistema";
            }
        } catch (SQLException e) {
            mensaje = "Error en la actualización: " + e.getMessage();
        }

        return mensaje;
    }
}

