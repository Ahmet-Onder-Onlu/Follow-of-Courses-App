package com.example.java_final_projectfx;
//Sınıf için gerekli tüm FX kütüphanelerinin importu yapıldı.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// Kullanıcı girişinden sonra gelen ana ekran ve seçim yapılır.
public class GetPageController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button add;
    ArrayList<Person> students = new ArrayList<>();

    // Kullanıcı girişene dönüş yapan sayfa
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Ders ekle controllerına geçiş yapan sayfa(ders ekle butonu)
    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        newController NewController = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        NewController.setStudentInfoGets((Student) students.get(0));
        stage.show();
    }

    // Dersleri gösteren sayfaya geçiş yapan fonksiyon
    @FXML
    public void switchToScene4(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("course-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        CoursePage NewControllerI = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        NewControllerI.setStudentInfoGetC((Student) students.get(0));
    }
    // Ders kaldır sayfasına geçişi sağlayan fonksiyon
    @FXML
    public void switchToScene5(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rem-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        RemPage NewControllerR = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        NewControllerR.setStudentInfoGetR((Student) students.get(0));
    }

    // Öğrenci bilgilerini gösteren sayfaya geçiş yapan buton fonksiyonu.
    @FXML
    public void switchToScene6(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("info-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        InfoPage NewControllerI = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        NewControllerI.setStudentInfoGetI((Student) students.get(0));
    }

    // GÖnderilen student verisini alır.
    public void setStudentInfoGet(Student std) {
        students.add((std));
    }
}