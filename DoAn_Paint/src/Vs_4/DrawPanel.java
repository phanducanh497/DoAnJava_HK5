package Vs_4;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
	
	private LinkedList<MyShape> myShapes; 
	private LinkedList<MyShape> clearedShapes;
	
	private int currentShapeType; 
    private MyShape currentShapeObject;
    private Color currentShapeColor; 
    private boolean currentShapeFilled;
    
    JLabel statusLabel;
    
    public DrawPanel(JLabel statusLabel) {
    	this.myShapes=new LinkedList<MyShape>();
    	clearedShapes=new LinkedList<MyShape>();
    	
    	currentShapeType=0;
    	currentShapeObject=null;
    	currentShapeColor=Color.BLACK;
    	currentShapeFilled=false;
    	
    	this.statusLabel=statusLabel;
    	
    	setLayout(new BorderLayout());//lay layout
    	setBackground(Color.WHITE);//mau 
    	add(statusLabel,BorderLayout.SOUTH);
    	
    	MouseHandler handler=new MouseHandler();
    	addMouseListener(handler);
    	addMouseMotionListener(handler);
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	//ve
    	ArrayList<MyShape> shapeArray=myShapes.getArray();
    	for(int counter=shapeArray.size()-1;counter>=0;counter--) {
    		shapeArray.get(counter).draw(g); 
    		}
    	
    	if(currentShapeObject!=null)
    		currentShapeObject.draw(g);
    	
    }
    
    public void setCrruentShapeType(int type)
    {
    	this.currentShapeType=type;   
    }
    
    public void setCurrentShapeColor(Color color) {
    	this.currentShapeColor=color;
    }
    
    public void setCurrentShapeFilled(boolean filled) {
    	this.currentShapeFilled=filled;
    }
    
    public void clearlastShape() {
    	if(!myShapes.isEmpty())
    	{
    		clearedShapes.addFront(myShapes.removeFront());
    		repaint();
    	}
    }
    
    public void redoLastShape() {
    	if(!clearedShapes.isEmpty())
    	{
    		myShapes.addFront(clearedShapes.removeFront());
    		repaint();
    	}
    }
    
    public void clearDrawing() {
    	myShapes.makeEmpty();
    	clearedShapes.makeEmpty();
    	repaint();
    }
    
    private class MouseHandler extends MouseAdapter{
    	public void mousePressed(MouseEvent event)
    	{
    		switch(currentShapeType)
    		{
    		case 0:{
    			currentShapeObject=new MyLine(event.getX(),event.getY(),
    										event.getX(),event.getY(),currentShapeColor);
    			break;
    			}
    		case 1:{
    			currentShapeObject=new MyRectangle(event.getX(),event.getY(),
    											event.getX(),event.getY(),currentShapeColor,currentShapeFilled);
    			break;
    		}
    		
    		case 2: {
    			currentShapeObject=new MyOval(event.getX(),event.getY(),
						event.getX(),event.getY(),currentShapeColor,currentShapeFilled);
    			break;
    		}
    		case 3: {
    			currentShapeObject=new MyPen(event.getX(),event.getY(),
    					event.getX(),event.getY(),currentShapeColor);
    		}
    	}
    }
    	public void mouseReleased(MouseEvent event) {
    		currentShapeObject.setX2(event.getX());
    		currentShapeObject.setY2(event.getY());
    		
    		myShapes.addFront(currentShapeObject);
    		
    		currentShapeObject=null;
    		clearedShapes.makeEmpty();
    		repaint();
    	}
    	
    	public void mouseMoved(MouseEvent event) {
    		statusLabel.setText(String.format("Toa do X:%d Y: %d",event.getX(),event.getY()));
    	}
	public void mouseDragged(MouseEvent event) {
		currentShapeObject.setX2(event.getX());
		currentShapeObject.setY2(event.getY());
		
		statusLabel.setText(String.format("Toa do: X: %d Y: %d", event.getX(),event.getY()));
		repaint();
	}	
	}
}
