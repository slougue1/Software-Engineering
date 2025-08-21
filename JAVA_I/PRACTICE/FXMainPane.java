

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	
	/*private static final Button Hello = null;
	private static final Button Howdy = null;
	private static final Button Chinese = null;
	private static final Button Clear = null;
	private static final Button Exit = null;*/
	
	private Button b1;//  declare five button
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	
	private Button b6; //optional
	
	private Label label;     //  declare a label
	
	private TextField text;
	private HBox hBox1,     //  declare two HBoxes
	             hBox2;
	
	//student Task #4:
	DataManager dManager;   //  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		b1 = new Button ("hello");  //instantiate the buttons
		b2 = new Button ("Howdy"); 
		b3 = new Button ("Chinese");
		b4 = new Button ("Clear");
		b5 = new Button ("Exit");
		b6 = new Button ("French");
		
		label = new Label ("Feedback"); //instantiate label
		
		text = new TextField ();       //instantiate text field
		
		hBox1 = new HBox();           // instantiate the HBoxes
		hBox2 = new HBox();
		
		//student Task #4:
		
		 dManager = new DataManager ();                   //  instantiate the DataManager instance
		 HBox.setMargin(b1, new Insets(10));
	     HBox.setMargin(b2, new Insets(10));
	     HBox.setMargin(b3, new Insets(10));
	     HBox.setMargin(b4, new Insets(10));
	     HBox.setMargin(b5, new Insets(10));
	     HBox.setMargin(b6, new Insets(10));
	     hBox1.setAlignment(Pos.CENTER);
	     hBox2.setAlignment(Pos.CENTER);                 //  set margins and set alignment of the components
		
		//student Task #3:
		hBox1.getChildren().addAll(b1, b2, b3,b6, b4, b5);               //  add the buttons to the other HBox
	    hBox2.getChildren().addAll(label,text);                       //  add the label and textfield to one of the HBoxes
		getChildren().addAll(hBox1, hBox2);                           //  add the HBoxes to this FXMainPanel (a VBox)
		

	//Task #4:
	b1.setOnAction(new ButtonHandler());
    b2.setOnAction(new ButtonHandler());
    b3.setOnAction(new ButtonHandler());
    b6.setOnAction(new ButtonHandler());
    b4.setOnAction(new ButtonHandler());
    b5.setOnAction(new ButtonHandler());
    b6.setOnAction(new ButtonHandler());
    
	}
    class ButtonHandler implements EventHandler<ActionEvent>  //  create a private inner class to handle the button clicks
	{
		
		public void handle(ActionEvent event)
		{
			event.getTarget();
			if (event.getTarget()==b1)
			{
				text.setText(dManager.getHello());
			}
			else if (event.getTarget()==b2)
			{
				text.setText(dManager.getHowdy());
			}
			else if (event.getTarget()==b3)
			{
				text.setText(dManager.getChinese());
			}
			else if (event.getTarget()==b4)
			{
				text.setText("");
			}
			else if (event.getTarget()==b5)
			{
				Platform.exit();
				System.exit(0);
			}
			else if (event.getTarget()==b6)
			{
				text.setText(dManager.getFrench());
			}
		}
	}
}
 	