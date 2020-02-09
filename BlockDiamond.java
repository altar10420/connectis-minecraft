package com.connectis.programator.demo.dom.minecraft4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockDiamond extends Block {

    private List<Item> returnItemList;
    private List<Tool> strongEnoughToolList;

    public BlockDiamond() {

        this.returnItemList = new ArrayList<>();

        this.strongEnoughToolList = new ArrayList<>();

        this.strongEnoughToolList.add(new PickAxe(Tool.Material.STEEL));
    }

    @Override
    public List<Item> gather(Tool tool) {

        if (this.isToolStrongEnough(tool)) {

            Random random = new Random();
            for (int i = 0; i < random.nextInt(3) + 1 ; i++) {
                this.returnItemList.add(new Diamond());
            }
            return returnItemList;

        }
        return returnItemList;
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
}
