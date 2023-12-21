//Sınıf için gerekli tüm FX kütüphanelerinin importu yapıldı.

package com.example.java_final_projectfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CoursePage {
// Ekran arayüzü için gerekli değişkenler
// Scene builder üzerinden alındı.
    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<Person> students = new ArrayList<>();
    @FXML
    private TextArea text1;
    @FXML
    private TextArea text2;
    @FXML
    private TextArea text3;
    @FXML
    private TextArea text4;
    @FXML
    private TextArea text5;
    @FXML
    private TextArea text6;
    @FXML
    private TextArea text7;
    @FXML
    private TextArea text8;
    private ArrayList<OptionalLessons> optlsns;
    private ArrayList<FieldLessons> fldlsns;

    // Ana ekrana geçişi ve veriyi oraya yollamayı sağlayan fonsiyon.
    //Geri tuşu aslında
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("get-page.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        GetPageController newController = loader.getController();

        // Öğrenci bilgisini alıcı controller'a aktar
        newController.setStudentInfoGet((Student) students.get(0));

        stage.show();
    }

    //Veriyi diğer controllerdan alan fonkiyon
    public void setStudentInfoGetC(Student std) {
        students.add((std));
    }

    //Dersleri textlere yazdırır. Ders klaslarından veriyi ekrana yazdırır.
    @FXML
    public void setTextOnText() {
      try{

        fldlsns = students.get(0).getFldLes();
        optlsns = students.get(0).getOptLes();
        if (!fldlsns.isEmpty()) {
            jusTest(text1, fldlsns.get(0));
        }
        else{
            text1.setVisible(false);
        }
        if (1 < fldlsns.size()) {
            jusTest(text2, fldlsns.get(1));
        }
        else{
            text2.setVisible(false);
        }
        if (2 < fldlsns.size()) {
            jusTest(text3, fldlsns.get(2));
        }
        else{
            text3.setVisible(false);
        }
        if (3 < fldlsns.size()) {
            jusTest(text4, fldlsns.get(3));
        }
        else{
            text4.setVisible(false);
        }
        if (!optlsns.isEmpty()) {
            jusTest2(text5, optlsns.get(0));
        }
        else{
            text5.setVisible(false);
        }
        if (1 < optlsns.size()) {
            jusTest2(text6, optlsns.get(1));
        }
        else{
            text6.setVisible(false);
        }
        if (2 < optlsns.size()) {
            jusTest2(text7, optlsns.get(2));
        }
        else{
            text7.setVisible(false);
        }
        if (3 < optlsns.size()) {
            jusTest2(text8, optlsns.get(3));
        }
        else{
            text8.setVisible(false);
        }
      }
      catch (Exception e){
          System.out.println("Hata!!! ");
      }

}


    // Dersleri tek tek yazdırmak yerine böyle for döngüsülerine atadım
        public void jusTest (TextArea text, FieldLessons fld){
            String metin = ("Ders adı: " + fld.get_lesson_name() + "\n" + "Ogretmen adı: " + fld.getTeacherName() + "\n" +
                    "Sınıf: " + fld.getWhat_year());
            text.setText(metin);
        }
        public void jusTest2 (TextArea text, OptionalLessons opt){
            String metin = ("Ders adı: " + opt.get_lesson_name() + "\n" + "Ogretmen adı: " + opt.getTeacherName() + "\n" +
                    "Sınıf: " + opt.getWhat_year());
            text.setText(metin);
        }

}
