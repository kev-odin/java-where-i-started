// Kevin Chung

public class ManagersCrossing {

    public static boolean isMoveOkay (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        
        if (!isPositionLegal(boatBefore, managerABefore, managerBBefore, managerCBefore, engineerABefore, engineerBBefore, engineerCBefore, boatAfter, managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter)) {
            return false;
        }
        
        if (!isBoatSinking(boatBefore, managerABefore, managerBBefore, managerCBefore, engineerABefore, engineerBBefore, engineerCBefore, boatAfter, managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter)) {
            return false;
        }

        if (!isEngineerSafe(managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter)) {
            return false;
        }

        areWeThereYet(managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter);
        return true;
    }

    // Method to check position integers are 1 or 2, part of isMoveOkay method
    public static boolean isPositionLegal (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        
        String positionError = "All positions must be 1 or 2!";

        if (boatBefore != 1 && boatBefore != 2 || boatAfter != 1 && boatAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (managerABefore != 1 && managerABefore != 2 || managerAAfter != 1 && managerAAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (managerBBefore != 1 && managerBBefore != 2 || managerBAfter != 1 && managerBAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (managerCBefore != 1 && managerCBefore != 2 || managerCAfter != 1 && managerCAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (engineerABefore != 1 && engineerABefore != 2 || engineerAAfter != 1 && engineerAAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (engineerBBefore != 1 && engineerBBefore != 2 || engineerBAfter != 1 && engineerBAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        if (engineerCBefore != 1 && engineerCBefore != 2 || engineerCAfter != 1 && engineerCAfter != 2) {
            System.out.println(positionError);
            return false;
        }
        return true;
    }

    // Method to check that that boat is moving, needs to be true, part of isBoatSinking method
    public static boolean isBoatMoving (int boatBefore, int boatAfter) {
        // If boatAfter is not the same as boatBefore, we have a destination
        if (boatAfter != boatBefore) {
            return true;
        }
        System.out.println("The boat must move!");
        return false;
    }

    // Method to check that the boat does not carry more than 2 people across the river and at least 1 person, otherwise it will not move :( 
    public static boolean isBoatSinking (int boatBefore, int managerABefore, int managerBBefore, int managerCBefore, int engineerABefore, int engineerBBefore, int engineerCBefore, int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        
        if (!isBoatMoving(boatBefore, boatAfter)) {
            return false;
        }
        
        int peopleMoved = 0;
        String boatError = "You may not move a person who is not with the boat!";
        String captainError = "You must move one or two people!";

        // Manager A moved
        if (managerAAfter != managerABefore) {
            peopleMoved++;
            if (boatBefore != managerABefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // Manager B moved
        if (managerBAfter != managerBBefore) {
            peopleMoved++;
            if (boatBefore != managerBBefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // Manager C moved
        if (managerCAfter != managerCBefore) {
            peopleMoved++;
            if (boatBefore != managerCBefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // Engineer A moved
        if (engineerAAfter != engineerABefore) {
            peopleMoved++;
            if (boatBefore != engineerABefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // Engineer B moved
        if (engineerBAfter != engineerBBefore) {
            peopleMoved++;
            if (boatBefore != engineerBBefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // Engineer C moved
        if (engineerCAfter != engineerCBefore) {
            peopleMoved++;
            if (boatBefore != engineerCBefore) {
                System.out.println(boatError);
                return false;
            }
        }
        // More than 2 people can not be on the boat and if no people are on the boat it does not move.
        if (peopleMoved <= 0 || peopleMoved > 2) {
            System.out.println(captainError);
            return false;
        }
        return true;
    }

    // Method to check that the engineer is safe and not eaten
    public static boolean isEngineerSafe (int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        
        String managerARecruited = "Manager A would try to recruit someone!";
        String managerBRecruited = "Manager B would try to recruit someone!";
        String managerCRecruited = "Manager C would try to recruit someone!";

        // Manager A would recruit engineer B if manager B was not present
        if (managerAAfter == engineerBAfter) {
            if (engineerBAfter != managerBAfter) {
                System.out.println(managerARecruited);
                return false;
            }
        }
        // Manager A would recruit engineer C if manager C was not present
        if (managerAAfter == engineerCAfter) {
            if (engineerCAfter != managerCAfter) {
                System.out.println(managerARecruited);
                return false;
            }
        }
        // Manager B would recruit engineer A if manager A was not present
        if (managerBAfter == engineerAAfter) {
            if (engineerAAfter != managerAAfter) {
                System.out.println(managerBRecruited);
                return false;
            }
        }
        // Manager B would recruit engineer C if manager C was not present
        if (managerBAfter == engineerCAfter) {
            if (engineerCAfter != managerCAfter) {
                System.out.println(managerBRecruited);
                return false;
            }
        }
        // Manager C would recruit engineer A if manager A was not present
        if (managerCAfter == engineerAAfter) {
            if (engineerAAfter != managerAAfter) {
                System.out.println(managerCRecruited);
                return false;
            }
        }
        // Manager C would recruit engineer B if manager B was not present
        if (managerCAfter == engineerBAfter) {
            if (engineerBAfter != managerBAfter) {
                System.out.println(managerCRecruited);
                return false;
            }
        }
        return true;
    }

    // Method to check the win condition is satisfied,
    public static boolean areWeThereYet (int managerAAfter, int managerBAfter, int managerCAfter, int engineerAAfter, int engineerBAfter, int engineerCAfter) {
        if (managerAAfter == 2 && managerBAfter == 2 && managerCAfter == 2 && engineerAAfter == 2 && engineerBAfter == 2 && engineerCAfter == 2){
            System.out.println("You solved the puzzle!");
            return true;
        }
        return false;
    }

} // Class bracket