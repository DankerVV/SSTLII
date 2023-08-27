package com.mycompany.proyectoalternosstlii;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author carlossalcidoa
 */
public class conexionBD {
     Connection conectar = null;
    
    String usuario="postgres";
    String contrasenia=".UdeG-3847";
    String bd="ProyectoAlternoSSTLII";
    String ip="localhost";
    String puerto="5432";
  
    String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            conectar= DriverManager.getConnection(cadena, usuario, contrasenia);
            //JOptionPane.showMessageDialog(null, "Conexión a la Base de Datos exitosa");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos:"+ e.toString());
        }
        return conectar;
    }
}
