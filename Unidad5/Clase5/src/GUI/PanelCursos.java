/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import GUI.VCrearCurso;
import clase5.Clase5;
/**
 *
 * @author rodri
 */
public class PanelCursos extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear, beditar, beliminar;
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
    
}
