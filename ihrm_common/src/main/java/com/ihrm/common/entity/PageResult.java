package com.ihrm.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页处理
 * {
 *     success:成功，
 *     code:10000,
 *     message:OK
 *     data:{
 *         total:,//总条数
 *         rows://记录列表
 *
 *     }
 * }
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
