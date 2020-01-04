package One;

class Graphical{
	public double width;
	public double length;
	public double area;
	public double Perimeter;
	public double Inscribed_circle;
	public double Circumscribed_circle;
 
 
public double areaGraphical() {
	return area;
}
public double PerimeterGraphical() {
	return Perimeter;
}
public double Inscribed_circleGraghical(){
	return Inscribed_circle;
}
public double Circumscribed_circleGraghical(){
	return Circumscribed_circle;
}
}
 
class rectangle extends Graphical{
	public double areaGraghical() {
		area = width * length;
		return area;
	}
	public double PerimeterGraphical() {
		Perimeter = (width + length) * 2;
		return Perimeter;
	}
	public double Inscribed_circleGraghical() {
		if(width < length)
		{
			Inscribed_circle = width;
		}
		else
		{
			Inscribed_circle = length;
		}
		return Inscribed_circle;
	}
	public double Circumscribed_circleGraghical()
	{
		Circumscribed_circle = Math.sqrt(width*width + length*length)/2;
		return Circumscribed_circle;
	}
}
 
class Triangle extends Graphical{
	public double high;
	public double bottom;
	public double side;
	public double areaGraphical() {
		area = (bottom * high) / 2;
		return area;
	}
	public double PerimeterGraphical() {
		Perimeter = high + bottom + side;
		return Perimeter;
	}
	public double Inscribed_circleGraghical() {
		Inscribed_circle = 2* area /(high+bottom+side);
		return Inscribed_circle;
	}
	public double Circumscribed_circleGraghical() {
		Circumscribed_circle = high*bottom*side/(4*area);
		return Circumscribed_circle;
	}
}
 
class Circal extends Graphical{
	public double r;
	public double areaGraphical() {
		area = 3.14 * r * r;
		return area;
	}
	public double PerimeterGraphical() {
		Perimeter = 2 * 3.14 * r;
		return Perimeter;
	}
}
 
class RightTripzoid extends Graphical{
	public double top;
	public double high;
	public double bottom;
	public double tri;
	
	public double areaGraphical() {
		area = (top + bottom) * high / 2;
		return area;
	}
	public double PerimeterGraphical() {
		Perimeter = top + high + bottom + tri;
		return Perimeter;
	}
	public double Inscribed_circleGraghical() {
		Inscribed_circle = high/2;
		return Inscribed_circle;
	}
	public double Circumscribed_circleGraghical() {
		Circumscribed_circle = Math.sqrt(high*high + bottom*bottom)/2;
		return Circumscribed_circle;
	}
}
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle p1 = new rectangle();
		p1.width = 6;
		p1.length = 5;
		p1.areaGraghical();
		p1.PerimeterGraphical();
		p1.Inscribed_circleGraghical();
		p1.Circumscribed_circleGraghical();
		System.out.println("���ε����:"+p1.areaGraphical()+"\n���ε��ܳ�:"+p1.PerimeterGraphical()+"\n���ε�����Բ�뾶:"+p1.Inscribed_circleGraghical()+"\n���ε�����Բ�뾶��"+p1.Circumscribed_circleGraghical());
		Triangle p2 = new Triangle();
		p2.high = 6;
		p2.bottom = 8;
		p2.side = 9;
		p2.areaGraphical();
		p2.PerimeterGraphical();
		p2.Inscribed_circleGraghical();
		p2.Circumscribed_circleGraghical();
		System.out.println("�����ε����:"+p2.areaGraphical()+"\n�����ε��ܳ�:"+p2.PerimeterGraphical()+"\n�����ε�����Բ�뾶:"+p2.Inscribed_circleGraghical()+"\n�����ε�����Բ�뾶��"+p2.Circumscribed_circleGraghical());
		Circal p3 = new Circal();
		p3.r = 2.5;
		p3.areaGraphical();
		p3.PerimeterGraphical();
		System.out.println("Բ�ε����:"+p3.areaGraphical()+"\nԲ�ε��ܳ�:"+p3.PerimeterGraphical());
		RightTripzoid p4 = new RightTripzoid();
		p4.top = 3;
		p4.bottom = 4;
		p4.high = 5;
		p4.tri = 6;
		p4.areaGraphical();
		p4.PerimeterGraphical();
		p4.Inscribed_circleGraghical();
		p4.Circumscribed_circleGraghical();
		System.out.println("ֱ�����ε����:"+p4.areaGraphical()+"\nֱ�����ε��ܳ�:"+p4.PerimeterGraphical()+"\nֱ�����ε�����Բ�뾶:"+p4.Inscribed_circleGraghical()+"\nֱ�����ε�����Բ�뾶��"+p4.Circumscribed_circleGraghical());
	}
 
}

