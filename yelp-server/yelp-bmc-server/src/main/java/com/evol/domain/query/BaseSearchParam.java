package com.evol.domain.query;

import com.evol.SortEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseSearchParam implements Serializable {
    public BaseSearchParam(){
        page = 0;
        pageSize = 10;
        sort = SortEnum.ASC;
    }

    private int page;

    private int pageSize;

    private SortEnum sort;

    public void setPage(int value){
        if(value >= 0)
            this.page = value;
    }
}
