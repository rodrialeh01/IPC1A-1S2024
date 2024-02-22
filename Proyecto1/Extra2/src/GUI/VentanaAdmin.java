/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import GUI.*;
/**
 *
 * @author rodri
 */
public class VentanaAdmin extends JFrame implements ActionListener{
    //COLORES
    Color amarillo_ejemplo = new Color(210, 179, 56);
    Color cbotones = new Color(148, 210, 56);
    Color btext = new Color(196, 198, 194);
    JButton boton_salir;
    JPanel Panel;
            
    public VentanaAdmin(){
        
        //PANEL PRINCIPAL
        Panel = new JPanel();
        Panel.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(Panel);
        Panel.setLayout(null);
        
        //PESTAÑAS
        JTabbedPane pestañas = new JTabbedPane(JTabbedPane.TOP);
        pestañas.setBounds(10,11,1290,650);
        pestañas.setFont(new Font("Century Gothic",Font.PLAIN,15));
        pestañas.setBackground(Color.WHITE);
        Panel.add(pestañas);
        
        //PANEL DE CURSOS
        PanelCursos pc = new PanelCursos();
        pestañas.addTab("Cursos", null, pc,null);
        
        //PANEL DE PROFESORES
        PanelProfesores pp = new PanelProfesores();
        pestañas.addTab("Profesores", null, pp, null);
        
        //PANEL DE Estudiantes
        PanelEstudiantes pe = new PanelEstudiantes();
        pestañas.addTab("Estudiantes", null, pe, null);
        
        //BOTON CERRAR SESIÓN
        boton_salir = new JButton("Cerrar Sesión");
        //FUENTE DEL BOTON DEL TEXTO
        boton_salir.setFont(new Font("Century Gothic",Font.PLAIN,15));
        //COORDENADAS DEL BOTON
        boton_salir.setBounds(1150,0,150,30);
        //AÑADIR EVENTO
        boton_salir.addActionListener(this);
        //QUE SEA VISIBLE
        boton_salir.setVisible(true);
        //COLOR DE FONDO AL BOTON
        boton_salir.setBackground(cbotones);
        //COLOR DEL TEXTO DEL BOTON
        //boton_salir.setForeground(btext);
        //AGREGA EL BOTON A LA VENTANA
        this.add(boton_salir);
        
        
        
        //DISEÑO DE LA VENTANA
        //TITULO DE LA VENTANA
        this.setTitle("Administrador");
        //COORDENADAS ESPACIO X, ESPACIO Y, TAMAÑO EN X, TAMAÑO Y
        // COMIENZA EN X DE IZQ A DERECHA
        //COMIENZA EN Y DE ARRIBA PARA ABAJO
        this.setBounds(150,150,1320,700);
        //COLOR DE FONDO PARA LA VENTANA
        this.getContentPane().setBackground(amarillo_ejemplo);
        //BORRAR LOS MARGENES
        this.setLayout(null);
        //CERRAR LA VENTANA
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //para que el usuario no cambie el tamaño de la ventana
        this.setResizable(false);
        //VER LA VENTANA
        this.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_salir) {
            System.out.println("Cerraste sesión");
        }
    }
    
}
