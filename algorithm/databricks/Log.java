package algorithm.databricks;

import javafx.util.Pair;

import java.util.*;

public class Log {
    public List<List<String>> find(List<Pair<String,String>> list){
        Set<String> exitOnly=new HashSet<>();
        Set<String> enterOnly=new HashSet<>();
        HashMap<String,Integer> map=new HashMap<>();
        for(Pair<String,String> p:list){
            if(map.containsKey(p.getKey())){
                if(p.getValue().equals("exit")){
                    if(map.get(p.getKey())==1){
                        map.put(p.getKey(),0);
                    }else{
                        exitOnly.add(p.getKey());
                        map.put(p.getKey(),-1);
                    }
                }else{
                    if(map.get(p.getKey())==0){
                        map.put(p.getKey(),1);
                    }else{
                        enterOnly.add(p.getKey());
                    }
                }
            }else{
                if(p.getValue().equals("exit")){
                    exitOnly.add(p.getKey());
                    map.put(p.getKey(),-1);
                }else{
                    map.put(p.getKey(),1);
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        res.add(new ArrayList<>(enterOnly));
        res.add(new ArrayList<>(exitOnly));
        return res;
    }

    public List<Pair<String,List<Integer>>> followup1(List<Pair<String,List<Integer>>> list){
        if(list==null||list.size()==0)
            return list;
        List<Pair<String,List<Integer>>> res=new ArrayList<>();
        for(Pair<String,List<Integer>> p:list){
            String name=p.getKey();
            List<Integer> l=p.getValue();
            List<Integer> ll=new ArrayList<>();
            for(int i=0;i<l.size();){
                if(i+2>=l.size())
                    break;
                int a=l.get(i);
                int b=l.get(i+2);
                if(check(a,b)){
                    ll.add(l.get(i));
                    ll.add(l.get(i+1));
                    ll.add(l.get(i+2));
                    i+=3;
                }else{
                    i++;
                }
            }
        }
        return res;
    }

    public boolean check(int a, int b){
        String temp1=a+"";
        String temp2=b+"";
        int min1=Integer.parseInt(temp1.substring(0,temp1.length()-2))*60+Integer.parseInt(temp1.substring(temp1.length()-2));
        int min2=Integer.parseInt(temp2.substring(0,temp1.length()-2))*60+Integer.parseInt(temp2.substring(temp2.length()-2));
        return min2-min1<=60;
    }

    public static void main(String[]args){
        Log l=new Log();

    }
}
