package modelo;


public class Usuarios {
    public String usuario;
    public String clave;
    public String rol;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    public void setClave(String clave) {
        this.clave = clave; // Debes agregar esto
    }


    public Usuarios(String usuario, String clave, String rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }



    @Override
    public String toString() {
        return "Usuarios{" +
                "usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", rol='" + rol + '\'' +
                "}\n";
    }


}

