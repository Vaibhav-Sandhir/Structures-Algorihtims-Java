import java.util.*;

public class WeightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label){
            this.label = label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this,to,weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }

        @Override
        public String toString(){
            return label;
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + "->" + to;
        }
    }

    private Map<String,Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);
    }

    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public List<String> getShortestPath(String from, String to){
        List<String> path = new ArrayList<>();
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        Map<Node, Integer> distances = new HashMap<>();
        for(Node node: nodes.values())
            distances.put(node,Integer.MAX_VALUE);
        distances.replace(fromNode,0);

        Map<Node, Node> previousNode = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new NodeEntry(fromNode,0));

        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            visited.add(current);

            for(Edge edge: current.getEdges()){
                if(visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to,newDistance);
                    previousNode.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNode.get(toNode);
        while(previous != null){
            stack.push(previous);
            previous = previousNode.get(previous);
        }

        while(!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    public void print() {
        for (Node node : nodes.values()) {
            List<Edge> edges = node.getEdges();
            if (!edges.isEmpty()) {
                System.out.println(node + " is connected to " + edges);
            }
        }
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();
        for(Node node: nodes.values()){
            if(!visited.contains(node) && hasCycle(node,null,visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){
        visited.add(node);

        for(Edge edge: node.getEdges()){
            if(edge.to == parent)
                continue;

            if(visited.contains(edge.to))
                return true;

            if(hasCycle(edge.to,node,visited))
                return true;
        }
        return false;
    }

    public WeightedGraph getMinimumSpanningTree(){
        WeightedGraph tree = new WeightedGraph();

        if(nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Node startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if(edges.isEmpty())
            return tree;

        while(tree.nodes.size() < nodes.size()){
            Edge minEdge = edges.remove();
            Node nextNode = minEdge.to;

            if(tree.containsNode(minEdge.to.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label,nextNode.label, minEdge.weight);

            for(Edge edge: nextNode.getEdges())
                if(!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }

        return tree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }
}
