import java.util.*;

public class Problem_87 {
    static int directions[] = {0,1,2,3};

    // Maps alphabet and its corresponding node
    static Map<Character,Node> map = new HashMap<>();
    public static void main(String[] args){
        String[] rules = {"A N B","B NE C","C N A"};
        boolean bool = ValidateRules(rules);
        if(bool){
            System.out.println("Rules are valid");
        }
        else {
            System.out.println("Rules are not valid");
        }
    }

    // node stores char and 4 edges (NESW)
    public static class Node{
        char data;
        List<Set<Node>> edges = new ArrayList<>();
        public Node(char data) {
            this.data = data;
            for (int i=0;i<4;i++){
                edges.add(new HashSet<>());
            }
        }
    }

    private static boolean ValidateRules(String[] rules) {
        // Maps direction and corresponding integer
        Map<Character,Integer> DirNumber = new HashMap<>();
        DirNumber.put('N',0);
        DirNumber.put('E',1);
        DirNumber.put('W',2);
        DirNumber.put('S',3);

        for (String rule:rules){
            String[] rule_split = rule.split(" ");
            char fromchar =  rule_split[2].charAt(0);
            char tochar =  rule_split[0].charAt(0);
            // adding nodes if not present already;
            if(!map.containsKey(fromchar)){
                map.put(fromchar,new Node(fromchar));
            }
            if(!map.containsKey(tochar)){
                map.put(tochar,new Node(tochar));
            }
            // Finding from and to nodes
            Node fromNode = map.get(fromchar);
            Node toNode = map.get(tochar);
            // validation for all directions
            for(char Dir:rule_split[1].toCharArray()){
                int dir = DirNumber.get(Dir);
                if(!IsValid(fromNode,toNode,dir)){
                    return false;
                }
                else {
                    if(AddEdges(fromNode,toNode,dir)==false){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean AddEdges(Node fromNode, Node toNode, int dir) {
        int oppdir = FindOppDir(dir);
        // adding both edges corresponding to each other
        fromNode.edges.get(dir).add(toNode);
        toNode.edges.get(oppdir).add(fromNode);
        // for remaining edges of fromNode
        for (int dirvar:directions){
            if(dirvar!=dir){
                for (Node neighbourNode:fromNode.edges.get(dirvar)){
                    if(neighbourNode!=toNode){
                        if(IsValid(neighbourNode,toNode,dir)){
                            neighbourNode.edges.get(dir).add(toNode);
                            toNode.edges.get(oppdir).add(neighbourNode);
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean IsValid(Node fromNode, Node toNode, int dir) {
        int oppdir = FindOppDir(dir);
        if(fromNode.edges.get(oppdir).contains(toNode)){
            return false;
        }
        else if(toNode.edges.get(dir).contains(fromNode)){
            return false;
        }
        else {
            return true;
        }
    }

    private static int FindOppDir(int dir) {
        return (dir+2)%4;
    }
}
