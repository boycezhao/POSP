package com.cssweb.payment.posp.main;

import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.server.POSPServer;
import com.cssweb.payment.posp.server.WorkerThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenhf on 2014/10/8.
 */
public class Main {

    public static void main(String[] args)
    {
        WorkerThreadPool.getInstance().init(10, 10000);

        // 服务线程
        POSPServer server = new POSPServer(3500);
        Thread thread = new Thread(server);
        thread.start();

        // 主线程
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String cmd = console.readLine();



                if (cmd.equalsIgnoreCase("changekey")) {
                    System.out.println("change key...");

                }
                else if(cmd.equalsIgnoreCase("exit"))
                {
                    server.stop();

                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
