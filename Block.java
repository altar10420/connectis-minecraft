package com.connectis.programator.demo.dom.minecraft4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Block implements Item {


    public List<Item> gather(Tool tool) {
        return new ArrayList<>(Arrays.asList(this));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());  // tak nie robic, bo porownoje klase z ta sama klasa i nigdy nie zadziala
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
