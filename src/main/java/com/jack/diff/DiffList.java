package com.jack.diff;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: diff list
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-24 19:02
 */
public class DiffList extends ArrayList<Diff> implements Diff, List<Diff> {

    @Override
    public DiffType getType() {
        return null;
    }

    @Override
    public Object getNewValue() {
        return null;
    }

    @Override
    public Object getOldVlaue() {
        return null;
    }

}
