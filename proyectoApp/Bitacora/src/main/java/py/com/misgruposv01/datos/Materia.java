package py.com.misgruposv01.datos;

import java.util.ArrayList;
import java.util.Date;

public class Materia {
    private int id;
    private String nombre;
    private ArrayList<Tema> temas;

//    public static ArrayList<Grupo> grupos = new ArrayList<>();
//
//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }

    public Materia(String nombre) {
        this.nombre = nombre;
        temas = new ArrayList<>();
    }
    public Materia(int id, String nombre, ArrayList temas) {
        this.id = id;
        this.nombre = nombre;
        temas = temas;
    }



//    public static void agregarGrupo( Grupo unGrupo ) {
//        grupos.add( unGrupo );
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }


//    public int cantidadIntegrantes(){
//        int cantidad = 0;
//
//        if(usuariosIntegrantes != null){
//            cantidad = usuariosIntegrantes.size();
//        }
//        return cantidad;
//    }
}
