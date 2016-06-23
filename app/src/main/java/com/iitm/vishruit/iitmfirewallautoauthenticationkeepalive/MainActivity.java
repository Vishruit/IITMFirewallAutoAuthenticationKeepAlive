package com.iitm.vishruit.iitmfirewallautoauthenticationkeepalive;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et_roll = (EditText)findViewById(R.id.et_roll);
        final EditText et_password = (EditText)findViewById(R.id.et_password);
        Button bt_submit = (Button)findViewById(R.id.bt_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_roll.getText() == null || et_password.getText() == null)
                    Toast.makeText(MainActivity.this, "Please check your roll number and password.", Toast.LENGTH_SHORT).show();
                else {
                    setContentView(R.layout.activity_main);
                    TextView tv_hello = (TextView)findViewById(R.id.tv_hello);
                    tv_hello.setText(et_roll.getText().append(et_password.getText()));
                }
            }
        });
    }
}