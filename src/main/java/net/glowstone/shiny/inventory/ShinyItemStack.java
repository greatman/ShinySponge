package net.glowstone.shiny.inventory;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * Implementation of {@link ItemStack}.
 */
public class ShinyItemStack implements ItemStack {

    private final ItemType item;
    private int quantity;
    private short damage;

    private int maxQuantity;

    public ShinyItemStack(ItemType item) {
        this(item, 1, (short) 0);
    }

    public ShinyItemStack(ItemType item, int quantity) {
        this(item, quantity, (short) 0);
    }

    public ShinyItemStack(ItemType item, int quantity, short damage) {
        this.item = item;
        this.quantity = quantity;
        this.damage = damage;
        maxQuantity = item.getMaxStackQuantity();
    }

    @Override
    public ItemType getItem() {
        return item;
    }

    @Override
    public void setDamage(short damage) {
        this.damage = damage;
    }

    @Override
    public short getDamage() {
        return damage;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity > maxQuantity) {
            throw new IllegalArgumentException("Quantity exceeds max: " + quantity + " > " + maxQuantity);
        }
        this.quantity = quantity;
    }

    @Override
    public int getMaxStackQuantity() {
        return maxQuantity;
    }

    @Override
    public void setMaxStackQuantity(int quantity) {
        maxQuantity = quantity;
    }

    @Override
    public int compareTo(@Nonnull ItemStack other) {
        return 0;
    }

}
