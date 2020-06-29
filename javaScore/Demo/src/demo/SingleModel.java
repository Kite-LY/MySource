/**
 * 
 */
package demo;

/**实现单例模式
 * @author 小风筝
 *
 */
public class SingleModel {

		private static SingleModel me = null;
		public int count = 1;
		
		private SingleModel() {}
		
		
		public static SingleModel getInstance() {
			if(me == null) {
				me = new SingleModel();
			}
			return me;
		}
		
}
