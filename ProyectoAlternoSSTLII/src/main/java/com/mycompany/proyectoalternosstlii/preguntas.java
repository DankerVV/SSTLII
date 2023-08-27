
package com.mycompany.proyectoalternosstlii;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class preguntas {

    int id;
    int num;
    String pregunta;
    String rightAns;
    String wrongAns1;
    String wrongAns2;
    String wrongAns3;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRightAns() {
        return rightAns;
    }
    public void setRightAns(String righAns) {
        this.rightAns = righAns;
    }
    public String getWrongAns1() {
        return wrongAns1;
    }
    public void setWrongAns1(String wrongAns1) {
        this.wrongAns1 = wrongAns1;
    }
    public String getWrongAns2() {
        return wrongAns2;
    }
    public void setWrongAns2(String wrongAns2) {
        this.wrongAns2 = wrongAns2;
    }
    public String getWrongAns3() {
        return wrongAns3;
    }
    public void setWrongAns3(String wrongAns3) {
        this.wrongAns3 = wrongAns3;
    }
    
    public void insertarPreguntas(int id, int num, String pregunta, String correcta, String incorrecta1, String incorrecta2, String incorrecta3){
        setId(id);
        setNum(num);
        setPregunta(pregunta);
        setRightAns(correcta);
        setWrongAns1(incorrecta1);
        setWrongAns2(incorrecta2);
        setWrongAns3(incorrecta3);
        
        conexionBD objetoConexion = new conexionBD();
        String consulta = "insert into preguntas (id, num, question, right_ans, wrong_ans1,wrong_ans2,wrong_ans3)	values(?, ?, ?, ?, ?, ?, ?);";
        try{
            CallableStatement cs= objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getId());
            cs.setInt(2, getNum());
            cs.setString(3, getPregunta());
            cs.setString(4, getRightAns());
            cs.setString(5, getWrongAns1());
            cs.setString(6, getWrongAns2());
            cs.setString(7, getWrongAns3());
            cs.execute();
            //JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    }
    
    public String retornarPregunta(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(3);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
    
    public String retornarRespustaC(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(4);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
    
    public String retornarRespustaI1(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(5);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
    
    public String retornarRespustaI2(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(6);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
    
    public String retornarRespustaI3(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(7);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
     
    public String retornarNumPregunta(int id, int num){
        String aux="";
        conexionBD objetoConexion = new conexionBD();
        String sql="";        
        sql="select * from preguntas";
        Statement st;
        try{
            st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(1)==(id)&&rs.getInt(2)==(num)){
                    aux = rs.getString(3);
                    return aux;
                }
            }           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        return "FIN";
    }
    
    
    
}
