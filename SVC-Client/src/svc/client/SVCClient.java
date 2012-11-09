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

    public static void waiting(long n) {
        long t0, t1;
        t0 = System.currentTimeMillis();
        do {
            t1 = System.currentTimeMillis();
        } while (t1 - t0 < n);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
        cm.setMaxTotal(100);

        HttpClient httpclient = new DefaultHttpClient(cm);

        //Set constants
        final int NR_SEGMENTS = 50;
        final long SECONDS = 1;
        final String SERVER_LOCATION = "location";
        final int[] PORTS = {8080, 8081, 8082, 8083};
        
        try {
            for (int k = 0; k < NR_SEGMENTS; k++) {

                // create a thread for each URI
                GetSegment[] threads = new GetSegment[PORTS.length];
                for (int i = 0; i < threads.length; i++) {
                    HttpGet httpget = new HttpGet();
                    threads[i] = new GetSegment(httpclient,httpget,i);
                }

                // start the threads
                for (int j = 0; j < threads.length; j++) {
                    threads[j].start();
                }

                //Wait for x milliseconds (depends on segment length)
                waiting(SECONDS);

                //Call abort on threads not done yet
                for (int i = 0; i < threads.length; i++) {
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
