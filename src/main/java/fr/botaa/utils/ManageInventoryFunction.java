package fr.botaa.utils;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ManageInventoryFunction {
    public static <T> boolean equalsIgnoreOrderItemStack(List<ItemStack> elements1, List<ItemStack> elements2) {
        if (elements1.size() != elements2.size()) {
            return false;
        }
        List<ItemStack> work = new ArrayList<ItemStack>(elements2);
        for (ItemStack element : elements1) {
            if (!work.remove(element)) {
                return false;
            }
        }
        return work.isEmpty();
    }
}
