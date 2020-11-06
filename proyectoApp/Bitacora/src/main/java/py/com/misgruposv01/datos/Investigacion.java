package py.com.misgruposv01.datos;

import java.util.Date;

public class Investigacion {
    private int tiempoDedicado;
    private String tema;
    private String comentarios;
    private int comprension;
    private String dudas;

//    public static ArrayList<Grupo> grupos = new ArrayList<>();
//
//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }
//
    public Investigacion(int tiempoDedicado, String tema, String comentarios, int comprension, String dudas) {
        this.tiempoDedicado = tiempoDedicado;
        this.tema = tema;
        this.comentarios = comentarios;
        this.comprension = comprension;
        this.dudas = dudas;
    }

//    public static void agregarGrupo( Grupo unGrupo ) {
//        grupos.add( unGrupo );
//    }
//

    public int getTiempoDedicado() {
        return tiempoDedicado;
    }

    public void setTiempoDedicado(int tiempoDedicado) {
        this.tiempoDedicado = tiempoDedicado;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getComprension() {
        return comprension;
    }

    public void setComprension(int comprension) {
        this.comprension = comprension;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
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
