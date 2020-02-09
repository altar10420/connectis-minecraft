package com.connectis.programator.demo.dom.minecraft4;


import java.util.*;

public class Player {

    private String name;
    private List<Item> equipment;
    private Tool tool;



    public Player(String name) {
        this.name = name;
        this.equipment = new ArrayList<>();
        this.tool = null;
    }

    public void gatherBlock(Block block) {

        List<Item> itemList = block.gather(this.tool);
        collect(itemList);
    }

    public void collect(List<Item> itemList) {

        equipment.addAll(itemList);
    }


    public Optional<Tool> craftPickAxe(Tool.Material material) {

        // tutaj juz przekazuje material wiec nie robic
        // nowych oddzielnych list juz jak ponizej
        // Bartek - inny user podpowiedzi:
        // sprawdzenie ile obiektow danego typu w ekwipunku a potem usuniecie ich z ekwipunku
        // juz ten material usuwac z ekwipunku?


        // tak nie robic, tylko zrobic Mape i wtedy zaleznie co przekazane jako argument, to zwraca odpowiednio BlockWood itp
        // tak musi byc, zeby sie dalo rozszerzyc funkcjonalnosc jak bedzie nowy material, bez przebudowy calej metody

        Map<Tool.Material, Block> materialToBlockMap = new HashMap<>();  // w konstruktorze playera (pole statyczne)

        materialToBlockMap.put(Tool.Material.WOOD, new BlockWood()); //samodzielny enum, zeby Blocki miały też swoje typy
        materialToBlockMap.put(Tool.Material.STONE, new BlockStone());
        materialToBlockMap.put(Tool.Material.STEEL, new BlockIron());

        List<Block> craftingMaterialList = new ArrayList<>();
//        int count = 0;

//        for (Item item : equipment) {
//            while (count <= 2) {
//                craftingMaterialList.add(item);
//                count++;
//            }
//        }

//        while (count <= 2) { // zapętli sie w nieskonczonosc (iteracja zamiast tego)
//            if (equipment.contains(material)) {
//                craftingMaterialList.add(material);
//                count++;
//            }
//        }
        int counter = 0;  // zamiast tego zrobic Liste i do niej wrzucac, po wrzuceniu dwoch zrobic break

        for (Item item : equipment) {

//            if (item.inMaterialObtainedFromBlockTypeMap)
//            if (materialToBlockMap.contains(item)) {
//                craftingMaterialList.add(material);
//            }

//            if ((materialToBlockMap.get(material))==(item)) {
//            if ((materialToBlockMap.get(material)).getClass().equals(item.getClass())) {
            if ((materialToBlockMap.get(material)).equals(item)) { //

                if (counter < 2) {
                    craftingMaterialList.add((Block) item);
                }
                counter++;
            }
        }

//        for (int i = 0; i < 2 ; i++) {
//            craftingMaterialList.add(materialToBlockMap.get(material));
//        }
        System.out.println("\ncraftingMaterialList to make " + material + " = " + craftingMaterialList + "\n");

//        equipment.removeAll(craftingMaterialList);

        if (craftingMaterialList.size() > 0) {

            for (Block block : craftingMaterialList) {
                equipment.remove(block);
            }

            return Optional.of(new PickAxe(material));
        }

        return Optional.empty();

//        List<BlockWood> countBlockWood = new ArrayList<>();
//        List<BlockStone> countBlockStone = new ArrayList<>();
//        List<BlockIron> countBlockIron = new ArrayList<>();

//        for (Item item : equipment) {
//            switch (item.getClass().getSimpleName()) { // nie robic tak, robic obiektowo (Bartek)
//                case "BlockWood" :
//                    countBlockWood.add((BlockWood) item);  // to robię, ale nie wiem czemu trzeba castowac ?
//                    continue;
//
//                case "BlockStone" :
//                    countBlockStone.add((BlockStone) item);
//                    continue;
//
//                case "BlockIron" :
//                    countBlockIron.add((BlockIron) item);
//            }
//        }
//
//        if (material == Tool.Material.WOOD && countBlockWood.size() >= 2) {
//            equipment.removeAll(countBlockWood.subList(0, 2));
//            return Optional.of(new PickAxe(material));
//        }
//        else if (material == Tool.Material.STONE && countBlockStone.size() >= 2) {
//            equipment.removeAll(countBlockStone.subList(0, 2));
//            return Optional.of(new PickAxe(material));
//        }
//        else if (material == Tool.Material.STEEL && countBlockIron.size() >= 2) {
//            equipment.removeAll(countBlockIron.subList(0, 2));
//            return Optional.of(new PickAxe(material));
//        }
//
//        return Optional.empty();
    }

//    public Tool craftPickAxe(Tool.Material material) {
//
//        int countBlockWood = 0;
//        int countBlockStone = 0;
//        int countBlockIron = 0;
//
//        Tool craftedTool = null;
//
//        for (Item item : equipment) {
//            switch (item.getClass().getSimpleName()) {
//                case "BlockWood" :
//                    countBlockWood += 1;
//                    continue;
//
//                case "BlockStone" :
//                    countBlockStone += 1;
//                    continue;
//
//                case "BlockIron" :
//                    countBlockIron += 1;
//            }
//        }
//
//        if (material == Tool.Material.WOOD && countBlockWood >= 2) {
//            craftedTool = new PickAxe(material);
//            equipment.remove(new BlockWood());
//        }
//        else if (material == Tool.Material.STONE && countBlockStone >= 2) {
//            craftedTool = new PickAxe(material);
//        }
//        else if (material == Tool.Material.STEEL && countBlockIron >= 2) {
//            craftedTool = new PickAxe(material);
//        }
//
//        return craftedTool;
//    }


    public String getName() {
        return name;
    }


    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", equipment=" + equipment +
                ", tool=" + tool +
                '}';
    }
}
