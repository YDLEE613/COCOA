package Solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int up = -2;
		int down = 2;
		int left = -1;
		int right = 1;
		boolean valid = true;
		int numKnights = 0;
		char[][] base = new char[5][5];

		for (int i = 0; i < base.length; i++) {
			String each = br.readLine();

			for (int j = 0; j < base[i].length; j++) {

				base[i][j] = each.charAt(j);
				
				if(base[i][j] == 'k') {
					numKnights++;
				}
				if (i >= 2 && j >= 1) {// up left
					if (base[i+up][j+left] == 'k' && base[i][j]=='k') {
						valid = false;
						//System.out.println("val at base "+i+","+ j+":" +base[i][j]);
						//System.out.println("val at base ["+(i+up)+"]["+(j+left)+"]: " + base[i+up][j+left]);
						break;
					}
				}

				if (i >= 2 && j + right < base[i].length) {// up right
					if(base[i+up][j+right] == 'k'&& base[i][j]=='k') {
						valid = false;
						//System.out.println("val at base "+i+","+ j+":" +base[i][j]);
						//System.out.println("val at base ["+(i+up)+"]["+(j+right)+"]: " + base[i+up][j+right]);
						break;
					}
				}
				
				if(i+down <base.length && j>=1) {//down left
					if(base[i+down][j+left] == 'k'&& base[i][j]=='k') {
						valid = false;
						//System.out.println("val at base "+i+","+ j+":" +base[i][j]);
						//System.out.println("val at base ["+(i+down)+"]["+(j+left)+"]: " + base[i+down][j+left]);
						break;
					}
				}
				
				if(i+down<base.length && j+right<base[i].length) {
					if(base[i+down][j+right] == 'k'&& base[i][j]=='k') {
						valid = false;
						//System.out.println("val at base "+i+","+ j+":" +base[i][j]);
						//System.out.println("val at base ["+(i+down)+"]["+(j+right)+"]: " + base[i+down][j+right]);
						break;
					}
				}

			}
		}
		
		if(valid) {
			if(numKnights != 9) {
				bw.write("invalid");
			}else {
				bw.write("valid");
			}
		}else {
			bw.write("invalid");
		}
		bw.flush();
		

	}
}
