package com.jack.javadiff;

/**
 * @description: diff
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-30 16:00
 */

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.jack.diff.Diff;
import com.jack.diff.DiffList;
import com.jack.diff.DiffUtils;
import com.jack.diff.EntityDiff;
import com.jack.model.Item;
import com.jack.model.Model;
import com.jack.model.Vo;

/**
 * https://github.com/SQiShER/java-object-diff
 */
public class ObjectDiff {

    public static void main(String[] args) {

        Model working = new Model(1,"name",new Vo(1,"desc"), Lists.newArrayList(new Item(1, "name1"),new Item(3, "name")));
        Model base = new Model(1,"name",new Vo(1,"desc1"), Lists.newArrayList(new Item(1, "name"),new Item(2, "name")));

        final EntityDiff entityDiff = DiffUtils.diff(base, working);

        final Diff diff = entityDiff.getDiff("items");

        if (diff instanceof DiffList) {
            DiffList dl = (DiffList)diff;
            for (Diff d : dl) {
                System.err.println(d.getType());
                System.err.println(JSON.toJSONString(d.getNewValue()));
                System.err.println(JSON.toJSONString(d.getOldVlaue()));
            }
        }
    }

}
