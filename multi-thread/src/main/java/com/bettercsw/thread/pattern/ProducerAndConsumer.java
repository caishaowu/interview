package com.bettercsw.thread.pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;


/**
 * @author csw
 * @date 2020/9/23 11:01
 */
@Slf4j
public class ProducerAndConsumer {

    class Message {
        private int id;
        private String message;

        public Message(int id, String message) {
            this.id = id;
            this.message = message;
        }

        public int getId() {
            return this.id;
        }

        public String getMessage() {
            return this.message;
        }
    }

    @AllArgsConstructor
    @Getter
    class MessageQueue {

        private LinkedList<Message> queue = new LinkedList<>();
        private int capacity;

        public Message take() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    log.info("紧急备货中....");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = queue.removeFirst();
                queue.notifyAll();
                return message;
            }

        }

        public void put(Message message) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    log.info("仓库满了...");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.addLast(message);
                queue.notifyAll();
            }
        }

    }
}
