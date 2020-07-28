package corejava.core.threadTest;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyConnectionPool {
    private ConcurrentHashMap<String, FutureTask<Connection>> pool = new ConcurrentHashMap<>();

    public Connection getConnection(String key) throws InterruptedException, ExecutionException {
        FutureTask<Connection> connectionTask = pool.get(key);


        if (connectionTask != null) {
            return connectionTask.get();


        } else {
            Callable<Connection> callable = () -> createConnection();
            FutureTask<Connection> newTask = new FutureTask<>(callable);


            /**
             * @return null if there was no mapping for the key
             */
            connectionTask = pool.putIfAbsent(key, newTask);

            /**
             * run only for the 1st time connection creation
             */
            if (connectionTask == null) {
                connectionTask = newTask;
                connectionTask.run();
            }


            return connectionTask.get();
        }
    }

    public Connection createConnection() {
        return new Connection();
    }

    class Connection {
    }

}
