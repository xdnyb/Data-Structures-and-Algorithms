import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		int root;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		


		int computeHeight() {
			ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0;i<n;i++){
			nodes.add(i,new ArrayList<>());
		}

		for (int c = 0;c<n;c++){
			int p = parent[c];
			if (p ==-1){
				root = c;
				continue;
			}
			nodes.get(p).add(c);
		}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(root);
			int level = 0;
			while(!queue.isEmpty()){
				level++;
				int size = queue.size();
				
				
				for (int i =0;i<size;i++){
					if (!queue.isEmpty()){
						int key = queue.poll();
					
						if (nodes.get(key).size()!=0){
							queue.addAll(nodes.get(key));
						}
					}
					
				}

				
			}
			return level;

                        // Replace this code with a faster implementation
			/**
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
			**/
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
