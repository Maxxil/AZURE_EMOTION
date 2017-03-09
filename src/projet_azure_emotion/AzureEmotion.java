/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_azure_emotion;

import controller.EmotionController;
import controller.ManagementController;
import controller.ReceiveController;
import controller.RootController;
import controller.TextAnalyticsController;
import iothubazure.IotHubConnection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Massil
 */
public class AzureEmotion extends Application {
    
    private Stage primaryStage;
    
    private BorderPane rootLayoutAnchorePane;
    
    private AnchorPane emotionSceneAnchorePane;
    
    private AnchorPane textAnalyticsAnchorPane;
    
    private AnchorPane managementAnchorPane;
    
    private AnchorPane receiveAnchorPane;
    
    private IotHubConnection iotHubConnection;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Azure Emotion <3");
        
        initRootLayout();
        showManagement();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setIotHubConnection(IotHubConnection iotHubConnection) {
        this.iotHubConnection = iotHubConnection;
    }

    public IotHubConnection getIotHubConnection() {
        return iotHubConnection;
    }
    
    private void initRootLayout()
    {
        
        try {
            RootController controller = new RootController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AzureEmotion.class.getResource("/view/RootLayout.fxml"));
            loader.setController(controller);
            rootLayoutAnchorePane = loader.load();
            controller.setMainApp(this);
            
            Scene scene = new Scene(rootLayoutAnchorePane);
            primaryStage.setScene(scene);
            primaryStage.show();
         
        } catch (IOException ex) {
            Logger.getLogger(AzureEmotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showReceive()
    {
        try {
            ReceiveController controller = new ReceiveController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AzureEmotion.class.getResource("/view/ReceiveMessage.fxml"));
            loader.setController(controller);
            receiveAnchorPane = loader.load();
            
            rootLayoutAnchorePane.setCenter(receiveAnchorPane);
            controller.setMainApp(this);
        } catch (IOException ex) {
            Logger.getLogger(AzureEmotion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void showEmotionView(){
        try {
            EmotionController controller = new EmotionController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AzureEmotion.class.getResource("/view/EmotionView.fxml"));
            loader.setController(controller);
            emotionSceneAnchorePane = loader.load();
            
            rootLayoutAnchorePane.setCenter(emotionSceneAnchorePane);
            controller.setMainApp(this);
            
        } catch (IOException ex) {
            Logger.getLogger(AzureEmotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showManagement()
    {
        try {
            ManagementController controller = new ManagementController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AzureEmotion.class.getResource("/view/Management.fxml"));
            loader.setController(controller);
            managementAnchorPane = loader.load();
            
            rootLayoutAnchorePane.setCenter(managementAnchorPane);
            controller.setMainApp(this);
            controller.setStage(primaryStage);
        } catch (IOException ex) {
            Logger.getLogger(AzureEmotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showTextAnalytics()
    {
        try {
            TextAnalyticsController controller = new TextAnalyticsController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AzureEmotion.class.getResource("/view/TextAnalytics.fxml"));
            loader.setController(controller);
            textAnalyticsAnchorPane = loader.load();
            
            rootLayoutAnchorePane.setCenter(textAnalyticsAnchorPane);
            controller.setMainApp(this);
        } catch (IOException ex) {
            Logger.getLogger(AzureEmotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
