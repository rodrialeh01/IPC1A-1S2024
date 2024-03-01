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
import GUI.VentanaAdmin;
import clase6.Clase6;

/**
 *
 * @author rodri
 */
public class VAuth extends JFrame implements ActionListener{

    JLabel titulo, lcodigo, lpas;
    JTextField tcodigo;
    JPasswordField tpassword;
    String cod, pas;
    JButton bLogin;
    JRadioButton opcion1, opcion2;
    
    public VAuth() {
        //TITULO
        titulo = new JLabel("LOGIN");
        titulo.setFont(new Font("Century Gothic",Font.BOLD,50));
        titulo.setBounds(200,10,400,90);
        titulo.setVisible(true);
        this.add(titulo);
        
        //label de codigo
        lcodigo = new JLabel("Codigo: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcodigo.setBounds(50,130,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //TEXTFIELD DE CODIGO
        tcodigo = new JTextField();
        tcodigo.setBounds(160,130,350,25);
        tcodigo.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tcodigo.setVisible(true);
        this.add(tcodigo);
        
        //label de PASSWORD
        lcodigo = new JLabel("Contrasenia: ");
        lcodigo.setFont(new Font("Century Gothic",Font.BOLD,15));
        lcodigo.setBounds(50,200,100,30);
        lcodigo.setVisible(true);
        this.add(lcodigo);
        
        //TEXTFIELD DE PASSWORD
        tpassword = new JPasswordField();
        tpassword.setBounds(160,200,350,25);
        tpassword.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tpassword.setVisible(true);
        this.add(tpassword);
        
        //BOTON ELIMINAR CURSO
        bLogin = new JButton("Iniciar Sesión");
        bLogin.setFont(new Font("Century Gothic",Font.PLAIN,15));
        bLogin.setBounds(240,280,150,30);
        bLogin.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(bLogin);
        
        //radiobutton
        opcion1 = new JRadioButton("Estudiante", false);
        opcion1.setBounds(220, 230,100,30);
        opcion1.setVisible(true);
        this.add(opcion1);
        opcion2 = new JRadioButton("Profesor", false);
        opcion2.setBounds(320, 230,100,30);
        opcion2.setVisible(true);
        this.add(opcion2);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Login");
        this.setBounds(400, 200, 600, 400);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cod = tcodigo.getText();
        pas = tpassword.getText();
        if(e.getSource() == bLogin){
            int codigo = Integer.parseInt(cod);
            if(cod.equals("201900042") && pas.equals("IPC12024")){
                JOptionPane.showMessageDialog(this, "Bienvenido Admin");
                VentanaAdmin va = new VentanaAdmin();
                this.dispose();
            }else if(Clase6.AutenticacionEstudiantes(codigo, pas) == true){
                //SE VA AL MODULO DE ESTUDIANTES
            }else if(Clase6.AutenticacionProfesores(codigo, pas) == true){
                //SE VA AL MODULO DE PROFESORES
            }else{
                JOptionPane.showMessageDialog(this, "Credenciales Incorrectas");
            }
        }
    }
    
}
