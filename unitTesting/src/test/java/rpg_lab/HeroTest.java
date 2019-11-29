package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import static org.junit.Assert.assertEquals;

public class HeroTest {
    private static final int BASE_EXPERIENCE = 10;


    @Test
    public void receivingExperienceWhenTargetDies() {
        Weapon mockedAxe = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(BASE_EXPERIENCE);

        Hero hero = new Hero("Ivan", BASE_EXPERIENCE, mockedAxe);

        hero.attack(mockedTarget);

        assertEquals(BASE_EXPERIENCE + 10, hero.getExperience());
    }
}
