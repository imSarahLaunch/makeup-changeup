package org.launchcode.makeupchangeup.data;

import org.launchcode.makeupchangeup.models.MakeupItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MakeupItemData {

    // need a place to put makeup items
    private static final Map<Integer, MakeupItem> items = new HashMap<>();

    // get all makeup items
    public static Collection<MakeupItem> getAll() {
        return items.values();
    }

    // get a single makeup item
    public static MakeupItem getById(int id) {
        return items.get(id);
    }

    // add a makeup item
    public static void add(MakeupItem makeupItem) {
        items.put(makeupItem.getId(), makeupItem);
    }

    // remove a makeup item
    public static void remove(int id) {
        items.remove(id);
    }
}
