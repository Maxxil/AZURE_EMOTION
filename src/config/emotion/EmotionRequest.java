/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.emotion;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import model.Documents;
import model.Image;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Massil
 */
public interface EmotionRequest {
    @POST("emotion/v1.0/recognize")
    @Headers({
        "Content-Type: application/json",
        "Ocp-Apim-Subscription-Key:d1b88cab93574f50ade15fdbc3460d7d"
    })
    Call<ArrayList> sendPic(@Body Image image);
}
