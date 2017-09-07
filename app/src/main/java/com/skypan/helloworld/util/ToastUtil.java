package com.skypan.helloworld.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by skypan on 2017/9/5.
 */

public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context,String msg){
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
