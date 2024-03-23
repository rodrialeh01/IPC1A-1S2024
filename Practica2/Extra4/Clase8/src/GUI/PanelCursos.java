/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Curso;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import javax.swing.*;
import GUI.VCrearCurso;
import clase8.Clase8;
import GUI.TablaCursos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;
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
public class PanelCursos extends JPanel implements ActionListener, MouseListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear, beditar, beliminar,bcargar,bcreara;
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
        
        //BOTON CARGAR
        bcargar = new JButton("Cargar");
        bcargar.setBounds(900,70,150,50);
        bcargar.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcargar.setVisible(true);
        bcargar.addActionListener(this);
        this.add(bcargar);

        //BOTON CREAR ARCHIVO
        bcreara = new JButton("Crear Archivo");
        bcreara.setBounds(900,130,150,50);
        bcreara.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcreara.setVisible(true);
        bcreara.addActionListener(this);
        this.add(bcreara);
        
        //COMBOBOX
        /*opciones = new JComboBox();
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
        this.add(opciones);*/
        
        
        /*
        para obtener que combobox selecciono
        opciones.getSelectedItem()
        */
        
        //TABLA
        //ENCABEZADO
        String[] encabezado = {"Código", "Nombre", "Créditos", "Acciones"};
        //DATOS DE LA TABLA
        datos = Clase8.convertirTablaCurso();
        //CREACIÓN DE LA TABLA
        tabla = new JTable(datos,encabezado);
        tabla.setDefaultRenderer(Object.class, new TablaCursos());
        tabla.addMouseListener(this);
        //SCROLLPANE
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20,10,800,600);
        //PARA BLOQUEAR LA TABLA
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
        }else if(e.getSource() == bcargar){
            leerArchivo();
        }else if(e.getSource() == bcreara){
            CrearArchivo();
        }
    }
    
    //------------------METODOS PARA EL MANEJO DE ARCHIVOS----------------
    public void leerArchivo(){
        //PARA OBTENER EL ARCHIVO
        File archivo = null;
        //PARA LEER ARCHIVO
        FileReader fr = null;
        BufferedReader br = null;
        try{
            //SE USA UN JFILECHOOSER PARA BUSCAR UN ARCHIVO DESDE LA INTERFAZ
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if(op == JFileChooser.APPROVE_OPTION){
                System.out.println(fc.getSelectedFile());
                archivo = fc.getSelectedFile();
            }
            //PROCEDIMIENTO PARA LEER EL ARCHIVO
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            //LEER NUESTRO ARCHIVO Y OBTENER SUS DATOS
            String linea;
            String contenido = "";
            int contador = 0;
            
            while((linea = br.readLine()) != null){
                contenido += linea + "\n";
                if(contador != 0){
                    String[] fila_datos = linea.split(",");
                    int codigo = Integer.parseInt(fila_datos[0]);
                    String nombre = fila_datos[1].trim().toUpperCase();
                    int creditos = Integer.parseInt(fila_datos[2]);
                    System.out.println("["+codigo + "," +nombre+","+creditos + "]");
                    Curso nuevo_curso = new Curso(codigo,nombre,creditos);
                    Clase8.añadirCurso(nuevo_curso);
                }
                contador++;
            }
            JOptionPane.showMessageDialog(this, "Se cargó el archivo correctamente");
            //System.out.println(contenido);
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void CrearArchivo(){
        String nombre_archivo = "ejemplo8.csv";
        String contenido = "codigo,creditos,nombre";
        LinkedList<Curso> cursos = Clase8.cursos;
        
        for (int i = 0; i < cursos.size(); i++) {
            contenido += "\n"+ String.valueOf(cursos.get(i).getCodigo()) +  "," + String.valueOf(cursos.get(i).getCreditos()) + "," + cursos.get(i).getNombre();
        }
        
        try (FileOutputStream archivo = new FileOutputStream(nombre_archivo)){
            archivo.write(contenido.getBytes());
            archivo.close();
            JOptionPane.showMessageDialog(this, "Archivo creado correctamente");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo");
        }
        
    }

    //-------------------METODO PARA MOSTRAR LA GRAFICA-------------------
    public void espacioGrafica(){
        JLabel vacio = new JLabel("No hay Cursos :C");
        vacio.setBounds(180,135,200,30);
        vacio.setFont(new Font("Century Gothic", Font.PLAIN,20));
        grafica.add(vacio);
        if(Clase8.cursos.size() == 0 ){
            grafica.setVisible(true);
        }else{
            grafica.setVisible(false);
            GenerarGrafica();
        }
    }
    
    //CREA LA GRAFICA
    public void GenerarGrafica(){
        // CREAMOS UN ARREGLO QUE TENGA LOS CURSOS ORDENADOS
        Curso[] cursos_ordenados = Clase8.ordenamientoCursos();
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

    //METODO PARA DAR CLICK
    @Override
    public void mouseClicked(MouseEvent e) {
        //SE OBTIENE LAS COORDENADAS DE LA TABLA
        int posy = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        System.out.println("Y: " + posy);
        int posx = e.getY()/tabla.getRowHeight();
        System.out.println("X: " + posx);
        //VARIFICA LAS COORDENADAS DE LA TABLA
        if(posx < tabla.getRowCount() && posx >=0 && posy < tabla.getColumnCount() && posy >=0){
            //OBTIENE EL OBJETO SELECCIONADO
            Object objeto = tabla.getValueAt(posx, posy);
            System.out.println(objeto);
            //VER SI ENCUENTRA EL JLABEL
            if(objeto instanceof JLabel){
                JLabel lbl = (JLabel) objeto;
                System.out.println("Acabas de presionar una acción del label que tiene el name " + lbl.getName());
                //CONFORME A ESE LBL.GETNAME() OBTENEMOS EL CODIGO DEL CURSO Y HACEMOS LO QUE QUERAMOS CONESO;
                String name = lbl.getName();
                System.out.println(name);
                String[] separacion_cadena = name.split(",");
                int cod = Integer.parseInt(separacion_cadena[1]);
                String accion = separacion_cadena[0];
                if(accion.equals("VerMas")){
                    System.out.println("VERE MAS A FONDO EL CODIGO " + cod);
                }else if(accion.equals("Atender")){
                    System.out.println("ATENDERE LA CITA");
                }else if(accion.equals("Rechazar")){
                    System.out.println("RECHAZARE LA CITA");
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
    }
    
}
