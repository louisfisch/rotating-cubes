import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import static java.lang.Math.*;


public class DrawCube extends Object3D {
    private float xInitRotAngle = 0;
    private float yInitRotAngle = 0;
    private float zInitRotAngle = 0;
    private float orbAngle = 0;

    private float x;
    private float xRotAngle;
    private float yRotAngle;
    private float zRotAngle;
    private float xTrans;
    private float yTrans;
    private float zTrans;
    private float orbDist;
    private float orbSpeed;

    public DrawCube(float x, float xRotAngle, float yRotAngle, float zRotAngle, float xTrans, float yTrans, float zTrans, float orbDist, float orbSpeed) {
        this.x = x;
        this.xRotAngle = xRotAngle;
        this.yRotAngle = yRotAngle;
        this.zRotAngle = zRotAngle;
        this.xTrans = xTrans;
        this.yTrans = yTrans;
        this.zTrans = zTrans;
        this.orbDist = orbDist;
        this.orbSpeed = orbSpeed;
    }

    public void draw(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Replace current matrix with the identity matrix
        gl.glLoadIdentity();

        // Push current matrix onto a stack
        gl.glPushMatrix();

        // Handle position by translating
        gl.glTranslatef(this.xTrans, this.yTrans, this.zTrans);

        // Handle cube's rotation in the plane {z = 0} around the origin at a distance of distRotCenter from the cube
        orbAngle = (orbAngle + this.orbSpeed) % 360f;
        float x = (float) cos(toRadians(orbAngle)) * this.orbDist;
        float y = (float) sin(toRadians(orbAngle)) * this.orbDist;
        gl.glTranslatef(x, y, 0);

        // Handle cube's rotation around its own axis
        // Define a rotation through angle xRotAngle about an axis direction (1, 0, 0) (i.e.: x axis)
        gl.glRotatef(this.xInitRotAngle, 1, 0, 0);
        // Define a rotation through angle xRotAngle about an axis direction (0, 1, 0) (i.e.: y axis)
        gl.glRotatef(this.yInitRotAngle, 0, 1, 0);
        // Define a rotation through angle xRotAngle about an axis direction (0, 0, 1) (i.e.: z axis)
        gl.glRotatef(this.zInitRotAngle, 0, 0, 1);

        // Start quadrilateral drawing
        gl.glBegin(GL2.GL_QUADS);

        // Back - red face
        gl.glColor3f(1, 0, 0);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, this.x, this.x);
        gl.glVertex3f(this.x, this.x, this.x);

        // Bottom - orange face
        gl.glColor3f(1, .5f, 0);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);

        // Left - blue face
        gl.glColor3f(0, 0, 1);
        gl.glVertex3f(-this.x, -this.x, this.x);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, this.x);

        // Right - violet face
        gl.glColor3f(1, 0, .5f);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(this.x, this.x, this.x);
        gl.glVertex3f(this.x, -this.x, this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);

        // Top - green face
        gl.glColor3f(0, 1, 0);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, this.x);
        gl.glVertex3f(this.x, this.x, this.x);

        // Front - yellow face
        gl.glColor3f(1, 1, 0);
        gl.glVertex3f(-this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, -this.x, -this.x);
        gl.glVertex3f(this.x, this.x, -this.x);
        gl.glVertex3f(-this.x, this.x, -this.x);

        // Stop quadrilateral drawing
        gl.glEnd();

        // Pull the top matrix off the stack
        gl.glPopMatrix();
    }

    public void update() {
        this.xInitRotAngle += this.xRotAngle;
        this.yInitRotAngle += this.yRotAngle;
        this.zInitRotAngle += this.zRotAngle;
    }
}
