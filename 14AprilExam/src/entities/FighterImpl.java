package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {

    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50;
    private static final double DEFENCE_POINTS_MODIFIER = 25;


    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;
    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.aggressiveMode = true;
        this.attackPointsModifier = ATTACK_POINTS_MODIFIER;
        this.deffencePointsModifier = DEFENCE_POINTS_MODIFIER;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {

    }
}
