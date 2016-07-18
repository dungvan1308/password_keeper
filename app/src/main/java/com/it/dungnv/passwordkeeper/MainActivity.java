package com.it.dungnv.passwordkeeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.nvdung.passwordkeeper.R;

/**
 * Created by dungnv on 3/2/2016.
 * Man hinh main chinh
 */
public class MainActivity extends Activity {

    //Khoi tao MainActivy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set Content View
        setContentView(R.layout.main_activity);
    }
}
