package py.com.misgruposv01.datos;

import java.util.ArrayList;

public class Bitacora {
   private String anho;

//    private static Usuario usuarioLogueado;
    private static ArrayList<Materia> listadoMaterias;

//    static {
//        listadoMaterias = new ArrayList<>();
//        listadoMaterias.add( new Materia("batman", "Bruce Wine", "batman@ciudadgotica.com", "batman", "0900123123"));
//    }

    public Bitacora(String anho, ArrayList listadoMaterias) {
        this.anho = anho;
        this.listadoMaterias = listadoMaterias;
    }

    public Bitacora(String anho) {
        this.anho = anho;
    }

}
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
//
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
//}
