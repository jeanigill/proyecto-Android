package py.com.misgruposv01.datos;

import java.util.ArrayList;
import java.util.Date;

public class Materia {
    private int id;
    private String nombreMateria;
    private ArrayList<Tema> temas;


//    public static ArrayList<Grupo> grupos = new ArrayList<>();
//
//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }

    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
        temas = new ArrayList<>();
    }
    public Materia(int id, String nombreMateria, ArrayList temas) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        temas = temas;
    }
    public Materia(int id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
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
        return nombreMateria;
    }

    public void setNombre(String nombreMateria) {
        this.nombreMateria = nombreMateria;
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
