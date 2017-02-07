/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author Massil
 */
public class TextRecognitionResponse {
    @SerializedName("detectedLanguages")
    public ArrayList<DetectedLanguage> DetectedLanguages;
    
    @SerializedName("id")
    public String Id;
    
}
