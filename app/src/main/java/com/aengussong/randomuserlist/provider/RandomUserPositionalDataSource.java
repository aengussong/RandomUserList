package com.aengussong.randomuserlist.provider;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.aengussong.randomuserlist.model.RandomUser;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class RandomUserPositionalDataSource extends PositionalDataSource<RandomUser> {

    private final DataProvider dataProvider;

    private CompositeDisposable disposables;

    private String seed = "";

    @Inject
    public RandomUserPositionalDataSource(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        this.disposables = new CompositeDisposable();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<RandomUser> callback) {
        disposables.add(dataProvider.getPage(params.requestedStartPosition, seed).subscribe(randomUserResponse -> {
            seed = randomUserResponse.getInfo().getSeed();
            callback.onResult(randomUserResponse.getRandomUsers(), params.requestedStartPosition);
        }));
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<RandomUser> callback) {
        disposables.add(dataProvider.getPage(params.startPosition, seed).subscribe(randomUserResponse ->
                callback.onResult(randomUserResponse.getRandomUsers())));
    }

}