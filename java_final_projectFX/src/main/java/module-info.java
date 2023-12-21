module com.example.java_final_projectfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_final_projectfx to javafx.fxml;
    exports com.example.java_final_projectfx;
}