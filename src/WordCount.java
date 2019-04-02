
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class WordCount  {
		public static Map<String,Integer> map=new TreeMap<String,Integer>();//集合用键值对的方式存取数据

		
		public static void main(String[] args) throws Exception{		
		
        new FileChooser();
		
		BufferedReader bf=new BufferedReader(new FileReader("wj.txt"));
		String s;
		String[] a;//存放统计的单词的频率
		while((s=bf.readLine())!=null){
			String[] words=s.split("[^a-zA-Z]");//截取字母，避免多余的计入，比如各种符号
			for(int i=0;i<words.length;i++){
				String key=words[i].toLowerCase();//便于管理，将字母变小写
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
			
		//使用switch语句实现功能选择
		System.out.println("-------词频--------");
		System.out.println("1.单词的查找及柱状图的显示");
		System.out.println("2.高频词的显示");
		System.out.println("3.输出文件完成");
		System.out.println("4.统计文本行数及字符数");
		Scanner input = new Scanner(System.in);
		int i=input.nextInt();
		Tongji t=new Tongji();
		switch(i){
		case 1:
			//提示用户输入单词，并提示用什么符号隔开
			System.out.printf("请输入你要查找的单词，并用';'隔开");
			String str= input.next();
			Tongji tj=new Tongji(map,t.oneword(map, str)); //通过方法调用来实现单个单词的频率
			tj.setVisible(true);
			break;					//用break中断循环，否则一直执行，直到最后
		case 2:		
			Scanner sc=new Scanner(System.in);
		    System.out.println("请输入要查看的高频词频的个数:"); 
			int k = sc.nextInt();  
			t.gaopin(map, k);	//通过方法调用来实现单个单词的频率
			break;
		case 3:
			t.out(map);	//通过方法调用来存入result文件
			break;
		case 4:
			t.allCount("wj.txt");
			break;
		}
	}

		

}
