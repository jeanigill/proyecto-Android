package py.com.misgruposv01.datos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

import py.com.misgruposv01.utils.LogUtils;

public class Tema {
    private int id;
    private String nombre;
    private String fecha;
    private ArrayList<Item> items;
    private ArrayList<Ejercicio> ejercicios;
    private ArrayList<Investigacion> investigaciones;

//    public static ArrayList<Grupo> grupos = new ArrayList<>();
//
//    static {
//        Usuario unUsuario = new Usuario("pepe", "Carlos Tintero", "correo@mail.com", "123", "000000");
//        grupos.add( new Grupo("Estudiantes Java", "Grupo para compartir conocimientos sobre Java", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Android", "Grupo para compartir conocimientos sobre Android", 0.0, 0.0, unUsuario));
//        grupos.add( new Grupo("Estudiantes Programación", "Grupo para compartir conocimientos sobre Programación", 0.0, 0.0, unUsuario));
//    }

    public Tema (int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
       // this.fecha = new Date();
        items = new ArrayList<>();
        investigaciones = new ArrayList<>();
        ejercicios = new ArrayList<>();

    }
    public Tema (int id, String nombre, ArrayList items, ArrayList investigaciones, ArrayList ejercicios ) {
        this.id = id;
        this.nombre = nombre;
        //this.fecha = new Date();
        this.items = items;
        this.investigaciones = investigaciones;
        this.ejercicios = ejercicios;
    }

    public Tema (int id, String nombre, String fecha ) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public void agregarInvestigacion (Investigacion investigacion) {
        if (getInvestigaciones()==null){
            Log.i(LogUtils.tag, "No tiene investigaciones ");
            investigaciones.add(investigacion);
            setInvestigaciones(investigaciones);
        }else{
            Log.i(LogUtils.tag, "Tamaño de ArrayListInvestigaciones"+getInvestigaciones().size());
            getInvestigaciones().add(investigacion);
            Log.i(LogUtils.tag, "Materia nueva: "+investigacion.getTema());
        }
    }
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public ArrayList<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public void setInvestigaciones(ArrayList<Investigacion> investigaciones) {
        this.investigaciones = investigaciones;
    }

}
