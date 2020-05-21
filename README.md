# SimpleRayTracer
Author: Chris Caudill

Simple Ray Tracer built in java using https://raytracing.github.io/ and material from David Wolff's Computer Graphics class at PLU as references

If I were to break this project down into major tasks, this is how it would shake up:
- Define Utilities
- Make Renderer
- Use Rays to render image in orthographic projection
- Define and implement geometric objects to put in the scene
- Implement Perspective Projection
- Implement Materials and Ray Scattering


The current build has a memory leak, so scenes containing more than 50 or so objects may result in a StackOverflow Error.

In the future I plan to:
- Fix Stack Overflow Error
- Abstract with better design choices
- Add a UI
