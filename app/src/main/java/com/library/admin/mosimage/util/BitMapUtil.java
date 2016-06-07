package com.library.admin.mosimage.util;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ${zyj} on 2016/6/7.
 */
public class BitMapUtil {

    /*
       * 保存用户头像
       * @param bitmap
       */
    public static String saveBitmap( Bitmap bitmap) throws IOException {
        // 保存截图路径
        String SAVEPATH= Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/cropImage/";

        String imagePath = "" ;

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File file = new File(SAVEPATH);
            if(!file.exists()){
                file.mkdir();
            }

            imagePath = SAVEPATH + System.currentTimeMillis() + ".png" ;
            File file1 = new File( imagePath );
            if(!file1.exists()){
                file1.createNewFile();
            }
            FileOutputStream b = null;
            try {
                b = new FileOutputStream(file1);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, b);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                b.flush();
                b.close();
            }
        }
        return  imagePath ;
    }

}
