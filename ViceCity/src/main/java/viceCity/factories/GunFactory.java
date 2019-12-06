package viceCity.factories;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;

public class GunFactory {
    public static Gun createGun(String type, String name) {
        switch (type) {
            case "Pistol":
                return new Pistol(name);
            case "Rifle":
                return new Rifle(name);
            default:
                return null;
        }
    }
}
