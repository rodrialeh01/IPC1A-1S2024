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
import Clases.Curso;
import clase6.Clase6;

/**
 *
 * @author rodri
 */
public class VCrearCurso extends JFrame implements ActionListener{
    
    JLabel titulo, lcodigo, lnombre, lcreditos;
    JTextField tcodigo,tnombre,tcreditos;
    JButton bcrear;
    String codigot, nombret, creditost; 
    public VCrearCurso() {
        //TITULO
        titulo = new JLabel("Crear Curso");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,15));
        titulo.setBounds(120,30,250,30);
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de codigo
        lcodigo = new JLabel("Codigo: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcodigo.setBounds(40,100,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,100,30);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //label de NOMBRE
        lnombre = new JLabel("Nombre: ");
        lnombre.setFont(new Font("Century Gothic",Font.BOLD,18));
        lnombre.setBounds(40,180,100,30);
        lnombre.setVisible(true);
        this.add(lnombre);
        
        //TEXTFIELD DE NOMBRE
        tnombre = new JTextField();
        tnombre.setBounds(140,180,280,30);
        tnombre.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tnombre.setVisible(true);
        this.add(tnombre);
        
        //label de CREDITOS
        lcreditos = new JLabel("Creditos: ");
        lcreditos.setFont(new Font("Century Gothic",Font.BOLD,18));
        lcreditos.setBounds(40,260,100,30);
        lcreditos.setVisible(true);
        this.add(lcreditos);
        
        //TEXTFIELD DE CREDITOS
        tcreditos = new JTextField();
        tcreditos.setBounds(140,260,280,30);
        tcreditos.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcreditos.setVisible(true);
        this.add(tcreditos);
        
        //BOTON CREAR CURSO
        bcrear = new JButton("Crear Curso");
        bcrear.setBounds(100,500,280,40);
        bcrear.addActionListener(this);
        //BLOQUEAR UN BOTON
        //bcrear.setEnabled(false);
        this.add(bcrear);
        
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Crear Curso");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //OBTENGO LA INFO DE LOS TEXTFIELD
        codigot = tcodigo.getText();
        nombret = tnombre.getText();
        creditost = tcreditos.getText();
        if(e.getSource() == bcrear){
            //PARSEO DE STRING A INT
            int cod = Integer.parseInt(codigot);
            int cred = Integer.parseInt(creditost);
            //CREO UN CURSO
            Curso curso = new Curso(cod,nombret, cred);
            //AÑADO LA UN CURSO A LA LISTA
            Clase6.añadirCurso(curso);
            //MUESTRO TODOS LOS CURSOS DE LA LISTA
            Clase6.MostrarCursos();
            //CERRAR LA VENTANA ACTUAL
            this.dispose();
        }
    }
    
}
