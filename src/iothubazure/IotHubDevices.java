/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iothubazure;

import com.google.gson.JsonSyntaxException;
import com.microsoft.azure.iot.service.auth.SymmetricKey;
import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.DeviceStatus;
import com.microsoft.azure.iot.service.sdk.RegistryManager;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Massil
 */
public class IotHubDevices {
    private RegistryManager regManager;
    private static String CONNECTION_STRING = "";
    
    public IotHubDevices()
    {
        try {
            regManager = RegistryManager.createFromConnectionString(CONNECTION_STRING);
        } catch (Exception ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Device> getDevices()
    {
        ArrayList<Device> array = null;
        try {
            array = regManager.getDevices(100);
        } catch (IOException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IotHubException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonSyntaxException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return array;
    }
    
    public void addDevice(String deviceName)
    {
        try {
            Device device = Device.createFromId(deviceName, DeviceStatus.Enabled, new SymmetricKey());
            regManager.addDevice(device);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IotHubException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonSyntaxException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteDevice(String deviceName)
    {
        try {
            regManager.removeDevice(deviceName);
        } catch (IOException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IotHubException ex) {
            Logger.getLogger(IotHubDevices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
