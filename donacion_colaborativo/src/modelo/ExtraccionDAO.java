/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Tarde
 */
public class ExtraccionDAO implements DAO<Extraccion> {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection dbCon;
    Conexion c = new Conexion();
    
    public List<Extraccion> listar() throws SQLException {
        List<Extraccion> extracciones = new ArrayList<>();
          
        dbCon = c.conectar();
        ps = dbCon.prepareStatement("SELECT * FROM EXTRACCIONES");
        rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println("Extraccion cargada");
            extracciones.add(rsAExtraccion(rs));
        }

        return extracciones;
    }
    
    private Extraccion rsAExtraccion(ResultSet rs) {
        System.out.println("Convirtiendo extraccion");
        Extraccion e = new Extraccion();
        try {
            e.setNumero(rs.getInt("NUMERO"));
            e.setDni(rs.getString("DNI"));
            e.setNombre(rs.getString("NOMBRE"));
            e.setTelefono(rs.getString("TELEFONO"));
            e.setLugar(rs.getString("LUGAR"));
            e.setFecha(rs.getDate("FECHA").toLocalDate());
            e.setGrupo(rs.getString("GRUPO"));
            e.setRh(rs.getString("RH"));
        } catch (SQLException ex) {
            System.out.println("Error leyendo de la base de datos");
        }
        return e;
    }

    @Override
    public void insert(Extraccion e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Extraccion e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Extraccion e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
