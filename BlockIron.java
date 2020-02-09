package com.connectis.programator.demo.dom.minecraft4;

import java.util.ArrayList;
import java.util.List;

public class BlockIron extends Block {

    private List<Tool> strongEnoughToolList;

    public BlockIron() {
        strongEnoughToolList = new ArrayList<>();
        strongEnoughToolList.add(new PickAxe(Tool.Material.STONE));
        strongEnoughToolList.add(new PickAxe(Tool.Material.STEEL));
    }

    public boolean isToolStrongEnough(Tool tool) {

        boolean result = false;

        for (Tool strongTool : strongEnoughToolList) {
            if (strongTool.equals(tool)) {
                result = true;
            }

        }

        return result;
    }

    @Override
    public List<Item> gather(Tool tool) {

        if (this.isToolStrongEnough(tool)) {
            return super.gather(tool);
        }

        return new ArrayList<>();
    }
}
