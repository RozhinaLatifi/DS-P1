public class Stack {

        StackNode top;

        public Stack() {
            this.top = null;
        }

        public void push(String data) {
            StackNode newNode = new StackNode(data);
            newNode.next = this.top;
            this.top = newNode;
        }

        public String pop() {
            if (this.top == null) {
                throw new ArithmeticException("empty stack");
            }
            String data = this.top.data;
            this.top = this.top.next;
            return data;
        }

        public String peek() {
            if (this.top == null) {
                throw new ArithmeticException("empty stack");
            }
            return this.top.data;
        }
    public void printList() {
        StackNode currentNode = this.top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

        public boolean isEmpty() {
            return this.top == null;
        }


    }

