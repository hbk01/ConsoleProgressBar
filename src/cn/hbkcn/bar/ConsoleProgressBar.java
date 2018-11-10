package cn.hbkcn.bar;

import java.math.*;

/**
 * 控制台进度条的实现
 * @author 3243430237@qq.com
 * @version 1.0
 */
public class ConsoleProgressBar{
	// 进度条最大值
	private double max = 100.00;
	// 进度条长度
	private int barLength = 20;
	// 进度条填充前
	private String before = "+";
	// 进度条填充后
	private String after = "#";
	// 进度条文本
	private String text = "";

	// 进度条后面数值显示的格式，推荐使用0
	// type 0: [12/100]
	// type 1: [12%]
	// type 2: 12%
	private int type = 0;

	public ConsoleProgressBar(){}
	
	public ConsoleProgressBar(double max){
		this.max = max;
	}
	
	public ConsoleProgressBar(double max, int barLength){
		this.max = max;
		this.barLength = barLength;
	}

	public void draw(double current){
		draw(current, 0);
	}

	public void draw(double current, int type){
		// 一个进度条长度对应的进度值
		double d = max / barLength;
		// 应该画多少个后
		int v = divI(current, d);
		
		// 回到行首
		System.out.print('\r');
		/* 另一种方式
		for(int i = 0; i <= text.length(); i++){
			print("\b");
		}
		*/

		// 添加前缀
		text = "[";
		
		// 添加填充后字符串
		for(int i = 0; i < v; i++){
			text += after;
		}
		
		// 添加填充前字符串
		for(int i = 0; i < barLength - v; i++){
			text += before;
		}
		text += "] ";

		// 添加结尾处具体数据显示
		switch(type){
			case 0:
				text = text.concat("[" + current + "/" + max + "]");
				break;
			case 1:
				text = text.concat("[" + divD(current, max) + "%]");
				break;
			case 2:
				text = text.concat(divD(current, max) + "%");
				break;
			default:
				text = text.concat("[" + current + "/" + max + "]");
				break;
		}
		
		// 打印
		System.out.print(text);
	}

	// 精确计算除法，返回double
	private double divD(double a, double b){
		BigDecimal ba = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		return ba.divide(bb, 4, RoundingMode.HALF_DOWN)
			.multiply(new BigDecimal(100)).doubleValue();
	}
	
	// 精确计算除法，返回int
	private int divI(double a, double b){
		BigDecimal ba = new BigDecimal(a);
		BigDecimal bb = new BigDecimal(b);
		return ba.divide(bb, 2, RoundingMode.HALF_DOWN).intValue();
	}
}
