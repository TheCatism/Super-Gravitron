import javax.swing.JFrame;

public class SuperDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("GREATEST GAME EVER");
		frame.setSize(1000, 1000);
		frame.setLocation(100, 10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new SuperGravitronPanel());
		frame.setVisible(true);

	}

}
