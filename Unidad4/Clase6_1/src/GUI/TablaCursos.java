/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rodri
 */
public class TablaCursos extends DefaultTableCellRenderer{
    //RENDERZAR LA TABLA PARA QUE PUEDA LEER DE MANERA CORRECTA LOS LABEL
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bin1,int i, int i1){
        if(o instanceof JLabel){
            JLabel lbl = (JLabel) o;
            return lbl;
        }
        return super.getTableCellRendererComponent(jtable, o, bin1, bin1, i, i1);
    }
}
