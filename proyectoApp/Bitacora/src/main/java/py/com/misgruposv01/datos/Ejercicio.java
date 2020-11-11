package py.com.misgruposv01.datos;

import java.util.Date;

public class Ejercicio {
    private int tiempoDedicado;
    private String experiencia;
    private String dudas;
    private int logrado;

//
//    public static ArrayList<Grupo> grupos = new ArrayList<>();
//
//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }
//
    public Ejercicio(int tiempoDedicado, String experiencia, String dudas, int logrado) {
        this.tiempoDedicado= tiempoDedicado;
        this.experiencia = experiencia;
        this.dudas = dudas;
        this.logrado = logrado;
    }

    public int getTiempoDedicado() {
        return tiempoDedicado;
    }

    public void setTiempoDedicado(int tiempoDedicado) {
        this.tiempoDedicado = tiempoDedicado;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getDudas() {
        return dudas;
    }

    public void setDudas(String dudas) {
        this.dudas = dudas;
    }

    public int getLogrado() {
        return logrado;
    }

    public void setLogrado(int logrado) {
        this.logrado = logrado;
    }

//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getDescripcion() {
//        return descripcion;
//    }
//
//    public void setDescripcion(String descripcion) {
//        this.descripcion = descripcion;
//    }
//
//    public Date getFechaCreacion() {
//        return fechaCreacion;
//    }
//
//    public void setFechaCreacion(Date fechaCreacion) {
//        this.fechaCreacion = fechaCreacion;
//    }
//
//    public Usuario getCreador() {
//        return creador;
//    }
//
//    public void setCreador(Usuario creador) {
//        this.creador = creador;
//    }
//
//    public double getUbicacionLatitud() {
//        return ubicacionLatitud;
//    }
//
//    public void setUbicacionLatitud(double ubicacionLatitud) {
//        this.ubicacionLatitud = ubicacionLatitud;
//    }
//
//    public double getUbicacionLongitud() {
//        return ubicacionLongitud;
//    }
//
//    public void setUbicacionLongitud(double ubicacionLongitud) {
//        this.ubicacionLongitud = ubicacionLongitud;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int cantidadIntegrantes(){
//        int cantidad = 0;
//
//        if(usuariosIntegrantes != null){
//            cantidad = usuariosIntegrantes.size();
//        }
//        return cantidad;
//    }
}
