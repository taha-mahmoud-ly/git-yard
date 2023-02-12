/**
 * this is a rewrite of zuul game adventure.
 * my method with this book is to rewrite  the code myself.
 * 
 * @author taha mahmoud
 * @version 11.2.2023
 */
public class Game2
{
    private Parser2 parser;
    private Room2 currentRoom;
    
    /**
     * kick the game and create the rooms
     */
    public Game2()
    {
        createRooms();
        parser = new Parser2();
    
        {
    
        }
    
    }
    
    /**
     * create rooms with exits
     */
    public void createRooms()
    {
        Room outside, theater, pub, lab, office;
        // create rooms
        
        outside = new Room2("out side the main enterence of the university");
        theater = new Room2("in a lecture theater");
        pub = new Room2("in the campus pub");
        lab = new Room2("in a computing lab");
        office = new Room2("in the computing admin office");
        
        // set exits
        
        outside.setExits(null, theater, lab, pub);
        theater.setExits(null, null, null, outside);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);
        pub.setExits(null, outside, null, null);
        
        //start the game out side
        currentRoom = outside;
    }
    
    /**
     * play
     */
    
    public void play()
    {
        printWlcome();
        
        boolean finished = false;
            while (!finished)
            {
                Command2 command = parser.getCommand();
                finished = processCommand(command);
            }
            System.out.println("Thankyou for playing, Goodbye");
            
            
    }
   
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null){
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null){
            System.out.print("east ");
        }
        if(currentRoom.southExit != null){
            System.out.print("south ");
        }
        if(currentRoom.westExit != null){
            System.out.print("west ");
        }
        System.out.println();
    
    





    }