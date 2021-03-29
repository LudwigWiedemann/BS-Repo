package geschenkkatalog_Vorlage;

import java.io.IOException;
import java.util.List;
import geschenk.IGeschenk;
import util.Util;

public class Katalog implements IKatalog{

	private KatalogNode root;
	
	@Override
	public int add(KatalogEntry entry) {
		if (root == null) {
			root = new KatalogNode(entry);
			return root.elem.getAnzahl();
		}
		return addAfter(entry, root);
	}

	private int addAfter(KatalogEntry entry, KatalogNode node) {
		int compare = entry.compareTo(node.getElement());
		if (compare == 0) {
			node.elem.erhoeheAnzahl(entry.getAnzahl());
			return node.elem.getAnzahl();
//			return entry.getAnzahl();
		}
		if (compare > 0) {
			if (node.getRightNode() != null) return addAfter(entry, node.rightNode);
			node.setRightNode(entry);
			return entry.getAnzahl();
		}
		if (node.getLeftNode() != null) return addAfter(entry, node.leftNode);
		node.setLeftNode(entry);
//		return node.elem.getAnzahl();
		return entry.getAnzahl();
	}

	@Override
	public KatalogEntry search(IGeschenk geschenk) {
		KatalogEntry toSearch = new KatalogEntry(geschenk);
		return search(toSearch, root);
	}
	
	private KatalogEntry search(KatalogEntry toSearch, KatalogNode node) {
		if (node == null) return null;
		int compare = node.elem.compareTo(toSearch);
		if (compare == 0) return node.elem;
		if (compare < 0) {
			return search(toSearch, node.rightNode);
		}
		return search(toSearch, node.leftNode);
	}

	public void printDOTFile(String name) {
		try {
			Util.printDOTFile(name, root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String toString() {
		String myTree = "";
		return printTree(root, myTree);
	}
	
	private String printTree(KatalogNode node, String tree) {
		if (node.leftNode != null) {
			tree = printTree(node.leftNode, tree);
		}
		tree += "\n" + node.elem.getName();
		if (node.rightNode != null) {
			tree = printTree(node.rightNode, tree);
		}
		return tree;
	}

	
	@Override
	public String toStringReverse() {
		String myTree = "";
		return printTreeReverse(root,myTree);
	}
	
	private String printTreeReverse(KatalogNode node, String tree) {
		if (node.rightNode != null) {
			tree = printTreeReverse(node.rightNode, tree);
		}
		tree += "\n" + node.elem.getName();
		if (node.leftNode != null) {
			tree = printTreeReverse(node.leftNode, tree);
		}
		return tree;
	}

	@Override
	public int getGeschenkanzahl() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<KatalogEntry> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int remove(KatalogEntry entry) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class KatalogNode implements INode<KatalogEntry>{
		KatalogNode rightNode;
		KatalogNode leftNode;
		KatalogEntry elem;
		
		public KatalogNode (KatalogEntry elem) {
			this.elem = elem;
		}
		
		public INode<KatalogEntry> getRightNode() {
			return rightNode;
		}
		
		public void setRightNode(KatalogEntry entry) {
			rightNode = new KatalogNode(entry);
		}
		
		@Override
		public INode<KatalogEntry> getLeftNode() {
			return leftNode;
		}
		
		public void setLeftNode(KatalogEntry entry) {
			leftNode = new KatalogNode(entry);
		}
	
		@Override
		public KatalogEntry getElement() {
			return elem;
		}
		
		public void add(KatalogEntry entry) {
			if (this.elem.compareTo(entry) == 1) {
				
			}
		}
	}

}
