/*
Made By Sudheera D. Navaratne took me 6 hours to do extra things.
 Who asked "nobody?"" But this is my code so shut up !!!
 */

import java.util.Scanner;

abstract class Gun {
    int currentBullets;
    int maxBullets;

    abstract void shoot(String enemy);

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
    void shoot(String enemy) {
        if (currentBullets > 0) {
            System.out.println("Shooting your " + enemy + " with an Ak47. They are bleeding to death. (Gruesome. Get some help ! 😨)");
            currentBullets--;
            System.out.println("Bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the AK47 quickly. The " + enemy + " will kill you for what you did to them");
        }
    }
}

class Sniper extends Gun {
    Sniper() {
        currentBullets = 10;
        maxBullets = 10;
    }

    @Override
    void shoot(String enemy) {
        if (currentBullets > 0) {
            System.out.println("Headshot your " + enemy + " with a Sniper(They don't even know what hit them. Nice ! 😏)");
            currentBullets--;
            System.out.println("Bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the Sniper quickly. The " + enemy + " will kill you for what you did to them");
        }
    }
}

class Pistol extends Gun {
    Pistol() {
        currentBullets = 15;
        maxBullets = 15;
    }

    @Override
    void shoot(String enemy) {
        if (currentBullets > 0) {
            System.out.println("Shooting your " + enemy + " with a Pistol(Diabolical 😎)");
            currentBullets--;
            System.out.println("Bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the Pistol quickly. The " + enemy + " will kill you for what you did to them");
        }
    }
}

class Vector extends Gun {
    Vector() {
        currentBullets = 30;
        maxBullets = 30;
    }

    @Override
    void shoot(String enemy) {
        if (currentBullets > 0) {
            System.out.println("Shooting with a Vector. Quick kills! 😏");
            currentBullets--;
            System.out.println("Bullets left " + currentBullets);
        } else {
            System.out.println("You need to reload the Vector quickly. The " + enemy + " will kill you for what you did to them");
        }
    }
}

class Soldier {
    private Gun[] guns = new Gun[3];
    private int currentGunIndex = 0;
    private static String enemy = "enemies";

    Soldier() {
        guns[0] = new AK47();
        guns[1] = new Sniper();
        guns[2] = new Pistol();
    }

    void switchGun(int index) {
        if (index >= 0 && index < guns.length && guns[index] != null) {
            currentGunIndex = index;
            System.out.println("Switched to " + guns[currentGunIndex].getClass().getSimpleName());
        } else {
            System.out.println("Invalid gun selection!");
        }
    }

    void shoot() {
        if (guns[currentGunIndex] != null) {
            guns[currentGunIndex].shoot(enemy);
        } else {
            System.out.println("No gun equipped!");
        }
    }

    void reload() {
        if (guns[currentGunIndex] != null) {
            guns[currentGunIndex].reload();
        } else {
            System.out.println("No gun equipped!");
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

    void displayAvailableGuns() {
        System.out.println("Available Guns:");
        for (int i = 0; i < guns.length; i++) {
            if (guns[i] != null) {
                System.out.println(i + " - " + guns[i].getClass().getSimpleName());
            }
        }
    }

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game has started. Let's kill!");
        boolean condition;

        do {
            System.out.print("Turn on Friendly Fire (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                enemy = "friends";
                condition = true;
            } else if (choice.equals("N")) {
                enemy = "enemies";
                condition = true;
            } else {
                System.out.println("Not a valid response. Try again.");
                enemy = "enemies";
                condition = false;
            }
        } while (!condition);

        while (running) {
            System.out.println("\nChoose an action: \n1. Shoot\n2. Reload\n3. Switch Gun\n4. Drop Gun\n5. Add Gun\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    soldier.shoot();
                    break;
                case 2:
                    soldier.reload();
                    break;
                case 3:
                    soldier.displayAvailableGuns();
                    System.out.println("Select Gun by number:");int gunChoice = scanner.nextInt();
                    soldier.switchGun(gunChoice);
                    break;
                case 4:
                    soldier.dropGun();
                    break;
                case 5:
                    System.out.println("Pick up a new gun: 0 - AK47 | 1 - Sniper | 2 - Pistol | 3 - Vector");
                    int newGunChoice = scanner.nextInt();
                    Gun newGun = null;
                    switch (newGunChoice) {
                        case 0:
                            newGun = new AK47();
                            break;
                        case 1:
                            newGun = new Sniper();
                            break;
                        case 2:
                            newGun = new Pistol();
                            break;
                        case 3:
                            newGun = new Vector();
                            break;
                        default:
                            System.out.println("Invalid gun choice!");
                            break;
                    }
                    if (newGun != null) {
                        soldier.addGun(newGun);
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting game... Goodbye! 👋");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }
}
