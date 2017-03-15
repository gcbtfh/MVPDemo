package demo.sfr.com.mvpdemo;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Tong Hung on 15-Mar-17.
 */

public class DialogUtil {
    private ProgressDialog progressDialog;

    private static final DialogUtil ourInstance = new DialogUtil();

    public static DialogUtil getInstance() {
        return ourInstance;
    }

    private DialogUtil() {
    }

    public void showProgressDialog(Context context){
        progressDialog  = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissProgressDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }


}
