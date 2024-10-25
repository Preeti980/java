
public class Practice {
  public static void main(String args[]){
    Pen p1 = new Pen();
    p1.setColor("Blue");
    System.out.println(p1.color);
    p1.setColor("Red");
    System.out.println(p1.color);
    p1.setTip(25);
    System.out.println(p1.tip);
  }
}
class Pen{ // by conventional class name started with capital latter
  //properties of pen class
  String color;
  int tip;
  // functions of pen class
  void setColor(String newColor){
color = newColor;
}
void setTip(int newTip){
  tip = newTip;
}
}
class Student{
  String name;
  int age;
  float percentage;

  void calPercentage(int phy, int chem, int math){
    percentage = (phy + chem + math)/3;
  }
}
