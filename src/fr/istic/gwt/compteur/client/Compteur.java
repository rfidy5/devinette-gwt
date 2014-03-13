package fr.istic.gwt.compteur.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Compteur implements EntryPoint {

//	  private double i =0;
	  private VerticalPanel mainPanel = new VerticalPanel();
	  private HorizontalPanel visuPanel = new HorizontalPanel();
	  private HorizontalPanel buttonPanel = new HorizontalPanel();
	  private TextBox visuDevinetteTextBox = new TextBox();
	  private Button startButton = new Button("Demarrez");
	  private Label label;

	 private int randomNumber;
	 private int compteur=0;
	 
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		label= new Label("Choisissez un nombre entre 1 et 100:");
		
		startButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
			    	
//			        refresh();
			        startButton.setEnabled(false);
			    	visuPanel.add(visuDevinetteTextBox);
			    	visuPanel.add(label);
			      }
			    });
		
		//visuPanel.add(visuCompteurTextBox);
		

		buttonPanel.setSpacing(20);
		buttonPanel.add(startButton);
		mainPanel.add(visuPanel);
		mainPanel.add(buttonPanel);
		
		
		RootPanel.get("mainCompteur").add(mainPanel);

	    // Listen for mouse events on the Add button.
//	    addButton.addClickHandler(new ClickHandler() {
//	      public void onClick(ClickEvent event) {
//	    	
//	        refresh();
//	      }
//	    });


	    
	    // Listen for keyboard events in the input box.
		visuDevinetteTextBox.addKeyPressHandler(new KeyPressHandler() {
	      public void onKeyPress(KeyPressEvent event) {
	        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
	        	compteur++;
	        	int entryVal = Integer.parseInt(visuDevinetteTextBox.getText());
	        	
	        	System.out.println("return "+verifyNumber(entryVal));
	        	
	        	if(verifyNumber(entryVal)==1){
	        		label.setText("trop grand / "+ compteur +" coups effectues");
	        	}if(verifyNumber(entryVal)==-1){
	        		label.setText("trop petit / "+ compteur +" coups effectues");
	        	}if(verifyNumber(entryVal)==0){
	        		label.setText("Vous avez gagne en "+compteur+" coups");
	        	}
	          
	          
	       //   cpt=Integer.parseInt(newVal);
	        }
	      }
	    });
//	    refresh();
	}
//		private void refresh() {
//			visuDevinetteTextBox.setText("" +i );
//		}
		
		private int createNumber(int lower, int higher){
			randomNumber = (int)(Math.random() * (higher-lower)) + lower;
			return randomNumber;
		}
		private int verifyNumber(int number){
			if(number>randomNumber){
				return 1;
			}
			if(number<randomNumber){
				return -1;
			}if(number==randomNumber){
				return 0;
			}else{ 
				return 2;
			}
		}
		
}
