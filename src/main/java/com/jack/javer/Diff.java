package com.jack.javer;

import static org.javers.core.diff.ListCompareAlgorithm.LEVENSHTEIN_DISTANCE;

import com.google.common.collect.Lists;
import com.jack.model.Item;
import com.jack.model.Model;
import com.jack.model.Vo;
import java.util.List;
import java.util.Optional;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.changetype.ObjectRemoved;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.container.ListChange;
import org.javers.core.diff.changetype.container.ValueRemoved;

/**
 * @description: https://github.com/javers/javers
 * @author: zhuxingsheng@gmail.com
 * @create: 2021-03-30 15:36
 */
public class Diff {

    public static void main(String[] args) {
        Model working = new Model(1,"name",new Vo(1,"desc"), Lists.newArrayList(new Item(1, "name")));
        Model base = new Model(1,"name",new Vo(1,"desc1"), Lists.newArrayList(new Item(1, "name"),new Item(2, "name")));

        Javers javers = JaversBuilder.javers()
            .withListCompareAlgorithm(LEVENSHTEIN_DISTANCE)
            .build();
        org.javers.core.diff.Diff diff = javers.compare(base, working);
        final Changes changes = diff.getChanges();

        final List<ObjectRemoved> objectRemoveds = diff.getChangesByType(ObjectRemoved.class);

        final List<ListChange> changesByType = diff.getChangesByType(ListChange.class);
        final ListChange listChange = changesByType.get(0);

        final List<?> addedValues = listChange.getAddedValues();
        final List<ValueRemoved> valueRemovedChanges = listChange.getValueRemovedChanges();
        final List<?> removedValues = listChange.getRemovedValues();

        final List<PropertyChange> propertyChanges = diff.getPropertyChanges("items");
        final PropertyChange propertyChange = propertyChanges.get(0);
        System.err.println(propertyChange.getChangeType());
        System.err.println(propertyChange.isPropertyRemoved());
        System.err.println(propertyChange.isPropertyAdded());
        System.err.println(propertyChange.isPropertyValueChanged());
        final Optional<Object> affectedObject = propertyChange.getAffectedObject();
        System.err.println(diff);
    }

}
