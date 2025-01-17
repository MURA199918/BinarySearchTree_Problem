public class MyBinaryTree<k extends Comparable<k>> {
    private MyBinaryNode<k> root;

    public void add(k key){
        this.root = this.addRecursively(root,key);
    }

    private MyBinaryNode<k> addRecursively(MyBinaryNode<k> current, k key) {
        if(current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if(compareResult == 0) return current;
        if(compareResult < 0){
            current.left = addRecursively(current.left,key);
        }
        else{
            current.right = addRecursively(current.right,key);
        }
        return current;
    }
    
    public void Search(k key){
        this.root = this.SearchRecursively(root,key);
    }

    private MyBinaryNode<k> SearchRecursively(MyBinaryNode<k> current, k key) {
        if(current == null || current.key == key)
            return current;
        int compareResult = key.compareTo(current.key);
        if(compareResult == 0)  return current;
        if(compareResult < 0){
            return SearchRecursively(current.left,key);
        }
        else{
            return SearchRecursively(current.right,key);
        }
    }

    public int getSize(){
        return this.getSizeRecursive(root);
    }

    private int getSizeRecursive(MyBinaryNode<k> current) {
        return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
                                       + this.getSizeRecursive(current.right);
    }

}
