package demo.printDemo;

import demo.iface.IInkBox;
import demo.iface.IPaper;

/**
 * ��ӡ����
 * @author С����
 *
 */
public class Print {
	private IInkBox box = null;			//��ӡ���е�ī��
	private IPaper	paper = null;		//��ӡ���е�ֽ��
	
	/**
	 * ��ӡ���Ĵ�ӡ���� - ʹ��ī�к�ֽ��
	 * @param content	����Ĵ�ӡ����
	 */
	public void print(String content) {
		if(box == null || paper == null) {
			System.out.println("��ӡ����û��ī�л���ֽ�ţ���ӡʧ�ܣ�");
			return;
		}
		//��ӡ����
		
		System.out.println("������ɫ��" + box.getColor());
		System.out.println("ֽ�Ŵ�С��" + paper.getSize());
		System.out.println("�������ݣ�" + content);
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
