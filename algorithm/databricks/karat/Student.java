package algorithm.databricks.karat;

import javafx.util.Pair;

import java.util.*;

public class Student {
    public List<String> find(List<Pair<String,String>> list){
        if(list.size()==0)
            return new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        Set<String> res=new HashSet<>();
        for(Pair<String,String> p:list){
            if(map.containsKey(p.getValue())){
                res.add(p.getValue());
            }
            map.put(p.getValue(),1);
        }
        return new ArrayList<>(res);
    }

    public List<String> find2(List<Pair<String,String>> list){
        Map<String,List<String>> adj=new HashMap<>();
        Set<String> startPoint=new HashSet<>();
        Map<String,Integer> countInDegree=new HashMap<>();
        for(Pair<String,String> p:list){
            countInDegree.put(p.getKey(),countInDegree.getOrDefault(p.getKey(),0)+1);
            countInDegree.put(p.getValue(),countInDegree.getOrDefault(p.getValue(),0));
            if(!adj.containsKey(p.getValue()))
                adj.put(p.getValue(),new ArrayList<>());
            adj.get(p.getValue()).add(p.getKey());
        }
        for(Map.Entry<String,Integer> e:countInDegree.entrySet()){
            if(e.getValue()==0)
                startPoint.add(e.getKey());
        }
        Set<String> res=new HashSet<>();
        for(String s:startPoint){
            dfs(s,adj,new ArrayList<>(),res);
        }
        return new ArrayList<>(res);
    }

    public void dfs(String s, Map<String,List<String>> map, List<String> path, Set<String> res){
        path.add(s);
        if(!map.containsKey(s)){
            res.add(path.get((path.size()-1)/2));
            path.remove(path.size()-1);
            return;
        }
        List<String> next=map.get(s);
        for(String x:next){
            dfs(x,map,path,res);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[]args){
        Student s=new Student();
        List<Pair<String,String>> input=new ArrayList<>();
        input.add(new Pair<>("3","1"));
        input.add(new Pair<>("3","2"));
        input.add(new Pair<>("5","3"));
        input.add(new Pair<>("4","3"));
        input.add(new Pair<>("6","5"));
        input.add(new Pair<>("6","4"));
        input.add(new Pair<>("7","6"));
        input.add(new Pair<>("8","6"));
        input.add(new Pair<>("9","6"));
        input.add(new Pair<>("10","8"));
        input.add(new Pair<>("11","10"));
        input.add(new Pair<>("12","10"));
        input.add(new Pair<>("13","12"));
        List<String> list=s.find2(input);
        System.out.println(Arrays.toString(list.toArray()));

        List<Pair<String,String>> course=new ArrayList<>();
        course.add(new Pair<>("A","a"));
        course.add(new Pair<>("B","a"));
        course.add(new Pair<>("B","b"));
        course.add(new Pair<>("B","c"));
        course.add(new Pair<>("C","c"));
        course.add(new Pair<>("C","a"));
        List<String> l=s.find(course);
        System.out.println(Arrays.toString(l.toArray()));
    }
}
