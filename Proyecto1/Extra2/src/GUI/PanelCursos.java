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
/**
 *
 * @author rodri
 */
public class PanelCursos extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear, beditar, beliminar;
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
        
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(grisito);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bcrear){
            VCrearCurso vcc = new VCrearCurso();
        }
    }
    
}
