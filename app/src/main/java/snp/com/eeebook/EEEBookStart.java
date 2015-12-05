package snp.com.eeebook;

import android.app.Application;
import com.parse.Parse;

/**
 * Created by Mimansha on 5/12/2015.
 */
public class EEEBookStart extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "keK5fkhcbhoAxFbuwoq4lnlvzpwhpaUVt0Cfe3W7", "FzHaGcfIDjkZx7MQ3Am22MQTPH2bwGCqhDdaMbm2");
    }
}
