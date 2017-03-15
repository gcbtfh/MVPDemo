package demo.sfr.com.mvpdemo;

import android.os.Handler;

/**
 * Created by Tong Hung on 15-Mar-17.
 */

class ModelLogin{
    public boolean isLogicValidate(String name, String email){
        return email.contains("@");
    }

    public void logicValidate(final OnLoginListener listener, String name, final String email){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(email.contains("@")){
                    listener.OnSuccess();
                }else {
                    listener.OnError();
                }
            }
        }, 2000);
    }
}
