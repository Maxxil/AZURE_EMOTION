/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import projet_azure_emotion.AzureEmotion;
import thread.ReceiveMessageRun;

/**
 *
 * @author Massil
 */
public class ReceiveController{
    @FXML
    private TextArea message;
    
    @FXML
    private Button start;
    
    private AzureEmotion mainApp;
    
    private ObservableValue<String> messageObservable;
    
    private boolean isStarted = false ;
    
    private Thread thread;
    
    private ReceiveMessageRun runnable;

    public ReceiveController() {
        
    }
    
    public void setMainApp(AzureEmotion mainApp2)
    {
        this.mainApp = mainApp2;
        runnable = new ReceiveMessageRun();
        runnable.mainApp = mainApp;
        runnable.receiveArea = message;
        runnable.controller = this;
        this.thread = new Thread(this.runnable);
    }
    
    @FXML
    private void startStop()
    {
        isStarted = !isStarted;
        if(isStarted)
        {
            this.runnable.isStarted = true;
            this.thread.start();
        }
        else
        {
            this.runnable.isStarted = false;
            System.out.println("Stop");
            this.thread.interrupt();
        }
    }
    
    public void updateMessage(String message)
    {
        this.message.setText(message);
    }
    
    @FXML
    private void receive()
    {
        
    }

}
