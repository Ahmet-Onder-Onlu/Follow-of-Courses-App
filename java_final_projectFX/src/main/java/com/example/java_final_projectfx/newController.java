package com.example.java_final_projectfx;
//Sınıf için gerekli tüm FX kütüphanelerinin importu yapıldı.

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

// Derslerin seçilip eklendiği controller.
//CheckBoxlardan gelen verilere göre ders ekler

public class newController implements Initializable {
    // Tüm değişkenler scene builder da bulunan araçlar burada tanımlandı.
    @FXML
    private Label successful;
    @FXML
    private Button add;
    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private ChoiceBox<String> choiceBox3;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private Button saveL;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<Person> students = new ArrayList<>();

    // Kullanıcının alabileceği dersler ve hocalar burada tanımlandı
    // KUllanıcı ders sınırlarını(3-3, 4-4) sınıf düzeyine göre aşmadığ
    //sürece ders ekleyebilir.
    String[] birinciSinifSecmeliDersler = {
            "Introduction to Economics",
            "Introduction to Psychology",
            "Introduction to Philosophy"
    };

    String[] ikinciSinifSecmeliDersler = {
            "Principles of Accounting",
            "Sociology",
            "Art History"
    };

    String[] ucuncuSinifSecmeliDersler = {
            "Business Ethics",
            "Environmental Science",
            "Modern Literature"
    };

    String[] dorduncuSinifSecmeliDersler = {
            "International Relations",
            "Public Speaking",
            "Cultural Anthropology"
    };

    String[] birinciSinifZorunluDersler = {
            "Calculus I",
            "Linear Algebra I",
            "Introduction to Computer Science",
            "Statistics"
    };

    String[] ikinciSinifZorunluDersler = {
            "Calculus II",
            "Linear Algebra II",
            "Data Structures and Algorithms",
            "Probability Theory"
    };

    String[] ucuncuSinifZorunluDersler = {
            "Real Analysis",
            "Abstract Algebra",
            "Database Systems",
            "Machine Learning"
    };

    String[] dorduncuSinifZorunluDersler = {
            "Complex Analysis",
            "Numerical Analysis",
            "Software Engineering",
            "Big Data Analytics"
    };

    String[] ogretmenIsimleri = {
            "John Smith", "Emma Johnson", "Michael Williams", "Olivia Brown", "Sophia Davis", "William Miller", "Ava Wilson",
            "James Moore", "Isabella Taylor"
    };



    public void setStudentInfoGets(Student std) {
            students.add((std));
        }

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
    // Seçili checkBoxları kontrol eder ve seçilen Ders ekle, sınıf ve seçmeli mi
    // Yoksa zorunlu ders mi olduğuna göre dersi ekler. Bu dersler ayrılmıştır.
    @FXML
    private void saveSelectedCourses() throws NotFound {

            if (choiceBox3.getValue().equals("Secmeli Ders")) {
                try {
                    OptionalLessons opt1 = null, opt2 = null, opt3 = null;
                    if (checkBox1.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        opt1 = new OptionalLessons(checkBox1.getText(), ogretmenIsimleri[0], "Secmeli", sinif, 2);
                    }
                    if (checkBox2.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        opt2 = new OptionalLessons(checkBox2.getText(), ogretmenIsimleri[1], "Secmeli", sinif, 2);
                    }
                    if (checkBox3.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        opt3 = new OptionalLessons(checkBox3.getText(), ogretmenIsimleri[2], "Secmeli", sinif, 2);
                    }
                    if (opt1 == null && opt2 == null && opt3 == null) {
                        throw new NotFound("Herhangi bir ders bulunamadı!");
                    }
                    else{
                        Person student = students.get(0);

                        if (opt1 != null) {
                            student.addOptionalLessons(opt1);
                        }

                        if (opt2 != null) {
                            student.addOptionalLessons(opt2);
                        }

                        if (opt3 != null) {
                            student.addOptionalLessons(opt3);
                        }

                        successful.setText("Successfully added(S.D.)");
                        System.out.println("Successfully added(S.D.) ");
                    }
                }
                catch (NotFound | BoundOfLessons | Alreadyhave nf){
                    System.out.println(nf);
                }
            }


        else{
                try {
                    FieldLessons fld1 = null, fld2 = null, fld3 = null, fld4 = null;
                    if (checkBox1.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        fld1 = new FieldLessons(checkBox1.getText(), ogretmenIsimleri[3], "Zorunlu", sinif, 4);
                    }
                    if (checkBox2.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        fld2 = new FieldLessons(checkBox2.getText(), ogretmenIsimleri[4], "Zorunlu", sinif, 4);
                    }
                    if (checkBox3.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        fld3 = new FieldLessons(checkBox3.getText(), ogretmenIsimleri[5], "Zorunlu", sinif, 4);
                    }
                    if (checkBox4.isSelected()) {
                        int sinif = Integer.parseInt(choiceBox2.getValue());
                        fld4 = new FieldLessons(checkBox4.getText(), ogretmenIsimleri[6], "Zorunlu", sinif, 4);
                    }
                    if (fld1 == null && fld2 == null && fld3 == null && fld4 == null) {
                        throw new NotFound("Herhangi bir ders bulunamadı!");
                    }
                    // Eğer dersler boş yani null değilse arrayliste eklenir.
                    else{
                        Person student = students.get(0);

                        if (fld1 != null) {
                            student.addFieldLessons(fld1);
                        }

                        if (fld2 != null) {
                            student.addFieldLessons(fld2);
                        }

                        if (fld3 != null) {
                            student.addFieldLessons(fld3);
                        }

                        if (fld4 != null) {
                            student.addFieldLessons(fld4);
                        }
                        successful.setText("Successfully added(Z.D.)");
                        System.out.println("Successfully added(Z.D.) ");
                    }
                }
                // Hatalar ayıklanır.
                catch (NotFound nf){
                    System.out.println(nf);
                } catch (BoundOfLessons bl) {
                     System.out.println(bl);
                } catch (Alreadyhave ald) {
                    System.out.println(ald);
                }
            }
    }

    // Seçmeli dersleri checkboxlara atar.
    public void SecmeliAta(String[] array){
        for(int i= 0; i < 3; i++){
            CheckBox checkBox = getCheckBoxByIndex(i);
            assert checkBox != null;
            checkBox.setText(array[i]);
            checkBox.setVisible(true);

        }
        CheckBox getcheckBox = getCheckBoxByIndex(3);
        assert getcheckBox != null;
        getcheckBox.setVisible(false);
    }
    // Zorunlu dersleri kullanıcının görmesi için ekrana atar.
    public void ZorunluAta(String[] array){
        for(int i= 0; i < 4; i++){
            CheckBox checkBox = getCheckBoxByIndex(i);
            assert checkBox != null;
            checkBox.setText(array[i]);
            checkBox.setVisible(true);
        }
    }


        // Diğer kodlar



    // Ekran açılıdğı an başlatılacak fonksiyondur.İlk açılışta atanması gereken
    // Butonları içerikleri ve listelerin atamasını yapar.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Ders Ekle"
                //"Ders Sil",
                //"Kisisel Bilgileri Görüntüle",
                //"Aldıgım Dersleri Görüntüle"
        );
        choiceBox1.setItems(options);

        // İkinci ChoiceBox'un içeriğini doldur
        ObservableList<String> secondOptions = FXCollections.observableArrayList(
                "1",
                "2",
                "3",
                "4"
        );
        choiceBox2.setItems(secondOptions);

        // Üçüncü ChoiceBox'un içeriğini doldur
        ObservableList<String> thirdOptions = FXCollections.observableArrayList(
                "Secmeli Ders",
                "Zorunlu Ders"
        );
        choiceBox3.setItems(thirdOptions);

        // İkinci ChoiceBox'un görünürlüğünü kontrol et
        choiceBox1.setOnAction(event -> {
            if (choiceBox1.getValue() != null && choiceBox1.getValue().equals("Ders Ekle")) {
                choiceBox2.setVisible(true);
            } else {
                choiceBox2.setVisible(false);
                choiceBox3.setVisible(false);
            }
        });

        // Üçüncü ChoiceBox'un görünürlüğünü kontrol et
        choiceBox2.setOnAction(event -> {
            if (choiceBox2.getValue() != null) {
                choiceBox3.setVisible(true);
            } else {
                choiceBox3.setVisible(false);
            }
        });

        // Seçimleri konsola yazdır
        choiceBox3.setOnAction(event -> {
            if (choiceBox1.getValue() != null && choiceBox1.getValue().equals("Ders Ekle")) {
                 if(choiceBox2.getValue().equals("1")){
                     if(choiceBox3.getValue().equals("Secmeli Ders")){
                         SecmeliAta(birinciSinifSecmeliDersler);
                     }
                     else{
                         ZorunluAta(birinciSinifZorunluDersler);
                     }
                 }
                 else if(choiceBox2.getValue().equals("2")){
                     if(choiceBox3.getValue().equals("Secmeli Ders")){
                         SecmeliAta(ikinciSinifSecmeliDersler);
                     }
                     else{
                         ZorunluAta(ikinciSinifZorunluDersler);
                     }
                 }
                 else if(choiceBox2.getValue().equals("3")){
                     if(choiceBox3.getValue().equals("Secmeli Ders")){
                         SecmeliAta(ucuncuSinifSecmeliDersler);
                     }
                     else{
                         ZorunluAta(ucuncuSinifZorunluDersler);
                     }
                 }
                 else if(choiceBox2.getValue().equals("4")){
                     if(choiceBox3.getValue().equals("Secmeli Ders")){
                         SecmeliAta(dorduncuSinifSecmeliDersler);
                     }
                     else{
                         ZorunluAta(dorduncuSinifZorunluDersler);
                     }
                 }
            }
            else if (choiceBox1.getValue() != null && choiceBox1.getValue().equals("Ders Sil")) {

            }
        });
        // CheckBoxların kontrolü yapılır.
        checkBox1.setOnAction(event -> checkIfSaveButtonVisible());
        checkBox2.setOnAction(event -> checkIfSaveButtonVisible());
        checkBox3.setOnAction(event -> checkIfSaveButtonVisible());
        checkBox4.setOnAction(event -> checkIfSaveButtonVisible());

    }
    // CheckBoxların seçili olup olmadığına bakılır
    private void checkIfSaveButtonVisible() {
        int selectedCount = 0;
        if (checkBox1.isSelected()) selectedCount++;
        if (checkBox2.isSelected()) selectedCount++;
        if (checkBox3.isSelected()) selectedCount++;
        if (checkBox4.isSelected()) selectedCount++;

        if (selectedCount > 0) {
            saveL.setVisible(true);
        } else {
            saveL.setVisible(false);
        }
    }

    // Seçili dersleri konsola yazdır

    private CheckBox getCheckBoxByIndex(int index) {
        switch (index) {
            case 0:
                return checkBox1;
            case 1:
                return checkBox2;
            case 2:
                return checkBox3;
            case 3:
                return checkBox4;
            default:
                return null;
        }
    }
}
