Minecraft

- Interface Item (marker interface) - taki ktory nie posiada metod, tylko po to zeby obiekty byly jakims typem

- Podstawowa klasa Block implements Item

- Tool (abstrakcyjna) -> PickAxe, Axe (wood, stone, steel) - materialy z ktorych moga byc narzedzia

- Klasa Block (abstrakcyjna): metoda -> public (ktora zwraca) List<Item> gather(Tool tool) - mozna przypisac tez nulla

- Klasa BlockDirt (nic nie zwraca) (zwraca siebie)

- Klasa BlockGrass (zwraca z gather BlockDirt) (w ten sposob zaimplementowac metode gather)

- Klasa BlockStone (wymaga PickAxe o dowolnym typie (wood, stone, steel)) (zwraca siebie ale wylacznie jesli PickAxem)

- Klasa BlockWood (mozna bez PickAxe zbierac)

- Klasa BlockIron (wymaga PickAxe w wersji stone+ (stone lub steel))

- Klasa BlockDiamond (wymaga PickAxe steel, zwraca 2-5 * Diamond)

- Player -> ekwipunek (List<Item>)

zaimplementowac craftowanie, np z kilku drewien mozna zobic PickAxe, i tak dalej



