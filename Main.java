package com.connectis.programator.demo.dom.minecraft4;

public class Main {

    public static void main(String[] args) {


        Tool tool = new PickAxe(Tool.Material.STEEL);

        Player player = new Player("William Wallace");

        player.setTool(tool);

        Block block = new BlockWood();
        Block block2 = new BlockWood();
        Block block3 = new BlockWood();

        Block blockStone = new BlockStone();

        Block blockDiamond = new BlockDiamond();

        player.gatherBlock(block);
        player.gatherBlock(block2);
        player.gatherBlock(block3);


        player.gatherBlock(blockStone);
        player.gatherBlock(blockDiamond);

        System.out.println(player);

        player.setTool(player.craftPickAxe(Tool.Material.WOOD).get());  // to jest dobrze
                                                                        // zaznacza get InteliJ bo zwraca uwage ze moze tego Optionala nie byc
                                                                        // i trzeba zrobic checka isPresent()

        System.out.println(player);

        player.setTool(player.craftPickAxe(Tool.Material.STEEL).get());

        System.out.println(player);


    }
}
