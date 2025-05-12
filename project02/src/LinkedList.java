public class LinkedList {

        Node head;

        public LinkedList() {
            this.head = null;
        }

    public void add(Consignment data) {
            Node newNode = new Node(data);

            if (this.head == null) {
                this.head = newNode;
            } else {
                Node currentNode = this.head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
        }

    public boolean find(int obj) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.randomNum == obj) {
                return true;
            }
            index++;
            current = current.next;
        }
        return false;
    }
    public boolean addToStack(int obj , String data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.randomNum == obj) {
                current.data.st.push(data);
                return true;
            }
            index++;
            current = current.next;
        }
        return false;
    }
    public boolean printStack(int obj) {
        Node current = head;
        while (current != null) {
            if (current.data.randomNum == obj) {
                System.out.println(current.data.getName());
                System.out.println(current.data.getReceiver());
                System.out.println(current.data.getDistance());
                current.data.st.printList();
                return true;
            }
            current = current.next;
        }
        return false;
    }






}
