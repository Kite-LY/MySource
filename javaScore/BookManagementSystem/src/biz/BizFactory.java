package biz;

import biz.impl.BookInfoBizImplV1;
import biz.impl.UserBizImplV1;

/**
 * ҵ���� - ������
 * @author С����
 *
 */
public class BizFactory {
	
	@SuppressWarnings("rawtypes")
	public static Biz getBiz(String bizName) {
		switch (bizName.toLowerCase()) {
		case "bookinfobiz": 
			return new BookInfoBizImplV1();
		case "userbiz" :
			return new UserBizImplV1();
		default:
			return null;
		}
	}
	
}
