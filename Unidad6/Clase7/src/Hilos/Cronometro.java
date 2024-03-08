/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Cronometro extends Thread{
    private int segundos;
    private int minutos;
    private JLabel label;
    
    private static boolean estado = true;

    public Cronometro(JLabel label) {
        this.segundos = 0;
        this.minutos = 0;
        this.label = label;
    }
    
    @Override
    public void run(){
        try {
            while(true){
                if(estado){
                    System.out.println("Tiempo: " + this.minutos + ":" + this.segundos);
                    if(this.minutos <10){
                        if(this.segundos <10){
                            label.setText("0" + this.minutos + ":0" + this.segundos);
                        }else{
                            label.setText("0" + this.minutos + ":" + this.segundos);
                        }
                    }else{
                        if(this.segundos <10){
                            label.setText("0" + this.minutos + ":0" + this.segundos);
                        }else{
                            label.setText("0" + this.minutos + ":" + this.segundos);
                        }
                    }
                    Thread.sleep(1000);
                    this.segundos++;
                    if(this.segundos == 60){
                        this.minutos ++;
                        this.segundos = 0;
                    }
                }else{
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pausar(){
        estado = false;
    }
    
    public void reanudar(){
        estado = true;
    }
    
    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public static boolean isEstado() {
        return estado;
    }

    public static void setEstado(boolean estado) {
        Cronometro.estado = estado;
    }
    
    
}
