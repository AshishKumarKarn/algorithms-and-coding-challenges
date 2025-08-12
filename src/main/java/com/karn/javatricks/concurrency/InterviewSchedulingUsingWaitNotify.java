package com.karn.javatricks.concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class InterviewSchedulingUsingWaitNotify {
    public static void main(String[] args) {
        Queue<InterviewTask> queue = new LinkedList<>();
        Thread t1 = new Thread(new Interviewer("one", queue));
        Thread t2 = new Thread(new Interviewer("two", queue));
        Thread t3 = new Thread(new Interviewer("four", queue));
        Thread t4 = new Thread(new Interviewer("five", queue));
        Thread t5 = new Thread(new Interviewer("six", queue));
        Thread s1 = new Thread(new InterviewSchedular(queue));
        Thread s2 = new Thread(new InterviewSchedular(queue));
        Thread s3 = new Thread(new InterviewSchedular(queue));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        s1.start();
        s2.start();
        s3.start();

    }
}

class Interviewer implements Runnable {
    private final Queue<InterviewTask> queue;
    private final String interviewer;

    public Interviewer(String interviewer, Queue<InterviewTask> queue) {
        this.interviewer = interviewer;
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.printf("Interviewer %s started at %s\n", interviewer, new Date());

        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.printf("[%s] No tasks. Waiting...\n", interviewer);
                        queue.wait(); // wait until a task is available
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                InterviewTask task = queue.poll();
                System.out.printf("Interview %s in progress by %s at %s\n",
                        task.getId(), interviewer, new Date());
            }

            try {
                Thread.sleep(2000); // Simulate time to complete interview
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            System.out.printf("Interview finished by %s at %s\n", interviewer, new Date());
            System.out.printf("Pending interviews %s\n", queue.size());
        }
    }
}

class InterviewSchedular implements Runnable {
    private final Queue<InterviewTask> tasks;

    InterviewSchedular(Queue<InterviewTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            int id = (int) (Math.random() * 10000);
            synchronized (tasks) {
                tasks.add(new InterviewTask(id));
                System.out.println("Added new interview task with id " + id + " at "+ new Date());
                tasks.notifyAll(); // notify all interviewers
            }

            try {
                Thread.sleep(1000); // Wait before adding next task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class InterviewTask {
    private final int id;

    InterviewTask(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
