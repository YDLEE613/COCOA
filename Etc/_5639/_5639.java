import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _5639 {
	
	class Node {
		int value = 0;
		Node left = null;
		Node right = null;
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	static Node root;

	public _5639() {
		root = null;
	}
	
	void add(int value) {
		root = addRecursive(root, value);
	}

	public Node addRecursive(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}else {
			if (value < root.value) {
				root.left = addRecursive(root.left, value);
			} else if (value > root.value) {
				root.right = addRecursive(root.right, value);
			}
		}
		
		return root;
	}

	public static void postOrder() {
		postOrder(root);
	}
	
	public static void postOrder(Node root) {
		if(root !=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		_5639 root = new _5639();
		
		while (sc.hasNextLine()) {
			String eachLine = sc.nextLine();
			if (eachLine.isEmpty()) {
				break;
			}else {
				int eachNum = Integer.parseInt(eachLine);
				root.add(eachNum);
			}
		}
		postOrder();
	}
}


