package actual;

/**
 * 判断链表是否有环
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        if(isCycle(node1)){
            System.out.println("链表有环");
        }else{
            System.out.println("链表没环");
        }
    }

    /**
     * 判断是否有环，并且输出环的长度
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        int flag = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2 && flag == 0) {
                while (p2 != null && p2.next != null) {
                    p1 = p1.next;
                    p2 = p2.next.next;
                    flag++;
                    if (p1 == p2) {
                        System.out.println("环的长度"+flag);
                        getCycle(head);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 如果环，输出入环点的值
     * @param head
     */
    public static void getCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        int flag = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2 && flag == 0) {
                p1 = head;
                while (p2 != null && p2.next != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2) {
                        System.out.println("入环点的值"+p1.data);
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}
