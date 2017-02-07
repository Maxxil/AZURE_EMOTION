/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.text_recognition_service;

import model.Documents;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Massil
 */
public interface TextRecognitionRequests {
    @POST("text/analytics/v2.0/languages?numberOfLanguagesToDetect=1")
    @Headers({
        "Content-Type:application/json",
        "Ocp-Apim-Subscription-Key: 52ef50b1b2d64cde9f3d43bdeaf3a3fc"
    })
    Call<Documents> sendtext(@Body Documents text);
}
