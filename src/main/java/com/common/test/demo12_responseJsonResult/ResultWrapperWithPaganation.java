package com.common.test.demo12_responseJsonResult;

import lombok.Data;

/**
 * @author jinx
 * @date 2018/8/22 15:45
 * Desc:
 */
@Data
public class ResultWrapperWithPaganation<T> {

    private static final int CODE = 0;
    private static final String MESSAGE = "OK";

    private Integer code;
    private String message;
    private T data;

    public ResultWrapperWithPaganation() {
    }

    public ResultWrapperWithPaganation(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultWrapperWithPaganation(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultWrapper buildSuccess() {
        return new ResultWrapper(CODE, MESSAGE);
    }

    public static <T> ResultWrapper<T> buildSuccess(T data) {
        return new ResultWrapper<>(CODE, MESSAGE, data);
    }

    public static ResultWrapper buildError(Integer code, String message) {
        return new ResultWrapper(code, message);
    }

    public static ResultWrapper buildError(Integer code) {
        return new ResultWrapper(code, null);
    }

    @Data
    public static class WithPagination<T> extends ResultWrapper<T> {
        private Integer pageNo;
        private Integer pageSize;
        private Integer totalPage;
        private Long totalCount;

        public WithPagination(Integer code, String message, Integer pageNo, Integer pageSize, Integer totalPage, Long totalCount, T data) {
            super(code, message, data);
            this.pageNo = pageNo;
            this.pageSize = pageSize;
            this.totalPage = totalPage;
            this.totalCount = totalCount;
        }

        public static <T> WithPagination buildSuccess(Integer pageNo, Integer pageSize, Integer totalPage, long totalCount, T data) {
            return new WithPagination<>(CODE, MESSAGE, pageNo, pageSize, totalPage, totalCount, data);
        }

    }

}
