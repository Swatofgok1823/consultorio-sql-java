package vista;

import Controlador.Controlador_Usuarios;
import modelo.Usuarios;

import javax.swing.*;
import java.util.InputMismatchException;

public class Vista_Usuario {
    private int numeroCaso;
    private String tipoCaso;
    private String nombreUsuario;
    private String activo_noActivo;



    public int menu() {
        int opcion = 0;
        while (opcion < 1 || opcion > 5) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "MENU\n\n" +
                                "1. Usuario Consultorio\n" +
                                "2. Estudiante Consultorio\n" +
                                "3. Profesor consultorio\n" +
                                "4. Administrador Consultorio\n" +
                                "5. salir\n" +
                                "¿Qué tipo de usuario eres?");
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }
        return opcion;
    }

    public String rol(int opcion) {
        String mensaje = "";

        switch (opcion) {
            case 1:
                mensaje = "Usuario";
                break;
            case 2:
                mensaje = "Estudiante";
                break;
            case 3:
                mensaje = "Profesor";
                break;
            case 4:
                mensaje = "Administrador";
                break;
            default:
                mensaje = ""; // Esto nunca debería ocurrir si la opción es válida (1 a 4)
        }

        return mensaje;
    }




    public String ingresoUsuario1() {
        return JOptionPane.showInputDialog("Digite su usuario:");
    }

    public String ingresoUsuario2() {
        return JOptionPane.showInputDialog("Digite su contraseña:");
    }

    public String ingresoEstu1() {
        return JOptionPane.showInputDialog("Digite el usuario del estudiante con el que va a ingresar:");
    }

    public String ingresoEstu2() {
        return JOptionPane.showInputDialog("Digite la clave del estudiante con el que va a ingresar:");
    }

    public String ingresoProfe1() {
        return JOptionPane.showInputDialog("Digite el usuario del profesor con el que va a ingresar:");
    }

    public String ingresoProfe2() {
        return JOptionPane.showInputDialog("Digite la clave del profesor con el que va a ingresar:");
    }

    public String ingresoAdmi1() {
        return JOptionPane.showInputDialog("Digite el usuario del administrador con el que va a ingresar:");
    }

    public String ingresoAdmi2() {
        return JOptionPane.showInputDialog("Digite la clave del administrador con el que va a ingresar:");
    }



    public int menuAdmin() {
        int opcion2 = 0;
        while (opcion2 < 1 || opcion2 > 8) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "1. Agregar\n" +
                                "2. Modificar\n" +
                                "3. Eliminar\n" +
                                "4. Mostrar Estudiantes\n" +
                                "5. Apartado Recursos legales\n" +
                                "6. Gestion de casos\n" +
                                "7. Apartado Informacion\n" +
                                "8. Salir\n\n" +
                                "¿Qué deseas hacer?");
                opcion2 = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }
        return opcion2;
    }


    public String agregarUser() {
        return JOptionPane.showInputDialog("Digite el usuario del estudiante que deseas agregar:");
    }

    public String agregarUserClave() {
        return JOptionPane.showInputDialog("Digite la contraseña del estudiante que deseas agregar:");
    }

    public String modificarUser1() {
        return JOptionPane.showInputDialog("Digite el usuario que deseas modificar:");
    }

    public String modificarUser2() {
        return JOptionPane.showInputDialog("Digite el nuevo ususaario:");
    }

    public String modificarUser3() {
        return JOptionPane.showInputDialog("Digite la nueva contraseña:");
    }

    public String eliminarUser() {
        return JOptionPane.showInputDialog("Digite el usuario del estudiante que deseas eliminar:");
    }




    public void imprimirUser(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void Conectar() {
        Controlador_Usuarios control = new Controlador_Usuarios();
        control.control();
    }

    //------------------------------------------------------------------------------------------------

    private  int codigo;
    private String nombre  =  "";
    private String significado = "";

    public int menu10() {
        int opcion = 0;

        while (true){
            String input = JOptionPane.showInputDialog(
                    "1. Recursos legales\n" +
                            "2. Gestion de casos\n" +
                            "3. Informacion\n" +
                            "4. salir\n" +
                            "Escoge la opcion");
            opcion = Integer.parseInt(input);
            return opcion;
        }
    }
    public int menu2() {
        int opcion = 0;

        while (true){
            String input = JOptionPane.showInputDialog(
                    "1. Mostrar recursos legales\n" +
                            "2. Buscar recursos legales\n" +
                            "3. salir\n" +
                            "Escoge la opcion");
            opcion = Integer.parseInt(input);
            return opcion;
        }
    }

    public int menu3() {
        int opcion = 0;
        while (opcion < 1 || opcion > 6) {
            try {
                String input = JOptionPane.showInputDialog(null,
                        "1. Agregar recurso legal\n" +
                                "2. Buscar recurso legal\n" +
                                "3. Modificar recurso legal \n" +
                                "4. Eliminar recurso legal\n" +
                                "5. Mostrar todos los recusos legales\n" +
                                "6. salir\n" +
                                "Escoge la opcion");
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
            }
        }
        return opcion;
    }


    public int codigo(){
        try {
            String input = JOptionPane.showInputDialog("\n ingresa el codigo del recurso ");
            codigo = Integer.parseInt(input);
        }catch (InputMismatchException e){
            String input = JOptionPane.showInputDialog("\n ingresa el codigo del recurso ");
            codigo = Integer.parseInt(input);
        }

        return codigo;
    }

    public String nombre(){
        String input = JOptionPane.showInputDialog("ingresa el nombre de tu recurso :");
        nombre = String.format(input);

        return nombre;
    }

    public String significado(){
        String input = JOptionPane.showInputDialog("escribe lo que sigfica el recurso :");
        significado = String.format(input);
        return significado;
    }

    public String modifi(){
        String input = JOptionPane.showInputDialog("ingresa el nuevo nombre del recurso :");
        nombre = String.format(input);
        return nombre;
    }
//------------------------------------------------------------------------------------------------

    public String capturaNumero() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese número del caso:");
                if (input == null) return null; // si el usuario cancela
                Integer.parseInt(input); // Validar que sea un número
                return input;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un número válido.");
            }
        }
    }

    public String capturaTipoCaso() {
        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese tipo del caso:");
            if (input != null && !input.trim().isEmpty()) {
                tipoCaso = input;
                return tipoCaso;
            } else {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un tipo válido.");
            }
        }
    }

    public String capturaNombre() {
        while (true) {
            String input = JOptionPane.showInputDialog("Ingrese nombre del usuario:");
            if (input != null && !input.trim().isEmpty()) {
                nombreUsuario = input;
                return nombreUsuario;
            } else {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un nombre válido.");
            }
        }
    }

    public String capturaActivo() {
        while (true) {
            String input = JOptionPane.showInputDialog("¿El caso se encuentra activo/inactivo?:");
            if (input != null && (input.equalsIgnoreCase("activo") || input.equalsIgnoreCase("inactivo"))) {
                activo_noActivo = input;
                return activo_noActivo;
            } else {
                JOptionPane.showMessageDialog(null, "Estado inválido. Digite activo o inactivo.");
            }
        }
    }


    public int menuProfesor() {
        int opcion = 8;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(
                        "1. Agregar caso\n" +
                                "2. Buscar caso\n" +
                                "3. Modificar caso\n" +
                                "4. Eliminar caso\n" +
                                "5. Mostrar lista de casos\n" +
                                "6. Cerrar programa\n" +
                                "\n¿Qué desea hacer el día de hoy?");
                opcion = Integer.parseInt(input);
                return opcion;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un número válido.");
            }
        }
    }



    public int buscarPor() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(
                        "1. Nombre de usuario, tipo de caso, estado del caso\n" +
                                "2. Número del caso\n" +
                                "\n¿Por qué atributo desea buscar?");
                int busc = Integer.parseInt(input);
                return busc;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese 1 o 2.");
            }
        }
    }

    public String capturaStrBuscar() {
        return JOptionPane.showInputDialog("Digite nombre de usuario, tipo de caso, estado del caso:");
    }
    public String capturaStrkey() {
        return JOptionPane.showInputDialog("Digite numero del caso:");
    }

    public int capturaIntBuscar() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Digite número del caso:");
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un número.");
            }
        }
    }

    public String capturaEleminar() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese número del caso que desea eliminar:");
                Integer.parseInt(input); // Validar que sea un número
                return input;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un número.");
            }
        }
    }
    public int menug_1() {
        int opcion = 8;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(
                        "1. Agregar caso\n" +
                                "2. Buscar caso\n" +
                                "3. Modificar caso\n" +
                                "0. Cerrar programa\n" +
                                "\n¿Qué desea hacer el día de hoy?");
                opcion = Integer.parseInt(input);
                return opcion;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "!!ERROR!!: Ingrese un número válido.");
            }
        }
    }

    public String capturaACambiar() {
        return JOptionPane.showInputDialog("Digite el nombre de usuario que desea cambiar:");
    }

    public String cambioNombre() {
        return JOptionPane.showInputDialog("Digite nombre del usuario:");
    }


    public void imprimir(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public int menu6() {
        String menu = "1. Agregar noticia\n" +
                "2. mostrar noticia\n" +
                "3. Editar \n" +
                "4. Eliminar \n" +
                "5. Salir\n" +
                "Elija una opción:";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public int menuEditar() {
        String menu = "1. Editar fecha\n" +
                "2. Editar nombre\n" +
                "3. Editar descripcion\n" +
                "4. Editar rama\n" +
                "5. Salir\n" +
                "Elija una opción:";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    public String agregarFecha() {
        return JOptionPane.showInputDialog("Agrega una fecha:");
    }

    public String agrega2() {
        return JOptionPane.showInputDialog("Digita el nombre de la noticia:");
    }

    public String agrega3() {
        return JOptionPane.showInputDialog("Digite la categoria de la noticia:");
    }

    public String agrega4() {
        return JOptionPane.showInputDialog("Digite el link :");
    }

    public String agrega5() {
        return JOptionPane.showInputDialog("Digite la rama:");
    }
    public String editafeche() {
        return JOptionPane.showInputDialog("escoja la fecha que quiere editar:");
    }
    public String fechaeditada() {
        return JOptionPane.showInputDialog("Digite la nueva fecha:");
    }

    public String editarnombre() {
        return JOptionPane.showInputDialog("Escoja el nombre que quiere editar:");
    }
    public String nombreeditada() {
        return JOptionPane.showInputDialog("Digite el nuevo nombre:");
    }

    public String editarDescripcion() {
        return JOptionPane.showInputDialog("Escoja la descripcion que va editar:");
    }
    public String descripcionEditada() {
        return JOptionPane.showInputDialog("Digite la nueva descripcion:");
    }

    public String editarrama() {
        return JOptionPane.showInputDialog("Digite la rama que va editar :");
    }

    public String ramaeditada() {
        return JOptionPane.showInputDialog("Digite la nueva rama:");
    }
    public String eliminada() {
        return JOptionPane.showInputDialog("Digite el nombre de la noticia qu quiere eliminar:");
    }

}