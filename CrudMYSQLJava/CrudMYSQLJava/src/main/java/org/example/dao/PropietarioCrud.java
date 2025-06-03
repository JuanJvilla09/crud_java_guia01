package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PropietarioCrud {
    //Realizar conexion base de datos en MySQL
    private final String url = "jdbc:mysql://localhost:3306/parking";
    private final String user = "root";
    private final String password = "";
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
