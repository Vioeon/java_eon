package ch02.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    void main(){
        Queue que = new LinkedList();

        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);

        System.out.println(que.size());

        System.out.println(que.poll());
        System.out.println(que.poll());
        System.out.println(que.poll());

        System.out.println(que.size());
    }
}
