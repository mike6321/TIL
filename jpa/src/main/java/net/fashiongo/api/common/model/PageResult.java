package net.fashiongo.api.common.model;

import lombok.Getter;

import java.util.Collection;

@Getter
public class PageResult<T> {
    private final int currentPage;
    private final int totalElements;
    private final int totalPage;
    private final Collection<T> list;

    public PageResult(int currentPage, int totalElements, int totalPage, Collection<T> list) {
        this.currentPage = currentPage;
        this.totalElements = totalElements;
        this.totalPage = totalPage;
        this.list = list;
    }
}
