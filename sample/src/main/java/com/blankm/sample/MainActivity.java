package com.blankm.sample;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainOnClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.btn_v2:
                intent = new Intent(this, V2Activity.class);
                startActivity(intent);

                break;
        }
    }
}
