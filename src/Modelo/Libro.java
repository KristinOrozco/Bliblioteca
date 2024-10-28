/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author krist
 */
public class Libro {
    private String titulo;
    private String autor;
    private String añoPublicacion;
    private String cantEjemplares;
    public static final String[] TBL_ETIQUETAS = {"titulo","autor","añoPublicacion","cantEjemplares"};
    // título, autor, año de publicación y cantidad de ejemplares del libro

    public Libro(String titulo, String autor, String añoPublicacion, String cantEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.cantEjemplares = cantEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(String cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", a\u00f1oPublicacion=" + añoPublicacion + ", cantEjemplares=" + cantEjemplares + '}';
    }
    
    
    
    
}//CLASE LIBRO
