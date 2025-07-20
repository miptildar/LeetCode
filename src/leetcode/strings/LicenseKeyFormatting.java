package leetcode.strings;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        s = s.replace("-", "");
        int fullParts = s.length() / k;
        int firstPartLength = s.length() - fullParts * k;

        int startIndex = 0;
        int endIndex = 0;

        if (firstPartLength > 0) {
            endIndex = firstPartLength;
            sb.append(s, startIndex, endIndex);

            if (fullParts > 0) sb.append("-");
        }

        int counter = 1;
        while (counter <= fullParts) {

            startIndex = endIndex;
            endIndex = startIndex + k;
            sb.append(s, startIndex, endIndex);

            if (counter != fullParts) sb.append("-");

            counter++;
        }

        return sb.toString().toUpperCase();
    }

}
