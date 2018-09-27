package training.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void update(){
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.contains("Conjured")) {
                updateQuality(i);
                updateQuality(i);
                items[i].sellIn = items[i].sellIn + 1;
            } else {
                updateQuality(i);
            }
        }
    }
    public void updateQuality(int i) {
        // changed .equals() to .contains() to include all possible passes
        if (!items[i].name.contains("Aged Brie") && !items[i].name.contains("Backstage pass")) {
            if (items[i].quality > 0) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                    items[i].quality = items[i].quality - 1;
                }
            }
        } else {
            if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
                // also change .equals() to .contains()
                if (items[i].name.contains("Backstage pass")) {
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
        }
        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }
        if (items[i].sellIn < 0) {
            // also change .equals() to .contains()
            if (!items[i].name.contains("Aged Brie")) {
                if (!items[i].name.contains("Backstage pass")) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            }
        }
    }
}