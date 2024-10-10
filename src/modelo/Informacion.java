package modelo;

public class Informacion  {
    private String fecha;
    private String nombre;
    private String descripcion;
    private String link;
    private String rama;

    public Informacion(String fecha, String nombre, String descripcion, String link, String rama) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.rama = rama;
    }

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "fecha='" + fecha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", link='" + link + '\'' +
                ", rama='" + rama + '\'' +
                '}';
    }
}
