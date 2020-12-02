package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
        stage.show();
        imageLayout();
    }
    public void imageLayout(){
        ImageView imageView = new ImageView("baseImage.png");
        imageView.setFitHeight(450);
        imageView.setFitWidth(450);
        imageView.setPreserveRatio(true);
        Button button = new Button("Browse");
        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());
            if(file != null){
                Image image = new Image("file:" + file.getAbsolutePath());
                imageView.setImage(image);
            }
        });

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(imageView, button);

        stage.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
