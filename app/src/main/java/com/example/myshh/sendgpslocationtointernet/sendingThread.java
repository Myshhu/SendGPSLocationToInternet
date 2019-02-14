package com.example.myshh.sendgpslocationtointernet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class sendingThread extends Thread {

    private double[] coords;

    sendingThread(double[] coords){
        this.coords = coords;
    }

    @Override
    public void run() {
        while (true) {
            sendCoords();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendCoords(){
        try {
            System.out.println("Start_sendCoords");
            URL rq = new URL("https://dweet.io/dweet/for/A4B1C2D9?lat=" + coords[0] + "&lon=" + coords[1]);
            HttpURLConnection connection = (HttpURLConnection) rq.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = rd.readLine();
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
