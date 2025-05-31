import org.w3c.dom.Node;

import javax.swing.*;
import java.net.HttpRetryException;

public class Tree <T> {

    private Node root;

    public class Node{
        private Node parent;
        private T data;
        private ArrayList<Node> children;

        public Node(Node parent, T data, ArrayList<Node> children){
            this.parent = parent;
            this.data = data;
            this.children = children;
        }

        @Override
        public String toString(){
            if (this.data.toString() != null)
                return this.data.toString();
            return null;
        }
    }
    //constructor
    Tree(T data){
        root = new Node(null, data, new ArrayList<Node>(1));
    }
    //setters

    public Node add(Node parent, T element){
        Node child = new Node(parent, element, new ArrayList<Node>(1));
        parent.children.add(child);
        return child;
    }

    //accessors
    public Node getRoot(){
        return root;
    }
    public Node parent(Node child){
        return child.parent;
    }
    public ArrayList<Node> children(Node parent){
        if (parent.children != null)
            return parent.children;
        return null;
    }

    //query
    public boolean isInternal(Node node){
        if (node.children.isEmpty())
            return false;
        return true;
    }

    public boolean isExternal(Node node){
        if (node.children.isEmpty())
            return true;
        return false;
    }
    public boolean isRoot(Node node){
        if (node.parent == null)
            return true;
        return false;
    }

    //traversal methods
    public void printPreOrder(Node node){
        System.out.println(node);
        if (this.isInternal(node)){
            for (int i = 0; i < node.children.size(); i++){
                printPreOrder(node.children.get(i));
            }
        }
    }
}


