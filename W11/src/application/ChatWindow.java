package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Application  {
	private TextArea textAreaMessage;
	private TextArea textAreaGroupChat;
	private String userInput = "";
	private String responseFromServer;
	private Socket socket;
	private BufferedReader inS;
	private PrintWriter outS;
	private Thread connection;

	@Override
	public void start(Stage ps) {

		try {
			StackPane stackPane = new StackPane();
			textAreaMessage = new TextArea();
			textAreaGroupChat = new TextArea();
			Label labelMessage = new Label("Message: ");
			textAreaGroupChat.setPrefRowCount(20);
			textAreaMessage.setPrefRowCount(4);

			VBox root = new VBox(5, textAreaGroupChat, labelMessage, textAreaMessage);
			VBox.setVgrow(textAreaMessage, Priority.NEVER);
			VBox.setVgrow(textAreaGroupChat, Priority.ALWAYS);
			root.setPadding(new Insets(5));
			textAreaGroupChat.setEditable(false);
			textAreaGroupChat.setWrapText(true);
			textAreaMessage.setWrapText(true);
			textAreaMessage.requestFocus();
			stackPane.getChildren().addAll(root);

			Scene scene = new Scene(stackPane, 350, 520);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ps.setTitle("Chat Window");
			ps.setScene(scene);
			ps.show();

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					textAreaMessage.setOnKeyPressed(new EventHandler<KeyEvent>() {

						public void handle(KeyEvent ke) {
							handleTextAreaMessageEntered(ke);
						}
					});
				}
			});

			connection = new Thread(() -> {
				try (Socket socket2 = new Socket("localhost", 5000)) {
					this.setSocket(socket2);
					inS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					outS = new PrintWriter(socket.getOutputStream(), true);
					do {
						responseFromServer = inS.readLine();
						System.out.print(responseFromServer);
					} while (!userInput.equals("exit"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			connection.start();

			// task.setOnSucceeded((SucceededEvent)->{});

		} catch (Exception a) {
			a.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	public String getTextAreaMessage() {
		return textAreaMessage.getText();
	}

	public void appendTextAreaGroupChat(String message) {
		textAreaGroupChat.appendText(message);
	}

	private void handleTextAreaMessageEntered(KeyEvent ke) {

		if (ke.getCode() == KeyCode.ENTER) {
			appendTextAreaGroupChat(textAreaMessage.getText() + "\n");
			userInput = textAreaMessage.getText();

			outS.println(textAreaMessage.getText());

			if (textAreaMessage.getText().equals("exit")) {
				Platform.exit();
			}
			textAreaMessage.clear();
			textAreaMessage.requestFocus();

		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	

}
