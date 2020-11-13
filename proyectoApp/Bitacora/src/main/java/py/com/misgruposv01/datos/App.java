package py.com.misgruposv01.datos;

import android.util.Log;

import java.util.ArrayList;

import py.com.misgruposv01.utils.LogUtils;

public class App {


    public static ArrayList<Bitacora> listadoBitacoras = new ArrayList<>();


    public static Bitacora bitacora1;
    public static Bitacora bitacora2;

    public static ArrayList<Materia> listadoMaterias1 = new ArrayList<>();
    public static ArrayList<Materia> listadoMaterias2 = new ArrayList<>();

    public static Materia materia1;
    public static Materia materia2 ;
    public static Materia materia3 ;
    public static Materia materia4 ;
    public static Materia materia5 ;
    public static Materia materia6 ;
    public static Materia materia7 ;

    public static Tema tema1;
    public static Tema tema2;
    public static Tema tema3;
    public static Tema tema4;
    public static Tema tema5;

    public static ArrayList<Tema> temas1 = new ArrayList<>();
    public static ArrayList<Tema> temas2 = new ArrayList<>();
    public static ArrayList<Tema> temas3 = new ArrayList<>();

    public static Item item1;
    public static Item item2;
    public static Item item3;
    public static Item item4;
    public static ArrayList<Item> items1 = new ArrayList<>();

    public static Investigacion investigacion1;
    public static Investigacion investigacion2;
    public static Investigacion investigacion3;
    public static Investigacion investigacion4;
    public static ArrayList<Investigacion> investigaciones1 = new ArrayList<>();

    public static Ejercicio ejercicio1;
    public static Ejercicio ejercicio2;
    public static Ejercicio ejercicio3;
    public static Ejercicio ejercicio4;
    public static ArrayList<Ejercicio> ejercicios1 = new ArrayList<>();

    static {
        ejercicio1 = new Ejercicio (90, 80 ,"Aprendí que una " +
                "clase puede tener varios constructores.", "¿Para qué sirve la palabra reservada static?", 80);
        ejercicio2 = new Ejercicio (30, 80, "buena", "", 100);
        ejercicio3 = new Ejercicio (60, 80, "muy larga", "No pude terminar", 30);
        ejercicio4 = new Ejercicio (20, 80, "rápida", "ninguna", 100);
        ejercicios1.add(ejercicio1);
        ejercicios1.add(ejercicio2);
        ejercicios1.add(ejercicio3);
        ejercicios1.add(ejercicio4);

        investigacion1 = new Investigacion (30, "Static en java",
                "Static se usa con métodos y atributos.", 80,
                "Aún no me queda claro ya que la palabra reservada se usa con atributos y métodos.");
        investigacion2 = new Investigacion (20, "Tema 2", "comentario 2",
                100, "dudas 2" );
        investigacion3 = new Investigacion (30, "Tema 3", "comentario 3",
                80, "dudas 3" );
        investigacion4 = new Investigacion (40, "Tema 4", "comentario 4",
                90, "dudas 4" );
        investigaciones1.add(investigacion1);
        investigaciones1.add(investigacion2);
        investigaciones1.add(investigacion3);
        investigaciones1.add(investigacion4);

        item1 = new Item ("Clase", "Modelo que define conjunto de atributos y métodos",
                "", true);
        item2 = new Item ("Objeto", "\"Unidad dentro de un programa que tiene estado y comportamiento. \n" +
                "Instancia de una clase\"",
                "", true);
        item3 = new Item ("Constructor", "",
                "¿Cuál es la diferencia entre objeto e instancia?", false);
        item4 = new Item ("concepto 4", "descripcion 4",
                "dudas 4", false);
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);
        items1.add(item4);
        Log.i(LogUtils.tag, "Cantidad de items de POO: "+items1.size());
        tema1 = new Tema (1, "Programación Orientada a Objetos", items1, investigaciones1, ejercicios1);
        tema2 = new Tema (2, "Tema 2",items1, investigaciones1, ejercicios1);
        tema3 = new Tema (3, "Tema 3",items1, investigaciones1, ejercicios1);
        tema4 = new Tema (4, "Tema 4");
        tema5 = new Tema (5, "Tema 5");

        temas1.add(tema1);
        temas1.add(tema2);
        temas1.add(tema3);
        temas2.add(tema4);
        temas3.add(tema5);

        materia1 = new Materia (1, "Proyecto TIC", temas1);
        materia2 = new Materia (2, "Materia 2", temas2);
        materia3 = new Materia (3, "Materia 3", temas3);
        materia4 = new Materia (4, "Materia 4", temas3);
        materia5 = new Materia (5, "Materia 5", temas3);
        materia6 = new Materia (6, "Materia 6", temas3);
        materia7 = new Materia (7, "Materia 7");

        listadoMaterias1.add(materia1);
        listadoMaterias1.add(materia2);
        listadoMaterias1.add(materia3);
        listadoMaterias1.add(materia4);
        listadoMaterias1.add(materia5);
        listadoMaterias2.add(materia6);
        listadoMaterias2.add(materia7);
        //Log.i(LogUtils.tag, "Cantidad de temas en materia 1 size: "+materia1.getTemas().size());
        Log.i(LogUtils.tag, "ListadoMaterias1 size: "+listadoMaterias1.size());
        Log.i(LogUtils.tag, "ListadoMaterias2 size: "+listadoMaterias2.size());
        bitacora1 = new Bitacora (1,  "1er año", listadoMaterias1);
        Log.i(LogUtils.tag, "ListadoMaterias de bitacora size: "+bitacora1.getMaterias().size());
        bitacora2 = new Bitacora(2, "2do año", listadoMaterias2);


        listadoBitacoras.add(bitacora1 );
        listadoBitacoras.add(bitacora2 );
    }

//    public static void agregarMateria(Bitacora bitacora, Materia materia) {
//        bitacora.getMaterias().add(materia);
//        Log.i(LogUtils.tag, "Materia nueva: "+materia.getNombre());
//    }
    public static void agregarBitacora(Bitacora unaBitacora) {
        listadoBitacoras.add(unaBitacora);
        Log.i(LogUtils.tag, "Materia nueva: "+unaBitacora.getAnho());
    }
    public static Bitacora buscarBitacora (int idBitacora) {
        Bitacora unaBitacora = null;
        for (int i = 0; i < listadoBitacoras.size(); i++) {
            unaBitacora = listadoBitacoras.get(i);
            if (idBitacora == unaBitacora.getId()) {
                Log.i(LogUtils.tag, "Bitacora encontrada: "+unaBitacora.getAnho());
                return unaBitacora;
            }

        }
        Log.i(LogUtils.tag, "Bitacora NULL");
        return null;
    }

    public static Materia buscarMateria (Bitacora unaBitacora, int idMateria){
        Materia unaMateria = null;
        for (int i = 0; i < unaBitacora.getMaterias().size(); i++) {
            unaMateria = unaBitacora.getMaterias().get(i);
            Log.i(LogUtils.tag, "Materias size: "+unaBitacora.getMaterias().size());
            if (idMateria == unaMateria.getId()) {
                i = unaBitacora.getMaterias().size();
                Log.i(LogUtils.tag, "Materia encontrada: "+unaMateria.getNombre());
                Log.i(LogUtils.tag, "Cantidad de temas: "+unaMateria.getTemas().size());
                return unaMateria;
            }
        }
        Log.i(LogUtils.tag, "Materia null ");
        return null;
    }

    public static Tema buscarTema ( Materia unaMateria, int idTema){
        Tema unTema = null;
        for (int i = 0; i < unaMateria.getTemas().size(); i++) {
            unTema = unaMateria.getTemas().get(i);
            Log.i(LogUtils.tag, "Temas size: "+unaMateria.getTemas().size());
            if (idTema == unTema.getId()) {
                i = unaMateria.getTemas().size();
                Log.i(LogUtils.tag, "Tema encontrado: "+unTema.getNombre());
                Log.i(LogUtils.tag, "Cantidad de Items: "+unTema.getItems().size()
                );
                return unTema;
            }
        }
        Log.i(LogUtils.tag, "Tema null ");
        return null;
    }

//    public static Item buscarItem ( Tema unTema, int idItem){
//        Item unItem = null;
//        for (int i = 0; i < unTema.getItems().size(); i++) {
//            unItem = unTema.getItems().get(i);
//            Log.i(LogUtils.tag, "Items size: "+unItem..getTemas().size());
//            if (idTema == unTema.getId()) {
//                i = unaMateria.getTemas().size();
//                Log.i(LogUtils.tag, "Tema encontrado: "+unTema.getNombre());
//                Log.i(LogUtils.tag, "Cantidad de Items: "+unTema.getItems().size()
//                );
//                return unTema;
//            }
//        }
//        Log.i(LogUtils.tag, "Tema null ");
//        return null;
//    }


    public static void agregarMateria (Bitacora bitacora, Materia materia) {
        if (bitacora.getMaterias()==null){
            Log.i(LogUtils.tag, "No tiene materias ");
            ArrayList<Materia> materias = new ArrayList<>();
            materias.add(materia);
            bitacora.setMaterias(materias);
        }else{
            Log.i(LogUtils.tag, "Tamaño de ArrayListMaterias"+bitacora.getMaterias().size());
            bitacora.getMaterias().add(materia);
            Log.i(LogUtils.tag, "Materia nueva: "+materia.getNombre());
        }
    }

    public static void agregarTema (Materia materia, Tema tema) {
        if (materia.getTemas()==null){
            Log.i(LogUtils.tag, "No tiene temas ");
            ArrayList<Tema> temas = new ArrayList<>();
            temas.add(tema);
            materia.setTemas(temas);
        }else{
            Log.i(LogUtils.tag, "Tamaño de ArrayListTemas"+materia.getTemas().size());
            materia.getTemas().add(tema);
            Log.i(LogUtils.tag, "Tema nuevo: "+tema.getNombre());
        }
    }

    public static void agregarEjercicio (Tema tema, Ejercicio unEjercicio) {
        if (tema.getEjercicios()==null){
            Log.i(LogUtils.tag, "No tiene ejercicios ");
            ArrayList<Ejercicio> ejercicios = new ArrayList<>();
            ejercicios.add(unEjercicio);
            tema.setEjercicios(ejercicios);
        }else{
            Log.i(LogUtils.tag, "Tamaño de ArrayListEjercicios antes: "+tema.getEjercicios().size());
            tema.getEjercicios().add(unEjercicio);
            Log.i(LogUtils.tag, "Experiencia del ejercicio nuevo: "+unEjercicio.getExperiencia());
            Log.i(LogUtils.tag, "Tamaño de ArrayListEjercicios despues: "+tema.getEjercicios().size());
        }
    }

    public static void agregarInvestigacion (Tema tema, Investigacion investigacion) {
        if (tema.getInvestigaciones()==null){
            Log.i(LogUtils.tag, "No tiene investigaciones ");
            ArrayList<Investigacion> investigaciones = new ArrayList<>();
            investigaciones.add(investigacion);
            tema.setInvestigaciones(investigaciones);
        }else{
                Log.i(LogUtils.tag, "Tamaño de ArrayList Investigaciones antes: "+tema.getInvestigaciones().size());
            tema.getInvestigaciones().add(investigacion);
            Log.i(LogUtils.tag, "Tema de la nueva investigacion: "+investigacion.getTema());
            Log.i(LogUtils.tag, "Tamaño de ArrayList Investigaciones despues: "+tema.getInvestigaciones().size());
        }
    }

    public static void agregarItem (Tema tema, Item items) {
        if (tema.getItems()==null){
            Log.i(LogUtils.tag, "No tiene items ");
            ArrayList<Item> itemss = new ArrayList<>();
            itemss.add(items);
            tema.setItems(itemss);
        }else{
            Log.i(LogUtils.tag, "Tamaño de ArrayList Item antes: "+tema.getItems().size());
            tema.getItems().add(items);
            Log.i(LogUtils.tag, "Tema de la nueva Itme: "+ items.getConcepto());
            Log.i(LogUtils.tag, "Tamaño de ArrayList Item despues: "+tema.getItems().size());
        }
    }

    public static ArrayList<Bitacora> getListadoBitacoras() {
        return listadoBitacoras;
    }

    public static void setListadoBitacoras(ArrayList<Bitacora> listadoBitacoras) {
        App.listadoBitacoras = listadoBitacoras;
    }
}
