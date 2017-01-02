package cn.qdgxy.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestSocketClient {

    public static void main(String[] args) throws Exception {
        //创建socket
        Socket s = new Socket("10.10.39.123", 8888);
        //获得输入流
        InputStream in = s.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
        s.close();
    }

}
