package net.fashiongo.api.common.model.command;

import lombok.Getter;

@Getter
public class ApiResponse {

    private ApiResponseHeader header;
    private ApiResponseBody data;
    public ApiResponse(){}
    public ApiResponse(ApiResponseHeader header, ApiResponseBody data) {
        this.header = header;
        this.data = data;
    }
}
