package cn.edu.sdwu.android02.classroom.sn170507180220;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ch10Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_3);
    }
    public void ok(View view){
        EditText editText=(EditText)findViewById(R.id.ch10_3_tv);
        String content=editText.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("name",content);
        setResult(RESULT_OK,intent);
        finish();
    }
    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
