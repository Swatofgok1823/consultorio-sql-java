package modelo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Modeloinfo {

    private Connection conexion;
    public Map<String, Informacion> informacion = new HashMap<>();

    public Modeloinfo() {
        conexion = Conexion.Conecta(); // Usando la clase de conexión para la base de datos
        System.out.println("Conexión establecida con la base de datos.");
    }

    // Método para agregar una noticia
    public String agregarnoticia(Informacion nombre) {
        String mensaje;

        try {
            String query = "INSERT INTO Informacion (nombre, fecha, descripcion, rama) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre.getNombre());
            ps.setString(2, nombre.getFecha());
            ps.setString(3, nombre.getDescripcion());
            ps.setString(4, nombre.getRama());

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Noticia registrada con éxito.";
            } else {
                mensaje = "Error al registrar la noticia.";
            }
        } catch (SQLException e) {
            mensaje = "Error al agregar noticia: " + e.getMessage();
        }

        return mensaje;
    }

    // Método para editar la fecha de una noticia
    public void editarFecha(String referencia, String nuevaFecha) {
        try {
            String query = "UPDATE Informacion SET fecha = ? WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevaFecha);
            ps.setString(2, referencia);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("Fecha actualizada correctamente.");
            } else {
                System.out.println("La noticia no se encontró.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la fecha: " + e.getMessage());
        }
    }

    // Método para editar el nombre de una noticia
    public void editarnombre(String referencia, String nuevoNombre) {
        try {
            String query = "UPDATE Informacion SET nombre = ? WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevoNombre);
            ps.setString(2, referencia);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("Nombre actualizado correctamente.");
            } else {
                System.out.println("La noticia no se encontró.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el nombre: " + e.getMessage());
        }
    }

    // Método para editar la descripción de una noticia
    public void editarDescripcion(String referencia, String nuevaDescripcion) {
        try {
            String query = "UPDATE Informacion SET descripcion = ? WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevaDescripcion);
            ps.setString(2, referencia);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("Descripción actualizada correctamente.");
            } else {
                System.out.println("La noticia no se encontró.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la descripción: " + e.getMessage());
        }
    }

    // Método para editar la rama de una noticia
    public void editarRama(String referencia, String nuevaRama) {
        try {
            String query = "UPDATE Informacion SET rama = ? WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nuevaRama);
            ps.setString(2, referencia);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("Rama actualizada correctamente.");
            } else {
                System.out.println("La noticia no se encontró.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la rama: " + e.getMessage());
        }
    }

    // Método para eliminar una noticia
    public String eliminarNoticia(String nombreNoticia) {
        String mensaje;

        try {
            String query = "DELETE FROM Informacion WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreNoticia);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mensaje = "Noticia eliminada correctamente.";
            } else {
                mensaje = "La noticia no se encontró.";
            }
        } catch (SQLException e) {
            mensaje = "Error al eliminar noticia: " + e.getMessage();
        }

        return mensaje;
    }

    // Método para mostrar todas las noticias
    public String mostrarLista() {
        StringBuilder listaNoticias = new StringBuilder();

        try {
            String query = "SELECT * FROM Informacion";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String fecha = rs.getString("fecha");
                String descripcion = rs.getString("descripcion");
                String rama = rs.getString("rama");
                listaNoticias.append("Nombre: ").append(nombre)
                        .append(", Fecha: ").append(fecha)
                        .append(", Descripción: ").append(descripcion)
                        .append(", Rama: ").append(rama)
                        .append("\n");
            }
        } catch (SQLException e) {
            return "Error al mostrar la lista: " + e.getMessage();
        }

        return listaNoticias.toString();
    }
}
