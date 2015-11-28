package Lytmus;

public class SocketAddress {
    /**
     * Determine if the provided string is a valid socket address.
     * <p>
     * This method declaration must be kept unmodified.
     *
     * @param socketAddress A string with a socket address, eg, '127.12.23.43:5000', to be
     *                      checked for validity.
     * @return boolean indicating wether the provided string is a valid socket
     * address
     */
    public static boolean isValidSocketAddress(String socketAddress) {
        String[] ip_port = socketAddress.split(":");
        if (ip_port.length != 2)
            return false;
        String ip = ip_port[0];
        String port = ip_port[1];
        try {
            if (port.contains(".")) {
                return false;
            }
            int port_num = Integer.parseInt(port);
            if (port_num < 1 || port_num > 65535)
                return false;
        } catch (Exception e) {
            return false;
        }

        String[] ip_units = ip.split("\\.");
        if (ip_units.length != 4)
            return false;
        try {
            for (String eachIp : ip_units) {
                int ip_num = Integer.parseInt(eachIp);
                if (ip_num < 0 || ip_num > 255)
                    return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * This tests your code with the examples given in the question, and is
     * provided only for your conveinience.
     */
    public static void main(String[] args) {
        String[] addresses = {"127.12.23.43:5.000", "127.A:-12"};
        for (String socketAddress : addresses) {
            System.out.println(isValidSocketAddress(socketAddress));
        }
    }
}
