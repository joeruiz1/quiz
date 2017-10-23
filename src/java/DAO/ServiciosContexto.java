/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexion.DbUtil;
import VO.Contexto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiciosContexto {
    
    
    private Connection connection;

    public ServiciosContexto() {
        connection = DbUtil.getConnection();
    }

    public void agregarContexto(Contexto con) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into contextoNavegacion(id,link,idM) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setInt(1, con.getId());
            preparedStatement.setString(2, con.getLink());
            preparedStatement.setInt(3, con.getIdM());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("agrego algo");
        }
    }
     public ArrayList<Contexto> listarCo() {
        ArrayList<Contexto> contexto = new ArrayList<Contexto>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from contextoNavegacion");
            while (rs.next()) {
                
                Contexto c=new Contexto();

                c.setId(rs.getInt("id "));
                c.setLink(rs.getString("link"));
                c.setIdM(rs.getInt("idM"));
               
                contexto.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contexto;
    }
    
    
}
    

