package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_SHOT = 5;


    public Rifle(String name) {
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
