package geschenkkatalog_Vorlage;

public interface INode<T extends Comparable<T>> {
	
	INode<T> getRightNode();
	
	INode<T> getLeftNode();
	
	T getElement();

}
