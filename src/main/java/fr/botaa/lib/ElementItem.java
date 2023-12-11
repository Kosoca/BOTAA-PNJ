package fr.botaa.lib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

public enum ElementItem {
    BASIQUE(Component.text().content("⁂ Basique").color(TextColor.color(0x7b7d7d)).build()),
    VENT(Component.text().content("☁ Vent").color(TextColor.color(0x58d68d)).build()),
    EAU(Component.text().content("≈ Eau").color(TextColor.color(0x5dade2)).build()),
    TERRE(Component.text().content("✿ Terre").color(TextColor.color(0x8d6e63)).build()),
    FEU(Component.text().content("፠ Feu").color(TextColor.color(0xec7063)).build()),
    LUMIERE(Component.text().content("☀ Lumière").color(TextColor.color(0xf4d03f)).build()),
    OMBRE(Component.text().content("⚈ Ombre").color(TextColor.color(0xaf7ac5)).build()),

    ;
    private final TextComponent name;

    ElementItem(TextComponent aName) {
        this.name = aName;
    }

    public TextComponent getTextComponent() {
        return this.name;
    }
}
