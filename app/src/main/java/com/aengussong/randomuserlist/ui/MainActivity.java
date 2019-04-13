package com.aengussong.randomuserlist.ui;

import android.arch.paging.PagedList;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aengussong.randomuserlist.ui.DetailsActivity;
import com.aengussong.randomuserlist.R;
import com.aengussong.randomuserlist.adapter.UserAdapter;
import com.aengussong.randomuserlist.model.RandomUser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements
        UserAdapter.OnUserClicked {

    @Inject
    PagedList<RandomUser> pagedList;

    @BindView(R.id.user_list)
    RecyclerView usersRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initAdapter();
    }

    @Override
    public void userClicked(RandomUser user) {
        Intent intent = DetailsActivity.getStartIntent(this, user);
        startActivity(intent);
    }

    private void initAdapter() {
        int columns = this.getResources().getInteger(R.integer.columns_number);
        GridLayoutManager layoutManager = new GridLayoutManager(this, columns);

        UserAdapter adapter = new UserAdapter(this);
        adapter.submitList(pagedList);

        usersRv.setLayoutManager(layoutManager);
        usersRv.setAdapter(adapter);
    }
}
