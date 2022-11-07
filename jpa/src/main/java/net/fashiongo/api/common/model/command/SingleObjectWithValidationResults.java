package net.fashiongo.api.common.model.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
public class SingleObjectWithValidationResults<T, S> implements ApiResponseBody {

    private T content;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<S> validationResults;

    public SingleObjectWithValidationResults(T content, List<S> validationResults) {
        this.content = content;
        this.validationResults = validationResults;
    }
}
