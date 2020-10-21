package com.example;

import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

    interface Work {
        void perform() throws IOException, InterruptedException;
    }

    private String formatDecimal(final long number) {
        return new DecimalFormat("0.00").format((double) number / 1_000_000_000);
    }

    private void timeWork(final Work work) throws IOException, InterruptedException {
        System.out.println("Start work");
        final long startTime = System.nanoTime();
        work.perform();
        final long endTime = System.nanoTime();
        final long duration = endTime - startTime;
        System.out.println(String.format("Completed work in %s second(s)", formatDecimal(duration)));
    }

    private void theFunctionToTime() {
        for (int i = 0; i < 1_000; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Main main = new Main();
        main.timeWork(()->{
            main.theFunctionToTime();
        });
    }
}
