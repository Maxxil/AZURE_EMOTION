/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iothubazure;

import com.microsoft.azure.iothub.IotHubMessageResult;
import com.microsoft.azure.iothub.Message;
import com.microsoft.azure.iothub.MessageCallback;
import java.util.Observable;

/**
 *
 * @author Massil
 */
public class IotHubMessageCallback implements MessageCallback{

    private String message = "";
    
    public IotHubMessageCallback()
    {
        message = "";
    }
    
    public String getMessage() {
        return message;
    }

    @Override
    public IotHubMessageResult execute(Message msg, Object o) {
        message = new String(msg.getBytes());
        System.out.println("Reception callback: " + message);
        return IotHubMessageResult.COMPLETE;
    }
    
}
