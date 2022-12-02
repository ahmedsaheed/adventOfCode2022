import java.util.stream.*;
import java.io.*;
import java.util.*;
class day01{
       /// TERRIBLE CODE !!! 
    public static Stream<String> readInput(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Stream<String> lines = br.lines();
        return lines;
    }

    public static ArrayList<Integer> part1(Stream<String> lines){
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> newLineLocation = new ArrayList<Integer>();
        ArrayList<Integer> sumOfEveryElf = new ArrayList<Integer>();
        lines.forEach(list::add);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("")){
                newLineLocation.add(i+1);
            }
        }
        int index = 0;
        int sum = 0;
        int iteration = 0;
        int breakPoint = newLineLocation.get(0);
        while(index != list.size()){
            for (int j=index; j < breakPoint - 1; j++){
                    sum += Integer.parseInt(list.get(j));
             }
            sumOfEveryElf.add(sum);
            sum = 0;
            iteration+=1;
            index = breakPoint;
            breakPoint = newLineLocation.get(iteration);
            if (breakPoint == newLineLocation.get(newLineLocation.size() - 1)){
                for (int i = newLineLocation.get(newLineLocation.size() - 1)  ; i < list.size(); i++){
                    sum += Integer.parseInt(list.get(i));
                 }
                sumOfEveryElf.add(sum);
                sum = 0;
                for (int i = newLineLocation.get(newLineLocation.size() - 2)  ; i < newLineLocation.get(newLineLocation.size() - 1)-1; i++){
                    sum += Integer.parseInt(list.get(i));
                }
                sumOfEveryElf.add(sum);
                break;
            }
        }
        return sumOfEveryElf;
    }
    public static int getTopThreeElvs(ArrayList<Integer> list){
        Collections.sort(list);
        return list.get(list.size()-1) + list.get(list.size() -2) +list.get(list.size() -3);
    }

    public static void main(String[] args){
        try{
            System.out.println("DAY 1, PART 1 "+part1(readInput("day01")));
            System.out.println("DAY 1, PART 2 " + getTopThreeElvs(part1(readInput("day01"))));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
