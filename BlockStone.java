package com.connectis.programator.demo.dom.minecraft4;

import java.util.ArrayList;
import java.util.List;

public class BlockStone extends Block {

    private List<Tool> strongEnoughToolList;

    public BlockStone() {
        strongEnoughToolList = new ArrayList<>();
        strongEnoughToolList.add(new PickAxe(Tool.Material.WOOD)); //enum a nie obiekt konkretny
//        strongEnoughToolList.add(new PickAxe(new BlockStone()));  // to sie zapetlalo bo wywolywalem konstruktor BlockStone w konstruktorze BlockStone
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
