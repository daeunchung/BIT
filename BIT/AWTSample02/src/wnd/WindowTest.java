package wnd;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.w3c.dom.Text;

public class WindowTest extends Frame implements WindowListener{

	public WindowTest()
	{
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(3, 1));
		setLayout(null);	// 레이아웃을 사용하지 않겠다
		
		
		// 레이블의 영역은 전체영역
		Label label = new Label();
		label.setText("레이블1");
		
		label.setBounds(100, 100, 150, 30);	// (100,100) 부터 가로150 세로 30
		label.setBackground(Color.red);
		add(label);
		
		Button btn = new Button();
		btn.setBounds(100, 200, 200, 100);	

		btn.setLabel("버튼");
		add(btn);
		
		// 텍스트 필드
		TextField textField = new TextField();
		textField.setBounds(100, 350, 150, 50);	
		add(textField);
		
		
//		label = new Label();
//		label.setText("레이블2");
//		add(label);
		
		setSize(640, 480);
		setBackground(Color.LIGHT_GRAY);
		setLocation(0,0);
		setVisible(true);
		
		addWindowListener(this);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
