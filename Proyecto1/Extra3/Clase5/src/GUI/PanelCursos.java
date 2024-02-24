/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Curso;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import GUI.VCrearCurso;
import clase5.Clase5;
//LIBRERIAS DE JFREECHART (GRAFICA DE PIE)
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author rodri
 */
public class PanelCursos extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear, beditar, beliminar;
    JComboBox opciones;
    static JPanel grafica; 
    static JTable tabla;
    static Object[][] datos;
    public PanelCursos() {
        //BOTON CREAR
        bcrear = new JButton("Crear");
        bcrear.setBounds(900,10,150,50);
        bcrear.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcrear.setVisible(true);
        bcrear.addActionListener(this);
        this.add(bcrear);
        
        //BOTON EDITAR
        beditar = new JButton("Editar");
        beditar.setBounds(1100,10,150,50);
        beditar.setFont(new Font("Century Gothic",Font.PLAIN,15));
        beditar.setVisible(true);
        beditar.addActionListener(this);
        this.add(beditar);
        
        //BOTON ELIMINAR
        beliminar = new JButton("Eliminar");
        beliminar.setBounds(1100,70,150,50);
        beliminar.setFont(new Font("Century Gothic",Font.PLAIN,15));
        beliminar.setVisible(true);
        beliminar.addActionListener(this);
        this.add(beliminar);
        
        //COMBOBOX
        opciones = new JComboBox();
        opciones.setBounds(900,90,150,50);
        opciones.setFont(new Font("Century Gothic",Font.PLAIN,15));
        String[] opcioness = {"opcion1", "opcion2", "opcion3", "opcion4"};
        //RELLENO EL COMBOBOX
        try{
            for (int i = 0; i < opcioness.length; i++) {
                opciones.addItem(opcioness[i]);
            }
        }catch(Exception e){
            
        }
        opciones.setVisible(true);
        opciones.addActionListener(this);
        this.add(opciones);
        
        
        /*
        para obtener que combobox selecciono
        opciones.getSelectedItem()
        */
        
        //TABLA
        //ENCABEZADO
        String[] encabezado = {"Código", "Nombre", "Créditos"};
        //DATOS DE LA TABLA
        datos = Clase5.convertirTablaCurso();
        //CREACIÓN DE LA TABLA
        tabla = new JTable(datos,encabezado);
        //SCROLLPANE
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20,10,800,600);
        //PARA BLOQUEAR LA TABLA
        tabla.setEnabled(false);
        tabla.setFont(new Font("Century Gothic", Font.PLAIN,12));
        this.add(sp);
        
        //PANEL DE GRAFICA
        grafica = new JPanel();
        grafica.setBounds(900,220,350,300);
        grafica.setBackground(grisito);
        this.add(grafica);
        espacioGrafica();
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(grisito);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bcrear){
            VCrearCurso vcc = new VCrearCurso();
        }else if(e.getSource() == beditar){
            VEditarCurso vec = new VEditarCurso();
        }else if(e.getSource() == beliminar){
            VEliminarCurso vdc = new VEliminarCurso();
        }
    }
    
    //-------------------METODO PARA MOSTRAR LA GRAFICA-------------------
    public void espacioGrafica(){
        JLabel vacio = new JLabel("No hay Cursos :C");
        vacio.setBounds(180,135,200,30);
        vacio.setFont(new Font("Century Gothic", Font.PLAIN,20));
        grafica.add(vacio);
        if(Clase5.cursos.size() == 0 ){
            grafica.setVisible(true);
        }else{
            grafica.setVisible(false);
            GenerarGrafica();
        }
    }
    
    //CREA LA GRAFICA
    public void GenerarGrafica(){
        // CREAMOS UN ARREGLO QUE TENGA LOS CURSOS ORDENADOS
        Curso[] cursos_ordenados = Clase5.ordenamientoCursos();
       //SE MANDAN LOS DATOS AL DATASET DE LA GRAFICA
       DefaultCategoryDataset datos = new DefaultCategoryDataset();
       try{
           for (int i = 0; i < 3; i++) {
               if (cursos_ordenados != null && cursos_ordenados[i].getCreditos() != 0) {
                   datos.setValue(cursos_ordenados[i].getCreditos(), cursos_ordenados[i].getNombre(), String.valueOf(cursos_ordenados[i].getCreditos()));
               }
           }
       }catch(Exception e){
           
       }
       //SE DIBUJA LA GRAFICA
       JFreeChart gbarras = ChartFactory.createBarChart("Top 3 de Cursos con más créditos de FIUSAC", "Cursos", "Creditos", datos, PlotOrientation.VERTICAL, true,false,false);
       gbarras.setBorderPaint(grisito);
       gbarras.getTitle().setPaint(Color.BLACK);
       gbarras.getTitle().setFont(new Font("Arial", Font.PLAIN,20));
       ChartPanel chartpanel = new ChartPanel(gbarras);
       chartpanel.setBounds(900,220,350,300);
       this.add(chartpanel);
       
    }
    
}
