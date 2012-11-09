/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svc.client;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;

/**
 *
 * @author svrijders
 */
public class CloseConnectionsThread extends Thread {

    private final ClientConnectionManager connMgr;

    public CloseConnectionsThread(ClientConnectionManager connMgr) {
        super();
        this.connMgr = connMgr;
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                wait(Constants.MILLISECONDS);
                connMgr.closeIdleConnections(0, TimeUnit.SECONDS);
            }
        } catch (InterruptedException ex) {
            // terminate
        }
    }
}
