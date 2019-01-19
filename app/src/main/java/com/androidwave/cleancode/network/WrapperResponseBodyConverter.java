package com.androidwave.cleancode.network;

import com.androidwave.errorhandling.network.pojo.WrapperResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class WrapperResponseBodyConverter<T>
        implements Converter<ResponseBody, T> {
    private Converter<ResponseBody, WrapperResponse<T>> converter;

    public WrapperResponseBodyConverter(Converter<ResponseBody,
            WrapperResponse<T>> converter) {
        this.converter = converter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        WrapperResponse<T> response = converter.convert(value);
        if (!response.getError()) {
            return response.getData();
        }
        // RxJava will call onError with this exception
        throw new WrapperError(response.getStatus());
    }
}