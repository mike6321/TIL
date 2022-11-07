package net.fashiongo.api.common.model.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseHeader {

    @JsonProperty("isSuccessful")
    private boolean isSuccessful;
    private int resultCode;
    private String resultMessage;

    public ApiResponseHeader() {}

    @Builder
    public ApiResponseHeader(boolean isSuccessful, int resultCode, String resultMessage) {
        this.isSuccessful = isSuccessful;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public static ApiResponseHeader create(boolean isSuccessful, int resultCode, String resultMessage) {

        return builder()
                .isSuccessful(isSuccessful)
                .resultCode(resultCode)
                .resultMessage(resultMessage)
                .build();
    }

    public static ApiResponseHeader create(ResultCode resultCode) {

        return builder()
                .isSuccessful(resultCode.isSuccess())
                .resultCode(resultCode.getCode())
                .resultMessage(resultCode.getMessage())
                .build();
    }
}
