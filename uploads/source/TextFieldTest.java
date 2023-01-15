import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldTest extends JFrame {
   private JTextField textField1, textField2,
        textField3;
   private JPasswordField passwordField;

   // set up GUI
   public TextFieldTest()
   {
      super("Exemple de JTextField et JPasswordField");

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // construct textfield with default sizing
      textField1 = new JTextField( 10 );
      container.add( textField1 );

      // construct textfield with default text
      textField2 = new JTextField("Entrez votre texte ici");
      container.add( textField2 );

      // construct textfield with default text and
      // 20 visible elements and no event handler
      textField3 = new JTextField(
          "Champ non éditable", 20 );
      textField3.setEditable( false );
      container.add( textField3 );

      // construct textfield with default text
      passwordField =
          new JPasswordField( "Texte caché" );
      container.add( passwordField );

      // register event handlers
      TextFieldHandler handler =
          new TextFieldHandler();
      textField1.addActionListener( handler );
      textField2.addActionListener( handler );
      textField3.addActionListener( handler );
      passwordField.addActionListener( handler );

      setSize( 325, 100 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      TextFieldTest application = new TextFieldTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

   // private inner class for event handling
   private class TextFieldHandler
        implements ActionListener {

      // process text field events
      public void actionPerformed(ActionEvent event)
      {
         String string = "";

         // user pressed Enter in textField1
         if ( event.getSource() == textField1 )
            string = "textField1: "
                + event.getActionCommand();

         // user pressed Enter in textField2
         else if ( event.getSource() == textField2 )
            string = "textField2: "
                + event.getActionCommand();

         // user pressed Enter in textField3
         else if ( event.getSource() == textField3 )
            string = "textField3: "
                + event.getActionCommand();

         // user pressed Enter in passwordField
         else if ( event.getSource() == passwordField ) {
            JPasswordField pwd =
               ( JPasswordField ) event.getSource();
            string = "passwordField: " +
                new String(passwordField.getPassword());
         }

         JOptionPane.showMessageDialog( null, string );// Pour montrer le mot de passe
      }
   }  // end private inner class TextFieldHandler
}  // end class TextFieldTest
