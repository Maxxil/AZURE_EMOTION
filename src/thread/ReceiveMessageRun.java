/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ReceiveController;
import javafx.scene.control.TextArea;
import projet_azure_emotion.AzureEmotion;

/**
 *
 * @author Massil
 */
public class ReceiveMessageRun implements Runnable{

    public boolean isStarted = false;
    public AzureEmotion mainApp;
    public String message = "";
    public TextArea receiveArea;
    public ReceiveController controller;
    public boolean messageReceived = false;

    @Override
    public void run() {
        System.out.println(isStarted);
        while(isStarted)
        {
            String res = mainApp.getIotHubConnection().getMessage();
            if(!res.equals(""))
            {
                messageReceived = true;
                message = res;
            }
        }
    }
    
}
