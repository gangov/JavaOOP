package rpg_lab.interfaces;

import rpg_lab.Dummy;

public interface Weapon {
    public int getAttackPoints();

    public int getDurabilityPoints();

    public void attack(Target target);
}
