/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Clases.Curso;
import clase5.Clase5;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class VEditarCurso extends JFrame implements ActionListener, MouseListener, KeyListener{
    
    JLabel titulo, lcodigo, lnombre, lcreditos;
    JTextField tcodigo,tnombre,tcreditos;
    JButton bcrear, bbuscar;
    String codigot, nombret, creditost;

    public VEditarCurso() {
        //TITULO
        titulo = new JLabel("Editar Curso");
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
        
        //BOTON BUSCAR
        bbuscar = new JButton("Buscar");
        bbuscar.setBounds(280,100,100,30);
        bbuscar.setFont(new Font("Century Gothic",Font.BOLD,18));
        bbuscar.addActionListener(this);
        bbuscar.setVisible(true);
        this.add(bbuscar);
        
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
        
        //BOTON EDITAR CURSO
        bcrear = new JButton("Editar Curso");
        bcrear.setBounds(100,500,280,40);
        bcrear.addActionListener(this);
        //BLOQUEAR UN BOTON
        bcrear.setEnabled(false);
        this.add(bcrear);
        
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Editar Curso");
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
        if(e.getSource() == bbuscar){
            Curso encontrado = Clase5.mostrarCurso(Integer.parseInt(codigot));
            if(encontrado != null){
                tcodigo.setEditable(false);
                tnombre.setText(encontrado.getNombre());
                tcreditos.setText(String.valueOf(encontrado.getCreditos()));
                bcrear.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro el curso");
            }
        }else if(e.getSource() == bcrear){
            //FORMAS DE ACTUALIZAR
            //creando el objeto y seteando el objeto
            /*
            Curso c = new Curso(Integer.parseInt(codigot), nombret, Integer.parseInt(creditost));
            Clase5.actualizarCurso(Integer.parseInt(codigot), c);
            */
            
            //USANDO EL SET
            for (int i = 0; i < Clase5.cursos.size(); i++) {
                if (Clase5.cursos.get(i).getCodigo() == Integer.parseInt(codigot)) {
                    Clase5.cursos.get(i).setNombre(nombret);
                    Clase5.cursos.get(i).setCreditos(Integer.parseInt(creditost));
                }
            }
            
            JOptionPane.showMessageDialog(this, "Se actualizó el curso");
            this.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //CUANDO HACE CLICK HACE UN EVENTO
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //CUANDO PRESIONA UN COMPONENTE HACED UN EVENTO
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //CUANDO SUELTA EL COMPONENTE HACE UN EVENTO
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //CUANDO NOS POSICIONAMOS DENTRO DE UN COMPONENTE
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //cuando nos posicionamos fuera del componente
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //CUANDO ESCRIBE HACE EL EVENTO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //CUANDO PRESIONO UNA TECLA
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //CUANDO SUELTO UNA TECLA
    }
    
}
