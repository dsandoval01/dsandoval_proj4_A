import java.util.*;

public class BST{

	public BSTNode find(int k, BSTNode v){
		int rootVal = v.element;
		if(v == null){
			return null;
		}

		else if(rootVal>k){
			return find(k,v.left);
		}
//hiiiiiiiiiii
		else if(rootVal<k){
			return find(k, v.right);
		}

		else{
			return v;
		}
	}

	public void recInsert(int k, BSTNode v){
		if(k>v.element){
			if(v.right!=null){
				recInsert(k, v.right);
			}
			else if(k<= v.element){
				if(v.left!=null){
					recInsert(k, v.left);
				}
			}
			else{
				v.right = new BSTNode(null,k,null,v);
			}
			// else{
			// 	recInsert(k, root);
			//}
		}
	}

	public void insert(int k){
		if(root == null){
			root = new Node(k, null, null, null);
		}
		else{
			recInsert(k, root);
		}
	}

	public void replace(BSTNode v, BSTNode w){
		if(v==root){
			root=w;
		}else{
			if(v.parent.right=v){
				v.parent.right=w;
			}
			else{
				v.parent.left=w;
			}
		}
	}

	public void delete(int k){

	}

	public void preOrder(BSTNode v){
		System.out.println(v.element);
		if(v.left != null){
			preOrder(v.left);
		}
		else if(v.right != null){
			preOrder(v.right);
		}
	}

	public void inOrder(BSTNode v){
		System.out.println(v.left);
		inOrder(v.right);

	}

	public void postOrder(BSTNode v){
		if(v != null){
			postOrder(v.left);
			postOrder(v.right);
			System.out.println(v.element);
		}
	}
//helloooo
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = (BSTNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}  // end displayTree()

}