package py.com.misgruposv01.datos;

import java.util.Date;

public class Item {
    private String concepto;
    private String descripcion;
    private String dudas;
    private Boolean aprendido;

//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }

    public Item (String concepto, String descripcion, String dudas, Boolean aprendido) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.dudas = dudas;
        this.aprendido = aprendido;
    }

//    public static void agregarGrupo( Grupo unGrupo ) {
//        grupos.add( unGrupo );
//    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public Boolean getAprendido() {
        return aprendido;
    }

    public void setAprendido(Boolean aprendido) {
        this.aprendido = aprendido;
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
