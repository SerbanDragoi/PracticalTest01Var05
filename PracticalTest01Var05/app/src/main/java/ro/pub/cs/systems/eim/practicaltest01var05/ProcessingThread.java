package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.StringTokenizer;

public class ProcessingThread extends Thread {

    private Context context;
    private String text;

    public ProcessingThread(Context context, String text) {
        this.context = context;
        this.text = text;
    }

    @Override
    public void run() {
        StringTokenizer st = new StringTokenizer(text, ",");
        while (st.hasMoreTokens()) {
            String element = st.nextToken();
            sendMessage(element);
            sleep();
        }

    }

    private void sendMessage(String element) {
        Intent intent = new Intent();

        intent.setAction(Constants.ACTION_STRING);
        intent.putExtra(Constants.DATA, element);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}
