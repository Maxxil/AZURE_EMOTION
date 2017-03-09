/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iothubazure;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

/**
 *
 * @author Massil
 */
public class IotHubEventCallback implements com.microsoft.azure.iothub.IotHubEventCallback{

    @Override
    public void execute(com.microsoft.azure.iothub.IotHubStatusCode ihsc, Object o) {
        System.out.println("IoT Hub responded to message with status: " + ihsc.name());

        if (o != null) {
          synchronized (o) {
            o.notify();
          }
        }    
    }
    
}
