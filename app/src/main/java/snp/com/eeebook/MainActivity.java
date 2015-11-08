package snp.com.eeebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Mimansha on 3/11/2015.
 */
public class MainActivity extends ActionBarActivity{

    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
    }



    public void startbooking(View view){
        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, BookingActivity.class);
        startActivity(i);
    }
}
