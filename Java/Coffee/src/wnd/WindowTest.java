package wnd;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WindowTest extends Frame implements WindowListener, ActionListener{

	Button menuBtn, orderBtn; 
	JRadioButton small, medium, large;
	JRadioButton vanilla, caramel, hazelnut;
	JCheckBox shots, whipping;
	JComboBox box;
	Checkbox checkEtc;
	TextField textField = new TextField();
	Label labelSize, labelSyrup, labelEtc;

	
	public WindowTest()
	{
		setLayout(null);
		menuBtn = new Button("메뉴보기");
		menuBtn.setBounds(500, 100, 100, 50);
		menuBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				box.showPopup();
			}
		});	// 버튼 이벤트를 발생 시킬때는 버튼 리스너를 켜줘야 함(action listener)
		add(menuBtn);
		
		box = new JComboBox<String>();
		box.setBounds(100, 100, 350, 30);
		box.addItem("아메리카노");
		box.addItem("카페 라떼");
		box.addItem("밀크티 라떼");
		box.addItem("카라멜 마끼아토");
		box.addItem("녹차");
		box.addActionListener(this);
		add(box);
		
		// --------------------------------------------------------------
		labelSize = new Label("크기");
		labelSize.setBounds(50, 200, 100, 30);
		labelSize.setBackground(new Color(0, 255, 0));
		add(labelSize);
		
		small = new JRadioButton();
		medium = new JRadioButton();
		large = new JRadioButton();
		small.setText("small");
		medium.setText("medium");
		large.setText("large");
		small.setBounds(50, 250, 100, 30);
		medium.setBounds(50, 300, 100, 30);
		large.setBounds(50, 350, 100, 30);
		add(small);
		add(medium);
		add(large);
		// --------------------------------------------------------------
		labelSyrup = new Label("시럽");
		labelSyrup.setBounds(230, 200, 100, 30);
		labelSyrup.setBackground(new Color(0, 255, 0));
		add(labelSyrup);	
		
		vanilla = new JRadioButton();
		caramel = new JRadioButton();
		hazelnut = new JRadioButton();
		vanilla.setText("vanilla");
		caramel.setText("caramel");
		hazelnut.setText("hazelnut");
		vanilla.setBounds(230, 250, 100, 30);
		caramel.setBounds(230, 300, 100, 30);
		hazelnut.setBounds(230, 350, 100, 30);
		add(vanilla);
		add(caramel);
		add(hazelnut);
		
		// --------------------------------------------------------------

		labelEtc = new Label("기타");
		labelEtc.setBounds(400, 200, 100, 30);
		labelEtc.setBackground(new Color(0, 255, 0));
		add(labelEtc);
//		JPanel panel = new JPanel();
		shots = new JCheckBox();
		whipping = new JCheckBox();
		shots.setText("샷 추가");
		whipping.setText("휘핑 추가");
		shots.setBounds(400, 250, 100, 30);
		whipping.setBounds(400, 300, 100, 30);
		add(shots);
		add(whipping);
		
		// --------------------------------------------------------------
		
		setSize(640, 480);
		setLocation(0,0);
		setVisible(true);
		
		addWindowListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
