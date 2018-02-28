/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.common.test.demo12_responseJsonResult;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/11/14
 */
public class PageReq {
    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     * 页大小
     */
    private Integer pageSize = 10;

    private Page pager;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        buildPage();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        buildPage();
        if (pager != null && this.pageSize != 10) {
            pager = PageHelper.startPage(this.pageNo, this.pageSize);
        }
    }

    private void buildPage() {
        if (pager == null && this.pageNo != null && this.pageSize != null) {
            pager = PageHelper.startPage(this.pageNo, this.pageSize);
        }
    }

    public int getTotal() {
        if (pager != null) {
            return (int) pager.getTotal();
        }
        return 0;
    }
}
