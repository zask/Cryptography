package DEScSM4;



public class Code {
	private int left[]=new int[16];
	private int right[]=new int[16];
	private int key[]=new int[16];
	private int keyA[][]=new int[16][16];	
	public Code(String simple,String k){
		//��simple�ֳ�left��right��תΪint[]   complete
		char c[] = simple.toCharArray();//ת��ascii��
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
 
		//��keyתΪint[]��ֵ��this.key   
        for(int i=0;i<16;i++){
        	if(s[i]>='0'&&s[i]<='9'){
        		key[i]=s[i]-'0';
        	}
        	else{
        		key[i]=s[i]-'a'+10;
        	}
        }
        getNextKey();//��������ʱֱ�ӵõ�16��roundKey
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

	//F Function---��ֱ�����R  ,***����
    public int[] F(int[] R,int t){
    	int[] result = new int[16];
        for(int i=0;i<16;i++){
        	//��R������key���
        	result[i] = keyA[t][i]^R[15-i];
        }
        //����S����*****
    	return result;
    }
    
    //get next key  ---��ֱ�������ͬkey  ,****
    public void getNextKey(){
    	//��һ��key
    	keyA[0]= key;
    	for(int i=0;i<16;i++){
        	System.out.print(keyA[0][i]);
        	System.out.print(' ');
    	}
        System.out.println();
    	for(int i=1;i<16;i++){
    		if(i%4==0){
    			//ÿ4��,����ѭ����1��
    			int temp = keyA[i-1][15];
    			for(int z=0;z<15;z++){
    				keyA[i-1][z] = keyA[i-1][z+1];
    			}
    			keyA[i-1][15] = temp;
    		}
    		for(int j=0;j<16;j++){
    			//ѭ��
    			keyA[i][j] = (keyA[i-1][j]<<1|keyA[i-1][j]>>3)%16;
    			System.out.print(keyA[i][j]);
    			System.out.print(' ');
    		}
    		System.out.println();
    	}
    }
    
    //Feistel�ṹ--ÿ��      
    public void round(int t){
    	int[] temp = new int[16];
    	int[] tempF = new int[16];
    	//�ȵõ���key
    	System.arraycopy(left, 0, temp, 0, left.length);
    	System.arraycopy(right, 0, left, 0, right.length);
    	//F����
    	tempF = F(right,t);
    	//F������
    	for(int i=0;i<16;i++){
    		right[i]=tempF[i]^temp[i];
    	}
    }
    
    //����
    public char[] enCode(boolean flag){
    	//flag = trueΪ����
    	int[] temp = new int[16];
    	char []s = new char[32];
    	
    	//2.left\right\key��Ϊ�������round16��
    	for(int i=0;i<16;i++){
    		if(flag) round(i);
    		else round(15-i);
    	}
    	
    	//3.����left��right
    	System.arraycopy(left, 0, temp, 0, left.length);
    	System.arraycopy(right, 0, left, 0, right.length); 	
    	System.arraycopy(temp, 0, right, 0, temp.length);
    	//��left��right�ϳ�secert,��ת��char[]
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
