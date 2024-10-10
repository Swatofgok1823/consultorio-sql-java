package Controlador;

import modelo.*;
import vista.Vista_Usuario;

public class Controlador_Usuarios {

    Array map = new Array();
    gestionArray lista = new gestionArray();
    HashMap lista_gestion=new HashMap();
    Vista_Usuario v = new Vista_Usuario();
    Modeloinfo hasmap = new Modeloinfo();
    public void control() {
        boolean control = true;
        while (control) {
            int opcion = v.menu();
            switch (opcion) {
                //USUARIO CONSULTORIO
                case 1:
                    Usuarios c = new Usuarios(v.ingresoUsuario1(), v.ingresoUsuario2(), v.rol(opcion));
                    lista.agregarUsuario(c);
                    boolean control2 = true;
                    while(control2){
                        int opcion2 = v.menu10();
                        switch (opcion2){
                            case 1:
                                int opcion23 = v.menu10();
                                switch (opcion23){
                                    case 1:
                                        map.recorrer();
                                        break;
                                    case 2:
                                        String res = map.buscarRecursoLegal(v.codigo());
                                        v.imprimirUser(res);
                                        break;
                                    case 3:
                                        break;
                                }
                            case 2:
                                int opcg_1= v.menug_1();
                                if (opcg_1==1){
                                    String n=v.capturaNumero();
                                    Consultorio x = new Consultorio( v.capturaTipoCaso(), v.capturaNombre(), v.capturaActivo());
                                    v.imprimir(lista_gestion.agregarElemento(n,x));
                                }
                                //opcion 2 del menu
                                if (opcg_1==2){
                                    int buscar=v.buscarPor();

                                    if(buscar==1){
                                        v.imprimir(lista_gestion.buscarCodigo(v.capturaStrBuscar()));
                                    }
                                    if(buscar==2){
                                        v.imprimir(lista_gestion.buscarCodigo(v.capturaStrkey()));
                                    }
                                }
                                //opcion 3
                                if(opcg_1==3){
                                    v.imprimir( lista_gestion.modificarNombre(v.capturaACambiar(),v.cambioNombre()));
                                }
                            case 3:
                                v.imprimirUser(hasmap.mostrarLista());
                                break;
                            case 4:
                                control2 = false;
                                break;
                        }
                    }
                    break;
                //ESTUDIANTE cONSULTORIO
                case 2:
                    Usuarios j = new Usuarios(v.ingresoEstu1(), v.ingresoEstu2(), v.rol(opcion));
                    lista.agregarUsuario(j);
                    boolean control22 = true;

                    while(control22){
                        int opcion1_1 = v.menu10();

                        if(opcion1_1==1){
                            int opcion2 = v.menu2();


                            switch (opcion2){
                                case 1:
                                    map.recorrer();
                                    break;
                                case 2:
                                    String res = map.buscarRecursoLegal(v.codigo());
                                    v.imprimirUser(res);
                                    break;
                                 case 3:
                                     break;
                            }
                        }
                        //------>menu gestion de recursos legales
                        else if (opcion1_1==2) {
                            int opcg_1= v.menug_1();
                            if (opcg_1==1){
                                String n=v.capturaNumero();
                                Consultorio x = new Consultorio( v.capturaTipoCaso(), v.capturaNombre(), v.capturaActivo());
                                v.imprimir(lista_gestion.agregarElemento(n,x));
                            }
                            //opcion 2 del menu
                            if (opcg_1==2){
                                int buscar=v.buscarPor();

                                if(buscar==1){
                                    v.imprimir(lista_gestion.buscarCodigo(v.capturaStrBuscar()));
                                }
                                if(buscar==2){
                                    v.imprimir(lista_gestion.buscarCodigo(v.capturaStrkey()));
                                }
                            }
                            //opcion 3
                            if(opcg_1==3){
                                v.imprimir( lista_gestion.modificarNombre(v.capturaACambiar(),v.cambioNombre()));
                            }


                        }
                        else if (opcion1_1==3) {
                            v.imprimirUser(hasmap.mostrarLista());
                            break;

                        }
                        else if (opcion1_1==4) {
                            control22 = false;
                            break;

                        }

                    }
                    break;
                //PROFESOR CONSULTORIO
                case 3:
                    Usuarios i = new Usuarios(v.ingresoProfe1(), v.ingresoProfe2(), v.rol(opcion));
                    lista.agregarUsuario(i);

                    boolean control3 = true;
                    while (control3) {
                        int opcion2 = v.menuAdmin();
                        switch (opcion2) {
                            case 1:
                                Usuarios y = new Usuarios(v.agregarUser(), v.agregarUserClave());
                                lista.agregarUsuario(y);
                                break;
                            case 2:
                                String nombreUsuario = v.modificarUser1();
                                String nuevoNombreUsuario = v.modificarUser2();
                                String nuevaClave = v.modificarUser3();
                                v.imprimirUser(lista.modificarUsuario(nombreUsuario, nuevoNombreUsuario, nuevaClave));
                                break;
                            case 3:
                                String usuarioEliminar = v.eliminarUser();
                                lista.eliminarUsuario(usuarioEliminar);
                                break;

                            case 4:
                                v.imprimirUser(lista.mostrarLista());
                                break;
                            case 5:
                                boolean control5 = true;
                                while(control5){
                                    int opcion5 = v.menu3();
                                    switch (opcion5){
                                        case 1:
                                            int codi5 = v.codigo();
                                            Recursos k = new Recursos(v.nombre(), v.significado());
                                            map.agregarRecurso(String.valueOf(codi5),k);
                                            break;
                                        case 2:
                                            String res = map.buscarRecursoLegal(v.codigo());
                                            v.imprimirUser(res);
                                            break;
                                        case 3:
                                            map.modificarRecursoLegal(v.codigo(),v.modifi(),v.significado());
                                            break;
                                        case 4:
                                            map.eliminarRecursoLegal(v.codigo());
                                            break;
                                        case 5:
                                            map.recorrer();
                                            break;
                                        case 6:
                                            control5 = false;
                                            break;
                                    }
                                }
                                break;

                            case 6:
                                boolean controll = true;
                                while(controll){
                                    int opcion5 = v.menuProfesor();
                                    switch (opcion5){
                                        case 1:
                                            String n=v.capturaNumero();
                                            Consultorio x = new Consultorio( v.capturaTipoCaso(), v.capturaNombre(), v.capturaActivo());
                                            v.imprimir(lista_gestion.agregarElemento(n,x));
                                            break;
                                        case 2:
                                            int buscar=v.buscarPor();

                                            if(buscar==1){
                                                v.imprimir(lista_gestion.buscarCodigo(v.capturaStrBuscar()));
                                            }
                                            if(buscar==2){
                                                v.imprimir(lista_gestion.buscarCodigo(v.capturaStrkey()));
                                            }
                                            break;
                                        case 3:
                                            v.imprimir( lista_gestion.modificarNombre(v.capturaACambiar(),v.cambioNombre()));
                                            break;
                                        case 4:
                                            lista_gestion.eliminar(v.capturaEleminar());
                                            break;
                                        case 5:
                                            v.imprimir(lista_gestion.recorrerLista());
                                            break;
                                        case 6:
                                            controll = false;
                                            break;
                                    }

                                }

                                break;
                            case 7:
                                boolean control7 = true;
                                while (control7){
                                    int opc7 = v.menu6();
                                    switch (opc7){
                                        case 1:
                                            Informacion n = new Informacion(v.agregarFecha(),v.agrega2(),v.agrega3(),v.agrega4(),v.agrega5());
                                            hasmap.agregarnoticia(n);
                                            break;
                                        case 2:
                                            v.imprimirUser(hasmap.mostrarLista());
                                            break;

                                        case 3:
                                            boolean control77 = true;
                                            while (control77){
                                                int opc77 = v.menuEditar();
                                                switch (opc77){
                                                    case 1:
                                                        String fecha = v.editafeche();
                                                        String nuevaFecha = v.fechaeditada();
                                                        hasmap.editarFecha(fecha, nuevaFecha);
                                                        break;

                                                    case  2:
                                                        String nombre = v.editarnombre();
                                                        String nuevoNombre = v.nombreeditada();
                                                        hasmap.editarnombre(nombre, nuevoNombre);
                                                        break;
                                                    case  3:
                                                        String descripcion = v.editarDescripcion();
                                                        String nuevadescrip = v.descripcionEditada();
                                                        hasmap.editarDescripcion(descripcion, nuevadescrip);
                                                        break;
                                                    case 4:
                                                        String rama = v.editarrama();
                                                        String nuevarama = v.ramaeditada();
                                                        hasmap.editarRama(rama, nuevarama);
                                                        break;
                                                    case  5:
                                                        control77 = false;
                                                        break;
                                                }
                                            }
                                        case 4:
                                            String eliminada = v.eliminada();
                                            hasmap.eliminarNoticia(eliminada);
                                            break;
                                        case  5:
                                            control7 = false;
                                            break;

                                    }
                                }
                            case 8:
                                control3 = false;
                                break;

                        }
                    }
                    break;
                //ADMINISTRADOR DE CONSULTORIO
                case 4:
                    Usuarios p = new Usuarios(v.ingresoAdmi1(), v.ingresoAdmi2(), v.rol(opcion));
                    lista.agregarUsuario(p);

                    boolean control4 = true;
                    while (control4) {
                        int opcion4 = v.menuAdmin();

                        switch (opcion4) {
                            case 1:
                                Usuarios y = new Usuarios(v.agregarUser(), v.agregarUserClave());
                                lista.agregarUsuario(y);
                                break;
                            case 2:
                                String nombreUsuario = v.modificarUser1();
                                String nuevoNombreUsuario = v.modificarUser2();
                                String nuevaClave = v.modificarUser3();
                                v.imprimirUser(lista.modificarUsuario(nombreUsuario, nuevoNombreUsuario, nuevaClave));
                                break;
                            case 3:
                                String usuarioEliminar = v.eliminarUser();
                                lista.eliminarUsuario(usuarioEliminar);
                                break;
                            case 4:
                                v.imprimirUser(lista.mostrarLista());
                                break;
                            case 5:
                                boolean control55 = true;
                                while(control55){
                                    int opcion55 = v.menu3();
                                    switch (opcion55){
                                        case 1:
                                            int codi5 = v.codigo();
                                            Recursos k = new Recursos(v.nombre(), v.significado());
                                            map.agregarRecurso(String.valueOf(codi5),k);
                                            break;
                                        case 2:
                                            String res = map.buscarRecursoLegal(v.codigo());
                                            v.imprimirUser(res);
                                            break;
                                        case 3:
                                            map.modificarRecursoLegal(v.codigo(),v.modifi(),v.significado());
                                            break;
                                        case 4:
                                            map.eliminarRecursoLegal(v.codigo());
                                            break;
                                        case 5:
                                            map.recorrer();
                                            break;
                                        case 6:
                                            control55 = false;
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                boolean controll = true;
                                while(controll){
                                    int opcion5 = v.menuProfesor();
                                    switch (opcion5){
                                        case 1:
                                            String n=v.capturaNumero();
                                            Consultorio x = new Consultorio( v.capturaTipoCaso(), v.capturaNombre(), v.capturaActivo());
                                            v.imprimir(lista_gestion.agregarElemento(n,x));
                                            break;
                                        case 2:
                                            int buscar=v.buscarPor();

                                            if(buscar==1){
                                                v.imprimir(lista_gestion.buscarCodigo(v.capturaStrBuscar()));
                                            }
                                            if(buscar==2){
                                                v.imprimir(lista_gestion.buscarCodigo(v.capturaStrkey()));
                                            }
                                            break;
                                        case 3:
                                            v.imprimir( lista_gestion.modificarNombre(v.capturaACambiar(),v.cambioNombre()));
                                            break;
                                        case 4:
                                            lista_gestion.eliminar(v.capturaEleminar());
                                            break;
                                        case 5:
                                            v.imprimir(lista_gestion.recorrerLista());
                                            break;
                                        case 6:
                                            controll = false;
                                            break;
                                    }

                                }
                            break;

                            case 7:
                                boolean control7 = true;
                                while (control7){
                                    int opc7 = v.menu6();
                                    switch (opc7){
                                        case 1:
                                            Informacion n = new Informacion(v.agregarFecha(),v.agrega2(),v.agrega3(),v.agrega4(),v.agrega5());
                                            hasmap.agregarnoticia(n);
                                            break;
                                        case 2:
                                            v.imprimirUser(hasmap.mostrarLista());
                                            break;

                                        case 3:
                                            boolean control77 = true;
                                            while (control77){
                                                int opc77 = v.menuEditar();
                                                switch (opc77){
                                                    case 1:
                                                        String fecha = v.editafeche();
                                                        String nuevaFecha = v.fechaeditada();
                                                        hasmap.editarFecha(fecha, nuevaFecha);
                                                        break;
                                                    case  2:
                                                        String nombre = v.editarnombre();
                                                        String nuevoNombre = v.nombreeditada();
                                                        hasmap.editarnombre(nombre, nuevoNombre);
                                                        break;
                                                    case  3:
                                                        String descripcion = v.editarDescripcion();
                                                        String nuevadescrip = v.descripcionEditada();
                                                        hasmap.editarDescripcion(descripcion, nuevadescrip);
                                                        break;
                                                    case 4:
                                                        String rama = v.editarrama();
                                                        String nuevarama = v.ramaeditada();
                                                        hasmap.editarRama(rama, nuevarama);
                                                        break;
                                                    case  5:
                                                        control77 = false;
                                                        break;



                                                }
                                            }
                                        case 4:
                                            String eliminada = v.eliminada();
                                            hasmap.eliminarNoticia(eliminada);
                                            break;
                                        case  5:
                                            control7 = false;
                                            break;

                                    }
                                }


                            case 8:
                                control4 = false;
                                break;
                        }
                    }

                case 5:
                    control = false;
                    break;
            }
        }
    }

}

