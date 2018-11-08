/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import views.ViewCsv;
/**
 * 
 * @author morenita
 */
public class ModelCsv {
    private String nombre = "";
    private String correo = "";
    private String path = "C:\\archivos\\base.csv";//creacion del archivo en el disco local c
    boolean condicion = true;
    ViewCsv viewCsv;

    //se crean los metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    public ViewCsv getViewCsv() {
        return viewCsv;
    }

    public void setViewCsv(ViewCsv viewCsv) {
        this.viewCsv = viewCsv;
    }
    /**
     * lee un archivo
     */
    public void leer(){
        try{
            String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    String [] campo = row.split(",");
                    nombre = campo[0];
                    correo = campo[1]; 
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewCsv,"File not found: " + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewCsv,"Error en I/O operation" + ex.getMessage());
        }
    }
    /**
     * escribe en el archivo
     */
    public void escribir(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter (file,condicion);
            try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                ArrayList<String> nuevo = new ArrayList<>();
                nuevo.add(nombre);
                nuevo.add(correo);
                printWriter.print(nombre + "," + correo);
                printWriter.close();
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewCsv,"Error en I/O operation" + ex.getMessage());
                }
            }
}
