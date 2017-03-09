/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Massil
 */
public class Emotion {
    @SerializedName("anger")
    public double Anger;
    
    @SerializedName("contempt")
    public double Contempt;
    
    @SerializedName("disgust")
    public double Disgust;
    
    @SerializedName("fear")
    public double Fear;
    
    @SerializedName("happiness")
    public double Happinness;
    
    @SerializedName("neutral")
    public double Neutral;
    
    @SerializedName("sadness")
    public double Sadness;
    
    @SerializedName("surprise")
    public double Surprise;
}
