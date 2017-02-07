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
public class DetectedLanguage {
    @SerializedName("name")
    public String Name;
    @SerializedName("iso6391Name")
    public String Iso;
    @SerializedName("score")
    public double Score;
}
