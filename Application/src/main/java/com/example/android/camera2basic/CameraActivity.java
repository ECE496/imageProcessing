/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CameraActivity extends AppCompatActivity {

    Interpreter tflite;
    Bitmap savedBmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }
//
//        try {
//            tflite = new Interpreter(loadModelFile());
//            InputStream is = this.getAssets().open("face.jpg");
//            savedBmp = BitmapFactory.decodeStream(is);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        doInference(savedBmp);
    }

//    private MappedByteBuffer loadModelFile() throws IOException {
//        AssetFileDescriptor fileDescriptor = this.getAssets().openFd("model.tflite");
//        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
//        FileChannel fileChannel = inputStream.getChannel();
//        long startOffset = fileDescriptor.getStartOffset();
//        long declaredLength = fileDescriptor.getDeclaredLength();
//        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
//    }
//
//    private float[][] doInference(Bitmap bmp){
//        float [][][][] img = new float[1][200][200][3];
//        float [][] output = new float[1][7];
//        for (int i = 0; i < 200; i++){
//            for (int j = 0; j < 200; j++){
//                int p = bmp.getPixel(j, i);
//                img[0][i][j][0] = ((p >> 16) & 0xff) / (float)255;
//                img[0][i][j][1] = ((p >> 8) & 0xff) / (float)255;
//                img[0][i][j][2] = (p & 0xff) / (float)255;
//            }
//        }
//        tflite.run(img, output);
//        return output;
//    }

}
