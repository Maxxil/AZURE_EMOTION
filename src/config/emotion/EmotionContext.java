/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.emotion;

import com.google.gson.internal.LinkedTreeMap;
import config.CognitiveService;
import java.util.ArrayList;
import model.Image;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Massil
 */
public class EmotionContext extends CognitiveService{
    public EmotionRequest emotion;
    private LinkedTreeMap<String , Object> result;
    public EmotionContext()
    {
        emotion = context.create(EmotionRequest.class);
    }
    
    public LinkedTreeMap<String , Object> sendImage(String url)
    {
        try
        {
            Image image = new Image();
            image.Url = url;
            Call<ArrayList> promise = emotion.sendPic(image);
            ArrayList array = promise.execute().body();
            System.out.println(array);
            LinkedTreeMap<String , Object> result = (LinkedTreeMap<String , Object>)array.get(0);
            System.out.println(result.get("faceRectangle"));

            return result;
        }
        catch(Exception e)
        {
            
        }
        return null;
    }
}
