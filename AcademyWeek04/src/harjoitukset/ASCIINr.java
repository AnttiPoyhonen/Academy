package harjoitukset;

public class ASCIINr {

    private String[] nr0 = {
        "000000",
        "00  00",
        "00  00",
        "00  00",
        "000000"
    };

    private String[] nr1 = {
        "1111  ",
        "  11  ",
        "  11  ",
        "  11  ",
        "111111"
    };

    private String[] nr2 = {
        "222222",
        "     2",
        "222222",
        "2     ",
        "222222"
    };

    private String[] nr3 = {
        "333333",
        "    33",
        "333333",
        "    33",
        "333333"
    };

    private String[] nr4 = {
        "44  44",
        "44  44",
        "444444",
        "    44",
        "    44"
    };

    private String[] nr5 = {
        "555555",
        "55    ",
        "555555",
        "    55",
        "555555"
    };

    private String[] nr6 = {
        "666666",
        "66    ",
        "666666",
        "66  66",
        "666666"
    };

    private String[] nr7 = {
        "777777",
        "    77",
        "    77",
        "    77",
        "    77"
    };

    private String[] nr8 = {
        "888888",
        "88  88",
        "888888",
        "88  88",
        "888888"
    };

    private String[] nr9 = {
        "999999",
        "99  99",
        "999999",
        "    99",
        "999999"
    };
    
    private String number;
    private char[] numbers;
    private StringBuilder print = new StringBuilder();

    public void printNumber(Long inputnr) {
        String nr = String.valueOf(inputnr);
        this.printNumber(nr);
    }
    
    public void printNumber(int inputnr) {
        String nr = String.valueOf(inputnr);
        this.printNumber(nr);
    }
    
    public void printNumber(String inputnumber) {

        number = inputnumber.replaceAll("[^0-9]", "");
        
        numbers = number.toCharArray();
        
        appendToPrint();
        
        System.out.println(print.toString());
        
        // empty print for future input
        print.delete(0, print.length() - 1);

    }

    private void appendToPrint() {
        
        // printing rows of the numbers row at a time (5 rows in each number)
        for (int i = 0; i < 5; i++) {
            
            // looping through the numbers for each row
            for (char c : numbers) {
                
                String row = "";
                
                switch(c) {
                    case '0':
                        row = nr0[i];
                        break;
                    case '1':
                        row = nr1[i];
                        break;
                    case '2':
                        row = nr2[i];
                        break;
                    case '3':
                        row = nr3[i];
                        break;
                    case '4':
                        row = nr4[i];
                        break;
                    case '5':
                        row = nr5[i];
                        break;
                    case '6':
                        row = nr6[i];
                        break;
                    case '7':
                        row = nr7[i];
                        break;
                    case '8':
                        row = nr8[i];
                        break;
                    case '9':
                        row = nr9[i];
                        break;
                    default:;
                }
                
                print.append(row).append("  ");
            }
            
            // appending a line break before adding text from next number row
            print.append("\n");

        }
    }

}

/* ASCII NUMBERS
        
000000
00  00
00  00
00  00
000000

1111
  11
  11
  11
111111

222222
     2
222222
2
222222

333333
    33
333333
    33
333333

44  44
44  44
444444
    44
    44

555555
55
555555
    55
555555

666666
66
666666
66  66
666666

777777
    77
    77
    77
    77

888888
88  88
888888
88  88
888888

999999
99  99
999999
    99
999999
        
*/
