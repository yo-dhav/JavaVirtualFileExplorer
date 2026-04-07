<<<<<<< HEAD
 package com.esiea.pootd2.commands;
=======
package com.esiea.pootd2.commands;
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a

public class ClearCommand extends Command {

    /**
     * Constructor for clear command
     */
    public ClearCommand() {
        // no properties needed
    }

    /**
     * Execute the command
     * @return The escape code to clear the screen
     */
    @Override
    public String execute() {
        // ANSI escape code to clear the screen
        return "\033[H\033[2J";
    }
}
