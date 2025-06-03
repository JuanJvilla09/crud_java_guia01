package org.example;


import org.example.dao.VehiculoCrud;
import org.example.modelo.Vehiculo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //probar conexion base de datos
        VehiculoCrud oVehiculo = new VehiculoCrud();

        Connection conn = null;
        try {
            conn = oVehiculo.conectar(); // Intenta conectar

            // Verificación con condicional
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexión realizada correctamente.");
                System.out.print("Ingrese numero de placa: ");
                String nroplaca = sc.nextLine();
                System.out.print("Ingrese la marca: ");
                String marca = sc.nextLine();
                System.out.print("Ingrese precio: ");
                Integer precio = sc.nextInt();
                oVehiculo.agregarVehiculo(new Vehiculo(nroplaca, marca , precio));
                System.out.println("Vehiculo agregado exitosamente.....");
                oVehiculo.listarVehiculos().forEach(vehiculo ->
                        System.out.println(vehiculo.getNroplaca() + " | " + vehiculo.getMarca() + " | " + vehiculo.getPrecio()));

            } else {
                System.out.println("Conexión fallida.");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            //e.printStackTrace();
        }

        // fin probar la conexión




    }
}