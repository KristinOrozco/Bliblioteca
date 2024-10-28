/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Libro;
import Modelo.RegistroLiblro;
import Vista.FRM_RegistroLibros;
import Vista.PanelRegistroLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krist
 */
public class ManejdorRegistroLibros implements ActionListener {

    Libro libro;
    RegistroLiblro registroLibro;
    PanelRegistroLibros panelRegistroLibros;
    //FRM_RegistroLibros frmRegistro;

    public ManejdorRegistroLibros(PanelRegistroLibros panelRegistroLibros) {

        //this.libro = libro;
        registroLibro = new RegistroLiblro();
        this.panelRegistroLibros = panelRegistroLibros;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Agregar")) {

            if (panelRegistroLibros.getTitulo().isEmpty() || panelRegistroLibros.getAutor().isEmpty() || panelRegistroLibros.getAno().isEmpty() || panelRegistroLibros.getEjemplares().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");

            } else {
                

                //public Libro(String titulo, String autor, String añoPublicacion, String cantEjemplares) {
                libro = new Libro(panelRegistroLibros.getTitulo(), panelRegistroLibros.getAutor(), panelRegistroLibros.getAno(), panelRegistroLibros.getEjemplares());

                JOptionPane.showMessageDialog(null, registroLibro.agregarLibro(libro));
                
                panelRegistroLibros.setLibro(libro);
                panelRegistroLibros.limpiar();

            }
        }//AGREGAR
//-------------------BUSCAR------------------------------------------------------------------------
        if (e.getActionCommand().equals("Buscar por titulo")) {
    
            
            if (panelRegistroLibros.getTitulo().isEmpty()) {
                
           
                JOptionPane.showMessageDialog(null, "Por escriba el nombre del autor ");
            } else {
                libro = registroLibro.buscarLibro(panelRegistroLibros.getTitulo());
                if (libro != null) {
                    panelRegistroLibros.setAutor(libro.getAutor());
                    panelRegistroLibros.setTitulo(libro.getTitulo());
                    panelRegistroLibros.setAno(libro.getAñoPublicacion());
                    panelRegistroLibros.setEjemplares(libro.getCantEjemplares());

                } else {//ELSE2
                    JOptionPane.showMessageDialog(null, "No hay nungun libro con este nombre");

                }
            }//ELSE1
        }//IF1

        //---------MODIFICAR-----------------------------------------------------------------------------
        if (e.getActionCommand().equals("Modificra")) {
            if (panelRegistroLibros.getTitulo().isEmpty() || panelRegistroLibros.getAutor().isEmpty() || panelRegistroLibros.getAno().isEmpty() || panelRegistroLibros.getEjemplares().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos");
            } else {
                libro = new Libro(panelRegistroLibros.getTitulo(), panelRegistroLibros.getAutor(), panelRegistroLibros.getAno(), panelRegistroLibros.getEjemplares());
                JOptionPane.showMessageDialog(null, registroLibro.modificarLibro(libro));
                panelRegistroLibros.limpiar();

            }
        }
        //---------ELIMINAR-----------------------------------------------------------------------------

        if (e.getActionCommand().equals("Eliminar")) {
            if (panelRegistroLibros.getTitulo().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese/seleccione el titulo");
            } else {
                JOptionPane.showMessageDialog(null, registroLibro.eliminarLibro(panelRegistroLibros.getTitulo()));
                panelRegistroLibros.limpiar();

            }
        }
        //---------Salir-----------------------------------------------------------------------------

        if (e.getActionCommand().equals("Salir")) {
            System.exit(0);

        }
        //---------Lista-----------------------------------------------------------------------------

           if (e.getActionCommand().equals("Lista")) {
           //JALANDO LOS DATOS DE UNA TABLA
          
               DefaultTableModel tablaModelo = new DefaultTableModel();
               //c cancela no vea el boton profe jajaj
 
        }
        
        
        
    }//ACTION PERFORMED

}//FIN CLASE
