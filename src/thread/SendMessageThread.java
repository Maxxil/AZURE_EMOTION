/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.Message;
import iothubazure.IotHubEventCallback;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Massil
 */
public class SendMessageThread implements Runnable{
    private String message;
    private DeviceClient device;
    
    public SendMessageThread(String message, DeviceClient device){
        System.out.println(message);
        System.out.println(device);
        this.message = message;
        this.device = device;
    }

    @Override
    public void run() {
        //JsonObject json = new JsonObject();
        Message msg;
        try {
            msg = new Message(new String(this.message.getBytes() , "UTF-8"));
            System.out.println("Message: " + this.message);
            IotHubEventCallback callback = new IotHubEventCallback();
            Object o = new Object();
            device.sendEventAsync(msg, callback, o);
            synchronized(o)
            {
                try {
                    o.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SendMessageThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SendMessageThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
