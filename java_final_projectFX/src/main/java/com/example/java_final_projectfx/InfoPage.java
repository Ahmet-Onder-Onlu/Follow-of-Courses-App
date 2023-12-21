package com.example.java_final_projectfx;
//Sınıf için gerekli tüm FX kütüphanelerinin importu yapıldı.

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

// Öğrenci bilgilerinin ekrana basıldığı ekran kodu.
public class InfoPage {

    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<Person> students = new ArrayList<>();
    @FXML
    private TextField nameT;
    @FXML
    private TextField surnameT;
    @FXML
    private TextField titleT;
    @FXML
    private TextField classT;
    @FXML
    private TextField noT;
    @FXML
    private TextField courseHour;
    public void setStudentInfoGetI(Student std) {
        students.add((std));
    }

    // Ana ekrana geçiş fonksiyonu
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("get-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        GetPageController NewController = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        NewController.setStudentInfoGet((Student) students.get(0));
        stage.show();
    }
    //Verileri ekrana basan fonksiyon.
    @FXML
    public void setTextOnTextField() {
        nameT.setText(students.get(0).getName());
        surnameT.setText(students.get(0).getSurname());
        titleT.setText(students.get(0).getTitle());
        classT.setText(Integer.toString(students.get(0).getWhat_year()));
        noT.setText(Integer.toString(students.get(0).getNumber()));
        ArrayList<OptionalLessons> optLsn = students.get(0).getOptLes();
        ArrayList<FieldLessons> fldLsn = students.get(0).getFldLes();
        int total = 0;
        for(OptionalLessons opt : optLsn){
            total += opt.get_course_time();
        }
        total += fldLsn.get(0).get_course_time(Student.getAmountOfFieldLessons());
        courseHour.setText(Integer.toString(total));
    }

}
