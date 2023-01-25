module com.robsonteam.wyjatki {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.robsonteam.wyjatki to javafx.fxml;
    exports com.robsonteam.wyjatki;
}