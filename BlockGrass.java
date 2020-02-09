package com.connectis.programator.demo.dom.minecraft4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockGrass extends Block {

    @Override
    public List<Item> gather(Tool tool) {

        return new ArrayList<>(Arrays.asList(new BlockDirt()));
    }
}
