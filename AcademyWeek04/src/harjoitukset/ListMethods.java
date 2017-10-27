package harjoitukset;

import java.text.Collator;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

class ListMethods {
    
    private List<Character> list;

    private char get(int i) {
        return list.get(i);
    }
    
    private int indexOf (char c) {
        return list.indexOf(Character.toUpperCase(c));
    }
        
    static void combine(ListMethods list1, ListMethods list2) {
        for (int i = 0; i < list2.getSize(); i++) {
            char c = list2.get(i);
            if (list1.indexOf(c) == -1) {
                list1.add(c);
            }
        }
    }

    public void init() {
        list = new LinkedList<>();
    }

    void initAlph() {        
        list = new LinkedList<>();
                
        for (char a = 'A'; a <= 'Z'; a++) {
            list.add(a);
        }
    }
    
    void initFull() {
        list = new LinkedList<>();
                
        for (char a = 'A'; a <= 'Z'; a++) {
            list.add(a);
        }
        
        list.add('Å');
        list.add('Ä');
        list.add('Ö');
        
    }

    public int getSize() {
        return list.size();
    }

    public int placement(String m) {
        char [] c = m.toCharArray();
        return this.placement(c[0]);
    }
    
    public int placement (char c) {
        return list.indexOf(Character.toUpperCase(c));
    }

    void add (char c) {
        list.add(c);
    }
    
    void addAlph(String a, String before, char b) {
        char [] achar = a.toCharArray();
        this.addAlph(achar[0], before, b);
    }

    void addAlph(String a, String before, String b) {
        char [] achar = a.toCharArray();
        char [] bchar = b.toCharArray();
        this.addAlph(achar[0], before, bchar[0]);
    }

    void addAlph(char a, String before, String b) {
        char [] bchar = b.toCharArray();
        this.addAlph(a, before, bchar[0]);
    }

    void addAlph(char a, String when, char b) {
        int index = list.indexOf(Character.toUpperCase(b));
                
        char toAdd = Character.toUpperCase(a);
        
        if (index == -1) {
            System.out.println("Could not find the char on the list. Adding to the end.");
            list.add(toAdd);
            return;
        }
        
        switch (when) {
            case "before":
                list.add(index, toAdd);
                break;
            case "after":
                list.add(index + 1, toAdd);
                break;
            case "replace":
                list.remove(index);
                list.add(index, toAdd);
            default:
                System.out.println("Could not add char " + a 
                        + " without placement ('before' / 'after' / 'replace').");
        }
        
    }

    public String print() {
        String print = "";
        
        for (char c : list) {
            print += c;
        }
        
        return print; 
    }

    void order() {
        Collections.sort(list);
    }

    void collatorOrder() {
        
        // TODO Collator, ei hyväksy char:eja, Stringejä
        // kopiointi toiseen String-listaan foreachilla?
        
        Locale fi = new Locale("fi", "FI");
        Collator fiCollator = Collator.getInstance(fi);
        Collections.sort
        Collections.sort(list, fiCollator);
    }

    void removeAe() {
        
        List<Character> aeList = new LinkedList<>();
        
        aeList.add('A');
        aeList.add('E');
        aeList.add('I');
        aeList.add('O');
        aeList.add('U');
        aeList.add('Y');
        aeList.add('Å');
        aeList.add('Ä');
        aeList.add('Ö');
        
        for (Iterator<Character> i = list.iterator(); i.hasNext();) {
            char c = i.next();
            if (aeList.contains(c)) {
                i.remove();
            }
        }
    }

    public void scramble() {
        Collections.shuffle(list);
    }

}
