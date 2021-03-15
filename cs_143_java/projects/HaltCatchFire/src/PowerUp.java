//Zhengqi Yang
public class PowerUp {
    private int streak;
    private boolean powerUpStatus;

    public PowerUp(int streak, boolean powerUpStatus){
        this.streak=streak;
        powerUpStatus=false;
    }

    public int countStreak(){
        int res = 0;
        return res+streak;
    }

    public boolean status(){
        if(powerUpStatus){
            return true;
        }else{
            return false;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removePowerUp(ListNode head, int val){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr!=null){
            if (curr.val==val){
                curr = curr.next;
                prev.next = curr;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        //  if (curr.val==val) curr = null;
        return dummy.next;
    }


}
