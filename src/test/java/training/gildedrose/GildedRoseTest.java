package training.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void valuesLowerAtEndOfDay(){
        Item item = new Item("Carrot", 40, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(item.sellIn == 39 && item.quality == 39);
    }

    @Test
    public void qualityDecreasesBy2AfterSellBy(){
        Item item = new Item("Carrot", 0, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(item.quality == 38);
    }

    @Test
    public void qualityIsNeverNegative(){
        Item item = new Item("Carrot", 20, 0);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 999999999; count++) {
            rose.updateQuality();
        }

        assert(item.quality == 0);
    }

    @Test
    public void agedBrieIncreasesInQuality(){
        Item item = new Item("Aged Brie", 20, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(item.sellIn == 19 && item.quality == 41);
    }

    @Test
    public void qualityNeverMoreThan50(){
        Item item = new Item("Aged Brie", 20, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 999999999; count++) {
            rose.updateQuality();
        }

        assert(item.quality <= 50);
    }

    @Test
    public void sulfrasNeverDecreases() {
        Item sulfras = new Item("Sulfuras, Hand of Ragnaros", 20, 20);
        Item[] items = {sulfras};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 999999999; count++) {
            rose.updateQuality();
        }

        assert(sulfras.sellIn == 20 && sulfras.quality == 20);
    }

    @Test
    public void backstagePassesIncreaseInQuality(){
        Item pass = new Item("Backstage pass", 20, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(pass.sellIn == 19 && pass.quality == 21);
    }

    @Test
    public void backstagePassesQualityIncreasesBy2WhenSellInIsBelow10(){
        Item pass = new Item("Backstage pass", 10, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(pass.sellIn == 9 && pass.quality == 22);
    }

    @Test
    public void backstagePassesQualityIncreasesBy3WhenSellInIsBelow5(){
        Item pass = new Item("Backstage pass", 5, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(pass.sellIn == 4 && pass.quality == 23);
    }

    @Test
    public void backstagePassesQualityDropsTo0AfterConcert(){
        Item pass = new Item("Backstage pass", 0, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.updateQuality();

        assert(pass.quality == 0);
    }
}