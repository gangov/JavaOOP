package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository heroRepository;

    @Before
    public void creatingHeroRepository() {
        heroRepository = new HeroRepository();
    }


    @Test
    public void testingHeroRepositoryConstructor() {
        int size = heroRepository.getHeroes().size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testingHeroCreationMethod() {
        heroRepository.create(new Hero("Pesho", 20));
        Assert.assertEquals(1, this.heroRepository.getHeroes().size());
    }

    @Test(expected = NullPointerException.class)
    public void creatingNullHereShouldThrowException() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creatingDuplicateHeroShouldThrowException() {
        heroRepository.create(new Hero("Pesho", 22));
        heroRepository.create(new Hero("Pesho", 22));
    }

    @Test
    public void testingGetCountMethod() {
        heroRepository.create(new Hero("Ivan", 22));
        heroRepository.create(new Hero("Pesho", 22));
        Assert.assertEquals(2, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeNullHeroThrowingException() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeEmptyNameHeroThrowingException() {
        heroRepository.remove("          ");
    }

    @Test
    public void removeHeroShouldDecreaseSize() {
        heroRepository.create(new Hero("Ivan", 22));
        heroRepository.create(new Hero("Pesho", 22));
        heroRepository.remove("Pesho");
        Assert.assertEquals(1, heroRepository.getCount());
        Assert.assertEquals(true, heroRepository.remove("Ivan"));
    }

    @Test
    public void gettingHeroWithMaximumLevel() {
        heroRepository.create(new Hero("Ivan", 22));
        heroRepository.create(new Hero("Pesho", 30));
        Hero hero = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals("Pesho", hero.getName());
    }

    @Test
    public void gettingMaxLevelShouldReturnNullIfNoHeroesAdded() {
        Hero hero = heroRepository.getHeroWithHighestLevel();
        Assert.assertNull(hero);
    }

    @Test
    public void testingGetHeroMethod() {
        heroRepository.create(new Hero("Ivan", 22));
        heroRepository.create(new Hero("Pesho", 30));
        Hero hero = heroRepository.getHero("Ivan");
        Assert.assertEquals("Ivan", hero.getName());
    }

    @Test
    public void testingHeroMethodShouldGiveNullWhenHeroWithNoSuchNameIsAsked() {
        Hero hero = heroRepository.getHero("asd");
        Assert.assertNull(hero);
    }

    @Test
    public void testingGetHeroesMethod() {
        Hero hero1 = new Hero("Ivan", 22);
        Hero hero2 = new Hero("Pesho", 30);
        Hero hero3 = new Hero("Stoyan", 3);
        Hero hero4 = new Hero("Mincho", 34);

        List<Hero> collection = new ArrayList<>();
        collection.add(hero1);
        collection.add(hero2);
        collection.add(hero3);
        collection.add(hero4);

        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);
        this.heroRepository.create(hero4);
        List<Hero> actual = new ArrayList<>(this.heroRepository.getHeroes());
        Assert.assertEquals(collection, actual);
    }
}
