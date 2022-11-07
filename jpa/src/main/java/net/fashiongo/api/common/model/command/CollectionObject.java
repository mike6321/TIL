package net.fashiongo.api.common.model.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
public class CollectionObject<T> implements GenericApiResponseBody<T> {

    private List<T> contents;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer totalCount;

    public CollectionObject(List<T> contents) {
        this.contents = contents;
        this.totalCount = contents == null ? null : contents.size();
    }
    public CollectionObject(List<T> contents, Integer totalCount) {
        this.contents = contents;
        this.totalCount = totalCount;
    }
}
