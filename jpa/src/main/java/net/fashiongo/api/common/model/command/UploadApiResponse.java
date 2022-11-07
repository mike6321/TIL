package net.fashiongo.api.common.model.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadApiResponse<T> {

    private UploadApiResponseHeader header;
    private T data;

    @Override
    public String toString() {
        return "UploadApiResponse{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }
}
