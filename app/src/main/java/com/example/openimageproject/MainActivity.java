package com.example.openimageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int OPEN_IMAGE_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenImg(View view) {
        Intent openImageDialog = new Intent(Intent.ACTION_GET_CONTENT);
        startActivityForResult(openImageDialog, OPEN_IMAGE_REQUEST_CODE);
    }

    protected void OnActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) return;

        switch (requestCode){
            case OPEN_IMAGE_REQUEST_CODE:

                break;
        }
    }


}