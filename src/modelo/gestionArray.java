package modelo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class gestionArray {


    private Connection conexion;
    public Map<String, Usuarios> mapUsuarios = new HashMap<>();

    public gestionArray() {
        conexion = Conexion.Conecta(); // Obtiene la conexión
        if (conexion == null) {
            System.out.println("Error: No se pudo establecer conexión a la base de datos.");
        }
    }

    public String agregarUsuario(Usuarios usuario) {
        String mensaje;
        if (conexion == null) {
            return "Error: No hay conexión a la base de datos.";
        }

        try {
            String query = "INSERT INTO Usuarios (usuario, clave, rol) VALUES (?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getClave());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Usuario registrado con éxito.";
            } else {
                mensaje = "Error al registrar el usuario.";
            }
        } catch (SQLException e) {
            mensaje = "Error al agregar usuario: " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarUsuario(String nombreUsuario, String nuevoNombreUsuario, String nuevaClave) {
        String mensaje;

        try {
            String query = "UPDATE Usuarios SET usuario = ?, clave = ? WHERE usuario = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevoNombreUsuario);
            ps.setString(2, nuevaClave);
            ps.setString(3, nombreUsuario);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Usuario modificado correctamente.";
            } else {
                mensaje = "El usuario no se encontró en el sistema.";
            }
        } catch (SQLException e) {
            mensaje = "Error al modificar usuario: " + e.getMessage();
        }

        return mensaje;
    }

    public String eliminarUsuario(String nombreUsuario) {
        String mensaje;

        try {
            String query = "DELETE FROM Usuarios WHERE usuario = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreUsuario);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Usuario eliminado correctamente.";
            } else {
                mensaje = "El usuario no se encontró en el sistema.";
            }
        } catch (SQLException e) {
            mensaje = "Error al eliminar usuario: " + e.getMessage();
        }

        return mensaje;
    }

    public String mostrarLista() {
        StringBuilder listaUsuarios = new StringBuilder();

        try {
            String query = "SELECT * FROM Usuarios";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String clave = rs.getString("clave");
                listaUsuarios.append("Usuario: ").append(usuario)
                        .append(", Clave: ").append(clave)
                        .append("\n");
            }
        } catch (SQLException e) {
            return "Error al mostrar la lista: " + e.getMessage();
        }

        return listaUsuarios.toString();
    }
}
