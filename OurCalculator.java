import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class OurCalculator implements ActionListener {
	
	
	
	JFrame Frame;
	JPanel view, buttonGroup;
	JButton try1;
	JLabel viewNumber1, viewNumber2, spacing; 
	JButton[] numbDisplay = new JButton[10];
	JButton [] buttonMethods = new JButton[14];
	JButton add,subtract,multiply,divide, exponent, exponentItself,sqrt;
	JButton opposite,period,equals,c ,erase, ce;
	JButton history;
	double one=0, two=0, result=0, memory=0, allmemory = 0;
	char buttonFunction;
	int active = 0;
	public OurCalculator() {
		Font f = new Font("serif", Font.PLAIN, 35);
		Font f2 = new Font("arial", Font.BOLD, 50);
		Font f3 = new Font("arial", Font.BOLD, 50);
		Font f4 = new Font("arial", Font.PLAIN, 30);
		Frame = new JFrame("GCalculator");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setBackground(Color.decode("#FFF9F9"));
		Frame.setSize(350,715);
		Frame.setMinimumSize(new Dimension(350,715));
		Frame.setLayout(null);
	
		Frame.setResizable(false);
		
		view = new JPanel();
		viewNumber1 = new JLabel("");
		viewNumber1.setFont(f);
		viewNumber1.setBounds(20,20,300,150);
		viewNumber1.setBackground(Color.decode("#3E3636"));
		viewNumber2 = new JLabel("0");
		viewNumber2.setFont(f2);
		viewNumber2.setBounds(20,70,300,150);
		
		
		view.add(viewNumber1);
		view.add(viewNumber2);
		view.setBounds(0,0,335,178);
		view.setLayout(null);  
		Frame.add(view);
		
		view.setVisible(true);
				
		add = new JButton("+");
		subtract = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		period = new JButton(".");
		exponent = new JButton("x2");
		exponentItself = new JButton("x^");
		sqrt = new JButton("√");
		equals = new JButton("=");
		c = new JButton("C");
		ce = new JButton("CE");
		erase = new JButton("clr");
		opposite = new JButton("+/-");
		history = new JButton("HS");
		
		buttonMethods[0]= history;
		buttonMethods[1]= ce ;
		buttonMethods[2]= c;
		buttonMethods[3]= divide;
		buttonMethods[4]= period;
		buttonMethods[5]= equals;
		buttonMethods[6]= multiply;
		buttonMethods[7]= erase;
		buttonMethods[8]= opposite;
		buttonMethods[9]= subtract;
		buttonMethods[10]= exponent;
		buttonMethods[11]= exponentItself;
		buttonMethods[12]= sqrt;
		buttonMethods[13]= add;
		
		
		for(int i=0; i<14;	i++) {
			buttonMethods[i].addActionListener(this);
			buttonMethods[i].setFont(f4);
			buttonMethods[i].setFocusable(false);
			buttonMethods[i].setBackground(Color.decode("#FCF4F4"));
		}
		
		for(int i=0; i<3;	i++) {
			buttonMethods[i].setBackground(Color.decode("#FAB2B2"));
		}
		
		buttonMethods[5].setBackground(Color.decode("#FAB2B2"));
		
		for(int i=0;	i<10;	i++) {
			numbDisplay[i]= new JButton(String.valueOf(i));
			numbDisplay[i].addActionListener(this);
			numbDisplay[i].setFont(f3);
			numbDisplay[i].setFocusable(false);
			numbDisplay[i].setBackground(Color.decode("#FFFFFF"));
		}
		
		buttonGroup = new JPanel();
		buttonGroup.setBounds(0,178,335,500);
		Frame.add(buttonGroup);
	
		buttonGroup.setLayout(new GridLayout(6,4,1,1));
		
		
		
		
		buttonGroup.add(history);
		buttonGroup.add(ce);
		buttonGroup.add(c);
		buttonGroup.add(erase);
		buttonGroup.add(exponent);
		buttonGroup.add(exponentItself);
		buttonGroup.add(sqrt);
		buttonGroup.add(divide);
		buttonGroup.add(numbDisplay[7]);
		buttonGroup.add(numbDisplay[8]);
		buttonGroup.add(numbDisplay[9]);
		buttonGroup.add(multiply);
		buttonGroup.add(numbDisplay[4]);
		buttonGroup.add(numbDisplay[5]);
		buttonGroup.add(numbDisplay[6]);
		buttonGroup.add(subtract);
		buttonGroup.add(numbDisplay[1]);
		buttonGroup.add(numbDisplay[2]);
		buttonGroup.add(numbDisplay[3]);
		buttonGroup.add(add);
		buttonGroup.add(opposite);
		buttonGroup.add(numbDisplay[0]);
		buttonGroup.add(period);
		buttonGroup.add(equals);
					
		Frame.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			if (e.getSource() == numbDisplay[i]) {
				
				if(viewNumber2.getText() == "0") {
					viewNumber2.setText(String.valueOf(i));
				}else {
				viewNumber2.setText(viewNumber2.getText().concat(String.valueOf(i)));
				}
			}
		}
		
		
		if(e.getSource()==period) {
			viewNumber2.setText(viewNumber2.getText().concat("."));
		}
		
		if(e.getSource()==add) {
			
			one = Double.parseDouble(viewNumber2.getText());
			buttonFunction ='+';
				
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("+")));				
										
			viewNumber2.setText("");
			
		}
		
		
		if(e.getSource()==subtract) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='-';
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("-")));	
			viewNumber2.setText("");
		}
		if(e.getSource()==multiply) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='*';
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("*")));	
			viewNumber2.setText("");
		}
		if(e.getSource()==divide) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='/';
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("/")));	
			viewNumber2.setText("");
		}
		if(e.getSource()==sqrt) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='q';
			viewNumber1.setText("√".concat(viewNumber2.getText().concat("=") ));	
			
			result = Math.sqrt(one);
			viewNumber2.setText(String.valueOf(result));	
		}
		if(e.getSource()==exponent) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='e';
			viewNumber1.setText("sqr(".concat(viewNumber2.getText().concat(")=")));	
			
			result = one * one;
			viewNumber2.setText(String.valueOf(result));	
		}
		
		
		if(e.getSource()==exponentItself) {
			one= Double.parseDouble(viewNumber2.getText());
			buttonFunction ='f';
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("^")));	
			viewNumber2.setText("");
			
		}
		
		if(e.getSource()== equals) {
			two = Double.parseDouble(viewNumber2.getText());
			
			switch (buttonFunction){
			case '+':
				result = one + two;
				break;
			case '-':
				result = one - two;
				break;
			
			case '*':
				result = one * two;
				break;
			
			case '/':
				result = one/two;
				break;
				
			case 'q': //sqrt
			
				result = Math.sqrt(one);
				
				break;
				
				
			case 'e': //exponent with 2
				result = one * one;
				break;
				
				
			case 'f': //exponent with default
				result = Math.pow(one, two);
				break;
			}
			
			viewNumber1.setText(viewNumber1.getText().concat(viewNumber2.getText().concat("= ")));
			viewNumber2.setText(String.valueOf(result));
			one=result;
		}
		
		if(e.getSource()==c) {
			viewNumber2.setText("");
			viewNumber1.setText("");
			result = 0;
		}
		if(e.getSource()==ce) {
			viewNumber2.setText("");
		
		}
		if(e.getSource()==erase) {
			String string = viewNumber2.getText();
			viewNumber2.setText("");
			for(int i=0; i<string.length()-1; i++) {
				viewNumber2.setText(viewNumber2.getText()+string.charAt(i));
			}
			
		}
		if(e.getSource()==opposite) {
			double temp = Double.parseDouble(viewNumber2.getText());
			temp *=-1;
			viewNumber2.setText(String.valueOf(temp));
		}
		
		
		
		
	}

	
	
	public static void main(String[] args) {
		OurCalculator calc = new OurCalculator();
		System.out.println(Math.pow(6, 4));
	}
	
	
}


