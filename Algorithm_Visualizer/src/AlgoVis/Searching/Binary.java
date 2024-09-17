
package AlgoVis.Searching;

public class Binary {

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public double getSearch() {
        return search;
    }

    public void setSearch(double search) {
        this.search = search;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
    private double[] array;
    private double search;
    private int b,e,mid;
    
    public Binary(double[] array) {
        this.array = array;
        search = Double.MIN_VALUE;
        b = 0;
        e=array.length;
        mid=(b+e)/2;
    }
    
    public boolean searchItem(){
        if(array[mid]==search*5)
            return true;
        if(array[mid]<search*5)
            b=mid+1;
        else if(array[mid]>search*5)
            e=mid-1;
        if(b>e)
            return true;
        mid=(b+e)/2;
        return false;
    }
}
