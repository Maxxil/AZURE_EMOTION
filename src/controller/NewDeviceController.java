/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import iothubazure.IotHubDevices;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Massil
 */
public class NewDeviceController {
    
    @FXML
    private TextField deviceId;
    
    private Stage editStage;
    
    private ObservableList<String> items;
    
    @FXML
    public void ok()
    {
        if(!deviceId.getText().equals("") ||deviceId.getText() != null)
        {
            IotHubDevices devices = new IotHubDevices();
            devices.addDevice(deviceId.getText());
            this.items.add(deviceId.getText());
            this.editStage.close();
        }
    }
    
    @FXML
    private void cancel()
    {
        this.editStage.close();
    }
    
    public void setDevices(ObservableList<String> items)
    {
        this.items = items;
    }
    
    public void setEditStage(Stage editStage)
    {
        this.editStage = editStage;
    }
}
