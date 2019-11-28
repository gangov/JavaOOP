package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void dummyLosesHealthIfAttacked() {
        Axe axe = new Axe(1, 10);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
        Assert.assertEquals(9, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dummyThrowsExceptionIfAttackedWhenDead() {
        Axe axe = new Axe(1, 10);
        Dummy dummy = new Dummy(0, 10);
        axe.attack(dummy);
    }

    @Test
    public void deadDummyCanGiveExperience() {
        Hero hero = new Hero("Ivan");
        Axe axe = new Axe(11, 10);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
        Assert.assertEquals(10, hero.getExperience());
    }
}
