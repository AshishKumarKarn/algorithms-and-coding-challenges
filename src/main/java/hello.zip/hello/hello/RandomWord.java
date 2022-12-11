//package hello.zip.hello.hello;//remove package name before submission
//
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;
//
//
//public class RandomWord {
//    public static void main(String[] args) {
//        double counter = 1d;
//        String result = "";
//        while (!StdIn.isEmpty()) {
//            boolean bernoulli = StdRandom.bernoulli(1d / counter);
//            String string = StdIn.readString();
//            if (bernoulli) {
//                result = string;
//            }
//            counter++;
//        }
//        StdOut.println(result);
//    }
//}
