package com.robsonteam.wyjatki;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.nio.file.FileAlreadyExistsException;

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

    private PlaneSystemCheck pSC = new PlaneSystemCheck();

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

    private void EngineStop()
    {
        pSC.setEngineWorkStatus(false);
        pSC.setEnergyStatus(false);
        pSC.setCiagStatus(false);
        pSC.setWirnikiStatus(false);
        l_energy.setFill(Paint.valueOf("c3c9cd"));
        l_ciag.setFill(Paint.valueOf("c3c9cd"));
        l_wirniki.setFill(Paint.valueOf("c3c9cd"));
        b_send.setText("Start");
    }

    @FXML
    void b_exit_action(ActionEvent event)
    {
        Platform.exit();
    }

    @FXML
    void b_send_action(ActionEvent event)
    {
        if(!pSC.getEngineWrokStatus()) {
            try {
                pSC.systemModuleCheck(0);
                pSC.systemModuleCheck(1);
                pSC.systemModuleCheck(2);
                pSC.systemModuleCheck(3);

                if (pSC.getEngineWrokStatus()) {
                    b_send.setText("Stop");
                    start_window();
                }
            } catch (CiagMissExcepiton e) {
                error_window(e.getMessage());
            } catch (WirnikiMissException e) {
                error_window(e.getMessage());
            } catch (CoreSystemMissException e) {
                error_window(e.getMessage());
            }
        }else{
            EngineStop();
        }
    }

    //Button Functions
    @FXML
    void tb_ciag_action(ActionEvent event)
    {
        if(pSC.getCiagStatus())
        {
            l_ciag.setFill(Paint.valueOf("c3c9cd"));
            pSC.setCiagStatus(false);
        }else {
            l_ciag.setFill(Paint.valueOf("Green"));
            pSC.setCiagStatus(true);
        }
    }

    @FXML
    void tb_energy_action(ActionEvent event)
    {
        if(pSC.getEnergyStatus())
        {
            l_energy.setFill(Paint.valueOf("c3c9cd"));
            pSC.setEnergyStatus(false);
        }else {
            l_energy.setFill(Paint.valueOf("Green"));
            pSC.setEnergyStatus(true);
        }
    }

    @FXML
    void tb_wirniki_action(ActionEvent event)
    {
        if(pSC.getWirnikiStatus())
        {
            l_wirniki.setFill(Paint.valueOf("c3c9cd"));
            pSC.setWirnikiStatus(false);
        }else {
            l_wirniki.setFill(Paint.valueOf("Green"));
            pSC.setWirnikiStatus(true);
        }
    }

}