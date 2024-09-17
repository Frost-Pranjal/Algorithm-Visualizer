
package AlgoVis.BackTracking;

import AlgoVis.Model.ModelCell;

public class MazeGen {

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
        setBlock();
        setStack();
    }

    public ModelCell[] getBlock() {
        return block;
    }

    public void setBlock() {
        int h=519/cellSize,w=979/cellSize;
        block=new ModelCell[h*w];
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                getBlock()[(i*w)+j]=new ModelCell(j,i);
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(i-1 >= 0)
                    block[(i*w)+j].getNeighbours()[0]=getBlock()[((i-1)*w)+j];
                if(j+1 < w)
                    block[(i*w)+j].getNeighbours()[1]=getBlock()[(i*w)+j+1];
                if(i+1 < h)
                    block[(i*w)+j].getNeighbours()[2]=getBlock()[((i+1)*w)+j];
                if(j-1 >= 0)
                    block[(i*w)+j].getNeighbours()[3]=getBlock()[(i*w)+j-1];
            }
        }
    }

    public ModelCell[] getStack() {
        return stack;
    }

    public void setStack() {
        stack=new ModelCell[block.length];
    }

    public ModelCell getCurrent() {
        return current;
    }

    public void setCurrent(ModelCell current) {
        this.current = current;
    }
    public int cellSize;
    public ModelCell block[],stack[], current;
    
    public boolean exists(ModelCell a,int n)
    {
        int x=a.getX(), y=a.getY();
        return n==0&&x-1>=0 || n==1&&y-1>=0 || n==2&&x+1<979/cellSize || n==3&&y+1<519/cellSize;
    }
    
    public int available(ModelCell cell)
    {
        int n=4;
        for(int i=0;i<4;i++)
            if(cell.getNeighbours()[i]==null || cell.getNeighbours()[i].isVisited())
                n--;
        return n;
    }
    
    public void push(ModelCell item)
    {
        for(int i=stack.length-1;i>=0;i--)
        {
            if(stack[i]!=null)
                stack[i+1]=stack[i];
        }
        stack[0]=item;
    }
    
    public ModelCell pop()
    {
        ModelCell r=stack[0];
        for(int i=1;i<stack.length && stack[i-1]!=null;i++)
            stack[i-1]=stack[i];
        return r;
    }
    
    public int next(ModelCell cell, int s)
    {
        int open[]=new int[s];
        int count=0;
        for(int i=0;i<4;i++)
        {
            if(cell.getNeighbours()[i]==null || cell.getNeighbours()[i].isVisited())
                continue;
            open[count++]=i;
        }
        return open[(int)(Math.random()*s)];
    }
    
    public void gen(ModelCell current)
    {
        if(current==null)
            return;
        int open=available(current);
        current.setVisited(true);
        if(open!=0)
        {
            if(stack[0]!=null)
            {
                ModelCell prev=pop();
                push(prev);
            }
            int n=next(current, open);
            push(current);
            current.getWalls()[n]=false;
            current.getNeighbours()[n].getWalls()[(n+2)%4]=false;
            this.current=current.getNeighbours()[n];
        }
        else{
            this.current=pop();
        }
    }
    
    public MazeGen(int size){
        setCellSize(size);
    }
    
}
