package com.aengussong.randomuserlist.adapter;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aengussong.randomuserlist.R;
import com.aengussong.randomuserlist.databinding.ItemRandomUserBinding;
import com.aengussong.randomuserlist.model.RandomUser;

public class UserAdapter extends PagedListAdapter<RandomUser, UserAdapter.RandomUserViewHolder> {

    public interface OnUserClicked {
        void userClicked(RandomUser user);
    }

    private OnUserClicked listener;

    public UserAdapter(OnUserClicked listener) {
        super(RandomUser.DIFF_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemRandomUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_random_user, viewGroup, false);
        return new RandomUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserViewHolder viewHolder, int i) {
        viewHolder.bind(getItem(i));
    }

    public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        ItemRandomUserBinding binding;

        private RandomUserViewHolder(ItemRandomUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(RandomUser user) {
            binding.setRndUser(user);
            binding.setUserClickListener(this);
            binding.executePendingBindings();
        }

        public void onUserClick(RandomUser user) {
            listener.userClicked(user);
        }
    }
}
