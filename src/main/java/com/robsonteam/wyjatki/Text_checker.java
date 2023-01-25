package com.robsonteam.wyjatki;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Text_checker {

    @FXML
    private Button b_exit;

    @FXML
    private Button b_send;

    @FXML
    private Circle l_ciag;

    @FXML
    private Circle l_energy;

    @FXML
    private Label l_top;

    @FXML
    private Circle l_wirniki;

    @FXML
    private Button tb_ciag;

    @FXML
    private Button tb_energy;

    @FXML
    private Button tb_wirniki;

    boolean energyVal = false;
    boolean ciagVal = false;
    boolean wirnikiVal = false;
    boolean engineWork = false;

    public void error_window(String description)
    {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("Fatal Error");
        al.setHeaderText("Engine not started");
        al.setContentText(description);
        al.showAndWait();
    }

    private void start_window()
    {
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("System message");
        win.setHeaderText("Information about launch");
        win.setContentText("Engine was start correct");
        win.showAndWait();
    }
    @FXML
    void b_exit_action(ActionEvent event)
    {
        Platform.exit();
    }

    @FXML
    void b_send_action(ActionEvent event)
    {
        if(engineWork == false) {
            try {
                if (energyVal) {
                    System.out.println("Prąd OK");
                } else {
                    throw new Exp("Brak prądu");
                }

                if (ciagVal) {
                    System.out.println("Ciag OK");
                } else {
                    throw new Exp2("Brak ciągu");
                }

                if (wirnikiVal) {
                    System.out.println("Wirniki OK");
                } else {
                    throw new Exp3("Wirniki wyłączone");
                }

                if (energyVal && ciagVal && wirnikiVal) {
                    engineWork = true;
                    b_send.setText("Stop");
                    start_window();
                }
            } catch (Exp2 e) {
                error_window(e.getMessage());
            } catch (Exp3 e) {
                error_window(e.getMessage());
            } catch (Exp e) {
                error_window(e.getMessage());
            }
        }else{
            engineWork = false;
            energyVal = false;
            ciagVal = false;
            wirnikiVal = false;
            l_energy.setFill(Paint.valueOf("c3c9cd"));
            l_ciag.setFill(Paint.valueOf("c3c9cd"));
            l_wirniki.setFill(Paint.valueOf("c3c9cd"));
            b_send.setText("Start");
        }
    }

    @FXML
    void tb_ciag_action(ActionEvent event)
    {
        if(ciagVal)
        {
            l_ciag.setFill(Paint.valueOf("c3c9cd"));
            ciagVal = false;
        }else {
            l_ciag.setFill(Paint.valueOf("Green"));
            ciagVal = true;
        }
    }

    @FXML
    void tb_energy_action(ActionEvent event)
    {
        if(energyVal)
        {
            l_energy.setFill(Paint.valueOf("c3c9cd"));
            energyVal = false;
        }else {
            l_energy.setFill(Paint.valueOf("Green"));
            energyVal = true;
        }
    }

    @FXML
    void tb_wirniki_action(ActionEvent event)
    {
        if(wirnikiVal)
        {
            l_wirniki.setFill(Paint.valueOf("c3c9cd"));
            wirnikiVal = false;
        }else {
            l_wirniki.setFill(Paint.valueOf("Green"));
            wirnikiVal = true;
        }
    }

}