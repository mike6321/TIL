package net.fashiongo.api.common.model.command;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

@Getter
public class NhnCloudEmailResponse<T> {

    private ResponseHeader header;
    private Body<T> body;

    @Getter
    public static class Body<T> {
        T data;

        @Override
        public String toString() {
            return "Body{" +
                   "data=" + ObjectUtils.nullSafeToString(data) +
                   '}';

        }
    }

    @Override
    public String toString() {
        return "NhnCloudMailResponse{" +
               "header=" + ObjectUtils.nullSafeToString(header) +
               ", body=" + ObjectUtils.nullSafeToString(body) +
               '}';

    }
}
