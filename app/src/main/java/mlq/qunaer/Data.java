package mlq.qunaer;

import android.app.Application;

/**
 * Created by lenovo on 2017/12/28.
 */

public class Data extends Application{
    private  String a;

    public  String getA() {
        return a;
    }

    public  void setA(String a) {
        this.a = a;
    }

    @Override
    public void onCreate() {
        setA("HelloWorld!");
    }
}
