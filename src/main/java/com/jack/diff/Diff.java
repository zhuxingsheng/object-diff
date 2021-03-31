package com.jack.diff;

import java.util.List;

/**
 * @description: diff
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-24 14:49
 */
public interface Diff {

    DiffType getType();

    Object getNewValue();

    Object getOldVlaue();

}
