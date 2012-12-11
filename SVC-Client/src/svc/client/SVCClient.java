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
                GetSegment[] threads = new GetSegment[Constants.PORTS.length];
                for (int i = 0; i < Constants.PORTS.length; i++) {
                    //Location ~= serverlocatie:8080/video_s0_l0.dat
                    String location = "http://" + Constants.SERVER_LOCATION + ":" + Constants.PORTS[i] + "/video_s" + k + "_l" + i + ".dat";
                    HttpGet httpget = new HttpGet(location);
                    threads[i] = new GetSegment(httpclient, httpget, i,k);
                }



                // start the threads
                for (int j = 0; j < threads.length; j++) {
                    threads[j].start();
                }

                //Wait for x seconds on the next fragment
                try {
                    Thread.sleep(Constants.MILLISECONDS);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                // join the threads
                for (int j = 0; j < threads.length; j++) {
                    threads[j].getHttpget().abort();
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
