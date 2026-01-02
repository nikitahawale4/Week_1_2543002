import java.awt.*;
import java.awt.event.*;

class CalculatorAWT extends Frame implements ActionListener
 {
TextField tf;
double num1 = 0, num2 = 0, result = 0;
char operator;
CalculatorAWT() 
{
 setTitle("AWT Calculator");
 setSize(300, 400);
 setLayout(null);
 tf = new TextField();
 tf.setBounds(30, 50, 240, 40);
 add(tf);
 String[] buttons =
 {
   "7","8","9","/",
   "4","5","6","*",
   "1","2","3","-",
   "0",".","=","+"
  };
int x = 30, y = 120;
for (int i = 0; i < buttons.length; i++)
 {
   Button b = new Button(buttons[i]);
   b.setBounds(x, y, 50, 40);
   add(b);
   b.addActionListener(this);
   x += 60;
   if ((i + 1) % 4 == 0)
 {
   x = 30;
   y += 50;
 }
 }

  Button clr = new Button("C");
  clr.setBounds(30, y, 240, 40);
  add(clr);
  clr.addActionListener(this);

  addWindowListener(new WindowAdapter()
 {
   public void windowClosing(WindowEvent we)
 {
   System.exit(0);
 }
 });
   setVisible(true);
    }
   public void actionPerformed(ActionEvent ae)
 {
   String s = ae.getActionCommand();
   if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.equals("."))
 {
   tf.setText(tf.getText() + s);
  }
   else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
 {
    num1 = Double.parseDouble(tf.getText());
    operator = s.charAt(0);
    tf.setText("");
  }
     else if (s.equals("=")) {
     num2 = Double.parseDouble(tf.getText());
      try {
            switch (operator) 
		{
        case '+': result = num1 + num2; break;
        case '-': result = num1 - num2; break;
        case '*': result = num1 * num2; break;
        case '/':
        if (num2 == 0)
          throw new ArithmeticException("Divide by zero");
          result = num1 / num2;
          break;
                }
       tf.setText(String.valueOf(result));
            }
        catch (ArithmeticException e)
	 {
         tf.setText("Error: Divide by 0");
         }
        }
        else if (s.equals("C")) 
	{
            tf.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) 
	{
        new CalculatorAWT();
    	}
}
