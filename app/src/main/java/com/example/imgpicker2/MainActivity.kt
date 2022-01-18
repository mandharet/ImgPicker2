package com.example.imgpicker2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker

class MainActivity : AppCompatActivity() {

    var imagePicker: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagePicker = findViewById(R.id.picker_image)

        val gallery = findViewById<Button>(R.id.gallery)
        val camera = findViewById<Button>(R.id.camera)

        gallery.setOnClickListener {

            ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop(1f,1f)
                .maxResultSize(720, 720).start()

        }

        camera.setOnClickListener {

            ImagePicker.with(this).cameraOnly().crop(1f,1f).maxResultSize(720, 720).saveDir(getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!).start()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK && requestCode== ImagePicker.REQUEST_CODE) {


            imagePicker?.setImageURI(data?.data)
            Log.d("Asach","${data?.data}")

            var s1:String
            s1 = data?.data.toString()
            Log.d("Bdach",s1)

        }

    }


}