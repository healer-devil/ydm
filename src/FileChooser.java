import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class FileChooser {
	public static void main(String args[]) {
		jtxtfrm fm = new jtxtfrm();
	}
}

class jtxtfrm extends Frame implements ActionListener {
	FileDialog op, sv;
	Button btn1, btn2, btn3;
	TextArea tarea;

	jtxtfrm() {
		super("读写文件");
		setLayout(null);
		setBackground(Color.cyan);
		setSize(600, 300);
		setVisible(true);
		btn1 = new Button("打开");
		btn2 = new Button("保存");
		btn3 = new Button("关闭");
		tarea = new TextArea("");
		add(btn1);
		add(btn2);
		add(btn3);
		add(tarea);
		tarea.setBounds(30, 50, 460, 220);
		btn1.setBounds(520, 60, 50, 30);
		btn2.setBounds(520, 120, 50, 30);
		btn3.setBounds(520, 180, 50, 30);
		op = new FileDialog(this, "打开", FileDialog.LOAD);
		sv = new FileDialog(this, "保存", FileDialog.SAVE);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			String str;
			op.setVisible(true);
			try {
				File f1 = new File(op.getDirectory(), op.getFile());
				FileReader fr = new FileReader(f1);
				BufferedReader br = new BufferedReader(fr);
				tarea.setText("");
				while ((str = br.readLine()) != null)
					tarea.append(str + '\n');
				fr.close();
			} catch (Exception e1) {
			}
		}

		if (e.getSource() == btn2) {
			sv.setVisible(true);
			try {
				File f1 = new File(sv.getDirectory(), sv.getFile());
				FileWriter fw = new FileWriter(f1);
				BufferedWriter bw = new BufferedWriter(fw);
				String gt = tarea.getText();
				bw.write(gt, 0, gt.length());
				bw.flush();
				fw.close();
			} catch (Exception e2) {
			}
		}

		if (e.getSource() == btn3) {
			System.exit(0);
		}

	}
}