import com.jogamp.opengl.*;
import java.util.ArrayList;


public class RenderCube implements GLEventListener {
    ArrayList<Object3D> cubesList = new ArrayList<>();

    @Override
    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    public void render(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_FASTEST);

        // Handle depth
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);

        for (int i = 0; i < cubesList.size(); i++) {
            cubesList.get(i).draw(drawable);
        }
    }

    public void addCubeToList(Object3D cube) {
        cubesList.add(cube);
    }

    public void update() {
        for (int i = 0; i < cubesList.size(); i++) {
            cubesList.get(i).update();
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
    }
}
