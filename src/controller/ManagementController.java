/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.microsoft.azure.iot.service.sdk.Device;
import iothubazure.IotHubConnection;
import iothubazure.IotHubDevices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projet_azure_emotion.AzureEmotion;

/**
 *
 * @author Massil
 */
public class ManagementController {
    @FXML
    private ListView<String> listDevices;
    
    @FXML
    private AnchorPane editAnchorPane;
    
    private ObservableList<String> items;
    
    private IotHubDevices devices;
    
    private ArrayList<Device> arrayDevices;
    
    private AzureEmotion mainApp;
    
    private IotHubConnection iotHubConnection;
    
    private Scene editScene;
    private Stage editStage;
    private Stage managementStage;
    
    public ManagementController()
    {
        
    }
    
    public void initialisation()
    {
        arrayDevices = devices.getDevices();
    }
    
    @FXML
    private void initialize()
    {
        devices = new IotHubDevices();
        items = FXCollections.observableArrayList();
        initialisation();
        addDeviceToList();
    }
    
    @FXML
    public void chooseDevice()
    {
        int index = listDevices.getSelectionModel().getSelectedIndex();
        if(index < 0)
        {
            System.err.println("No device choosed");
            
        }
        else
        {
            Device device = devices.getDevices().get(index);
            System.out.println(device.getDeviceId() + " " + device.getPrimaryKey());
            if(device.getDeviceId().equals("") || device.getPrimaryKey().equals(""))
            this.iotHubConnection = new IotHubConnection(device.getDeviceId() , device.getPrimaryKey());
            this.mainApp.setIotHubConnection(iotHubConnection);
        }
    }
    
    public void setMainApp(AzureEmotion mainApp)
    {
        this.mainApp = mainApp;
    }
    
    public void setStage(Stage managementStage)
    {
        this.managementStage = managementStage;
    }
    
    public void addDeviceToList()
    {
        listDevices.setItems(null);
        for(Device device : arrayDevices)
        {
            items.add(device.getDeviceId());
        }
        listDevices.setItems(items);
        System.out.println(listDevices.getItems());
    }
    
    /**
     * Fonction appelé par Management.fxml permettant de supprimer un device
     */
    @FXML
    private void addNewDevice()
    {
        try {
            NewDeviceController controller = new NewDeviceController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManagementController.class.getResource("/view/NewDevice.fxml"));
            loader.setController(controller);
            editAnchorPane = loader.load();
            
            editStage = new Stage();
            editStage.setTitle("Nouveau Device");
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(this.mainApp.getPrimaryStage());
            
            
            editScene = new Scene(editAnchorPane);
            editStage.setScene(editScene);
            
            controller.setEditStage(editStage);
            controller.setDevices(items);
            
            editStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(ManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fonction appelé par Management.fxml permettant de supprimer un device
     */
    @FXML
    private void deleteDevice()
    {
        String device = listDevices.getSelectionModel().getSelectedItem();
        int index = listDevices.getSelectionModel().getSelectedIndex();
        devices.deleteDevice(device);
        items.remove(index);
        
    }
    
}
