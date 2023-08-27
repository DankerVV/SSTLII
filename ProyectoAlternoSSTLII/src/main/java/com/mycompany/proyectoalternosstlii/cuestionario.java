package com.mycompany.proyectoalternosstlii;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class cuestionario {
    int id;
    String nombre;
    String campeon;
    int puntaje_campeon;
    int num_preguntas;
    String creador;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCampeon() {
        return campeon;
    }
    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }
    public int getPuntaje_campeon() {
        return puntaje_campeon;
    }
    public void setPuntaje_campeon(int puntaje_campeon) {
        this.puntaje_campeon = puntaje_campeon;
    }
    public int getNum_preguntas() {
        return num_preguntas;
    }
    public void setNum_preguntas(int num_preguntas) {
        this.num_preguntas = num_preguntas;
    }
    public String getCreador() {
        return creador;
    }
    public void setCreador(String creador) {
        this.creador = creador;
    }
    
    public void insertarCuestionario(String nombre, String campeon, int puntaje, int num_preguntas, String creador){   
        setNombre(nombre);
        setCampeon(campeon);
        setPuntaje_campeon(puntaje);
        setNum_preguntas(num_preguntas);
        setCreador(creador);
        
        conexionBD objetoConexion = new conexionBD();
        String consulta = "insert into cuestionario (nombre, champ, champ_score, num_preguntas, creador)	values(?, ?, ?, ?, ?);";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.setString(2, getCampeon());
            cs.setInt(3, getPuntaje_campeon());
            cs.setInt(4, getNum_preguntas());
            cs.setString(5, getCreador());
            cs.execute();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());

        }
    }
    
    public int ultimoID(){
        int aux=0;
        conexionBD objetoConexion = new conexionBD();
        String sql="";
        sql = "SELECT MAX(id) AS valor_maximo FROM cuestionario;";// WHERE compras.nom_us = ? ;";
        String [] datos = new String [9];
        Statement st;        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                aux = rs.getInt(1);
            }
            System.out.println("AUX:"+aux);
            return aux;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return 0;
    }
    
    void mostrarTabla(JTable tabla){
        conexionBD objetoConexion = new conexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql="";
        
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Mayor.Punt");
        modelo.addColumn("Num.Preguntas");
        modelo.addColumn("Creador");
        
        tabla.setModel(modelo);
        sql = "select * from cuestionario";// WHERE compras.nom_us = ? ;";
        String [] datos = new String [5];
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3) +": "+ rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                modelo.addRow(datos);                
            }
            
            tabla.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    }

    public int retornarPuntaje(int id){
        int aux=0;
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from cuestionario";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)){
                    aux = rs.getInt(4);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return aux;
    }
    
    public void modificarCampeon(String campeon, int puntaje, int id){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        
        //NO SE PQ PERO SI NO, NO JALA
        String sql;
        sql="select * from cuestionario";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();            
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                ;
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        
        //ACTUALIZAR BASE DE DATOS
        String consulta = "update cuestionario set champ = ?  where id = ?";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, campeon);
            //cs.setInt(2, puntaje);
            cs.setInt(2, id);
            cs.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        consulta = "update cuestionario set champ_score = ?  where id = ?";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, puntaje);
            cs.setInt(2, id);
            cs.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    }
    
    
}
