import static edu.hm.cs.rs.arch.a02_waitnotify.Operation.*;

public class OperationsParallel {

    public static void main(String[] args){
        init(args);
        Object monitor1 = new Object();
        Object monitor2 = new Object();
        synchronized (monitor1){
            A1.exec();
        }
        synchronized (monitor1){
            A2.exec();
        }
        synchronized (monitor1) {
            A3.exec();
        }

        B1.exec();
        B2.exec();
        B3.exec();

        C1.exec();
        C2.exec();
        C3.exec();
        System.out.println("Complete");
    }

}
