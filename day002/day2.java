import java.util.stream.*;
import java.io.*;
import java.util.*;

public class day2 {
    static int total = 0;
    public record Game (String name, int point) {}
    static Map<String, Game> map = new HashMap<>();
        static {
            map.put("A", new Game("Rock", 1));
            map.put("B", new Game("Paper", 2));
            map.put("C", new Game("Scissors", 3));
            //=====================
            map.put("X",  new Game("Rock", 1));
            map.put("Y",  new Game("Paper", 2));
            map.put("Z",  new Game("Scissors", 3));
        }

    static ArrayList<String> readData(String filename) throws IOException{
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Stream<String> lines = br.lines();
        lines.forEach(list::add);
        return list;
    }
    static int gamePlay() throws IOException{
            try{
                readData("day2").forEach((game) -> {
                    String[] player = game.split(" ");
                    total += outcome(player[0],player[1]);
                });
            }catch (IOException e){
                System.err.print(e);
                }
            return total;

  }
    /*
    Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
    If both players choose the same shape, the round instead ends in a draw.
     */
    static int outcome(String opp, String me){
        if (map.get(me).name.equals(map.get(opp).name)){
           return map.get(me).point + 3;
        }
        if (map.get(opp).name.equals("Rock") && map.get(me).name.equals("Scissors")){
            return map.get(me).point + 0;
        }else if(map.get(opp).name.equals("Scissors") && map.get(me).name.equals("Rock")){
            return map.get(me).point + 6;
        }else{
            if (map.get(opp).name.equals("Scissors") && map.get(me).name.equals("Paper")){
                return map.get(me).point + 0;
            } else if(map.get(opp).name.equals("Scissors") && map.get(me).name.equals("Rock")){
                return map.get(me).point + 6;
            }else{
                if (map.get(opp).name.equals("Paper") && map.get(me).name.equals("Rock")){
                    return map.get(me).point + 0;
                }else{
                    return map.get(me).point + 6;
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            System.out.println(gamePlay());
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
