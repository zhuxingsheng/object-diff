package com.jack.diff;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description: diff object
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-24 19:01
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiffObject implements Diff {

    private DiffType diffType;

    private Object newValue;

    private Object oldValue;

    @Override
    public DiffType getType() {
        return diffType;
    }

    @Override
    public Object getNewValue() {
        return newValue;
    }

    @Override
    public Object getOldVlaue() {
        return oldValue;
    }

}
