/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svc.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author svrijders
 */
public class GetSegment extends Thread {

    private final HttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;
    private final int id;

    public GetSegment(HttpClient httpClient, HttpGet httpget, int id) {
        this.httpClient = httpClient;
        this.context = new BasicHttpContext();
        this.httpget = httpget;
        this.id = id;
    }

    @Override
    public synchronized void start() {
        System.out.println(id + " - about to get something from " + httpget.getURI());

        try {

            httpClient.getParams().setParameter("http.socket.timeout", Constants.MILLISECONDS);
            
            // execute the method
            HttpResponse response = httpClient.execute(httpget, context);

            System.out.println(id + " - get executed");
            // get the response body as an array of bytes
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                byte[] bytes = EntityUtils.toByteArray(entity);
                System.out.println(id + " - " + httpget.getURI() + " - " + bytes.length + " bytes read");
            }

        } catch (Exception e) {
            httpget.abort();
            System.out.println(id + " - error: " + e);
        }
    }
    
    public void abort(){
        httpget.abort();
        
        //Generate stats
        
        
        //kill thread
        
    }
    
}

