/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iothubazure;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetectedLanguage;
import model.Emotion;
import model.TextRecognitionResponse;
import thread.SendMessageThread;

/**
 *
 * @author Massil
 */
public class IotHubConnection {
    
    private String DEVICE_ID = "";
    private String CONNECTION_STRING;
    private static String HOST_NAME = "HostName=IotHubProjet.azure-devices.net";
    private DeviceClient deviceClient;
    private IotHubMessageCallback callback;
    private Runnable sendMessageRunnable;
    private Thread sendMessageThread;
    
    /**
     * 
     * @param connectionString  HostName
     * @param deviceId          DeviceId
     * @param sharedAccessKey   SharedAccesKey
     */
    public IotHubConnection(String connectionString , String deviceId , String sharedAccessKey)
    {
        DEVICE_ID = deviceId;
        callback = new IotHubMessageCallback();
        CONNECTION_STRING = connectionString +";DeviceId=" + deviceId + ";SharedAccessKey=" + sharedAccessKey ;
        try {
            deviceClient = new DeviceClient(CONNECTION_STRING, IotHubClientProtocol.MQTT);
            deviceClient.close();
            deviceClient.setMessageCallback(callback, null);
            deviceClient.open();
        } catch (IOException ex) {
            Logger.getLogger(IotHubConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public IotHubConnection(String device , String deviceKey)
    {
        this(HOST_NAME , device  , deviceKey);
    }

    public void sendMessageTextRecognition(LinkedTreeMap<String , Object> parms)
    {
        
        try {
            String msg = convertTextRecognitionMessage(parms);
            sendMessageRunnable = new SendMessageThread(msg, deviceClient);
            sendMessageThread = new Thread(sendMessageRunnable);
            sendMessageThread.start();
            sendMessageThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(IotHubConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SendEmotionRecognition(LinkedTreeMap<String , Object> params)
    {
        try {
            String msg = convertEmotionRecognitionMessage(params);
            sendMessageRunnable = new SendMessageThread(msg, deviceClient);
            sendMessageThread = new Thread(sendMessageRunnable);
            sendMessageThread.start();
            sendMessageThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(IotHubConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String convertTextRecognitionMessage(LinkedTreeMap<String , Object> parms)
    {
        DetectedLanguage lang = new DetectedLanguage();
        TextRecognitionResponse model = new TextRecognitionResponse();
        
        model.Id = DEVICE_ID;
        
        lang.Name = parms.get("name").toString();
        lang.Iso = parms.get("iso6391Name").toString();
        lang.Score = (Double)parms.get("score");
        
        model.DetectedLanguages = new ArrayList<>();
        
        model.DetectedLanguages.add(lang);
        
        Gson gson = new Gson();
        
        String msg = gson.toJson(model);
        return msg;
    }
    
    private String convertEmotionRecognitionMessage(LinkedTreeMap<String , Object> params)
    {
        Emotion emotion = new Emotion();
        LinkedTreeMap<String , Object> score = (LinkedTreeMap<String , Object>) params.get("scores");
        
        System.out.println(score);
        
        emotion.Anger = (Double)score.get("anger");
        emotion.Contempt = (Double)score.get("contempt");
        emotion.Disgust = (Double)score.get("disgust");
        emotion.Fear = (Double)score.get("fear");
        emotion.Happinness = (Double)score.get("happiness");
        emotion.Neutral = (Double)score.get("neutral");
        emotion.Sadness = (Double)score.get("sadness");
        emotion.Surprise = (Double)score.get("surprise");
        
        Gson gson = new Gson();
        
        String msg = gson.toJson(emotion);
        return msg;
    }
    
    public String receive()
    {
        deviceClient.setMessageCallback(callback, null);
        return callback.getMessage();
    }
    
    public String getMessage()
    {
        String res = callback.getMessage();
        if(res != null)
        {
            return res;
        }
        else
        {
            return "";
        }
        
    }
    
    
}
