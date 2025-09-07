package com.example.render;

import java.util.Objects;

public class Glyph {
    // Flyweight: extrinsic state (character) + intrinsic state (shared style)
    private final char ch;
    private final TextStyle style;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = Objects.requireNonNull(style, "style");
    }

    public int drawCost() { 
        return style.getSize() + (style.isBold() ? 10 : 0); 
    }
    
    public char getCh() { return ch; }
    public TextStyle getStyle() { return style; }
    
    // Convenience methods for backward compatibility
    public String getFont() { return style.getFont(); }
    public int getSize() { return style.getSize(); }
    public boolean isBold() { return style.isBold(); }
}
