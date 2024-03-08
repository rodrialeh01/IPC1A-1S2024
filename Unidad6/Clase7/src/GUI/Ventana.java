/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Hilos.Cronometro;
import Hilos.Movimiento;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class Ventana extends JFrame implements ActionListener{
    JButton boton1, boton2, boton3, boton4;
    JLabel lcron, lmoto, lcontador;
    
    public Ventana(){
        //LABEL CONTADOR GAS
        lcontador = new JLabel("20");
        lcontador.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcontador.setBounds(180,20,100,30);
        lcontador.setVisible(true);
        this.add(lcontador);
        
        // IMAGEN LABEL
        lmoto = new JLabel();
        lmoto.setBounds(10, 10, 150, 150);
        ImageIcon img = new ImageIcon(getClass().getResource("../imagenes/moto.gif"));
        Image nuevo = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon render = new ImageIcon(nuevo);
        lmoto.setIcon(render);
        lmoto.setVisible(true);
        this.add(lmoto);
        
        //label de codigo
        lcron = new JLabel("");
        lcron.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcron.setBounds(50,130,100,30);
        lcron.setVisible(true);
        this.add(lcron);

        //BOTON
        boton1 = new JButton("Iniciame");
        boton1.setFont(new Font("Century Gothic",Font.PLAIN,15));
        boton1.setBounds(240,180,150,30);
        boton1.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(boton1);

        //BOTON
        boton2 = new JButton("Pausame");
        boton2.setFont(new Font("Century Gothic",Font.PLAIN,15));
        boton2.setBounds(240,230,150,30);
        boton2.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(boton2);

        //BOTON
        boton3 = new JButton("Reanudame");
        boton3.setFont(new Font("Century Gothic",Font.PLAIN,15));
        boton3.setBounds(240,280,150,30);
        boton3.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(boton3);

        //BOTON
        boton4 = new JButton("Pruebame");
        boton4.setFont(new Font("Century Gothic",Font.PLAIN,15));
        boton4.setBounds(240,330,150,30);
        boton4.addActionListener(this);
        //BLOQUEAR UN BOTON

        this.add(boton4);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Hilos");
        this.setBounds(400, 200, 600, 400);
        this.getContentPane().setBackground(Color.cyan);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cronometro c = new Cronometro(lcron);
        if(e.getSource()== boton1){
            c.start();
        }else if(e.getSource() == boton2){
            c.pausar();
        }else if(e.getSource() == boton3){
            c.reanudar();
        }else if(e.getSource() == boton4){
            int limfin = this.getWidth() - lmoto.getWidth();
            Movimiento m = new Movimiento(lmoto,lcontador,0,limfin, this);
            m.start();
        }
    }
}
