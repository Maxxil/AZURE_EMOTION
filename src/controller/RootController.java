/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import projet_azure_emotion.AzureEmotion;

/**
 *
 * @author Massil
 */
public class RootController {
    
    private AzureEmotion mainApp;
    
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private MenuItem management;
    
    @FXML
    private MenuItem emotion;
    
    @FXML
    private MenuItem textAnalytics;
    
    @FXML
    private ListView<String> listView;
    
    private ObservableList<String> items;
    
    public RootController()
    {
        items = FXCollections.observableArrayList();
        items.add("Management");
        items.add("Text Analytics");
        items.add("Emotion Recognition");
        items.add("Reception de message");
    }
    
    @FXML
    private void initialize()
    {
        listView.setItems(items);
    }
    
    @FXML
    private void onClickList()
    {
        String item = listView.getSelectionModel().getSelectedItem();
        switch(item)
        {
            case "Management":
                showManagement();
                break;
            case "Text Analytics":
                showTextAnalytics();
                break;
            case "Emotion Recognition":
                showEmotion();
                break;
            case "Reception de message":
                showReceive();
                break;
            default:
                break;
        }
    }
    
    public void setMainApp(AzureEmotion mainApp)
    {
        this.mainApp = mainApp;
    }
    
    public void showReceive()
    {
        this.mainApp.showReceive();
    }
    
    public void showManagement()
    {
        System.out.println("Management");
        this.mainApp.showManagement();
    }
    
    public void showEmotion()
    {
        System.out.println("Emotion");
        this.mainApp.showEmotionView();
    }
    
    public void showTextAnalytics()
    {
        System.out.println("Text");
        this.mainApp.showTextAnalytics();
    }
}


