package net.fashiongo.api.common.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfo {

    private String userId;
    private String username;

    public UserInfo() {
        this.userId = null;
        this.username = "system";
    }
}
