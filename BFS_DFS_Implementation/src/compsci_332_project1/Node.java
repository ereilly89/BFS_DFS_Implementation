package compsci_332_project1;

import java.util.ArrayList;

public class Node {
    private String name;
    private boolean isVisited;
    private ArrayList<String> neighbors;
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setVisited(boolean newVisited){
        isVisited = newVisited;
    }
    
    public void setNeighbors(ArrayList<String> newNeighbors) {
    	neighbors = newNeighbors;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isVisited(){
        return isVisited;
    }
    
    public ArrayList getNeighbors(){
        return neighbors;
    }
    
    public Node(String name, boolean isVisiited, ArrayList<String> neighbors){
        super();
        this.name = name;
        this.isVisited = isVisited;
        this.neighbors = neighbors;
    }
    
    public Node(String name){
        super();
        this.name = name;
        this.isVisited = false;
        this.neighbors = neighbors;
    }
}
