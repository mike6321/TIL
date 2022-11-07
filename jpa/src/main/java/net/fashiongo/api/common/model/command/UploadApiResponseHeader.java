package net.fashiongo.api.common.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadApiResponseHeader {

    @JsonProperty("isSuccessful")
    private boolean isSuccessful;
    private int resultCode;
    private String resultMessage;

    @Override
    public String toString() {
        return "UploadApiResponseHeader{" +
                "isSuccessful=" + isSuccessful +
                ", resultCode=" + resultCode +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
