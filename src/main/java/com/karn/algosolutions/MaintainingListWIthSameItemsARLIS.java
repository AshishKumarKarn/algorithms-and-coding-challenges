package com.karn.algosolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class MaintainingListWIthSameItemsARLIS {
    public static void main(String[] args) {
        SelectionDo selectionDo1=new SelectionDo("itemName1","csn1");
        SelectionDo selectionDo2=new SelectionDo("itemName2","csn2");
        SelectionDo selectionDo3=new SelectionDo("itemName3","csn3");
        SelectionDo selectionDo4=new SelectionDo("itemName4","csn4");
        SelectionDo selectionDo5=new SelectionDo("itemName5","csn1");
        SelectionDo selectionDo6=new SelectionDo("itemName6","csn2");
        SelectionDo selectionDo7=new SelectionDo("itemName7","csn2");
        SelectionDo selectionDo8=new SelectionDo("itemName8","csn4");
        SelectionDo selectionDo9=new SelectionDo("itemName9","csn12");
        SelectionDo selectionDo10=new SelectionDo("itemName10","csn3");
        SelectionDo selectionDo11=new SelectionDo("itemName11","csn2");
        SelectionDo selectionDo12=new SelectionDo("itemName12","csn4");
        List<SelectionDo> selectionDos = Arrays.asList(selectionDo1, selectionDo2, selectionDo3, selectionDo4,
                selectionDo5, selectionDo6, selectionDo7, selectionDo8,
                selectionDo9, selectionDo10, selectionDo11,
                selectionDo12);
        System.out.println(getTransformedItemSet(selectionDos));

    }

    private static SelectedItemModel getTransformedItemSet(List<SelectionDo> selectionDos) {
        List<ItemSetModel> itemSetModels = new ArrayList<>();
        List<String> commonStimulusNames = new ArrayList<>();
        for (SelectionDo selectionDo : selectionDos) {
            ItemSetModel itemSetModel;
            int index = commonStimulusNames.indexOf(selectionDo.commonStimulusName);
            if (index > -1) {
                itemSetModel = itemSetModels.get(index);
            } else {
                itemSetModel = new ItemSetModel(new HashSet<>(), selectionDo.commonStimulusName);
                commonStimulusNames.add(selectionDo.commonStimulusName);
                itemSetModels.add(itemSetModel);
            }

            itemSetModel.itemModelSet.add(transformSelectionDoToItemModel(selectionDo));

        }
        return new SelectedItemModel(itemSetModels.toArray(new ItemSetModel[]{}));
    }

    private static ItemModel transformSelectionDoToItemModel(SelectionDo selectionDo) {
        return new ItemModel(selectionDo.itemName);
    }
}

class SelectionDo {
    String itemName;
    String commonStimulusName;

    SelectionDo(String itemName, String commonStimulusName) {
        this.itemName = itemName;
        this.commonStimulusName = commonStimulusName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SelectionDo.class.getSimpleName() + "[", "]")
                .add("itemName='" + itemName + "'")
                .add("commonStimulusName='" + commonStimulusName + "'")
                .toString();
    }
}

class SelectedItemModel {
    private ItemSetModel[] itemSetModels;
    SelectedItemModel(ItemSetModel[] itemSetModels){
        this.itemSetModels=itemSetModels;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SelectedItemModel.class.getSimpleName() + "[", "]")
                .add("itemSetModels=" + Arrays.toString(itemSetModels))
                .toString();
    }
}

class ItemSetModel {
    Set<ItemModel> itemModelSet;
    String commonStimulusName;

    ItemSetModel(Set<ItemModel> itemModelSet, String commonStimulusName) {
        this.itemModelSet = itemModelSet;
        this.commonStimulusName = commonStimulusName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemSetModel.class.getSimpleName() + "[", "]")
                .add("itemModelSet=" + itemModelSet)
                .add("commonStimulusName='" + commonStimulusName + "'")
                .toString();
    }
}

class ItemModel {
    String itemName;

    ItemModel(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemModel.class.getSimpleName() + "[", "]")
                .add("itemName='" + itemName + "'")
                .toString();
    }
}