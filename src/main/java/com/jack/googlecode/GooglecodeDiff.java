package com.jack.googlecode;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jack.model.Item;
import com.jack.model.Model;
import com.jack.model.Vo;
import difflib.Delta;
import difflib.DiffRow;
import difflib.DiffRow.Tag;
import difflib.DiffRowGenerator;
import difflib.DiffUtils;
import difflib.Patch;
import java.util.Collections;
import java.util.List;

/**
 * @description: google code 只能比较string
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-30 10:30
 */
public class GooglecodeDiff {

    public static void main(String[] args) {
        Model working = new Model(1,"name",new Vo(1,"desc"), Lists.newArrayList(new Item(1, "name")));
        Model base = new Model(1,"name",new Vo(1,"desc"), Lists.newArrayList(new Item(1, "name"),new Item(2, "name")));


        Patch<String> patch = DiffUtils.diff(Collections.singletonList(JSON.toJSONString(base)),Collections.singletonList(JSON.toJSONString(working)));

        DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder().showInlineDiffs(false);
        DiffRowGenerator generator = builder.build();

        for (Object d : patch.getDeltas()) {
            Delta delta = (Delta)d;
            List<?> list = delta.getRevised().getLines();
            for (Object object : list) {
                System.out.println(object);
            }

            List<DiffRow> generateDiffRows = generator.generateDiffRows((List<String>) delta.getOriginal().getLines(), (List<String>) delta
                .getRevised().getLines());
            int leftPos = delta.getOriginal().getPosition();
            int rightPos = delta.getRevised().getPosition();
            for (DiffRow row : generateDiffRows) {
                Tag tag = row.getTag();
                if (tag == Tag.INSERT) {
                    System.out.println("Insert: ");
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == Tag.CHANGE) {
                    System.out.println("change: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else if (tag == Tag.DELETE) {
                    System.out.println("delete: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("");
                } else if (tag == Tag.EQUAL) {
                    System.out.println("equal: ");
                    System.out.println("old-> " + row.getOldLine());
                    System.out.println("new-> " + row.getNewLine());
                    System.out.println("");
                } else {
                    throw new IllegalStateException("Unknown pattern tag: " + tag);
                }
            }
        }
    }

}
