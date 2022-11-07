package net.fashiongo.api.common.model.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestHeaderInfo {

    private String applicationType;
    private String requestId;
    private UserInfo userInfo;
    private Long vendorId;

    public static RequestHeaderInfo create(String applicationType, String requestId, UserInfo userInfo, Long vendorId) {
        return builder()
                .applicationType(applicationType)
                .requestId(requestId)
                .userInfo(userInfo)
                .vendorId(vendorId)
                .build();
    }
}
