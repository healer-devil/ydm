
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class WordCount  {
		public static Map<String,Integer> map=new TreeMap<String,Integer>();//�����ü�ֵ�Եķ�ʽ��ȡ����

		
		public static void main(String[] args) throws Exception{		
		
        new FileChooser();
		
		BufferedReader bf=new BufferedReader(new FileReader("wj.txt"));
		String s;
		String[] a;//���ͳ�Ƶĵ��ʵ�Ƶ��
		while((s=bf.readLine())!=null){
			String[] words=s.split("[^a-zA-Z]");//��ȡ��ĸ���������ļ��룬������ַ���
			for(int i=0;i<words.length;i++){
				String key=words[i].toLowerCase();//���ڹ�������ĸ��Сд
				if(key.length()>0){
					if(!map.containsKey(key)){
						map.put(key,1);
					}else{
						int value=map.get(key);
						value++;
						map.put(key,value);
					}
				}
			}			
		}
			
		//ʹ��switch���ʵ�ֹ���ѡ��
		System.out.println("-------��Ƶ--------");
		System.out.println("1.���ʵĲ��Ҽ���״ͼ����ʾ");
		System.out.println("2.��Ƶ�ʵ���ʾ");
		System.out.println("3.����ļ����");
		System.out.println("4.ͳ���ı��������ַ���");
		Scanner input = new Scanner(System.in);
		int i=input.nextInt();
		Tongji t=new Tongji();
		switch(i){
		case 1:
			//��ʾ�û����뵥�ʣ�����ʾ��ʲô���Ÿ���
			System.out.printf("��������Ҫ���ҵĵ��ʣ�����';'����");
			String str= input.next();
			Tongji tj=new Tongji(map,t.oneword(map, str)); //ͨ������������ʵ�ֵ������ʵ�Ƶ��
			tj.setVisible(true);
			break;					//��break�ж�ѭ��������һֱִ�У�ֱ�����
		case 2:		
			Scanner sc=new Scanner(System.in);
		    System.out.println("������Ҫ�鿴�ĸ�Ƶ��Ƶ�ĸ���:"); 
			int k = sc.nextInt();  
			t.gaopin(map, k);	//ͨ������������ʵ�ֵ������ʵ�Ƶ��
			break;
		case 3:
			t.out(map);	//ͨ����������������result�ļ�
			break;
		case 4:
			t.allCount("wj.txt");
			break;
		}
	}

		

}
