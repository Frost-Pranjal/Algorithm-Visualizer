
package AlgoVis.Model;

public class ModelCell {

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(boolean[] walls) {
        this.walls = walls;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ModelCell[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ModelCell[] neighbours) {
        this.neighbours = neighbours;
    }
    private int x;
    private int y;
    private boolean[] walls;
    private boolean visited;
    private ModelCell[] neighbours;
    
    public ModelCell(int x,int y)
    {
        this.x=x;
        this.y=y;
        walls=new boolean[]{true,true,true,true};
        visited=false;
        neighbours=new ModelCell[]{null,null,null,null};
    }
}
