
import java.util.stream.*;
import java.io.*;
import java.util.*;

class day03{
    static ArrayList<String> readData(String filename) throws IOException{
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Stream<String> lines = br.lines();
        lines.forEach(list::add);
        return list;
    }

    /// PART 1
    static String splitter(String s){
        int mid = s.length() / 2; 
        String[] parts = {s.substring(0, mid),s.substring(mid)};
        String firstPart = parts[0];
        String secondPart = parts[1];
        String dup = "";
        for (int i = 0; i < firstPart.length(); i++){
            for(int j = 0; j < secondPart.length(); j++){
                if( firstPart.charAt(i) == secondPart.charAt(j) ){
                    dup =  s.charAt(i) + "";  
                }
            }
        }

        return dup;
    }

    static int sumup(String ch){
        char cha = Character.toUpperCase(ch.charAt(0));
        boolean isUpperCase = Character.isUpperCase(ch.charAt(0)); 
        return isUpperCase ? (cha - 'A' + 1) + 26: cha - 'A' + 1;
    }

    static int doJob1() throws IOException{
        ArrayList<String> list = readData("day03");
        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            String value = splitter(list.get(i));
            sum += sumup(value);
        }
        return sum;
    }

    /// PART 2
    static ArrayList<String[]> throwEmInGroups() throws IOException{
        ArrayList<String[]> groups = new ArrayList<>();
        ArrayList<String> data = readData("day03");
        for (int i = 0; i < data.size(); i+=3){
            String[] group = {data.get(i), data.get(i+1), data.get(i+2)};
            groups.add(group);
        }
        return groups;
    }
    static String commons(String group){ 
        String cleaned = group.substring(1, group.length() - 1);
        String[] parts = cleaned.split(",");
        String firstPart = parts[0];
        String secondPart = parts[1];
        String thirdPart = parts[2];
        String dup = "";
        for (int i = 0; i < firstPart.length(); i++){
            for(int j = 0; j < secondPart.length(); j++){
                for(int k = 0; k < thirdPart.length(); k++){
                    if( firstPart.charAt(i) == secondPart.charAt(j) && secondPart.charAt(j) == thirdPart.charAt(k) ){
                        dup =  firstPart.charAt(i) + "";  
                    }
                }
            }
        }
        return dup;
    }

    static int doJob2() throws IOException{
        int sum = 0;
        ArrayList<String[]> groups = throwEmInGroups();
        for(int i =0; i < groups.size(); i++){
          sum += sumup(commons(Arrays.toString(groups.get(i))));
        }
        return sum;
    }


    public static void main(String[] args){ 
        try{
            System.out.println(doJob1());
            System.out.println(doJob2());
        }catch(IOException e){
            System.out.println(e);
        }
    }
    }
