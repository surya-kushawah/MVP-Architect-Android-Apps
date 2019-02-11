package com.androidwave.cleancode.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidwave.cleancode.R;
import com.androidwave.cleancode.data.network.pojo.FeedItem;
import com.androidwave.cleancode.ui.base.BaseActivity;
import com.androidwave.cleancode.utils.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity implements MainMvpView, RssAdapter.Callback {

    RecyclerView mRecyclerView;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    RssAdapter mRssAdapter;

    LinearLayoutManager mLayoutManager;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        mPresenter.onAttach(MainActivity.this);
        setUp();

    }

    @Override
    protected void setUp() {
        mRecyclerView = findViewById(R.id.recyclerViewFeed);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mPresenter.onViewPrepared();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateFeed(List<FeedItem> feedItemList) {
        mRecyclerView.setAdapter(mRssAdapter);
        mRssAdapter.addItems(feedItemList);
    }

    @Override
    public void onEmptyViewRetryClick() {
        mPresenter.onViewPrepared();
    }
}
