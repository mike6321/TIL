package net.fashiongo.api.common.model.command;

import lombok.Getter;

import java.util.Map;

@Getter
public class MapObject<K, V> implements ApiResponseBody {
    private final Map<K, V> contents;
    private final int totalCount;

    public MapObject(Map<K, V> contents, int totalCount) {
        this.contents = contents;
        this.totalCount = totalCount;
    }
}
