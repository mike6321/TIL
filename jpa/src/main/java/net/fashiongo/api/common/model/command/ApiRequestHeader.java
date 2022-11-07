package net.fashiongo.api.common.model.command;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jinwoo on 2019-11-07.
 */
@Getter
@Setter
public class ApiRequestHeader {

    private String requestId;
    private String refererApplicationType;
    private String userInfoJsonString;
}
