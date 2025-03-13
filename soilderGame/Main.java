/*
Made By Sudheera D. Navaratne took me 6 hours to do extra things.
Who asked "nobody???" But this is my code so shut up !!!
*/

abstract class Gun {
    int currentBullets;
    int maxBullets;

    abstract void shoot();

    void reload() {
        if (currentBullets == maxBullets) {
            System.out.println("Gun has max Bullets");
        } else {
            currentBullets = maxBullets;
            System.out.println("Reload Successful. Bullets left " + currentBullets);
        }
    }
}

class AK47 extends Gun {
    AK47() {
        currentBullets = 30;
        maxBullets = 30;
    }

    @Override
    void shoot() {
        if (currentBullets > 0) {
            System.out.println("Shooting your with an Ak47. They are bleeding to death. (Gruesome. Get some help ! 😨)");
            currentBullets--;
            System.out.println("bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the AK47 quickly. They will kill you for what you did to them");
        }
    }
}

class Sniper extends Gun {
    Sniper() {
        currentBullets = 5;
        maxBullets = 5;
    }

    @Override
    void shoot() {
        if (currentBullets > 0) {
            System.out.println("Headshot your with a Sniper(They don't even what hit them. Nice ! 😏)");
            currentBullets--;
            System.out.println("bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the sniper quickly. They will kill you for what you did to them");
        }
    }
}

class Pistol extends Gun {
    Pistol() {
        currentBullets = 15;
        maxBullets = 15;
    }

    @Override
    void shoot() {
        if (currentBullets > 0) {
            System.out.println("Shooting your with a Pistol(Diabolical 😎)");
            currentBullets--;
            System.out.println("bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the pistol quickly. They will kill you for what you did to them");
        }
    }
}

class Vector extends Gun {
    Vector() {
        currentBullets = 30;
        maxBullets = 30;
    }

    @Override
    void shoot() {
        if (currentBullets > 0) {
            System.out.println("Shooting your with a Vector(Quick Kills I like that 😏)");
            currentBullets--;
            System.out.println("bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the vector quickly. They will kill you for what you did to them");
        }
    }
}

class Soldier {
    private Gun[] guns = new Gun[3];
    private int currentGunIndex = 0;

    Soldier() {
        guns[0] = new AK47();
        guns[1] = new Sniper();
        guns[2] = new Pistol();
    }
    void shoot() {
        if (currentGunIndex < 3 && currentGunIndex >= 0 && guns[currentGunIndex] != null) {
            guns[currentGunIndex].shoot();
        } else {
            System.out.println("You don't have a gun equipped! Select a gun first.");
        }
    }
    void reload() {
        if (currentGunIndex < 3 && currentGunIndex >= 0 && guns[currentGunIndex] != null) {
            guns[currentGunIndex].reload();
        } else {
            System.out.println("You don't have a gun equipped! Select a gun first.");
        }
    }
    void switchGun(int index) {
        if (index >= 0 && index < 3 && guns[index] != null) {
            currentGunIndex = index;
            System.out.println("Switched to " + guns[currentGunIndex].getClass().getSimpleName());
        } else {
            System.out.println("No gun selected! Make sure the gun exists.");
        }
    }
    void dropGun() {
        if (guns[currentGunIndex] != null) {
            System.out.println("Dropped " + guns[currentGunIndex].getClass().getSimpleName());
            guns[currentGunIndex] = null;
        } else {
            System.out.println("No gun to drop!");
        }
    }
    void addGun(Gun newGun) {
        for (int i = 0; i < guns.length; i++) {
            if (guns[i] == null) {
                guns[i] = newGun;
                System.out.println("Picked up " + newGun.getClass().getSimpleName());
                return;
            }
        }
        System.out.println("No space to pick up a new gun!");
    }

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        System.out.println("Game has started. Let's kill!");
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        soldier.switchGun(1);
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
        soldier.switchGun(2);
        soldier.shoot();
        soldier.switchGun(0);
        soldier.shoot();
        soldier.reload();
        soldier.shoot();
        soldier.switchGun(1);
        soldier.shoot();
        soldier.switchGun(5);
        soldier.shoot();
        soldier.switchGun(7);
        soldier.shoot();
        soldier.switchGun(2);
        soldier.shoot();
        soldier.addGun(new Vector());
        soldier.shoot();
        soldier.dropGun();
        soldier.shoot();
        soldier.switchGun(1);
        soldier.shoot();
        soldier.switchGun(2);
        soldier.shoot();
        soldier.reload();
        soldier.shoot();
        soldier.addGun(new Vector());
        soldier.switchGun(2);
        soldier.shoot();
        soldier.shoot();
        soldier.shoot();
    }
}