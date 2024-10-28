/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author krist
 */
public class RegistroLiblro {

    private ArrayList<Libro> arregloLibros;
    private String mensaje;
    private String nombreArchivo;

    EscritorLibro escribirLibro;
    LectorLibro lectorLibro;

    //----------------------------------------------------------------------------------------
    public RegistroLiblro() {
        this.arregloLibros = new ArrayList<>();
        this.mensaje = "";
        this.nombreArchivo = "Registro Libros.csv";
        this.escribirLibro = new EscritorLibro(nombreArchivo);
        this.lectorLibro = new LectorLibro(nombreArchivo);
    }
    //-----------CONSTRUCTOR----------------------------------------------------------------
    //-----------AGREGAR----------------------------------------------------------------

    public String agregarLibro(Libro libro) {
        if (libro != null) {
            arregloLibros.add(libro);
            escribirLibro.escribir(arregloLibros);
            mensaje = "Libro agregado correctamente";

        }else{
        mensaje = "El libro no fue agregado ";
        }
        return mensaje;
        
    }
    
    //-----------BUSCAR INDICE----------------------------------------------------------------

    public int buscarIndice(String autor) {

        arregloLibros = new ArrayList<>();
        arregloLibros.addAll(lectorLibro.leer());//SE LLENA EN EL ARCHIVO

        for (int indice = 0; indice < arregloLibros.size(); indice++) {
            if (arregloLibros.get(indice) != null) {
                if (arregloLibros.get(indice).getAutor().equalsIgnoreCase(autor)) {
                    return indice;
                }
            }
        }
        return -1;
    }
    

    //-----------BUSCAR LIBRO----------------------------------------------------------------
    public Libro buscarLibro(String autor) {

        int posicion = buscarIndice(autor);
        if (posicion != -1) {
            return arregloLibros.get(posicion);
        }
        return null;
    }
    //-----------ELIMINAR----------------------------------------------------------------

    public String eliminarLibro(String titulo) {

        int posicion = buscarIndice(titulo);
        if (posicion != -1) {
            arregloLibros.remove(posicion);
            escribirLibro.escribir(arregloLibros);
            mensaje = "El libro fue eliminado";
        } else {
            mensaje = "No se encuentra ningun libro";

        }
        return mensaje;
    }
    //-----------MODIFICAR----------------------------------------------------------------

    public String modificarLibro(Libro libro) {

        int posicion = buscarIndice(libro.getTitulo());
        if (posicion != -1) {
            arregloLibros.get(posicion).setAutor(libro.getAutor());
            arregloLibros.get(posicion).setTitulo(libro.getTitulo());
            arregloLibros.get(posicion).setAñoPublicacion(libro.getAñoPublicacion());
            arregloLibros.get(posicion).setCantEjemplares(libro.getCantEjemplares());
            escribirLibro.escribir(arregloLibros);
            mensaje = "El libro fue modicficado correctamente";

        } else {
            mensaje = "El libro que se quiere modificar no se encuentra registrado";
        }
        return mensaje;
    }
    //-----------LISTA----------------------------------------------------------------
        //SE NECECITA TABLA
    /*public TableModel getLista(DefaultTableModel tablaModelo) {
        tablaModelo.addColumn("Autor");
        tablaModelo.addColumn("Titulo");
        tablaModelo.addColumn("AñoPublicacion");
        tablaModelo.addColumn("CantEjemplares");

        Object[] fila;

        for (Libro libro : arregloLibros) {

            fila = new Object[3];
            fila[0] = libro.getAutor();
            fila[1] = libro.getTitulo();
            fila[2] = libro.getAñoPublicacion();
            fila[3] = libro.getCantEjemplares();

            tablaModelo.addRow(fila);
        }//FOR
        return tablaModelo;
    }//TABLE MODEL*/

}//FIN CLASE REGISTRO LIBRO
