package hu.bme.aut.todolist.network;

public class NetworkConfig {
    public static final String ENDPOINT_ADDRESS = "https://api.trello.com/1/";
    public static final String API_KEY = "fd8daa0dff9f6892e4b2596de257b1a7";
    public static final String TOKEN = "c9be22f5e655546c5cdfd9b0223b22fc1c251a9dfc1605b80ebb35ec5b26f3d0";
    //The app uses the Trello REST API,
    // that sort the tasks to several boards and lists.
    //This app however is much more simple,
    // and puts all the cards in a specific list of a specific board.
    public static final String BOARD_ID = "5ea2887b0c003b045acc4b1e";
    public static final String LIST_ID = "5ea2887b7390b10b06656290";
}
