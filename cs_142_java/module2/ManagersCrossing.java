// Kevin Chung
public class ManagersCrossing {

    public static void main(String[] args) {
    isMoveOkay(1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1);
    }

    // Method to check that the boat does not carry more than 2 people across the river and at least 1 person, otherwise it will not move :( 
    public static boolean isMoveOkay (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        
        if (!isPositionLegal(boatBefore, managerABefore, managerBBefore, managerCBefore, engineerABefore, engineerBBefore, engineerCBefore, boatAfter, managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter)) {
            return false;
        }
        
        if (!isBoatMoving(boatBefore, boatAfter)) {
            return false;
        }

        int peopleMoved = 0;
        // Manager A moved
        if (managerAAfter != managerABefore) {
            //System.out.println("Manager A moved across the river.");
            peopleMoved++;
            if (boatBefore != managerABefore) {
                System.out.println("You may not move Manager A who is not with the boat.");
                return false;
            }
        }
        // Manager B moved
        if (managerBAfter != managerBBefore) {
            //System.out.println("Manager B moved across the river.");
            peopleMoved++;
            if (boatBefore != managerBBefore) {
                System.out.println("You may not move Manager B who is not with the boat.");
                return false;
            }
        }
        // Manager C moved
        if (managerCAfter != managerCBefore) {
            //System.out.println("Manager C moved across the river.");
            peopleMoved++;
            if (boatBefore != managerCBefore) {
                System.out.println("You may not move Manager C who is not with the boat.");
                return false;
            }
        }
        // Engineer A moved
        if (engineerAAfter != engineerABefore) {
            //System.out.println("Engineer A moved across the river.");
            peopleMoved++;
            if (boatBefore != engineerABefore) {
                System.out.println("You may not move Engineer A who is not with the boat.");
                return false;
            }
        }
        // Engineer B moved
        if (engineerBAfter != engineerBBefore) {
            //System.out.println("Engineer B moved across the river.");
            peopleMoved++;
            if (boatBefore != engineerBBefore) {
                System.out.println("You may not move Engineer B who is not with the boat.");
                return false;
            }
        }
        // Engineer C moved
        if (engineerCAfter != engineerCBefore) {
            //System.out.println("Engineer C moved across the river.");
            peopleMoved++;
            if (boatBefore != engineerCBefore) {
                System.out.println("You may not move Engineer C who is not with the boat.");
                return false;
            }
        }
        // More than 2 people can not be on the boat and if no people are on the boat it does not move.
        if (peopleMoved <= 0 || peopleMoved > 2) {
            System.out.println("You must move one or two people!");
            return false;
        }
        return true;
    }

    // Method to check position integers are 1 or 2, part of isMoveOkay method
    public static boolean isPositionLegal (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        // If boatBefore does not equal 1 and boatBefore does not equal 2 OR boatAfter does not equal 1 and boatAfter does not equal 2. && > ||.
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
        //System.out.println("All positions are 1 or 2! Keep moving forward.");
        return true;
    }

    // Method to check that that boat is moving, needs to be true, part of isMoveOkay method
    public static boolean isBoatMoving (int boatBefore, int boatAfter) {
        // If boatAfter is not the same as boatBefore, we have a destination
        if (boatAfter != boatBefore) {
            //System.out.println("The boat is ready to be moved. Destination has been set.");
            return true;
        }
        System.out.println("The boat must move!");
        return false;
    }

    // Method to check that the engineer is safe and not eaten, still working on this section
    public static boolean isEngineerSafe (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        // Manager A protects Engineer A
        if (engineerAAfter != managerAAfter || engineerABefore != managerABefore) {
            System.out.println("Engineer A is not protected!");
            return false;
        }
        System.out.println("Engineer A and Manager A are on the same side.");

        // Manager B protects Engineer B

        // Manager C protects Engineer C

        return true;
    }
} // Class bracket