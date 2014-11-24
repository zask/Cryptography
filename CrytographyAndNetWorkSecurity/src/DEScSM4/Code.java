package DEScSM4;



public class Code {
	private int left[]=new int[16];
	private int right[]=new int[16];
	private int key[]=new int[16];
	private int keyA[][]=new int[16][16];	
	public Code(String simple,String k){
		//把simple分成left和right并转为int[]   complete
		char c[] = simple.toCharArray();//转成ascii码
		char s[] = k.toCharArray();
        
        for(int i=0;i<16;i++){
        	if(c[i]>='0'&&c[i]<='9'){
        		left[i]=c[i]-'0';
        	}
        	else{
        		left[i]=c[i]-'a'+10;
        	}
        }
        
        for(int i=16;i<32;i++){
        	if(c[i]>='0'&&c[i]<='9'){
        		right[i-16]=c[i]-'0';
        	}
        	else{
        		right[i-16]=c[i]-'a'+10;
        	}
        }
 
		//把key转为int[]赋值给this.key   
        for(int i=0;i<16;i++){
        	if(s[i]>='0'&&s[i]<='9'){
        		key[i]=s[i]-'0';
        	}
        	else{
        		key[i]=s[i]-'a'+10;
        	}
        }
        getNextKey();//建立对象时直接得到16个roundKey
	}  
    
    public int[] getLeft() {
		return left;
	}

	public void setLeft(int[] left) {
		this.left = left;
	}

	public int[] getRight() {
		return right;
	}

	public void setRight(int[] right) {
		this.right = right;
	}

	//F Function---先直接输出R  ,***补充
    public int[] F(int[] R,int t){
    	int[] result = new int[16];
        for(int i=0;i<16;i++){
        	//将R倒序与key异或
        	result[i] = keyA[t][i]^R[15-i];
        }
        //补充S盒子*****
    	return result;
    }
    
    //get next key  ---先直接输出相同key  ,****
    public void getNextKey(){
    	//上一轮key
    	keyA[0]= key;
    	for(int i=0;i<16;i++){
        	System.out.print(keyA[0][i]);
        	System.out.print(' ');
    	}
        System.out.println();
    	for(int i=1;i<16;i++){
    		if(i%4==0){
    			//每4次,数组循右移1个
    			int temp = keyA[i-1][15];
    			for(int z=0;z<15;z++){
    				keyA[i-1][z] = keyA[i-1][z+1];
    			}
    			keyA[i-1][15] = temp;
    		}
    		for(int j=0;j<16;j++){
    			//循环
    			keyA[i][j] = (keyA[i-1][j]<<1|keyA[i-1][j]>>3)%16;
    			System.out.print(keyA[i][j]);
    			System.out.print(' ');
    		}
    		System.out.println();
    	}
    }
    
    //Feistel结构--每轮      
    public void round(int t){
    	int[] temp = new int[16];
    	int[] tempF = new int[16];
    	//先得到新key
    	System.arraycopy(left, 0, temp, 0, left.length);
    	System.arraycopy(right, 0, left, 0, right.length);
    	//F函数
    	tempF = F(right,t);
    	//F后的异或
    	for(int i=0;i<16;i++){
    		right[i]=tempF[i]^temp[i];
    	}
    }
    
    //加密
    public char[] enCode(boolean flag){
    	//flag = true为加密
    	int[] temp = new int[16];
    	char []s = new char[32];
    	
    	//2.left\right\key作为输入调用round16次
    	for(int i=0;i<16;i++){
    		if(flag) round(i);
    		else round(15-i);
    	}
    	
    	//3.交换left和right
    	System.arraycopy(left, 0, temp, 0, left.length);
    	System.arraycopy(right, 0, left, 0, right.length); 	
    	System.arraycopy(temp, 0, right, 0, temp.length);
    	//把left和right合成secert,并转成char[]
    	int f[]=new int[left.length+right.length];
    	for(int i=0;i<f.length;i++){
    		if(i<left.length){
    			f[i]=left[i];
    		}
    		else f[i]=right[i-left.length];
    	}
    	//change to char[]
    	for(int i=0;i<f.length;i++){
    		if(f[i]<10){
    			s[i] = (char) (f[i] + '0');
    		}
    		else s[i] = (char) (f[i] - 10 + 'a');
    	}
    	  
    	return s;
    }
}
