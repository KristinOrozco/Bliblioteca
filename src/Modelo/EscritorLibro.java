/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krist
 */
public class EscritorLibro 
{
   private String nombreArchivo;

    public EscritorLibro(String nombreArchivo) 
    {
        this.nombreArchivo = nombreArchivo;
        
    }//CONSTRUCTOR
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    
    public List procesarLibros(ArrayList<Libro> arregloLibros)
    {
        
        List<String[]> arregloVectores = new ArrayList<>();//SE DEFINE EL ARREGLO
        
        for (Libro libro:arregloLibros) 
        {
            arregloVectores.add(new String[]{libro.getAutor(), libro.getTitulo(), libro.getAñoPublicacion(), libro.getCantEjemplares()});
       //SE CREA EL ARREGLO DE VECTORES
        }
        return arregloVectores;
    }//PROCESAR LIBRO
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
   
    public void escribir(ArrayList<Libro> arregloLibros)
    {
        try
        {
            //CREAMOS EL ARCHIVO DONDE SE GUARDA TODO 
            CSVWriter csvOutput = new CSVWriter(new FileWriter(nombreArchivo, false));
            csvOutput.writeAll(procesarLibros(arregloLibros));//SEE LE INGRESAN LOS DATOS MEDIANTE EL METODO PROCESAR LIBRO
            csvOutput.close();
            
        }
        catch(IOException io)
        {
           io.printStackTrace();//imprimir
        } 
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
      
}//Fin class
