package com.jack.model;

import com.jack.domain.Entity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: model
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-30 09:27
 */
@Data
@AllArgsConstructor
public class Model implements Entity {

    private long id;

    private String name;

    private Vo vo;

    private List<Item> items;

}
