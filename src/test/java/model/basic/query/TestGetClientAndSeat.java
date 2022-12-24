package model.basic.query;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.onetoone.Client;
import model.onetoone.Seat;

public class TestGetClientAndSeat extends TestCase {

    private static boolean isSuccessGetClientAndSet = false;

    public static void main(String[] args) {
        startTestClient();
    }

    public static void startTestClient() {
        System.out.println("TestGetClientAndSeat - startTestClient(): BEGIN");
        try {
            DataAccessObject<Client> clientDataAccess = new DataAccessObject<>(Client.class);
            try {
                Client storageClient = clientDataAccess.getStorageItemById(1L);
                final String storageSeatName = storageClient.getSeat().getName();
                System.out.println("TestGetClientAndSeat - startTestClient() - Storage Seat Name: " + storageSeatName);
                isSuccessGetClientAndSet = (storageSeatName.isEmpty() == false);
            } catch (Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessGetClientAndSet);
                clientDataAccess.closeTransactionalDAO();
                System.out.println("TestGetClientAndSeat - startTestClient(): Query performed successfully.");
                System.out.println("TestGetClientAndSeat - startTestClient(): END");
            }
        } catch (RuntimeException connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }

    public static void startTestSeat() {
        System.out.println("TestGetClientAndSeat - startTestSeat(): BEGIN");
        try {
            DataAccessObject<Seat> seatDataAccess = new DataAccessObject<>(Seat.class);
            try {
                Seat storageClient = seatDataAccess.getStorageItemById(1L);
                final String storageClientName = storageClient.getClient().getName();
                System.out.println("TestGetClientAndSeat - startTestSeat() - Storage Client Name: " + storageClientName);
                isSuccessGetClientAndSet = (storageClientName.isEmpty() == false);
            } catch (Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessGetClientAndSet);
                seatDataAccess.closeTransactionalDAO();
                System.out.println("TestGetClientAndSeat - startTestSeat(): Query performed successfully.");
                System.out.println("TestGetClientAndSeat - startTestSeat(): END");
            }
        } catch (RuntimeException connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
