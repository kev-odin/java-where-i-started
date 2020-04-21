// Kevin Chung
public class ManagersCrossing {
    public static void main(String[] args) {
        isPositionOkay(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
        isBoatMoving(1, 2);
        isMoveLegal(2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2);
    }

    public static boolean isMoveOkay(int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        return true; //fake true
    }
    // Method to check position integers are between 1 and 2
    public static boolean isPositionOkay (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        if (boatBefore > 0 && boatBefore <= 2) {
            if (boatAfter > 0 && boatAfter <= 2)
            return true;
        }
        if (managerABefore > 0 && managerABefore <= 2) {
            if (managerAAfter > 0 && managerAAfter <= 2)
            return true;
        }
        if (managerBBefore > 0 && managerBBefore <= 2) {
            if (managerBAfter > 0 && managerBAfter <= 2)
            return true;
        }
        if (managerCBefore > 0 && managerCBefore <= 2) {
            if (managerCAfter > 0 && managerCAfter <= 2)
            return true;
        }
        if (engineerABefore > 0 && engineerABefore <= 2 ) {
            if (engineerAAfter > 0 && engineerAAfter <= 2)
            return true;
        }
        if (engineerBBefore > 0 && engineerBBefore <= 2) {
            if (engineerBAfter > 0 && engineerBAfter <= 2)
            return true;
        }
        if (engineerCBefore > 0 && engineerCBefore <= 2) {
            if (engineerCAfter > 0 && engineerCAfter <= 2)
            return true;
        } 
        System.out.println("All positions must be 1 or 2!");
        return false;
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