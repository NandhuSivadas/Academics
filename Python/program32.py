from Graphics import Rectangle,Circle
from Graphics.DGraphics import cuboid,sphere
l=int(input('enter the length of rectangle'))
b=int(input('enter the breadth of rectangle'))
h=c=int(input('enter the height of cuboid'))

Rectangle.area(l,b)
Rectangle.perimeter(l,b)
cuboid.area(l,c,h)
cuboid.volume(l,c,h)

r=int(input('enter the radius'))
Circle.area(r)
Circle.perimeter(r)
sphere.area(r)
sphere.volume(r)

