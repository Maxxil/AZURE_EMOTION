/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.internal.LinkedTreeMap;
import config.emotion.EmotionContext;
import iothubazure.IotHubConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import projet_azure_emotion.AzureEmotion;

/**
 *
 * @author Massil
 */
public class EmotionController{
    
    private IotHubConnection iotHubConnection;
    
    private AzureEmotion mainApp;

    @FXML
    private AnchorPane anchorePane;

    @FXML
    private TextField message;

    @FXML
    private TextArea reponse;

    @FXML
    private Button envoyer;

    public EmotionController()
    {
    }

    public void setMainApp(AzureEmotion mainApp)
    {
        this.mainApp = mainApp;
        this.iotHubConnection = this.mainApp.getIotHubConnection();
    }

    public void sendImage()
    {
        this.reponse.setText("");
        this.iotHubConnection = this.mainApp.getIotHubConnection();
        EmotionContext context = new EmotionContext();
        LinkedTreeMap<String , Object> json = context.sendImage(message.getText());
        if(json.isEmpty())
        {
            reponse.setText("No information found...");
        }
        else
        {
            LinkedTreeMap<String , Object> score = (LinkedTreeMap < String, Object>)json.get("scores");
            String resultat = "Anger : " + score.get("anger").toString()+ "\nContempt: " + score.get("contempt").toString()
                    + "\nDisgust: " + score.get("disgust").toString() +  "\nFear: " + score.get("fear").toString()+
                    "\nHappiness: " + score.get("happiness").toString() + "\nNeutral: " + score.get("neutral").toString()
                    + "\nSadness: " + score.get("sadness").toString()+ "\nSurprise: " + score.get("surprise").toString();
            iotHubConnection.SendEmotionRecognition(json);
            reponse.setText(resultat);
        }
        
    }
}
