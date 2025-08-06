import java.util.*;

public class Kruskal {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        char[] ch=new char[V];
        System.out.print("Cities: ");
        for(int i=0;i<V;i++){
            ch[i]=sc.next().charAt(0);
        }
        Arrays.sort(ch);
        int min=(int)(ch[0]);
        List<Edge> l=new ArrayList<>();
        System.out.println("No of Edge: ");
        int ed=sc.nextInt();
        for(int i=0;i<ed;i++){
            char a=sc.next().charAt(0);
            char b=sc.next().charAt(0);
            int w=sc.nextInt();
            l.add(new Edge(a,b,w));
        }
        l.sort(Comparator.comparingInt(a->a.weigh));
        DisjointSet d=new DisjointSet(V);
        int sum=0;
        System.out.println("Selected Edges in MST: ");
        for(Edge g:l){
            if(d.union(g.src,g.dest,min)){
                System.out.println(g.src+" - "+g.dest+" ( "+g.weigh+" )");
                sum+=g.weigh;
            }
        }
        System.out.println("Minimum Cost of Spanning Tree: "+sum);

    }
}
class Edge{
    char src,dest;
    int weigh;
    Edge(char s,char d,int w){
        this.src=s;
        this.dest=d;
        this.weigh=w;
    }
}
class DisjointSet{
    int[] parent;
    DisjointSet(int v){
        parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }
    boolean union(char a,char b,int x){
        int i=(int)a-x;
        int j=(int)b-x;
        int a1=find(i);
        int b1=find(j);
        if(a1==b1){
            return false;
        }
        parent[a1]=b1;
        return true;
    }
}
