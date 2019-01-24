package com.androidwave.cleancode.ui.base;
import com.androidwave.cleancode.network.WrapperError;
import com.androidwave.cleancode.utils.rx.SchedulerProvider;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private V mMvpView;

    @Inject
    public BasePresenter(SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    //
    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    @Override
    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    mMvpView.onError("Unauthorised User ");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    mMvpView.onError("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    mMvpView.onError("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    mMvpView.onError("Bad Request");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    mMvpView.onError("No Internet Connection");
                    break;
                default:
                    mMvpView.onError(error.getLocalizedMessage());

            }
        } else if (error instanceof WrapperError) {
            mMvpView.onError(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
            mMvpView.onError("Something Went Wrong API is not responding properly!");
        } else {
            mMvpView.onError(error.getMessage());
        }

    }


    @Override
    public void setUserAsLoggedOut() {
        //  getDataManager().setUserAsLoggedOut();

    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}

