package harjoitukset;

class RGB {

    public String toRGB(String s) {
        
        String hex = "";
                        
        if (s.charAt(0) == '#') {
            hex = s.substring(1);
        }
        
        if (hex.length() < 3 || hex.length() > 6) return "Not a valid hex!";
        
        int a = 0, b = 0, c = 0;
        
        if(hex.length() == 6) {
            a = Integer.parseInt(hex.substring(0,2), 16);
            b = Integer.parseInt(hex.substring(2,4), 16);
            c = Integer.parseInt(hex.substring(4), 16);
        } else if (hex.length() == 3) {
            a = Integer.parseInt(hex.substring(0,1), 16);
            b = Integer.parseInt(hex.substring(1,2), 16);
            c = Integer.parseInt(hex.substring(2), 16);
        } else System.out.println("Please input the hex number in format of either " 
                                    + "#fff or #ffffff! (with or without '#')");
        
        return "rgb(" + a + ", " + b + ", " + c + ")";
        
    }

    public String toHex(int r, int g, int b) {
        
        return "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        
    }

}
