/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.ViewCsv;
import models.ModelCsv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author morenita
 */
public class ControllerCsv implements ActionListener{
    ViewCsv viewCsv;
    ModelCsv modelCsv;
    public ControllerCsv(ViewCsv viewCsv, ModelCsv modelCsv) {
        this.viewCsv = viewCsv;
        this.modelCsv = modelCsv;
        this.viewCsv.jbtn_guardar.addActionListener(this);
        this.viewCsv.jbtn_limpiar.addActionListener(this);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == viewCsv.jbtn_limpiar){
            limpiar();
        } 
        else if(e.getSource() == viewCsv.jbtn_guardar){
            guardar();
        }
    }
    /**
     * limpia las cajas de texto
     */
    public void limpiar(){
        viewCsv.jtf_nombre.setText("");
        viewCsv.jtf_correo.setText("");
    }
    /**
     * guarda los cambios
     */
    public void guardar(){
        modelCsv.setNombre(viewCsv.jtf_nombre.getText());
        modelCsv.setCorreo(viewCsv.jtf_correo.getText());
        modelCsv.escribir();
    }
    private void initComponents(){
        viewCsv.setVisible(true);
        modelCsv.escribir();
        viewCsv.jtf_nombre.setText(modelCsv.getNombre());
        viewCsv.jtf_correo.setText(modelCsv.getCorreo());
        
    }
}
