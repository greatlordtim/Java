public class SolidTester {
       public static void main (String[] args) {
              // Cylinder 1
              Cylinder cyl1 = new Cylinder();
              int r1 = 34, h1 = 5;
              cyl1.SetRadius( r1 );
              cyl1.SetHeight( h1 );
              cyl1.CalcSurfaceArea();
              cyl1.CalcVolume();
              System.out.println("First Cylinder:");
              System.out.printf("\tradius\t= %4d\n", r1);
              System.out.printf("\theight\t= %4d\n", h1);
              System.out.printf("\tsurface area\t= %10.2f\n",
                            cyl1.GetSurfaceArea());
              System.out.printf("\tvolume\t\t= %10.2f\n\n",
                            cyl1.GetVolume());
              // Cylinder 2
              Cylinder cyl2 = new Cylinder();
              double r2 = 24.34, h2 = 12.32;
              cyl2.SetRadius( r2 );
              cyl2.SetHeight( h2 );
              cyl2.CalcSurfaceArea();
              cyl2.CalcVolume();
              System.out.println("Second Cylinder:");
              System.out.printf("\tradius\t= %6.2f\n", r2);
              System.out.printf("\theight\t= %6.2f\n", h2);
              System.out.printf("\tsurface area\t= %10.2f\n",
                            cyl2.GetSurfaceArea());
              System.out.printf("\tvolume\t\t= %10.2f\n\n",
                            cyl2.GetVolume());
       }
}
