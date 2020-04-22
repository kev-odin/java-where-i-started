// Kevin Chung
public class ManagersCrossing {
    public static void main(String[] args) {

    }

    public static boolean isMoveOkay(int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        return true; //fake true
    }
    // Method to check position integers are 1 or 2
    public static boolean isPositionLegal (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        if (boatBefore != 1 && boatBefore != 2 || boatAfter != 1 && boatAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (managerABefore != 1 && managerABefore != 2 || managerAAfter != 1 && managerAAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (managerBBefore != 1 && managerBBefore > 2 || managerBAfter != 1 && managerBAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (managerCBefore != 1 && managerCBefore > 2 || managerCAfter != 1 && managerCAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (engineerABefore != 1 && engineerABefore > 2 || engineerAAfter != 1 && engineerAAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (engineerBBefore != 1 && engineerBBefore > 2 || engineerBAfter != 1 && engineerBAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        if (engineerCBefore != 1 && engineerCBefore > 2 || engineerCAfter != 1 && engineerCAfter != 2) {
            System.out.println("All positions must be 1 or 2!");
            return false;
        }
        System.out.println("Yes! All positions are legal!");
        return true;
    }

    // Method to check that that boat is moving
    public static boolean isBoatMoving (int boatBefore, int boatAfter) {
        if (boatAfter != boatBefore) {
            System.out.println("The boat moved.");
            return true;
        }
        System.out.println("The boat must move!");
        return false;
    }

    // Method to check that the boat does not carry more than 2 people across the river, otherwise it will sink :( 
    public static boolean isMoveLegal (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {

        int peopleMoved = 0;
        if (managerAAfter != managerABefore) {
            peopleMoved++;
            if (boatBefore != managerABefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (managerBAfter != managerBBefore) {
            peopleMoved++;
            if (boatBefore != managerBBefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (managerCAfter != managerCBefore) {
            peopleMoved++;
            if (boatBefore != managerCBefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (engineerAAfter != engineerABefore) {
            peopleMoved++;
            if (boatBefore != engineerABefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (engineerBAfter != engineerBBefore) {
            peopleMoved++;
            if (boatBefore != engineerBBefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (engineerCAfter != engineerCBefore) {
            peopleMoved++;
            if (boatBefore != engineerCBefore) {
                System.out.println("You may not move a person who is not with the boat.");
                return false;
            }
        }
        if (peopleMoved > 2) {
            System.out.println("You must move one or two people.");
            return false;
        }
        System.out.println("The boat made it across! Yay!");
        return true;
    }
}