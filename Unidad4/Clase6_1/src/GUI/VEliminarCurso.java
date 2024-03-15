/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Curso;
import clase6.Clase6;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class VEliminarCurso extends JFrame implements ActionListener{

    JLabel titulo, lcodigo;
    JTextField tcodigo;
    JButton beliminar;
    String codigot;
    public VEliminarCurso() {
        //TITULO
        titulo = new JLabel("Eliminar Curso");
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
        
        //BOTON ELIMINAR CURSO
        beliminar = new JButton("Eliminar Curso");
        beliminar.setBounds(100,500,280,40);
        beliminar.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(beliminar);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(140,100,100,30);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,18));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Eliminar Curso");
        this.setBounds(450, 100, 500, 600);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        codigot = tcodigo.getText();
        if (e.getSource() == beliminar) {
            int cod = Integer.parseInt(codigot);
            //PRIMERO VALIDAR QUE EXISTA
            Curso c = Clase6.mostrarCurso(cod);
            if (c != null) {
                Clase6.eliminarCurso(cod);
                JOptionPane.showMessageDialog(this, "Curso eliminado correctamente");
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro el curso");
            }
            this.dispose();
        }
    }
    
}
