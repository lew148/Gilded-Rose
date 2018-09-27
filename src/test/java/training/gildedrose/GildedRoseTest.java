package training.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void valuesLowerAtEndOfDay(){
        Item item = new Item("Carrot", 40, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.sellIn).isEqualTo(39);
        assertThat(item.quality).isEqualTo(39);
    }

    @Test
    public void qualityDecreasesBy2AfterSellBy(){
        Item item = new Item("Carrot", 0, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.quality).isEqualTo(38);
    }

    @Test
    public void qualityIsNeverNegative(){
        Item item = new Item("Carrot", 20, 0);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 1000; count++) {
            rose.update();
        }

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    public void agedBrieIncreasesInQuality(){
        Item item = new Item("Aged Brie", 20, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.sellIn).isEqualTo(19);
        assertThat(item.quality).isEqualTo(41);
    }

    @Test
    public void qualityNeverMoreThan50(){
        Item item = new Item("Aged Brie", 20, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 1000; count++) {
            rose.update();
        }

        assertThat(item.quality).isLessThanOrEqualTo(50);
    }

    @Test
    public void sulfrasNeverDecreases() {
        Item sulfras = new Item("Sulfuras", 20, 80);
        Item[] items = {sulfras};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 1000; count++) {
            rose.update();
        }

        assertThat(sulfras.sellIn).isEqualTo(20);
        assertThat(sulfras.quality).isEqualTo(80);
    }

    @Test
    public void backstagePassesIncreaseInQuality(){
        Item pass = new Item("Backstage pass", 20, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(19);
        assertThat(pass.quality).isEqualTo(21);
    }

    @Test
    public void backstagePassesQualityIncreasesBy2WhenSellInIsBelow10(){
        Item pass = new Item("Backstage pass", 10, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(9);
        assertThat(pass.quality).isEqualTo(22);
    }

    @Test
    public void backstagePassesQualityIncreasesBy3WhenSellInIsBelow5(){
        Item pass = new Item("Backstage pass", 5, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(4);
        assertThat(pass.quality).isEqualTo(23);
    }

    @Test
    public void backstagePassesQualityDropsTo0AfterConcert(){
        Item pass = new Item("Backstage pass", 0, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.quality).isEqualTo(0);
    }

//--------------------------------------------------CONJURED TESTS----------------------------------------------------//


    @Test
    public void conjuredQualityDecreasesAtDoubleRate(){
        Item item = new Item("Conjured Carrot", 40, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.sellIn).isEqualTo(39);
        assertThat(item.quality).isEqualTo(38);
    }

    @Test
    public void conjuredQualityDecreasesBy4AfterSellBy(){
        Item item = new Item("Conjured Carrot", 0, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.quality).isEqualTo(36);
    }


    @Test
    public void conjuredAgedBrieIncreasesBy2InQuality(){
        Item item = new Item("Conjured Aged Brie", 20, 40);
        Item[] items = {item};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(item.sellIn).isEqualTo(19);
        assertThat(item.quality).isEqualTo(42);
    }

    @Test
    public void conjuredBackstagePassesIncreaseInQualityBy2(){
        Item pass = new Item("Conjured Backstage pass", 20, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(19);
        assertThat(pass.quality).isEqualTo(22);
    }

    @Test
    public void conjuredBackstagePassesQualityIncreasesBy4WhenSellInIsBelow10(){
        Item pass = new Item("Conjured Backstage pass", 10, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(9);
        assertThat(pass.quality).isEqualTo(24);
    }

    @Test
    public void conjuredBackstagePassesQualityIncreasesBy6WhenSellInIsBelow5(){
        Item pass = new Item("Conjured Backstage pass", 5, 20);
        Item[] items = {pass};
        GildedRose rose = new GildedRose(items);

        rose.update();

        assertThat(pass.sellIn).isEqualTo(4);
        assertThat(pass.quality).isEqualTo(26);
    }

    @Test
    public void conjuredSulfrasNeverDecreases() {
        Item sulfras = new Item("Conjured Sulfuras", 20, 80);
        Item[] items = {sulfras};
        GildedRose rose = new GildedRose(items);

        for (int count = 0; count <= 1000; count++) {
            rose.update();
        }

        assertThat(sulfras.sellIn).isEqualTo(20);
        assertThat(sulfras.quality).isEqualTo(80);
    }

}