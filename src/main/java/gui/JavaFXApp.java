package gui;

import cards.Card;
import cards.DeckIsEmptyException;
import game.GameSession;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
    static private final int MIN_WIDTH = 320;
    static private final int MIN_HEIGHT = 480;
    private static final Image cards = new Image("cards.png");
    private static final double cardImageWidth = cards.getWidth() / 13;
    private static final double cardImageHeight = cards.getHeight() / 4;

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Canvas canvas;
    private Button takeButton, passButton;
    private GameSession gameSession = new GameSession(0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Blackjack");

        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);

        takeButton = new Button("TAKE");
        passButton = new Button("PASS");

        canvas = new Canvas();


        rootLayout = new BorderPane();
        rootLayout.setCenter(canvas);
        rootLayout.setLeft(takeButton);
        rootLayout.setRight(passButton);

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private void drawCard(Card card, double offsetX, double offsetY, double width, double height) {
        canvas.getGraphicsContext2D().drawImage(
                cards,
                card.getValue().ordinal() * cardImageWidth,
                card.getSuit().ordinal() * cardImageHeight,
                cardImageWidth,
                cardImageHeight,
                offsetX,
                offsetY,
                width,
                height);
    }

    private void redrawCards() {
        double cardCanvasWidth = canvas.getWidth() / 5;
        double cardCanvasHeight = canvas.getHeight() / 2;

        double curX = 0;
        double curY = 0;

        for (Card card: gameSession.getCards(GameSession.Turn.PLAYER)) {
            drawCard(card, curX, curY, cardCanvasWidth, cardCanvasHeight);
            curX += cardCanvasWidth / 2;
        }

        curY += cardCanvasHeight;
        curX = 0;

        for (Card card: gameSession.getCards(GameSession.Turn.DEALER)) {
            drawCard(card, curX, curY, cardCanvasWidth, cardCanvasHeight);
            curX += cardCanvasWidth / 2;
        }
    }
}
