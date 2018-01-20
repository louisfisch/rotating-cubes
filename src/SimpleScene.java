import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.jogamp.opengl.*;
import com.jogamp.opengl.util.*;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;


public class SimpleScene {
    public static void main(String[] args) {
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(capabilities);

        Frame frame = new Frame("Rotating cubes");
        frame.setSize(700, 700);
        frame.add(canvas);
        frame.setVisible(true);

        // Draw the cubes
        DrawCube cube1 = new DrawCube(.1f, 0, 1, 0, 0, -.2f, 0, 0, 0);
        DrawCube cube2 = new DrawCube(.1f, 5, 0, 0, 0, .2f, 0, 0, 0);
        DrawCube cube3 = new DrawCube(.1f, 1, 1, 0, 0, 0, 0, .5f, 5);

        RenderCube renderCube = new RenderCube();

        renderCube.addCubeToList(cube1);
        renderCube.addCubeToList(cube2);
        renderCube.addCubeToList(cube3);

        canvas.addGLEventListener(renderCube);

        final FPSAnimator animator = new FPSAnimator(canvas, 30);
        
        // Start the animation
        animator.start();

        // Terminate the program when the window is asked to close
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
