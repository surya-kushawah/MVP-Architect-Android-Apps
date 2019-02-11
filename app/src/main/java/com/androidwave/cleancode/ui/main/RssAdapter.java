package com.androidwave.cleancode.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidwave.cleancode.R;
import com.androidwave.cleancode.data.network.pojo.FeedItem;
import com.androidwave.cleancode.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public class RssAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "RssAdapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<FeedItem> mFeedItemList;

    public RssAdapter(List<FeedItem> sportList) {
        mFeedItemList = sportList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mFeedItemList != null && mFeedItemList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mFeedItemList != null && mFeedItemList.size() > 0) {
            return mFeedItemList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<FeedItem> sportList) {
        mFeedItemList.addAll(sportList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        ImageView thumbnail;
        TextView titleTextView;
        TextView linkTextView;
        TextView descriptionTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.imageViewThumbnail);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            linkTextView = itemView.findViewById(R.id.textViewUrl);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
        }

        protected void clear() {
            thumbnail.setImageDrawable(null);
            titleTextView.setText("");
            linkTextView.setText("");
            descriptionTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final FeedItem mFeedItem = mFeedItemList.get(position);

            if (mFeedItem.getThumbnail() != null) {
                Glide.with(itemView.getContext())
                        .load(mFeedItem.getThumbnail())
                        .into(thumbnail);
            }

            if (mFeedItem.getTitle() != null) {
                titleTextView.setText(mFeedItem.getTitle());
            }

            if (mFeedItem.getLink() != null) {
                linkTextView.setText(mFeedItem.getLink());
            }

            if (mFeedItem.getDescription() != null) {
                descriptionTextView.setText(mFeedItem.getDescription());
            }

            linkTextView.setOnClickListener(v -> {
                if (mFeedItem.getLink() != null) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(mFeedItem.getLink()));
                        itemView.getContext().startActivity(intent);
                    } catch (Exception e) {
                        Log.e(TAG, "onClick: Image url is not correct");
                    }
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        TextView messageTextView;
        TextView buttonRetry;

        EmptyViewHolder(View itemView) {
            super(itemView);
            buttonRetry = itemView.findViewById(R.id.buttonRetry);
            buttonRetry.setOnClickListener(v -> mCallback.onEmptyViewRetryClick());
        }

        @Override
        protected void clear() {

        }

    }
}
