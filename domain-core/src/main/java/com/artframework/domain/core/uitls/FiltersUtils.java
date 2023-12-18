package com.artframework.domain.core.uitls;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import com.artframework.domain.core.MPFieldLambda;
import com.artframework.domain.core.constants.Op;
import com.artframework.domain.core.dto.BaseLoadFlag;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li.pengcheng
 * @version V1.0
 * @date 2023/12/11
 * 用於通過實體過濾過濾條件
 **/
public class FiltersUtils {


    /**
     * 原始過濾條件
     *
     * @param filters
     * @param entity
     * @return
     */
    public static List<BaseLoadFlag.FilterDTO> getEntityFilters(List<BaseLoadFlag.FilterDTO> filters, String entity) {
        List<BaseLoadFlag.FilterDTO> filterDTOS = new ArrayList<>();
        if (ObjectUtil.isNotNull(filters)) {
            for (BaseLoadFlag.FilterDTO entry : filters) {
                if (entity.equals(entry.getEntity())) {
                    filterDTOS.add(entry);
                }
            }
        }
        return filterDTOS;
    }

    public static <DO, T> LambdaQueryWrapper<DO> buildWrapper(LambdaQueryWrapper<DO> wrapper, BaseLoadFlag.FilterDTO filter, Class<DO> doClass) {
//        switch (filter.getOp()) {
//            case Op.EQ.getCode():
//                wrapper.eq(MPFieldLambda.fieldLambda(doClass, filter.getField()), filter.getValue());
//                break;
//            default:
                wrapper.eq(MPFieldLambda.fieldLambda(doClass, filter.getField()), filter.getValue());
//        }
        return wrapper;
    }
}
