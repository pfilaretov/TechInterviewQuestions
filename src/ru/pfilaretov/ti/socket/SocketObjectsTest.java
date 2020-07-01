package ru.pfilaretov.ti.socket;

import java.io.IOException;
import java.net.Socket;

/**
 *
 */
public class SocketObjectsTest {
    private Socket socket;

    public void run() throws IOException
    {
        socket = getSocket();
        if (socket != null)
        {
            socket.close();
        }

    }

    public Socket getSocket() throws IOException
    {
        Socket newSocket = null;
        try
        {
            newSocket = new Socket("localhost", 50018);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (newSocket != null) {
                newSocket.close();
            }
        }

        return newSocket;
    }

    public static void main(String[] args) throws IOException
    {
        SocketObjectsTest test = new SocketObjectsTest();
        while (true) {
            test.run();
        }
    }
}
