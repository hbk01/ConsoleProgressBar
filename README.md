# 控制台进度条
实现在控制台中显示进度条。



示例：

```java
public class Main{
	public static void main(String[] args){
		int max = 100;
		// 显示type 0的效果
		if (show(max, 0)) {
			System.out.println();
			// 显示type 1的效果
			if (show(max, 1)) {
				System.out.println();
				// 显示type 2的效果
				if (show(max, 2)) {
					System.out.println();
					System.out.println("ok.");
				}
			}
		}
	}

	public static boolean show(int max, int type){
		ConsoleProgressBar bar = new ConsoleProgressBar(max);
		for (int i = 0; i <= max; i++) {
            bar.draw(i, type);
            sleep(100);
        }
		return true;
	}

	public static void sleep(long time){
		try{
			Thread.sleep(time);
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
    
}

```

