package com.connectis.programator.demo.dom.minecraft4;

import com.connectis.programator.demo.dom.minecraft3.Item;

import java.util.Objects;

public abstract class Tool implements Item {

    private Material material;

    public Tool(Material material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return material == tool.material;
    }

    @Override
    public int hashCode() {

        return Objects.hash(material);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.material + ")";
    }

    public enum Material {
        WOOD, STONE, STEEL
    }
}
