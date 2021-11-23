package com.harysetyopermadi.watermarkktp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.harysetyopermadi.watermarkktp.global.Constant;
import com.harysetyopermadi.watermarkktp.utils.ImageUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public class Utama extends AppCompatActivity {

    private Bitmap photoBitmap=null;
    private ImageView bgImgView;
    private ImageView watermarkImgView;
    private EditText editTeext;
    private MaterialButton btnAddText;
    private MaterialButton btnClearWatermark;
    private MaterialButton btnSave;
    private MaterialButton addPhoto;

    private int pickImage=100;
    private Uri imageUri=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        bgImgView=findViewById(R.id.img_main);
        watermarkImgView=findViewById(R.id.imageView_watermark);
        editTeext=findViewById(R.id.isitext);
        btnAddText=findViewById(R.id.btnaddtext);
        btnClearWatermark=findViewById(R.id.btnleartext);
        btnSave=findViewById(R.id.btn_save);
        addPhoto=findViewById(R.id.btn_upload);

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i,pickImage);
                /*Uri photoUri = Uri.parse(getIntent().getStringExtra("photo_uri"));
                // Uri2Bitmap
                try {
                    photoBitmap = ImageUtils.getBitmapFromUri(Utama.this, photoUri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                bgImgView.setImageBitmap(photoBitmap);*/
            }
        });

        /*btnAddText.setOnClickListener((View v) -> {
            WatermarkText watermarkText = new WatermarkText(editText.getText().toString())
                    .setPositionX(0.5)          // 横轴坐标
                    .setPositionY(0.5)          // 纵轴坐标
                    .setRotation(30.00)         // 水印旋转角度
                    .setTextAlpha(120)           // 透明度
                    .setTextColor(Color.DKGRAY)   // 文字颜色
                    .setTextShadow(0.1f, 3, 3, Color.GRAY);

            WatermarkBuilder.create(this, bgImgView)
                    .setTileMode(true)
                    .loadWatermarkText(watermarkText)
                    .getWatermark()
                    .setToImageView(bgImgView);
        });*/

        // clear watermark
        btnClearWatermark.setOnClickListener((View v) -> {
            bgImgView.setImageBitmap(photoBitmap);
            watermarkImgView.setVisibility(View.GONE);
        });

        // save watermark image
       /* btnSave.setOnClickListener((View v) -> {
            Bitmap watermarkImage = WatermarkBuilder
                    .create(this, bgImgView)
                    .getWatermark()
                    .getOutputImage();
            String save_img_path = ImageUtils.localGalleryPath() + ImageUtils.defaultImageName();
            Log.d("test", save_img_path);
            boolean saved = ImageUtils.save(watermarkImage, save_img_path, Bitmap.CompressFormat.JPEG);
            if (saved) {
                Toast.makeText(this, Constant.SAVE_WATERMARK_IAMGE_SUCCESS, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, Constant.SAVE_WATERMARK_IAMGE_FAIL, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK && requestCode == pickImage) {
             imageUri=data.getData();
            bgImgView.setImageURI(imageUri);
        }
    }
}