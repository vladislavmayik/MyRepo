package com.solvd.booksy.database;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

    private static ConnectionPool instance;
    private final BlockingQueue<String> pool;
    private static final int MAX_CONNECTIONS = 5;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(MAX_CONNECTIONS);
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            pool.add("Connection " + i);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public String getConnection() throws InterruptedException {
        LOGGER.info("A connection is being requested from the pool.");
        return pool.take();
    }

    public void releaseConnection(String connection) {
        LOGGER.info("Connection returned to the pool.");
        pool.offer(connection);
    }
}