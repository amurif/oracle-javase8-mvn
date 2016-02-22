package recipe6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by O26 on 22/02/2016.
 */
public class BehaviorAsArgument extends Application {

    private Group root;

    public BehaviorAsArgument(){
        root = new Group();
    }

    public void run() {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello Lambda");
        Scene scene = new Scene(root, 300, 250);
        Button btn = new Button();
        Label message = new Label();
        btn.setLayoutX(60);
        btn.setLayoutY(80);
        btn.setText("Invoke Lambda Expression");
        btn.setOnAction((event) -> {
            message.setText("Lambda expression invoked!");
        });
        root.getChildren().add(btn);
        message.setLayoutX(300/2 - 90);
        message.setLayoutY(30);
        root.getChildren().add(message);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
