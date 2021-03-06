package cn.edu.sdwu.android02.classroom.sn170507180220;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Ch12Activity1 extends AppCompatActivity {

    private ServiceConnection serviceConnection;
    private MyService2 myService2;
    private boolean bindSucc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch12_1);
        bindSucc=false;

        serviceConnection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                MyService2.MyBinder myBinder=(MyService2.MyBinder) iBinder;
                 myService2=myBinder.getRandomService();
                bindSucc=true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

                bindSucc=false;
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(this,MyService2.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unbindService(serviceConnection);
    }

    public void start_service(View view){
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
    }
    public void stop_service(View view){
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);
    }

    public void getRandom(View view){
        if(bindSucc){
            int ran=myService2.genRandom();
            Toast.makeText(this,ran+ "", Toast.LENGTH_LONG).show();
        }
    }

}
