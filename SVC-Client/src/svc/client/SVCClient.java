/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svc.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

/**
 *
 * @author svrijders
 */

public class SVCClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
        cm.setMaxTotal(100);

        HttpClient httpclient = new DefaultHttpClient(cm);


        try {
            for (int k = 0; k < Constants.NR_SEGMENTS; k++) {

                // create a thread for each URI
                Thread[] threads = new Thread[Constants.PORTS.length+1];
                for (int i = 0; i < Constants.PORTS.length; i++) {
                    //Location ~= serverlocatie:8080/video_s0_l0.dat
                    String location = "http://" + Constants.SERVER_LOCATION + ":" + Constants.PORTS[i] + "/video_s" + k + "_l" + i + ".dat";
                    HttpGet httpget = new HttpGet(location);
                    threads[i] = new GetSegment(httpclient,httpget,i);
                }
                
                threads[Constants.PORTS.length] = new CloseConnectionsThread(cm);

                // start the threads
                for (int j = 0; j < threads.length; j++) {
                    threads[j].start();
                }

                // join the threads
                for (int j = 0; j < threads.length; j++) {
                    threads[j].join();
                }


            }
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }
}
