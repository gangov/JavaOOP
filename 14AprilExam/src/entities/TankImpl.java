package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40;
    private static final double DEFENCE_POINTS_MODIFIER = 30;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.defenseMode = true;
        this.attackPointsModifier = ATTACK_POINTS_MODIFIER;
        this.deffencePointsModifier = DEFENCE_POINTS_MODIFIER;
    }

    @Override
    public boolean getDefenseMode() {
        return false;
    }

    @Override
    public void toggleDefenseMode() {

    }
}
