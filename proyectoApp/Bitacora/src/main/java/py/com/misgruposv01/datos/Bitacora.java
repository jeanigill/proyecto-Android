package py.com.misgruposv01.datos;

import android.util.Log;

import java.util.ArrayList;

import py.com.misgruposv01.utils.LogUtils;

public class Bitacora {
    private ArrayList<Materia> materias;
    private int id;
    private String anho;



//    static {
//        materias = new ArrayList<>();
//        materias.add( new Materia("batman", "Bruce Wine", "batman@ciudadgotica.com", "batman", "0900123123"));
//
//    }

    public Bitacora(int id, String anho, ArrayList materias) {
        this.id = id;
        this.anho = anho;
        this.materias = materias;
    }

//    public static void agregarMateria(Materia materia) {
//        materias.add( materia );
//    }
public void agregarMateria (Materia materia) {
    materias.add(materia);
    Log.i(LogUtils.tag, "Materia nueva: "+materia.getNombre());
}

    public Bitacora(int id, String anho) {
        this.anho = anho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        materias = materias;
    }
}
//    public void agregarContato(Contacto contacto) {
//        contactos.add( contacto );
//    }


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
