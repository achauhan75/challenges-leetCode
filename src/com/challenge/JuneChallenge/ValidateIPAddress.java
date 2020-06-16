package com.challenge.JuneChallenge;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255,
 * separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address
 * to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 */
public class ValidateIPAddress {
    private static final String NEITHER = "Neither";

    public static String validIPAddress(String ip) {
        int len = ip.length();
        if(ip.indexOf('.') > 0 && ip.lastIndexOf('.') < len-1) {
            String[] sa = ip.split("\\.");
            if(sa.length != 4) return NEITHER;
            for(int i = 0; i < 4; i++) {
                if(sa[i].length() > 3 || sa[i].length() < 1
                        || (sa[i].length() != 1 && sa[i].charAt(0) == '0')) {
                    return NEITHER;
                }
                for(char c : sa[i].toCharArray()) {
                    if(!Character.isDigit(c)) return NEITHER;
                }
                if(Integer.parseInt(sa[i]) > 255) return NEITHER;
            }
            return "IPv4";
        } else if(ip.indexOf(':') > 0 && ip.lastIndexOf(':') < len-1){
            String[] sa = ip.split(":");
            if(sa.length != 8) return NEITHER;
            for(int i = 0; i < 8; i++) {
                if(sa[i].length() > 4 || sa[i].length() < 1) {
                    return NEITHER;
                }
                for(char c : sa[i].toCharArray()) {
                    if(!Character.isDigit(c)
                            && ((c < 'a' || c > 'f') && (c < 'A' || c > 'F'))) {
                        return NEITHER;
                    }
                }
                if(Integer.parseInt(sa[i], 16) > 0xFFFF) return NEITHER;
            }
            return "IPv6";
        } else {
            return NEITHER;
        }
    }

    public static void main(String[] args) {
        String ipAddr = "1.1.1.1.";
       System.out.println(validIPAddress(ipAddr));
    }
}
