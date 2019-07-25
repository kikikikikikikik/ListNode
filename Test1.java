/**
 * @ClassName Test1
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/7/24  9:00
 * @Veresion 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
    public String toString(){
        return String.format(val+" ");
    }
}
public class Test1 {
    public static void pushAfter(ListNode pos, int val) {
        ListNode node = new ListNode(val);
        node.next = pos.next;
        pos.next = node;
    }
    //头插
    private static ListNode pushFront(ListNode head,int val){
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;
        return node;
    }
    //尾插
    private static ListNode pushBack(ListNode head,int val){
        ListNode node=new ListNode(val);
        ListNode cur=head;
        if(head==null){
            return node;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        return head;
    }
    //头删
    private static ListNode deleteFront(ListNode head){
        if(head==null){
            System.err.println("表空不能删除");
            return null;
        }
        return head.next;
    }
    //尾删
    private static ListNode deleteBack(ListNode head){
        if(head==null){
            System.err.println("表空不能删除");
        }
        ListNode cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
    //去除指定元素
    private static ListNode removeelement(ListNode head,int val){
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            if(head.val==val){
                head=head.next;
            }

            if(cur.val==val){
                pre.next=cur.next;
            }
            else{
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
    //连接两个有序链表
    public ListNode contactlist(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while ((l1 != null) && (l2 != null)) {
            if (l1.val <= l2.val) {
                ListNode next=l1.next;
                if(result==null){
                    result=l1;
                }
                else {
                    cur.next = l1;
                }
                cur=l1;
                l1 =next;

            } else {
                ListNode next=l2.next;
                if(result==null){
                    result=l2;
                }
                else {
                    cur.next = l2;
                }
                cur=l2;
                l2 =next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return result.next;
    }
//打印
    private static void print(ListNode head){
        ListNode cur=head;
        for(;cur!=null;cur=cur.next){
            System.out.print(cur+"-->");
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode head=null;
        head=pushFront(head,1);
        head=pushFront(head,2);
        head=pushFront(head,3);
        head=pushBack(head,10);
        head=pushBack(head,20);
        head=pushBack(head,30);
        head=deleteFront(head);
        head=deleteBack(head);
        head= removeelement(head,10);
        print(head);
    }
}