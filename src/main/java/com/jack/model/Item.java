package com.jack.model;

import com.jack.domain.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: item
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-30 10:09
 */
@AllArgsConstructor
@Data
public class Item implements Entity {

    private long id;
    private String itemName;

}
