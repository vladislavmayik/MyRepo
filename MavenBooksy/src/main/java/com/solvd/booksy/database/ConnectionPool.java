package com.solvd.booksy.database;

import com.solvd.booksy.exceptions.ConnectionPoolException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final int POOL_SIZE = 5;

    private static List<String> availableConnections = new ArrayList<>();
    private static List<String> usedConnections = new ArrayList<>();
    private static int connectionCounter = 0;

    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            availableConnections.add("Connection-" + i);
            connectionCounter++;
        }
        AppLogger.info("Connection pool initialized with " + POOL_SIZE + " connections");
    }

    public static synchronized String getConnection() throws ConnectionPoolException {
        if (availableConnections.isEmpty()) {
            AppLogger.error("No available connections.");
            throw new ConnectionPoolException("No available connections in pool.");
        }

        String connection = availableConnections.remove(0);
        usedConnections.add(connection);
        return connection;
    }

    public static synchronized void releaseConnection(String connection) throws ConnectionPoolException {
        if (connection == null) {
            AppLogger.warning("Attempted to release null connection");
            throw new ConnectionPoolException("Cannot release null connection");
        }

        if (!usedConnections.remove(connection)) {
            AppLogger.warning("Connection not found in used connections: " + connection);
            throw new ConnectionPoolException("Connection not found in used connections");
        }

        availableConnections.add(connection);
    }

    public static synchronized int getAvailableCount() {
        return availableConnections.size();
    }

    public static synchronized int getUsedCount() {
        return usedConnections.size();
    }

    public static synchronized void shutdown() {
        AppLogger.info("Shutting down connection pool...");
        availableConnections.clear();
        usedConnections.clear();
        AppLogger.info("Connection pool closed. All connections released.");
    }
}