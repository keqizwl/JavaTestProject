package designpattern.test;

/**
 * 模式分析： 1从代码复用角度，简化了一系列繁琐的初始化过程或设置过程，统一包装成一个简单的接口 2从维护角度来说：过程修改只需改动那个简单的接口
 * 3从性能：完全可以把对用户来说比较繁琐的高性能代码封装起来，容易使用，不容易出错
 * 
 * @author Administrator
 *
 */
public class FacadeTest {

	public static void main(String[] args) {
		FacadeMediaPlayer facadeMediaPlayer = new FacadeMediaPlayer();
		facadeMediaPlayer.play();
	}

	static class FacadeMediaPlayer {
		private RealMediaPlayer realMediaPlayer = new RealMediaPlayer();

		public void play() {
			realMediaPlayer.setFormat(1);
			realMediaPlayer.setVoice(1);
			realMediaPlayer.setHeight(1);
			realMediaPlayer.setWidth(1);
			realMediaPlayer.play();
		}
	}

	static class RealMediaPlayer {

		void play() {

		}

		void setVoice(int a) {

		}

		void setHeight(int height) {

		}

		void setWidth(int width) {

		}

		void setFormat(int type) {

		}

		void setRate(int rate) {
		}
	}
}
