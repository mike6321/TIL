package net.fashiongo.api.common.model.command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class GenericApiResponse<T> {
    private ApiResponseHeader header;
    private GenericApiResponseBody<T> data;

    public static <T> GenericApiResponse<T> success(GenericApiResponseBody<T> data) {
        GenericApiResponse<T> result = new GenericApiResponse<>();
        result.header = ApiResponseHeader.create(ResultCode.SUCCESS);
        result.data = data;
        return result;
    }

    public static <T> GenericApiResponse<T> success(Collection<T> data) {
        GenericApiResponse<T> result = new GenericApiResponse<>();
        result.header = ApiResponseHeader.create(ResultCode.SUCCESS);
        result.data = new CollectionObject<>(new ArrayList<>(data));
        return result;
    }

    public static <T> GenericApiResponse<T> success(T data) {
        GenericApiResponse<T> result = new GenericApiResponse<>();
        result.header = ApiResponseHeader.create(ResultCode.SUCCESS);
        result.data = new SingleObject<>(data);
        return result;
    }

    public static <T> GenericApiResponse<T> fail(boolean isSuccessful, int resultCode, String resultMessage) {
        GenericApiResponse<T> result = new GenericApiResponse<>();
        result.header = ApiResponseHeader.create(isSuccessful, resultCode, resultMessage);
        return result;
    }
}
