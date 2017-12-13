import
java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * TODO
 * https://github.com/RealGamertime/Mario-Game/blob/master/Mario%20Redux/src/Main.java
 * https://github.com/account/organizations/newv
 * https://wiki.eclipse.org/Karaf_Remote_Management_with_Eclipse
 * WATCH THIS YOUTUBE PLAYLISTG FIRST - https://www.youtube.com/watch?v=z0S5Ded2IJY&list=PL513808FE7D9A5D68
 * THEN WATCH THIS SERIES - https://www.youtube.com/watch?v=0v56I5UWrYY&index=1&list=PL19F2453814E0E315
 */
public class Main {
	public static boolean fullScreen = false;
	public static String GAME_NAME = "Mario Redux";
	
	public static void main(String[] args)
	{
		initDisplay();
		gameLoop();
		cleanUp();
		
	}
	
	private static void gameLoop()
	{
		
		//Game Loop
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			Graphics.drawRect(56, 56, 336, 336, "Mario_Brick");
			//Graphics.drawRect(56, 56, 200, 50, 90);
			Display.update();
		}
	}
	
	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(0, 50, 255, 1);	
		glClear(GL_COLOR_BUFFER_BIT);
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
	}
	
	private static void cleanUp()
	{
		Display.destroy();
	}
	
	private static void initDisplay()
	{
		try
		{
			if(!fullScreen)
			{
			Display.setDisplayMode(new DisplayMode(1360, 720));
			Display.setResizable(true);
			}
			else
			{
				Display.setFullscreen(true);
			}
			Display.setTitle(GAME_NAME);
			Display.setVSyncEnabled(true);
			Display.create();
		}
		catch(LWJGLException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		initGL();
	}
}