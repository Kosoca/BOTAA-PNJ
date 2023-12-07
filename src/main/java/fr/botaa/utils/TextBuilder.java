package fr.botaa.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;


public class TextBuilder {
    private final TextComponent textComponent;
    public TextBuilder(String aMessage){
        this.textComponent = Component.text().content(aMessage).build();
    }

    public TextComponent getTextComponent() {
        return textComponent;
    }
}
