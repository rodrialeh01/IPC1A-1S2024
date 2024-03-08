/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Movimiento extends Thread {

    private JLabel label;
    private JLabel label2;
    private int limiteIzq;
    private int limiteDer;
    private boolean derecha;
    private JFrame ventana;
    private static boolean estado = true;

    public Movimiento(JLabel label,JLabel label2, int limiteIzq, int limiteDer, JFrame ventana) {
        this.label = label;
        this.label2 = label2;
        this.limiteIzq = limiteIzq;
        this.limiteDer = limiteDer;
        this.derecha = true;
        this.ventana = ventana;
    }

    @Override
    public void run() {
        try {
            int inicial = Integer.parseInt(label2.getText());
            while (estado) {
                int x = label.getX();
                int x2 = label2.getX();
                
                if (derecha) {
                    if (x >= limiteDer) {
                        derecha = false;
                    }
                } else {
                    if (x <= limiteIzq) {
                        derecha = true;
                    }
                }

                if (derecha) {
                    x++;
                    x2++;
                } else {
                    x--;
                    x2--;
                }
                inicial = inicial - 1;
                this.label.setLocation(x, label.getY());
                this.label2.setLocation(x2,label.getY());
                this.label2.setText(String.valueOf(inicial));
                if(inicial == 0){
                    this.pausar();
                }
                //label2.repaint();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pausar(){
        estado = false;
    }
    
    public void reanudar(){
        estado = true;
    }
}
