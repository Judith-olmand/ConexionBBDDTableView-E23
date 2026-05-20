package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    private TableView<Artista> tableView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejercicio 23");

        tableView = new TableView<>();

        // Definir columnas
        TableColumn<Artista, String> nombreCol = new TableColumn<>("Nombre");
        TableColumn<Artista, String> generoCol = new TableColumn<>("Genero Musical");


        // Asignar las propiedades del modelo a las columnas
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        generoCol.setCellValueFactory(new PropertyValueFactory<>("genero"));

        nombreCol.setMinWidth(200);
        generoCol.setMinWidth(200);

        tableView.getColumns().addAll(nombreCol, generoCol);

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 402, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        cargarDatos();
    }

    private void cargarDatos() {
        // INSTITUTO
//        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia según tu configuración
//        String user = "CONCIERTOS";                             // Cambia si es necesario
//        String password = "1234";                         // Cambia si es necesario

        // CASA
        String url = "jdbc:oracle:thin:@192.168.56.1:1521:xe"; // Cambia según tu configuración
        String user = "CONCIERTOS";                             // Cambia si es necesario
        String password = "1234";                         // Cambia si es necesario

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT NOMBRE_A, GENERO_MUSICAL FROM ARTISTA");) {
            while (rs.next()) {
                String nombre = rs.getString(1);
                String genero = rs.getString(2);
                tableView.getItems().add(new Artista(nombre, genero));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Artista {
        private final String nombre;
        private final String genero;

        public Artista(String nombre, String genero) {
            this.nombre = nombre;
            this.genero = genero;
        }

        public String getNombre() {
            return nombre;
        }

        public String getGenero() {
            return genero;
        }
    }
}