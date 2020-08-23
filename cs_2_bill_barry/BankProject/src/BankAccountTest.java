import static org.junit.Assert.*;

public class BankAccountTest {
    public void testConstructorAndGets() {
        BankAccount testAccount = new BankAccount("123", "Moog Loaf", 1078.89);
        assertEquals("123", testAccount.getOwnerName());
    }
    
}