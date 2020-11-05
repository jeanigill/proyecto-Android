package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class App {
//    private String anho;

//    private static Usuario usuarioLogueado;
    public static ArrayList<Bitacora> listadoBitacoras = new ArrayList<>();
    public static ArrayList<Materia> listadoMaterias1 = new ArrayList<>();
    public static Materia materia1;
    public static Materia materia2 ;

    public static ArrayList<Materia> listadoMaterias2 = new ArrayList<>();
    public static ArrayList<Materia> listadoMaterias3 = new ArrayList<>();

    static {
//        materia1 = new Materia ();
//        materia2 = new Materia ();
        listadoMaterias1.add(materia1);

        listadoMaterias1.add(materia2);
        listadoBitacoras = new ArrayList<>();
        listadoBitacoras.add( new Bitacora ("1er año"));
        listadoBitacoras.add( new Bitacora ("2do año"));
        listadoBitacoras.add( new Bitacora ("3er año"));

    }

    public App(    ) {

    }
//
//    public void agregarContato(Contacto contacto) {
//        contactos.add( contacto );
//    }
//
//
//    public static void agregarUsuario(Usuario usuario) {
//        usuarios.add( usuario );
//    }
//
//    public static boolean comprobarCredenciales(String email, String password) {
//
//        for( Usuario usuario : usuarios) {
//            if ( email.equals(usuario.getMail()) && password.equals(usuario.getPassword())){
//                return true;
//            }
//        }
//        return false;
//    }

//    public static void setUsuarioLogueado(Usuario usuario) {
//        usuarioLogueado = usuario;
//    }
//
//    public static Usuario getUsuarioLogueado() {
//        return usuarioLogueado;
//    }
//
//    public static Usuario getUsuario(String email ) {
//        for( Usuario usuario : usuarios) {
//            if ( email.equals(usuario.getMail()) ){
//                return usuario;
//            }
//        }
//        // TODO se podria lanzar una excepcion al no encontrar el usuairo
//        return null;
//    }
//
//    public String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static ArrayList<Bitacora> getListadoBitacoras() {
        return listadoBitacoras;
    }

    public static void setListadoBitacoras(ArrayList<Bitacora> listadoBitacoras) {
        App.listadoBitacoras = listadoBitacoras;
    }
}
