package perceptron;

public class Perceptron_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double nu[] = {0.35, 0.2};
		Perceptron_lib plib = new Perceptron_lib(2, nu, 0.01, 0.5);
		
		//学習データ
		double input[][] = {{1,1}, {1,0}, {0,1}, {0,0}};
		double output[] = {1, 0, 0, 0};
		
		//学習
		int index, count=0;
		double px = nu[0], py = nu[1];
		for(int i = 0; i < 150; i++){
			index = (int)(Math.random()*4);
			plib.getParameter(input[index], output[index]);
			
			if(px == nu[0] || py == nu[1]) {
				count = count + 1;
			}
			else {
				count = 0;
			}

			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
			
			if(count >= 10){
				break;      //もしもx,yの値が10回変化しなかった場合
			}				//学習の決められたループをbreakで抜けて結果を出すようにしました。
		}
		
		for(int i = 0; i < output.length; i++) {
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+", "+input[i][1]+") to output("+output[i]+")");
			else System.out.println("Miss! : input("+input[i][0]+", "+input[i][1]+") to output("+output[i]+")");
		}
		
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);

	}

}
