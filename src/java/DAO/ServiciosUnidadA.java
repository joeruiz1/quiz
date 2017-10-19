
package DAO;
import Conexion.DbUtil;
import VO.Contexto;
import VO.UnidadAbstracta;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ServiciosUnidadA {
     
    private Connection connection;

    public ServiciosUnidadA() {
        connection = DbUtil.getConnection();
    }

    public void agregarUnidad(UnidadAbstracta uni) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into unidadAbsInfo(idUnidad,id,id_Tabla) values (?, ?,? )");
            // Parameters start with 1
            preparedStatement.setInt(1, uni.getIdUnidad());
            preparedStatement.setInt(2, uni.getId());
            preparedStatement.setInt(3, uni.getIdUnidad());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public ArrayList<UnidadAbstracta> listarUni() {
        ArrayList<UnidadAbstracta> unidad = new ArrayList<UnidadAbstracta>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from unidadAbsInfo");
            while (rs.next()) {
                
              UnidadAbstracta u =new UnidadAbstracta();

                u.setIdUnidad(rs.getInt("idUnidad"));
                u.setId(rs.getInt("id"));
                u.setIdTabla(rs.getInt("id_Tabla"));
               
                unidad.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unidad;
    }
    
    
}
    

