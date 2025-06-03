package org.example.dao;

import org.example.modelo.Vehiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoCrud {
    //Realizar conexion base de datos en MySQL
    //credenciales
    private final String url = "jdbc:mysql://localhost:3306/parking";
    private final String user = "root";
    private final String password = "";
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //metodo para agregar un vehiculo
    public void agregarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (nroplaca, marca , precio) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmtquery = conn.prepareStatement(sql)) {
            stmtquery.setString(1,vehiculo.getNroplaca());
            stmtquery.setString(2,vehiculo.getMarca());
            stmtquery.setInt(3,vehiculo.getPrecio());
            stmtquery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Metodos listar los vehiculos//
    public List<Vehiculo> listarVehiculos() {
        //crear lista para almacenar los vehiculos de la tabla respectiva//
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";

        try (Connection conn = conectar();
             //crear objeto de la clase Statement
             Statement stmt = conn.createStatement();
             // Ejecutar la instruccion que contiene la variable SQL
             ResultSet rs = stmt.executeQuery(sql)) {
            // Recorrer rs con todos los vehiculos devueltos a
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getString("nroplaca"),
                        rs.getString("marca"),
                        rs.getInt("precio")
                );
                //agregar cada libro a la lista (lista)//
                lista.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
