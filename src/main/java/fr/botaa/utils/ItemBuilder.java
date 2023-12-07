package fr.botaa.utils;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ItemBuilder {

    private final ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(ItemStack is, int amount) {
        this.is = is;
        this.is.setAmount(amount);
    }
    public ItemBuilder(HeadDatabaseAPI apiHead, String id, int amount) {
        this.is = apiHead.getItemHead(id);
        this.is.setAmount(amount);
    }

    public ItemBuilder(Material m, int amount) {
        this.is = new ItemStack(m, amount);
    }

    public Material getMaterial() {
        return this.is.getType();
    }

    public ItemBuilder clone() throws CloneNotSupportedException {
        ItemBuilder clone = (ItemBuilder) super.clone();
        return new ItemBuilder(this.is);
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder setDurability(short dur) {
        this.is.setDurability(dur);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean yesNo) {
        ItemMeta im = this.is.getItemMeta();
        im.setUnbreakable(true);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setName(String name) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        im.setDisplayName(name);
        this.is.setItemMeta(im);
        return this;
    }
    public String getName() {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        return this.is.getItemMeta().getDisplayName();
    }

    public ItemBuilder setAmount(int amount) {
        this.is.setAmount(amount);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(Enchantment enchantment, int level, boolean b) {
        this.is.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchantment) {
        this.is.removeEnchantment(enchantment);
        return this;
    }


    public ItemBuilder addItemFlag(ItemFlag itemflag) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        im.addItemFlags(itemflag);
        this.is.setItemMeta(im);
        return this;
    }
    public ItemBuilder addItemFlag(Set<ItemFlag> itemFlags) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        for (ItemFlag itemFlag : itemFlags) {
            im.addItemFlags(itemFlag);
        }
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        im.addEnchant(enchantment, level, true);
        this.is.setItemMeta(im);
        return this;
    }
    public ItemBuilder addEnchant(Map<Enchantment, Integer> enchants) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        for (Enchantment enchantment : enchants.keySet()) {
            im.addEnchant(enchantment, enchants.get(enchantment), true);
        }
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addPotionEffect(PotionEffectType type, int duration, int amplifier) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        ((ItemBuilder) im).addPotionEffect(type, duration, amplifier);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        im.setLore(Arrays.asList(lore));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta im = this.is.getItemMeta();
        assert im != null;
        im.setLore(lore);
        this.is.setItemMeta(im);
        return this;
    }

    public List<String> getLore() {
        return this.is.getItemMeta().getLore();
    }


    public ItemBuilder setEnchantedBook(Enchantment enchantment, int power, boolean visible) {
        try {
            EnchantmentStorageMeta im = (EnchantmentStorageMeta)this.is.getItemMeta();
            assert im != null;
            im.addStoredEnchant(enchantment, power, visible);
            this.is.setItemMeta(im);
        } catch (ClassCastException ignored) {
        }
        return this;
    }

    public ItemBuilder setModelData(Integer modelData) {
            ItemMeta im = this.is.getItemMeta();
            assert im != null;
            im.setCustomModelData(modelData);
            this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) this.is.getItemMeta();
            assert im != null;
            im.setColor(color);
            this.is.setItemMeta(im);
        } catch (ClassCastException ignored) {
        }
        return this;
    }

    public ItemStack toItemStack() {
        return this.is;
    }


}
