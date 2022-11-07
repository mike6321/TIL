package net.fashiongo.api.common.model.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseHeader {

    private Integer resultCode;
    private String resultMessage;
    private Boolean isSuccessful;

    @Override
    public String toString() {
        return "ResponseHeader{" +
               "resultCode=" + resultCode +
               ", resultMessage='" + resultMessage + '\'' +
               ", isSuccessful=" + isSuccessful +
               '}';
    }
}
