package Solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2877 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if(num<7) {
			switch(num) {
				case 1: System.out.println("4");
						break;
				case 2: System.out.println("7");
						break;
				case 3: System.out.println("44");
						break;
				case 4: System.out.println("47");
						break;
				case 5: System.out.println("74");
						break;
				case 6: System.out.println("77");
						break;
			}
		}else {
			int zeros = 3;
			int limit = 7;
			
			while(num >= (limit*2)+1) {
				limit = limit*2+1;
				zeros++;
			}
			
			System.out.println("limit: " + limit);
			System.out.println("zeros: " + zeros);
			
			String res = Integer.toBinaryString(num-limit);
			System.out.println("res: " + res);
			
			if(limit == num) {
				res = "";
				for(int i = 0; i<zeros; i++) {
					res+="4";
				}
				System.out.println(res);
			
			}else {
				String tmp = "";
				for(int i=0; i<zeros-res.length();i++) {
					tmp += "4";
				}
				System.out.println("res2: " + res);
				res = res.replace('0', '4');
				res = res.replace('1', '7');
				System.out.println(tmp + res);
			}
		}
		
	}
}
