/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Massil
 */
public class CognitiveService {
    protected Retrofit context;
    
    public CognitiveService()
    {
        context = new Retrofit.Builder()
               .baseUrl("https://westus.api.cognitive.microsoft.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }
    
}
