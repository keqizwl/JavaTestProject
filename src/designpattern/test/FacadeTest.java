package designpattern.test;

/**
 * ģʽ������ 1�Ӵ��븴�ýǶȣ�����һϵ�з����ĳ�ʼ�����̻����ù��̣�ͳһ��װ��һ���򵥵Ľӿ� 2��ά���Ƕ���˵�������޸�ֻ��Ķ��Ǹ��򵥵Ľӿ�
 * 3�����ܣ���ȫ���԰Ѷ��û���˵�ȽϷ����ĸ����ܴ����װ����������ʹ�ã������׳���
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
