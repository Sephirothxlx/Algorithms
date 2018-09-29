package algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public String simplifyPath(String path) {
		String s = "";
		for (int i = 0; i < path.length(); i++) {
			if (i < path.length() - 1) {
				if (path.charAt(i) != '.')
					s += (path.charAt(i) + "");
				else {
					if (i + 1 < path.length() && path.charAt(i + 1) != '/') {
						while (i < path.length() && path.charAt(i) != '/') {
							s += (path.charAt(i) + "");
							i++;
						}
						i--;
					}
				}
			} else {
				if (path.charAt(i) != '.')
					s += (path.charAt(i) + "");
			}
		}
		int tag = 0;
		String ss = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '/') {
				if (tag == 0) {
					ss += (s.charAt(i) + "");
					tag = 1;
				}
			} else {
				ss += (s.charAt(i) + "");
				tag = 0;
			}
		}
		if (ss.length() != 1 && ss.charAt(ss.length() - 1) == '/')
			ss = ss.substring(0, ss.length() - 1);
		String sss[] = ss.split("/");
		if (sss.length == 0)
			return "/";
		List<String> l = new ArrayList<String>();
		if (sss[0].equals("")) {
			sss[0] = "/";
		} else
			l.add("/");
		for (int i = 0; i < sss.length; i++) {
			if (!sss[i].equals("..")) {
				l.add(sss[i]);
			} else {
				if (l.size() > 1)
					l.remove(l.size() - 1);
			}
		}
		if (l.size() == 0 || l.size() == 1)
			return "/";
		String re = "/";
		for (int i = 1; i < l.size(); i++) {
			re += l.get(i);
			if (i != l.size() - 1)
				re += "/";
		}
		return re;
	}

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.simplifyPath("/.hidden"));
	}
}
