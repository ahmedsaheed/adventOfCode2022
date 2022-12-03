
import java.util.stream.*;
import java.io.*;
import java.util.*;

class day03{
    
    
    static Map<String, int[]> map = new HashMap<>();
        static {
            map.put("a", new int[] {1,27} );
            map.put("b", new int[] {2,28} );
            map.put("c", new int[] {3,29} );
            map.put("d", new int[] {4,30} );
            map.put("e", new int[] {5,31} );
            map.put("f", new int[] {6,32} );
            map.put("g", new int[] {7,33} );
            map.put("h", new int[] {8,34} );
            map.put("i", new int[] {9,35} );
            map.put("j", new int[] {10,36} );
            map.put("k", new int[] {11,37} );
            map.put("l", new int[] {12,38} );
            map.put("m", new int[] {13,39} );
            map.put("n", new int[] {14,40} );
            map.put("o", new int[] {15,41} );
            map.put("p", new int[] {16,42} );
            map.put("q", new int[] {17,43} );
            map.put("r", new int[] {18,44} );
            map.put("s", new int[] {19,45} );
            map.put("t", new int[] {20,46} );
            map.put("u", new int[] {21,47} );
            map.put("v", new int[] {22,48} );
            map.put("w", new int[] {23,49} );
            map.put("x", new int[] {24,50} );
            map.put("y", new int[] {25,51} );
            map.put("z", new int[] {26,52} );
        }
    static ArrayList<String> readData(String filename) throws IOException{
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Stream<String> lines = br.lines();
        lines.forEach(list::add);
        return list;
    }

    static String splitter(String s){
        final int mid = s.length() / 2; 
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

    static int sumup(String s){
        boolean isUpperCase = Character.isUpperCase(s.charAt(0));
        return isUpperCase ? map.get(s.toLowerCase())[1] : map.get(s.toLowerCase())[0];
    }

    static int doJob(ArrayList<String> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            String value = splitter(list.get(i));
            sum += sumup(value);
        }

        return sum;
    }



    public static void main(String[] args){ 
        try{
            System.out.println(doJob(readData("day03")));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    }
