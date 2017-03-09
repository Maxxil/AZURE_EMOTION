/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.internal.LinkedTreeMap;
import config.text_recognition_service.TextRecognitionContext;
import iothubazure.IotHubConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet_azure_emotion.AzureEmotion;

/**
 *
 * @author Massil
 */
public class TextAnalyticsController {
    
    private IotHubConnection iotHubConnection;
    
    private AzureEmotion mainApp;
    
    @FXML
    private TextField message;
    
    @FXML
    private TextArea reponse;
    
    @FXML
    private Button envoyer;
    
    private Stage textAnalyticsStage;
    
    public TextAnalyticsController()
    {
        
    }
    
    public void setMainApp(AzureEmotion mainApp)
    {
        this.mainApp = mainApp;
    }
    
    public void setStage(Stage textAnalyticsStage)
    {
        this.textAnalyticsStage = textAnalyticsStage;
    }
    
    public void sendMessage()
    {
        reponse.setText("");
        this.iotHubConnection = this.mainApp.getIotHubConnection();
        TextRecognitionContext context = new TextRecognitionContext();
        LinkedTreeMap<String , Object> res = (LinkedTreeMap<String , Object>) 
                context.sendPost(message.getText());
        String resultat  = "Name : " + res.get("name").toString() 
                + "\nIso : " + res.get("iso6391Name") 
                + "\nScore : " + Double.toString((Double)res.get("score"));
        iotHubConnection.sendMessageTextRecognition(res);
        reponse.setText(resultat);
    }
    
}
