package Dao;

import Conexion.Conex;
import Modelo.Entradas;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;

public class EntradasDao {
    Conex conn;

    public EntradasDao(Conex conn) {
        this.conn = conn;
    }
    
    public boolean Insertar(Entradas Ent){
        String sql = "insert into entrada values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            //conexion ala base con unos parametros dados en este caso la sentencia sql
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            ps.setInt(1, Ent.getId());
            ps.setString(2, Ent.getNombre());
            ps.setString(3, Ent.getApellido());
            ps.setInt(4, Ent.getHabitacion());
            ps.setString(5, formato.format(Ent.getEntrada()));
            ps.executeUpdate();
            //Seteamos con los parametros necesarios para enviar ala bd datos que retornamos antes en el modelo
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Entradas> selectAll(){
        String sql = "select * from entrada";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Entradas Entr;
            List<Entradas> lista = new LinkedList<>();
            while (rs.next()) {                
                Entr = new Entradas(rs.getInt("id"));
                Entr.setNombre(rs.getString("nombre"));
                Entr.setApellido(rs.getString("apellido"));
                Entr.setHabitacion(rs.getInt("habitacion"));
                //Entr.setEntrada(rs.getDate("entrada"));
                lista.add(Entr);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
