# Rotating cubes
Rotating cubes using Java OpenGL.

## Descriptions of arguments when instancing the `DrawCube` class
When instancing the `DrawCube` class, you need to specify 8 arguments of type `float`:
* length of all 12 edges of the cube
* rotation speed of the cube on it self around the axis of direction `(1, 0, 0)` (i.e.: `x` axis)
* rotation speed of the cube on it self around the axis of direction `(0, 1, 0)` (i.e.: `y` axis)
* rotation speed of the cube on it self around the axis of direction `(0, 0, 1)` (i.e.: `z` axis)
* position of cube on `x` axis
* position of cube on `y` axis
* position of cube on `z` axis
* distance of the cube from the origin for the rotation around the origin in the plane `{z = 0}`
* rotation speed of the cube for the rotation around the origin in the plane `{z = 0}`

For example:
```Java
DrawCube cube = new DrawCube(.1f, 0, 2, 3, 0, 0, 0, .5f, 5);
```
instances a cube of length `0.1` that rotates around the origin at a distance of `0.5` from it and at a speed of `5`. The cube will also rotate on itself around the `y` axis at a speed of `2` and around the `z` axis at a speed of `3`.
