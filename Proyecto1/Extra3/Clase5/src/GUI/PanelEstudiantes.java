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

/**
 *
 * @author rodri
 */
public class PanelEstudiantes extends JPanel implements ActionListener{
    Color grisito = new Color(197, 201, 190);
    JButton bcrear, beditar, beliminar;
    public PanelEstudiantes() {
        //BOTON CREAR
        bcrear = new JButton("Crear");
        bcrear.setBounds(900,10,150,50);
        bcrear.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcrear.setVisible(true);
        bcrear.addActionListener(this);
        this.add(bcrear);
        
        //BOTON EDITAR
        bcrear = new JButton("Editar");
        bcrear.setBounds(1100,10,150,50);
        bcrear.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcrear.setVisible(true);
        bcrear.addActionListener(this);
        this.add(bcrear);
        
        //BOTON ELIMINAR
        bcrear = new JButton("Eliminar");
        bcrear.setBounds(1100,70,150,50);
        bcrear.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bcrear.setVisible(true);
        bcrear.addActionListener(this);
        this.add(bcrear);
        
        
        //DISEÑO PANEL
        this.setLayout(null);
        this.setBackground(grisito);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
