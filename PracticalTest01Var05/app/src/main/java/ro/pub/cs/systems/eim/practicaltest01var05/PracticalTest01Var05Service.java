package ro.pub.cs.systems.eim.practicaltest01var05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var05Service extends Service {
    public PracticalTest01Var05Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ProcessingThread processingThread = new ProcessingThread(this, intent.getStringExtra("TEXT"));
        processingThread.start();
        return START_REDELIVER_INTENT;
    }
}
