package com.example.openimageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final int OPEN_IMAGE_REQUEST_CODE = 101;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onClickOpenImg(View view) {
        Intent openImageDialog = new Intent(Intent.ACTION_GET_CONTENT);
        openImageDialog.setType("image/*");
        try {
            startActivityForResult(openImageDialog, OPEN_IMAGE_REQUEST_CODE);
        }
        catch (ActivityNotFoundException ex){
            textView.setText(ex.getMessage());
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) return;

        switch (requestCode){
            case OPEN_IMAGE_REQUEST_CODE:
                if(resultCode == RESULT_OK){ //Активность закрыта кнопкой ОК
                    String fileName = data.getData().getEncodedPath();
                    textView.setText(fileName);
                }
                break;
        }
    }


}