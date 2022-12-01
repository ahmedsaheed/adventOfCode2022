import java.util.stream.*;
import java.io.*;
import java.util.*;
class day01{
       /// TERRIBLE CODE !!! 
    public Stream<String> readInput(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Stream<String> lines = br.lines();
        return lines;
    }

    public ArrayList<Integer> part1(Stream<String> lines){
        ArrayList<String> list = new ArrayList<String>();
        lines.forEach(list::add);
        ArrayList<Integer> newLineLocation = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("")){
                newLineLocation.add(i+1);
            }
        }
        int index = 0;
        int sum = 0;
        int iteration = 0;
        int breakPoint = newLineLocation.get(0);
        int summer = 0;
        int au = 0;
        
        ArrayList<Integer> sumOfEveryElf = new ArrayList<Integer>();
        for (int i = newLineLocation.get(newLineLocation.size() - 1)  ; i < list.size(); i++){
           summer += Integer.parseInt(list.get(i));
        }
        sumOfEveryElf.add(summer);
        for (int i = newLineLocation.get(newLineLocation.size() - 2)  ; i < newLineLocation.get(newLineLocation.size() - 1)-1; i++){
           au += Integer.parseInt(list.get(i));
        }
        sumOfEveryElf.add(au);
        while(index != list.size()){
             for (int j=index; j < breakPoint - 1; j++){
                    sum += Integer.parseInt(list.get(j));
             }
            sumOfEveryElf.add(sum);
            sum = 0;
             iteration+=1;
             index = breakPoint;

            breakPoint = iteration == newLineLocation.size()+1 ? 300 :  newLineLocation.get(iteration);
            if (breakPoint == newLineLocation.get(newLineLocation.size() - 1)){

                break;
            }
        }
        return sumOfEveryElf;
    }

    public int getTopThreeElvs(ArrayList<Integer> list){
       
        Collections.sort(list);
        return list.get(list.size()-1) + list.get(list.size() -2 ) +list.get(list.size() -3);  
    }
    public static void main(String[] args){
        day01 d = new day01();
        try{
            System.out.println(d.part1(d.readInput("day01")));
            System.out.println(d.getTopThreeElvs(d.part1(d.readInput("day01"))));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
