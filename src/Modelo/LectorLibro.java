/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krist
 */
public class LectorLibro
{
    private String nombreArchivo;
    ArrayList<Libro> arregloLibros;

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    public LectorLibro(String nombreArchivo) 
    {
        this.nombreArchivo = nombreArchivo;
        
    }//CONSTRUCTOR
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------
    
    
    public ArrayList<Libro> leer()
    {
        try
        {
           
            CSVReader csvReader = null;
            List<String[]> arregloVectores = null;
            arregloLibros = new ArrayList<>();

            csvReader = new CSVReader(new FileReader(nombreArchivo));
            arregloVectores = csvReader.readAll();

            for(String[] linea:arregloVectores)
            {
                Libro libro = new Libro(linea[0], linea[1], (linea[2]), linea[3]);

                arregloLibros.add(libro);
            }
        }
        catch(FileNotFoundException e){
            }catch(IOException io){
                io.printStackTrace();
            }catch(CsvException cs){
                cs.printStackTrace();
            }
        return arregloLibros;
    }//FIN LEER
    
}//FIN LECTOR LIBRO
