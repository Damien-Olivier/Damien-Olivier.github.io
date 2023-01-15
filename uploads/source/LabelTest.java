import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LabelTest extends JFrame {
   private JLabel label1, label2, label3;

   public LabelTest()
   {
      super( "Teste JLabel" );

      // On récupère le conteneur
      Container container = getContentPane();
      container.setLayout(new FlowLayout());
      CompoundBorder b = new CompoundBorder(new LineBorder(Color.green,1),
					    null) ;

      label1 = new JLabel( "<html><em>Label avec texte</em><br>"+
                            "<ul> <li> avec cadre </li>"+
                                  "<li> et code HTML</li>"+
                            "</ul></html>" );
      label1.setToolTipText( "label1" );
      container.add( label1 );
      label1.setBorder(b);

      Icon woof = new ImageIcon( "Chien.gif" );
      label2 = new JLabel("Label avec texte et icone",
         woof, SwingConstants.LEFT );
      label2.setToolTipText( "label2" );
      container.add( label2 );
      label2.setBorder(b);

      label3 = new JLabel();
      label3.setText(
          "Label avec icone et texte au dessus" );
      label3.setIcon(new ImageIcon("Oiseau.gif"));
      label3.setHorizontalTextPosition(
          SwingConstants.CENTER );
      label3.setVerticalTextPosition(
          SwingConstants.BOTTOM );
      label3.setToolTipText( "label3" );
      container.add( label3 );
      label3.setBorder(b);

      pack();//setSize( 275, 170 );
      setVisible( true );
   }

   public static void main( String args[] )
   {
      LabelTest application = new LabelTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }
}
