// medium
class Solution {
    public String validIPAddress(String IP) {

        if (IP == null || IP.isEmpty()) { return "Neither"; }

        if (isValidIPv4(IP)) { return "IPv4"; }
        else if (isValidIPv6(IP)) { return "IPv6"; }

        return "Neither";
    }

    private boolean isValidIPv6(String ip)
    {
        // edge case like "1:1:1:1:1:1:1:1:", last char is ':'
        if (ip.substring(ip.length() - 1).equals(":")) { return false; }
        String[] tokens = ip.split(":");
        if (tokens.length != 8) { return false; }
        for (String t : tokens)
        {
            if (t.length() > 4 || t.length() == 0) { return false; }
            String tp = t.replaceAll("[0-9a-fA-F]", "");
            if (!tp.isEmpty()) { return false; }
        }
        return true;
    }

    private boolean isValidIPv4(String ip)
    {
        // edge case liks "192.168.1.26."
        if (ip.substring(ip.length() - 1).equals(".")) { return false; }
        // in java regex \\ means black slash
        // use \\. to escape .
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) { return false; }
        for (String t : tokens)
        {
            // leading zero
            if (t.length() > 1 && t.charAt(0) == '0') { return false; }
            // minus sign, e.g "-0"
            if (!t.isEmpty() && t.charAt(0) == '-') { return false; }
            try
            {
                int part = Integer.parseInt(t);
                // out of range
                if (part > 255 || part < 0) { return false; }
            }
            catch (NumberFormatException e) { return false; }
        }
        return true;
    }
}
