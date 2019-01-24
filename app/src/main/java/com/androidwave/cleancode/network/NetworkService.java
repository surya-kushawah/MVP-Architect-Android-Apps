package com.androidwave.cleancode.network;

import com.androidwave.cleancode.network.pojo.WrapperResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public interface NetworkService {
    /**
     * @return Observable feed response
     */
    @GET("facts.json")
    Observable<WrapperResponse<String>> getFeedResponse();
}
