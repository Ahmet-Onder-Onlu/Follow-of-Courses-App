package com.example.java_final_projectfx;
// Yine gerekli importlar yapıldı FX ve araylist...
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Ders kaldırmak için kullanılan class veya controller
public class RemPage {

    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private CheckBox check6;
    @FXML
    private CheckBox check7;
    @FXML
    private CheckBox check8;
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Arraylistler depolamak için oluşturuldu.
    // Öğrenci verisi mesala diğer controllerdan alındı.
    ArrayList<Person> students = new ArrayList<>();
    ArrayList<FieldLessons> fldlsns = new ArrayList<>();
    ArrayList<OptionalLessons> optlsns = new ArrayList<>();
    // Ana sayfaya geçiş fonksiyonu oluşturuldu
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

    // Diğer controllerdan veri alınır.
    public void setStudentInfoGetR(Student std) {
        System.out.println(std.getName());
        students.add((std));
    }

    // Eğer chechkbox boş değilse ona metin dersi atar.
    @FXML
    public void setCourses(){
        Person std_get = students.get(0);
        fldlsns = std_get.getFldLes();
        optlsns = std_get.getOptLes();

        try{
            if (!fldlsns.isEmpty()) {
                check1.setText(fldlsns.get(0).get_lesson_name());
            }
            else{
                check1.setVisible(false);
            }
            if (1 < fldlsns.size()) {
                check2.setText(fldlsns.get(1).get_lesson_name());
            }
            else{
                check2.setVisible(false);
            }
            if (2 < fldlsns.size()) {
                check3.setText(fldlsns.get(2).get_lesson_name());
            }
            else{
                check3.setVisible(false);
            }
            if (3 < fldlsns.size()) {
                check4.setText(fldlsns.get(3).get_lesson_name());
            }
            else{
                check4.setVisible(false);
            }
            if (!optlsns.isEmpty()) {
                check5.setText(optlsns.get(0).get_lesson_name());
            }
            else{
                check5.setVisible(false);
            }
            if (1 < optlsns.size()) {
                check6.setText(optlsns.get(1).get_lesson_name());
            }
            else{
                check6.setVisible(false);
            }
            if (2 < optlsns.size()) {
                check7.setText(optlsns.get(2).get_lesson_name());
            }
            else{
                check7.setVisible(false);
            }
            if (3 < optlsns.size()) {
                check8.setText(optlsns.get(3).get_lesson_name());
            }
            else{
                check8.setVisible(false);
            }
        }
        catch (Exception e){
            System.out.println("Hata!!! ");
        }
    }


    // Önce seçili lan checkboxlardan verileri alır sonra kaldıırır.

    @FXML
    private void remL() throws NotFound {
      try{
        Person std_get = students.get(0);
        fldlsns = std_get.getFldLes();
        optlsns = std_get.getOptLes();
        // Seçili olan checkBox'ların verilerini bir listeye ekleyin.
        List<String> selectedCheckboxesF = new ArrayList<>();
        List<String> selectedCheckboxesO = new ArrayList<>();
        if (check1.isSelected()) {
            selectedCheckboxesF.add(check1.getText());
        }
        if (check2.isSelected()) {
            selectedCheckboxesF.add(check2.getText());
        }
        if (check3.isSelected()) {
            selectedCheckboxesF.add(check3.getText());
        }
        if (check4.isSelected()) {
            selectedCheckboxesF.add(check4.getText());
        }
        if (check5.isSelected()) {
            selectedCheckboxesO.add(check5.getText());
        }
        if (check6.isSelected()) {
            selectedCheckboxesO.add(check6.getText());
        }
        if (check7.isSelected()) {
            selectedCheckboxesO.add(check7.getText());
        }
        if (check8.isSelected()) {
            selectedCheckboxesO.add(check8.getText());
        }

        // Dersleri kaldırır.
        for (String lsnName : selectedCheckboxesF) {
            for (FieldLessons fld : fldlsns) {
                if (lsnName.equals(fld.get_lesson_name())) {
                    students.get(0).deleteFieldLessons(fld);
                }
            }
        }

        for (String lsnName : selectedCheckboxesO) {
            for (OptionalLessons opt : optlsns) {
                if (lsnName.equals(opt.get_lesson_name())) {
                    students.get(0).deleteOptionalLessons(opt);
                }
            }
        }
    }
      catch (RuntimeException e){
          System.out.println("Go.");
      }
    }
}
