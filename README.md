## Step 5: Flashing Shapes


### Input File:
All shapes have been updated to include whether or not they are flashing shapes as a true/false boolean value at the end of their normal input line.
For shapes that **do not** flash, this is the final value on their input line.
For shapes that **do** flash, this boolean value is followed by three integers, specifying the values of red, green, and blue respectively, of the shape's second colour.

##### Example of Input Changes:
###### Original Red Circle:
circle 250 250 -3 1 true 80 255 0 0 2000
###### Updated Red Circle (Not Flashing):
circle 250 250 -3 1 true 80 255 0 0 2000 false
###### Updated Red Circle (Flashing to Blue):
circle 250 250 -3 1 true 80 255 0 0 2000 true 0 0 255

------------
### Code Changes:

##### ClosedShape.java
Added a second constructor for ClosedShapes, that also takes a boolean isFlashing, and an additional Color (secondary colour).

Added a new method 'updateColour' which switches the active colour from the current colour of the shape, to the other specified colour, for shapes where isFlashing is true.


##### BouncingShapesWindow.java
Added 'lastTime' and 'currentTime' long variables, to store timestamps.

Added an 'updateShapeColours' method that calls the 'updateColour' method for all objects in the activeShapes queue.

Added an if statement to the 'onTime' method, to call the 'updateShapeColours' method every two seconds.


##### ReadShapeFile.java
Updated all of the shape-specific read-shape methods to call the new shape constructor for all shapes loaded, where isFlashing is true.
