package fi.meucci;

public class App 
{
    public static void main( String[] args )
    {
        Serverstr server = new Serverstr();
        server.porta();
        while(true)
        {
            server.attendi();
            server.comunica();
        }
        
    }
}
