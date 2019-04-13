package com.aengussong.randomuserlist.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.aengussong.randomuserlist.R;
import com.aengussong.randomuserlist.databinding.ActivityDetailsBinding;
import com.aengussong.randomuserlist.model.RandomUser;

import dagger.android.support.DaggerAppCompatActivity;

public class DetailsActivity extends DaggerAppCompatActivity {

    public static Intent getStartIntent(Context context, RandomUser user) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_EXTRA_USER, user);
        return intent;
    }

    private static final String KEY_EXTRA_USER = "key_extra_user";
    public static final int PERMISSION_REQUEST_CALL = 9989;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        RandomUser user = (RandomUser) intent.getSerializableExtra(KEY_EXTRA_USER);

        if (user != null) {
            ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
            binding.setRandomUser(user);
            binding.setActivity(this);
        }
    }

    public void call(String phoneNumber) {
        requestPermissions(phoneNumber);
    }

    public void requestPermissions(String phoneNunber) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CALL);
            } else {
                callWithPermission(phoneNunber);
            }
        }
    }

    public void callWithPermission(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}
