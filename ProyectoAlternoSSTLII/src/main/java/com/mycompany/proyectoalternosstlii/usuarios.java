package com.mycompany.proyectoalternosstlii;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class usuarios {
    String nombre;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void insertarCliente(String name){
        setNombre(name);
        
        conexionBD objetoConexion = new conexionBD();
        String consulta = "insert into usuarios (nombre)	values(?);";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1, getNombre());
            cs.execute();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    }
    
    void login(String nombre){
        conexionBD objetoConexion = new conexionBD();
        int band=0;
        String sql;
        sql="select * from usuarios";
        
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(1).equals(nombre)){
                    band=1;
                }
            }           
            if(band!=1){
                insertarCliente(nombre);
                //return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    //return true;
    }
}
