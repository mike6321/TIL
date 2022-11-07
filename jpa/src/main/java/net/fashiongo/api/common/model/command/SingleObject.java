package net.fashiongo.api.common.model.command;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SingleObject<T> implements GenericApiResponseBody<T> {

    private T content;

    public SingleObject(T content) {
        this.content = content;
    }
}
