package modelo;

public class Recursos {
    public  String recurso = "";
    public String significado = "";

    public Recursos() {
    }

    public Recursos(String recurso, String significado) {
        this.recurso = recurso;
        this.significado = significado;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getEscrito() {
        return significado;
    }

    public void setEscrito(String escrito) {
        this.significado = escrito;
    }

    @Override
    public String toString() {
        return
                "nombre recurso :" + recurso + " \n   " +
                        "significado    :" + significado + "\n";
    }
}