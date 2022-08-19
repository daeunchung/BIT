package wnd;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener, ActionListener {		// 윈도우리스너, 버튼리스너

	Label label;
	Button button1, button2; 
	TextField textField = new TextField();
	
	
	public WindowTest()
	{
		setLayout(null);
		label = new Label("button event");
		label.setBounds(10, 60, 620, 30);
		label.setBackground(new Color(0, 255, 0));
		add(label);
		
		button1 = new Button("button one");
		button1.setBounds(50, 120, 100, 50);
		button1.addActionListener(this);	// 버튼 이벤트를 발생 시킬때는 버튼 리스너를 켜줘야 함(action listener)
		add(button1);
		
		button2 = new Button("button two");
		button2.setBounds(200, 120, 100, 50);
		button2.addActionListener(this);	// 버튼 이벤트를 발생 시킬때는 버튼 리스너를 켜줘야 함(action listener) - 리소스에 반드시 addActionListener 붙여줘야 동작 실행
		add(button2);
		
		
		/*
		// 버튼이 달랑 한개 이면 이런식으로 코딩해도 OK
		Button btn = new Button();
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		
		
		textField.setBounds(50, 240, 100, 50);
		add(textField);
		
		// --------------------- 여기까지는 리소스
		
		setSize(640, 480);
		setLocation(0,0);
		setVisible(true);
		
		addWindowListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	// 버튼이 여러개일때 구분해주는 구분자가 ActionEvent e
		// TODO Auto-generated method stub
		System.out.println("button click");
		
		Button btn = (Button)e.getSource();
		String btnName = btn.getLabel();
		
		if(btnName.equals("button one"))
		{
//			JOptionPane.showMessageDialog(null, "button 1 click!");
			textField.setText("버튼 1 클릭!");
		}
		else if(btnName.equals("button two"))
		{
//			JOptionPane.showMessageDialog(null, "button 2 click!");
			textField.setText("버튼 2 클릭!");
		}
		
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
