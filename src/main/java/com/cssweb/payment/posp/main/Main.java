package com.cssweb.payment.posp.main;

import com.cssweb.payment.posp.client.POSPClient;
import com.cssweb.payment.posp.server.POSPServer;
import com.cssweb.payment.posp.business.WorkerThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenhf on 2014/10/8.
 */
public class Main {

    public static void main(String[] args)
    {
        // 业务处理线程池
        WorkerThreadPool.getInstance().init(10, 10000);

        // 客户端线程
        POSPClient client = new POSPClient("127.0.0.1", 2013);
        Thread threadClient = new Thread(client);
        threadClient.start();


        // 服务线程
        POSPServer server = new POSPServer(3500, client);
        Thread threadServer = new Thread(server);
        threadServer.start();

        // 主线程
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String cmd = console.readLine();



                if (cmd.equalsIgnoreCase("applykey")) {
                    client.applyKey();

                }
                else if(cmd.equalsIgnoreCase("exit") || cmd.equalsIgnoreCase("quit"))
                {
                    client.close();

                    server.close();

                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
