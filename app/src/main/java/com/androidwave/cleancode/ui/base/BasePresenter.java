package com.androidwave.cleancode.ui.base;

import com.androidwave.errorhandling.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

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

//        if (error instanceof HttpException) {
//            switch (((HttpException) error).code()) {
//                case HttpsURLConnection.HTTP_UNAUTHORIZED:
//                    getMvpView().onError(R.string.api_default_error);
//                    break;
//                case HttpsURLConnection.HTTP_FORBIDDEN:
//                    setUserAsLoggedOut();
//                    getMvpView().openActivityOnTokenExpire();
//                    break;
//                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
//                    getMvpView().onError(R.string.api_default_error);
//                    break;
//                case HttpsURLConnection.HTTP_BAD_REQUEST:
//                    try {
//                        HttpException mError = (HttpException) error;
//                        String errorBody = mError.response().errorBody().string();
//                        BaseResponse response = gson.fromJson(errorBody, BaseResponse.class);
//                        getMvpView().onError(response.getMessage());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        getMvpView().onError(R.string.api_default_error);
//                    }
//                    //getMvpView().onError(R.string.api_default_error);
//                    break;
//                case Constants.API_STATUS_CODE_LOCAL_ERROR:
//                    getMvpView().onError(R.string.connection_error);
//                    break;
//                default:
//                    getMvpView().onError(R.string.api_default_error);
//                    //  getMvpView().onError(apiError.getMessage());
//            }
//        } else {
//            getMvpView().onError(R.string.connection_error);
//        }
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

