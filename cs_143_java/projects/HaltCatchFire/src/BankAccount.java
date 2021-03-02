import java.io.File;

public class BankAccount {
    private int money;
    private int roundOne = 1000;
    private int roundTwo = 2000;

    public int bank () {

        return money;
    }

///////////////////////////////////////////////////////////////////////////// This is an example of having the money be tied by hard code
   // public void sports{
        // lets say the player picks  (Which NFL team appeared in four consecutive Super Bowls from 1991 – 1994 and lost them all?)
       // if (guess == Bills ){
           // money = money + 100;
      //  }else
           // money = money - 100;
   // }
/////////////////////////////////////////////////////////////////////////////
/////////                          OR                      //////////////////
/////////////////////////////////////////////////////////////////////////////
public BankAccount() {
  money = 0;
}

public int addPrize(int prizeMoney){

        money = money + prizeMoney;
        return money;
}
public boolean Check (){
        if(money >= roundOne){
            //means that the players money is either greater than or equal to the cut off for round one
            return true;  //player makes it to round 2
        }else

        return false;
}



}
