import java.util.Scanner;

import java.util.Random;

public class Main {
    public static LinkedList list = new LinkedList();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue q = new Queue(100);
        MinHeap mn = new MinHeap(100);

        boolean exitCondition = false;
        do {
            System.out.println("1.recieve    2.sending     3.new position    4.follow-up   ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: {
                    System.out.println("enter name , transmitter , receiver , distance");
                    String name = scanner.nextLine();
                    String transmitter = scanner.nextLine();
                    String receiver = scanner.nextLine();
                    int distance = Integer.parseInt(scanner.nextLine());
                    System.out.println("consingnment created");

                    int min = 100000;
                    int max = 999999;
                    int range = max - min + 1;
                    int randomNum = (int) (Math.random() * range) + min;

                    while (list.find(randomNum)) {
                        randomNum = (int) (Math.random() * range) + min;
                    }
                    Consignment con = new Consignment(name, transmitter, receiver, distance, randomNum);
                    list.add(con);

                    System.out.println(randomNum);

                    q.enqueue(con);
                    mn.insert(con);


                    break;
                }

                case 2: {

                    System.out.println("1.first in queue       2.nearest ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1: {
                            System.out.println(q.peek().getDistance()); //اول صفو چاپ میکنه
                            System.out.println("1.yes   2.no ");
                            String answer = scanner.nextLine();
                            if (answer.equals("yes")) {
                                q.dequeue();
                                mn.remove();
                            } else {
                                System.out.println("canceled");
                            }

                            break;
                        }

                        case 2: {

                            System.out.println(mn.peek().getDistance()); //
                            String answer = scanner.nextLine();
                            if (answer.equals("yes")) {
                                mn.remove();
                                q.dequeue();
                            } else {
                                System.out.println("canceled");
                            }
                            break;
                        }
                    }

                    break;
                }
                case 3: {
                    System.out.println("Enter newPosition and randomNum");
                    String newPosition = scanner.nextLine();
                    int number = Integer.parseInt(scanner.nextLine());
                    list.addToStack(number, newPosition);
                    break;
                }

                case 4: {
                    System.out.println("Enter randomNum");
                    int number = Integer.parseInt(scanner.nextLine());

                    list.printStack(number);
                    break;

                }
                default:
                    System.out.println("faghat az mavared mojood");
            }

        }
        while (exitCondition == false);
    }
}
