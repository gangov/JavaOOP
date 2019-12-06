package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_SHOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (canFire()) {
            this.setTotalBullets(this.getBulletsPerBarrel() - BULLETS_SHOT);
            if (this.getBulletsPerBarrel() >= 0) {
                this.setTotalBullets(this.getTotalBullets() - this.getBulletsPerBarrel());
            }
            return BULLETS_SHOT;
        }
        return 0;
    }
}
