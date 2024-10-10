package modelo;

public class Consultorio {


        private String tipoCaso;
        private String nombreUsuario;
        private String activo_noActivo;

        private int contador;

        public Consultorio(String tipoCaso, String nombreUsuario, String activo_noActivo) {
            this.tipoCaso = tipoCaso;
            this.activo_noActivo = activo_noActivo;
            this.nombreUsuario = nombreUsuario;

        }

    /* public Consultorio( String tipoCaso, boolean activo_noActivo) {
        this.getNumeroCaso();
        this.tipoCaso = tipoCaso;
        this.activo_noActivo = activo_noActivo;
    }*/



        public String getTipoCaso() {
            return tipoCaso;
        }

        public void setTipoCaso(String tipoCaso) {
            this.tipoCaso = tipoCaso;
        }

        public String isActivo_noActivo() {
            return activo_noActivo;
        }

        public String getActivo_noActivo() {
            return activo_noActivo;
        }

        public void setActivo_noActivo(String activo_noActivo) {
            this.activo_noActivo = activo_noActivo;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        @Override
        public String toString() {
            return  ", tipoCaso='" + tipoCaso + '\'' +
                    ", nombreUsuario='" + nombreUsuario + '\'' +
                    ", activo_noActivo='" + activo_noActivo + '\'' +
                    '}';
        }

        //metodos

        private int generarNumeroCaso(){

            for (int i=0; i<1;i++){
                this.contador+=1;
            }

            return this.contador;
        }
    }

