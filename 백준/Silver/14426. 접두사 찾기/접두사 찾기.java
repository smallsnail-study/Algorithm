import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static class Node {
		int[] child;
		
		Node() {
			child = new int[26];
			for(int i = 0; i < 26; i++) {
				child[i] = -1;
			}
		}
	}
	
	static List<Node> list = new ArrayList<>();
	
	static class Trie {
		int init() {
			list.add(new Node());
			return list.size()-1;
		}
		
		void add(int idx, String str, int depth) {
			if(str.length() == depth) // �߰� �Ϸ�
				return;
			
			int ch = str.charAt(depth) - 'a';
			
			if(list.get(idx).child[ch] == -1) {
				list.get(idx).child[ch] = init();
			}
			
			add(list.get(idx).child[ch], str, depth+1);
		}
		
		boolean search(int idx, String str, int depth) {
			if(idx == -1) // ���ĺ��� �������� ����
				return false;
			
			if(str.length() == depth) // Ž�� �Ϸ�
				return true;
			
			int ch = str.charAt(depth) - 'a';
			
			return search(list.get(idx).child[ch], str, depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		
		Trie trie = new Trie();
		trie.init();
		int ans = 0;
		
		while(n-- > 0) {
			trie.add(0, br.readLine(), 0);
		}
		
		while(m-- > 0) { 
			if(trie.search(0, br.readLine(), 0)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}