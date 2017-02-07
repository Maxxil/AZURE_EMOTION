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
public class TextRecognition {
    @SerializedName("id")
    public String id;
    
    @SerializedName("text")
    public String text;
    
}
