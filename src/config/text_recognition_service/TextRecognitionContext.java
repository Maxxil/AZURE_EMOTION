/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.text_recognition_service;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import config.CognitiveService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetectedLanguage;
import model.Documents;
import model.TextRecognition;
import retrofit2.Call;

/**
 *
 * @author Massil
 */
public class TextRecognitionContext extends CognitiveService{
    private final String URL = "text/analytics/v2.0/";
    private String LANGUAGES = "languages?numberOfLanguagesToDetect=1/";
    private TextRecognitionRequests request;
    private LinkedTreeMap<String , String> response;
    
    public TextRecognitionContext()
    {
        super();        
        request = context.create(TextRecognitionRequests.class);
    }
    
    public LinkedTreeMap<String , Object> sendPost(String message)
    {
        Documents doc = new Documents();
        ArrayList<TextRecognition> docs = new ArrayList<TextRecognition>();
        TextRecognition text = new TextRecognition();
        text.text = message;
        text.id = "id";
        docs.add(text);
        doc.elements = docs;
        Gson gson = new Gson();
        
        System.out.println(gson.toJson(doc));
        Call<Documents> promise = request.sendtext(doc);
        try {
            Documents docRes = promise.execute().body();
            ArrayList<LinkedTreeMap<String , DetectedLanguage>> res = (ArrayList<LinkedTreeMap<String , DetectedLanguage>>)docRes.elements;
            ArrayList<LinkedTreeMap<String , Object>> detectedLanguages = (ArrayList<LinkedTreeMap<String , Object>>)res.get(0).values().toArray()[1];
            System.out.println(detectedLanguages.get(0));
            return detectedLanguages.get(0);

        } catch (IOException ex) {
            Logger.getLogger(TextRecognitionContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
