/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Alumno Tarde
 */
public interface DAO<E> {
    
    public List<E> listar() throws SQLException;
    
    public void insert(E e) throws SQLException;
    
    public void update(E e) throws SQLException;
    
    public void delete(E e) throws SQLException;
    
}
