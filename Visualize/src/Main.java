import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Main extends Application {
	private Pane PANE;
	private Scene SCENE;
	private Path PATH = new Path();
	private LineTo L = new LineTo(501,501);
	private int[][] DIRECTIONS  = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private Button BUTTONA = new Button("Start");
	public static void main(String[] args) {
        launch(args);
    }
	public void PathCraft() {
		while((1001 > L.getX() && L.getX() >= 0) && (1001 > L.getY() && L.getY() >= 0)) {
		int r = (int)(Math.random() * 4);
		L = new LineTo(L.getX() + DIRECTIONS[r][0],L.getY() + DIRECTIONS[r][1]);
		PATH.getElements().add(L);
		//System.out.println(L.getX() + " " + L.getY());
		}
		System.out.println("Created");
		PATH.setStroke(Color.PURPLE);
		PANE.getChildren().add(PATH);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.setTitle("Visualization");
		PANE = new Pane();
		PANE.setStyle("-fx-background-color: black;");
		SCENE = new Scene(PANE, 1000, 1000);
		BUTTONA.setLayoutX(900);
		BUTTONA.setPrefHeight(50);
		BUTTONA.setPrefWidth(50);
		BUTTONA.setLayoutY(900);
		// _______________________________
		EventHandler<ActionEvent> EVENT = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				PATH = new Path();
				L = new LineTo(501,501);
				PANE.getChildren().clear();
				PANE.getChildren().add(BUTTONA);
				PATH.getElements().add(new MoveTo(500f,500f));
				PathCraft();
			}
			
		};
		BUTTONA.setOnAction(EVENT);
		//________________________________
		PANE.getChildren().add(BUTTONA);
		arg0.setScene(SCENE);
		arg0.getIcons().add(new Image(getClass().getResourceAsStream("./img/star.png")));		
		arg0.show();
	}

}
