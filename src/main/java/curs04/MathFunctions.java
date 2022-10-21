package curs04;

public class MathFunctions {

        public static double computeVolume ( int vertex){ //Cube
            return Math.pow(vertex, 3); // same as: return vertex * vertex *vertex;
        }

        public static double computeVolume ( double radius){ // Sphere

            return ( 4.0 / 3.0 ) * Math.PI * Math.pow( radius, 3 );
        }

        public static double computeVolume (double Length, double Width, double pyramidHeight){ // Pyramid
            return ((Length * Width) * pyramidHeight) / 3;
        }

        public static double computeVolume (float Radius, float radius){ // Torus
            return ((Math.PI * Math.pow (radius, 2)) * (2 * Math.PI * Radius));
        }

        public static double computeVolume (float length, double width, double height){ // Rectangle
        return (length * width * height);
        }




        public static void main(String[] args) {
            int v = 5;
            System.out.println("The volume for a cube with vertex = " + v + " is " + computeVolume(v));

            double y = 7.14;
            System.out.println("The volume for a sphere with radius = " + y + " is " + computeVolume(y));

            double a = 8;
            double b = 5;
            double c = 15;
            System.out.println("The volume for a pyramid with pyramid height = " + c + " is " + computeVolume(a, b, c));

            float R = 13;
            float r = 2;
            System.out.println("The volume for a torus with radius = " + r + " is " + computeVolume(R, r));

            float  l = 8;
            double w = 5;
            double h = 15;
            System.out.println("The volume for a rectangle with the height = " + h + " is " + computeVolume(l, w, h));

        }
    }

