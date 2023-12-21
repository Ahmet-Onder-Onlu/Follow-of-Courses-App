//Sınıf için gerekli tüm FX kütüphanelerinin importu yapıldı.
package com.example.java_final_projectfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.util.ArrayList;

// Bu controller ise kullanıcı girişinin alındığı kontrollerdır.
public class HelloController {
    ArrayList<Person> students = new ArrayList<>();
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField number;
    @FXML
    private TextField stdClass;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent root2;

    // Ana ekrana geçişi sağlayan fonksiyonun yazımı
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        handle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("get-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        GetPageController newController = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        newController.setStudentInfoGet((Student) students.get(0));

        stage.show();
    }

    // Text e girilen verilerden yeni öğrenci nesnesi oluşturan fonksiyon
    @FXML
    protected void handle() {
        String get_name = name.getText();
        String get_surname = surname.getText();
        String get_number = number.getText();
        String  get_class = stdClass.getText();
        int get_IClass = Integer.parseInt(get_class);
        int get_Inumber = Integer.parseInt(get_number);
        newStudent(get_name, get_surname, "Bachelor",get_IClass, get_Inumber);
    }

    public void newStudent(String sName, String sSurname, String sDegree, int sClass, int sNumber){
        Student std1 = new Student(sName, sSurname, sDegree, sClass, sNumber);
        System.out.println(std1);
        students.add(std1);
    }
}



