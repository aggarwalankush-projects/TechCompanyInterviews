package Lytmus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

public class SuspiciousIP {
    /**
     * Returns an array of IP addresses that are deemed suspicious.
     * <p>
     * This method declaration must be kept unmodified.
     *
     * @param logPath The full path of a log file. * This is the file with your
     *                answer, do not rename or move it.
     * @return An array of IP addresses.
     */
    public static String[] findSuspiciousIps(String logPath) {


        HashMap<String, Integer> ipToCount = new HashMap<>();
        if (logPath == null || logPath.trim().length() == 0)
            return null;
        try (BufferedReader br = new BufferedReader(new FileReader(logPath))) {
            String logLine;
            while ((logLine = br.readLine()) != null) {
                String[] log_content = logLine.split(" ");
                String ip = log_content[0];
                String page = log_content[6];
                int response = Integer.parseInt(log_content[8]);
                if (!page.equalsIgnoreCase("/account/information") || response <= 400 || response >= 499)
                    continue;
                if (ipToCount.containsKey(ip)) {
                    ipToCount.put(ip, ipToCount.get(ip) + 1);
                } else {
                    ipToCount.put(ip, 1);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new String[]{};
        }

        HashSet<String> set = new HashSet<>();
        for (String s : ipToCount.keySet()) {
            if (ipToCount.get(s) >= 3)
                set.add(s);
        }

        return set.toArray(new String[set.size()]);
    }

    /**
     * Tests the method abbreviate with the examples given in the question. This
     * test code is provided only for your convenience.
     */
    public static void main(String[] args) {
        System.out.println("example.log:");
        for (String ip : findSuspiciousIps("./src/Lytmus/example.log")) {
            System.out.println(ip);
        }
        System.out.println("bank_logs.log:");
        for (String ip : findSuspiciousIps("./src/Lytmus/bank_logs.log")) {
            System.out.println(ip);
        }
    }
}