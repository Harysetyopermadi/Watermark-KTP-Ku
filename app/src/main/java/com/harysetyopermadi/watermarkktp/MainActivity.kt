package com.harysetyopermadi.watermarkktp


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

        lateinit var imgmainput:ImageView
        lateinit var inputbutton:MaterialButton
        private val pickImage = 100
        private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputbutton=findViewById(R.id.btn_upload)
        imgmainput=findViewById(R.id.img_main)

        inputbutton.setOnClickListener {
            val i=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(i,pickImage)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imgmainput.setImageURI(imageUri)
        }
    }


}