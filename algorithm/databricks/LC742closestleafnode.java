package algorithm.databricks;

import java.util.*;

public class LC742closestleafnode {
	public int find(Node root, int k) {
		Map<Node, List<Node>> map=new HashMap<>();
		if(root==null)
			return -1;
		Stack<Node> s=new Stack<>();
		s.push(root);
		Node start=null;
		while(!s.empty()) {
			Node temp=s.pop();
			if(temp.val==k)
				start=temp;
			if(!map.containsKey(temp))
				map.put(temp,new ArrayList<>());
			if(!map.containsKey(temp.left))
				map.put(temp.left,new ArrayList<>());
			if(!map.containsKey(temp.right))
				map.put(temp.right,new ArrayList<>());
			if(temp.left!=null) {
				s.push(temp.left);
				map.get(temp).add(temp.left);
				map.get(temp.left).add(temp);
			}
			if(temp.right!=null) {
				s.push(temp.right);
				map.get(temp).add(temp.right);
				map.get(temp.right).add(temp);
			}
		}
		Set<Node> set=new HashSet<>();
		Queue<Node> q=new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			if(temp.left==null&&temp.right==null)
				return temp.val;
			set.add(temp);
			if(map.containsKey(temp)) {
				for(Node n:map.get(temp)) {
					if(!set.contains(n))
					q.offer(n);
				}
			}
		}
		return -1;
	}
}
