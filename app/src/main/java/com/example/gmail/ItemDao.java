package com.example.gmail;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public ItemDao() {
    }


    public static List<ItemModel> getListFavorite(List<ItemModel> items){
        List<ItemModel> result = new ArrayList<>();
        for (int i=0;i<items.size();i++){
            if (items.get(i).isSelected() == true){
                result.add(items.get(i));
            }
        }
        return result;
    }

    public  static List<ItemModel> getListSearch(List<ItemModel> items, String text){
        List<ItemModel> result = new ArrayList<>();
        for (int index=0; index<items.size(); index++){
            if (items.get(index).getCapId().toLowerCase().contains(text.toLowerCase())
                    || items.get(index).getText1Id().toLowerCase().contains(text.toLowerCase())
                    || items.get(index).getText2Id().toLowerCase().contains(text.toLowerCase()))
            {
                result.add(items.get(index));
            }
        }
        return result;
    }
}
