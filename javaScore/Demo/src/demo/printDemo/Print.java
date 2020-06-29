package demo.printDemo;

import demo.iface.IInkBox;
import demo.iface.IPaper;

/**
 * 打印机类
 * @author 小风筝
 *
 */
public class Print {
	private IInkBox box = null;			//打印机中的墨盒
	private IPaper	paper = null;		//打印机中的纸张
	
	/**
	 * 打印机的打印方法 - 使用墨盒和纸张
	 * @param content	传入的打印类容
	 */
	public void print(String content) {
		if(box == null || paper == null) {
			System.out.println("打印机中没有墨盒或者纸张，打印失败！");
			return;
		}
		//打印过程
		
		System.out.println("文字颜色：" + box.getColor());
		System.out.println("纸张大小：" + paper.getSize());
		System.out.println("文字内容：" + content);
	}
	
	public IInkBox getBox() {
		return box;
	}
	
	
	public void setBox(IInkBox box) {
		this.box = box;
	}
	public IPaper getPaper() {
		return paper;
	}
	public void setPaper(IPaper paper) {
		this.paper = paper;
	}
	
	
}
