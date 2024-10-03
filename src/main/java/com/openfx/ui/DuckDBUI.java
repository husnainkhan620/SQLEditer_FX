package com.openfx.ui;

import org.openjfx.fx.Menu_Items_FX;

import com.openfx.handlers.NewMenuItemEventHandler;
import com.openfx.placeholders.ConnectionPlaceHolder;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DuckDBUI {


	public Menu_Items_FX menu_Items_FX;
	public NewMenuItemEventHandler newMenuItemEventHandler;
	
	public DuckDBUI(Menu_Items_FX menu_Items_FX,NewMenuItemEventHandler newMenuItemEventHandler) {
		this.menu_Items_FX = menu_Items_FX;
		this.newMenuItemEventHandler = newMenuItemEventHandler;
	}

	public VBox addConnectionCredentials() {
		
		 VBox connectionDetailsVbox = new VBox();
		  
		  GridPane connectionUrlCredentialsGridPane = new GridPane();
		  connectionUrlCredentialsGridPane.setPadding(new Insets(20,10,20,10));
		  connectionUrlCredentialsGridPane.setVgap(5);
		  connectionUrlCredentialsGridPane.setHgap(5);
		  Label jdbcUrlgeneralLabel = new Label("General"); 
		  GridPane.setConstraints(jdbcUrlgeneralLabel, 0, 0);   // column 0 row 0
		  Label jdbcConnectionNameLabel= new Label("Name");
		  GridPane.setConstraints(jdbcConnectionNameLabel, 0, 1);
		  newMenuItemEventHandler.jdbcConnectionName = new TextField();
		  newMenuItemEventHandler.jdbcConnectionName.setPrefHeight(15);
		  newMenuItemEventHandler.jdbcConnectionName.setPrefWidth(400);
		 // jdbcConnectionName.setOnKeyTyped(onjdbcUrlTextFieldKeyPressed() );
		  GridPane.setConstraints(newMenuItemEventHandler.jdbcConnectionName, 1, 1);
		  
		  Label jdbcUrlLabel = new Label("JDBC URL");
		  GridPane.setConstraints(jdbcUrlLabel, 0, 2);
		  newMenuItemEventHandler.jdbcUrlTextField = new TextField();
		  newMenuItemEventHandler.jdbcUrlTextField.setPrefHeight(15);
		  newMenuItemEventHandler.jdbcUrlTextField.setPrefWidth(400);
		  newMenuItemEventHandler.jdbcUrlTextField.setOnKeyTyped(newMenuItemEventHandler.onjdbcUrlTextFieldKeyPressed() );
		  GridPane.setConstraints(newMenuItemEventHandler.jdbcUrlTextField, 1, 2);
		  
		  connectionUrlCredentialsGridPane.getChildren().addAll(jdbcConnectionNameLabel,newMenuItemEventHandler.jdbcConnectionName,jdbcUrlgeneralLabel,jdbcUrlLabel,newMenuItemEventHandler.jdbcUrlTextField);
		  connectionDetailsVbox.getChildren().add(connectionUrlCredentialsGridPane);
		  /*
		  GridPane connectionUsernamePasswordCredentialsGridPane = new GridPane();
		  connectionUsernamePasswordCredentialsGridPane.setPadding(new Insets(20,10,20,10));
		  connectionUsernamePasswordCredentialsGridPane.setVgap(5);
		  connectionUsernamePasswordCredentialsGridPane.setHgap(5);
		  Label jdbcUrlAuthenticationLabel = new Label("Authentication");
		  GridPane.setConstraints(jdbcUrlAuthenticationLabel, 0, 0);   // column 0 row 0
		  Label jdbcAuthenticationUsername = new Label("Username :");
		  GridPane.setConstraints(jdbcAuthenticationUsername, 0, 1);   // column 0 row 0
		  newMenuItemEventHandler.jdbcAuthenticationUsernameTextField = new TextField();
		  newMenuItemEventHandler.jdbcAuthenticationUsernameTextField.setPrefHeight(15);
		  newMenuItemEventHandler.jdbcAuthenticationUsernameTextField.setPrefWidth(200);
		  newMenuItemEventHandler.jdbcAuthenticationUsernameTextField.setOnKeyTyped(newMenuItemEventHandler.onjdbcAuthenticationUsernameTextFieldPressed());
		  GridPane.setConstraints(newMenuItemEventHandler.jdbcAuthenticationUsernameTextField, 1, 1);   // column 0 row 0
		  
		  Label jdbcAuthenticationPassword = new Label("Password");
		  GridPane.setConstraints(jdbcAuthenticationPassword, 0, 2);   // column 0 row 0
		  newMenuItemEventHandler.jdbcAuthenticationPasswordField = new PasswordField();
		  newMenuItemEventHandler.jdbcAuthenticationPasswordField.setPrefHeight(15);
		  newMenuItemEventHandler.jdbcAuthenticationPasswordField.setPrefWidth(200);
		  newMenuItemEventHandler.jdbcAuthenticationPasswordField.setOnKeyTyped(newMenuItemEventHandler.onjdbcAuthenticationPasswordFieldPressed());
		  GridPane.setConstraints(newMenuItemEventHandler.jdbcAuthenticationPasswordField, 1, 2);   // column 0 row 0
		  
		  connectionUsernamePasswordCredentialsGridPane.getChildren().addAll(
				  jdbcUrlAuthenticationLabel,jdbcAuthenticationUsername,jdbcAuthenticationPassword,newMenuItemEventHandler.jdbcAuthenticationUsernameTextField,newMenuItemEventHandler.jdbcAuthenticationPasswordField);
		   
		  connectionDetailsVbox.getChildren().add(connectionUsernamePasswordCredentialsGridPane);*/
		  
		return connectionDetailsVbox;
		
	}
	
	public  TreeItem<String> getDuckDBTreeItem(ConnectionPlaceHolder connectionPlaceHolder,ImageView imageDuckDBnode,ImageView imageDatbaseTablenode) {
		
		TreeItem<String> duckDBTreeItem = new TreeItem<String>(connectionPlaceHolder.getConnectionName(),imageDuckDBnode);
		
		// Tables
		TreeItem<String> duckDBTreeItemTables = new TreeItem<String>("Tables",imageDatbaseTablenode);
		duckDBTreeItemTables.addEventHandler(TreeItem.branchExpandedEvent(), event -> {
			
			System.out.println("Tables Expanded !!!");
			
		});
		duckDBTreeItemTables.addEventHandler(TreeItem.branchCollapsedEvent(), event -> {
			
			System.out.println("Tables Collapsed !!!");
		});
		duckDBTreeItemTables.getChildren().add(new TreeItem<String>("Loading.."));
					
		// Views
		TreeItem<String> duckDBTreeItemViews = new TreeItem<String>("Views");
		duckDBTreeItemViews.addEventHandler(TreeItem.branchExpandedEvent(), event -> {
			
			System.out.println("Views Expanded !!!");
			
		});
		duckDBTreeItemViews.addEventHandler(TreeItem.branchCollapsedEvent(), event -> {
			
			System.out.println("Views Collapsed !!!");
		});
		duckDBTreeItemViews.getChildren().add(new TreeItem<String>("Loading.."));
		
		// Procedures 
		TreeItem<String> duckDBTreeItemProcedures = new TreeItem<String>("Procedures");
		duckDBTreeItemProcedures.addEventHandler(TreeItem.branchExpandedEvent(), event -> {
			
			System.out.println("Procedures Expanded !!!");
		});
		duckDBTreeItemProcedures.addEventHandler(TreeItem.branchCollapsedEvent(), event -> {
			
			System.out.println("Procedures Collapsed !!!");
		});
		duckDBTreeItemProcedures.getChildren().add(new TreeItem<String>("Loading.."));
						
		
		duckDBTreeItem.getChildren().add(duckDBTreeItemTables);
		duckDBTreeItem.getChildren().add(duckDBTreeItemViews);
		duckDBTreeItem.getChildren().add(duckDBTreeItemProcedures);
		
		return duckDBTreeItem;
	}
}
