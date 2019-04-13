package com.aengussong.randomuserlist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aengussong.randomuserlist.model.RandomUser;

public class DetailsActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context, RandomUser user){
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_EXTRA_USER, user);
        return intent;
    }

    private static final String KEY_EXTRA_USER = "key_extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
