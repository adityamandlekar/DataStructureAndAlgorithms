package nimahi.java.DAS.trees.node;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryNode {
	private int value;
	private int height;
	private BinaryNode left;
	private BinaryNode right;

	public int getHeight() {
		return height;
	}//end of method
	
	public void setHeight(int height) {
		this.height = height;
	}//end of method
	
	public int getValue() {
		return value;
	}//end of method

	public void setValue(int value) {
		this.value = value;
	}//end of method

	public BinaryNode getLeft() {
		return left;
	}//end of method

	public void setLeft(BinaryNode left) {
		this.left = left;
	}//end of method

	public BinaryNode getRight() {
		return right;
	}//end of method

	public void setRight(BinaryNode right) {
		this.right = right;
	}//end of method

	@Override
	public String toString() {
		return value + "";
	}//end of method

	public static class BinaryNodeWithParent {
		private int value;
		private BinaryNodeWithParent parent;
		private BinaryNodeWithParent left;
		private BinaryNodeWithParent right;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public BinaryNodeWithParent getParent() {
			return parent;
		}

		public void setParent(BinaryNodeWithParent parent) {
			this.parent = parent;
		}

		public BinaryNodeWithParent getLeft() {
			return left;
		}

		public void setLeft(BinaryNodeWithParent left) {
			this.left = left;
		}

		public BinaryNodeWithParent getRight() {
			return right;
		}

		public void setRight(BinaryNodeWithParent right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return value+"";
		}

	}

	public static class DoubleNode {
		private int value;
		private DoubleNode next;
		private DoubleNode prev;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public DoubleNode getNext() {
			return next;
		}

		public void setNext(DoubleNode next) {
			this.next = next;
		}

		public DoubleNode getPrev() {
			return prev;
		}

		public void setPrev(DoubleNode prev) {
			this.prev = prev;
		}

		@Override
		public String toString() {
			return  value + "";
		}

	}

	public static class GraphNode {
		private String name;
		private int index; //index is used to map this Node's name with index of Adjacency Matrix' cell#
		private ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		private boolean isVisited = false;
		private GraphNode parent;

		public GraphNode(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public ArrayList<GraphNode> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(ArrayList<GraphNode> neighbors) {
			this.neighbors = neighbors;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public GraphNode getParent() {
			return parent;
		}

		public void setParent(GraphNode parent) {
			this.parent = parent;
		}

		public GraphNode(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return  name ;
		}

	}

	public static class NumberOfPathsNode {

		int costToReachLastCell = 0;
		int costOfCurrentCell = 0;
		NumberOfPathsNode rightCell = null;
		NumberOfPathsNode downCell = null;
		int numberOfWaysToComeHereFromRightOrDown = 0;
		ArrayList<Integer> NumberOfWaysSatifyingDownCell = new ArrayList<Integer>();
		ArrayList<Integer> NumberOfWaysSatifyingRightCell = new ArrayList<Integer>();



		//Constructor
		public NumberOfPathsNode(int costOfCurrentCell, NumberOfPathsNode rightCell, NumberOfPathsNode DownCell, int costToReachLastCell) {
			this.costOfCurrentCell = costOfCurrentCell;
			this.rightCell = rightCell;
			this.downCell = DownCell;
			this.costToReachLastCell = costToReachLastCell;
		}




		//Getting numbers of ways to reach last cell from current cell
		public int getnumberOfWaysToReachLastCellFromHere() {
			int numberOfWaysToReachLastCellFromHere = 0;
			for(int i=0; i<NumberOfWaysSatifyingRightCell.size(); i++) {
				if(NumberOfWaysSatifyingRightCell.get(i) == costOfCurrentCell) {
					numberOfWaysToReachLastCellFromHere++;
				}
			}
			for(int i=0; i<NumberOfWaysSatifyingDownCell.size(); i++) {
				if(NumberOfWaysSatifyingDownCell.get(i) == costOfCurrentCell) {
					numberOfWaysToReachLastCellFromHere++;
				}
			}
			return numberOfWaysToReachLastCellFromHere;
		}


		//Calculate number ways
		public void setNumberOfWaysToComeHereFromRightOrDown() {

			numberOfWaysToComeHereFromRightOrDown = NumberOfWaysSatifyingDownCell.size() + NumberOfWaysSatifyingRightCell.size();
			System.out.println("numberOfWaysToComeHereFromRightOrDown: " + numberOfWaysToComeHereFromRightOrDown);
			for(int i=0; i<NumberOfWaysSatifyingDownCell.size();i++) {
				System.out.println("DownArray: " + NumberOfWaysSatifyingDownCell.get(i) + "  ");
			}

			for(int i=0; i<NumberOfWaysSatifyingRightCell.size();i++) {
				System.out.println("RightArray: " + NumberOfWaysSatifyingRightCell.get(i) + "  ");

			}

		}


		//Calculate number of ways to come here from Right cell
		public void calculateNumberOfWaysSatifyingRightCell(){
			if(rightCell == null) {
				return;
			}

			int sizeOfRightCellsRight = rightCell.NumberOfWaysSatifyingRightCell.size();
			int sizeOfRightCellsDown  = rightCell.NumberOfWaysSatifyingDownCell.size();

			for(int i=0; i<sizeOfRightCellsRight; i++) {
				if(rightCell.NumberOfWaysSatifyingRightCell.get(i) >= rightCell.costOfCurrentCell) {
					NumberOfWaysSatifyingRightCell.add(rightCell.NumberOfWaysSatifyingRightCell.get(i)-rightCell.costOfCurrentCell);
				}
			}//end of loop

			for(int i=0; i<sizeOfRightCellsDown; i++) {
				if(rightCell.NumberOfWaysSatifyingDownCell.get(i) >= rightCell.costOfCurrentCell) {
					NumberOfWaysSatifyingRightCell.add(rightCell.NumberOfWaysSatifyingDownCell.get(i)-rightCell.costOfCurrentCell);
				}
			}//end of loop
		}//end of method


		//Calculate number of ways to come here from Down cell
			public void calculateNumberOfWaysSatifyingDownCell(){
				if((downCell == null) && (rightCell == null)) { //Base case for last row and col
					NumberOfWaysSatifyingDownCell.add(costToReachLastCell);
				}

				if(downCell == null) {
					return;
				}

				int sizeOfDownCellsRight = downCell.NumberOfWaysSatifyingRightCell.size();
				int sizeOfDownCellsDown = downCell.NumberOfWaysSatifyingDownCell.size();

				for(int i=0; i<sizeOfDownCellsRight; i++) {
					if(downCell.NumberOfWaysSatifyingRightCell.get(i) >= downCell.costOfCurrentCell) {
						NumberOfWaysSatifyingDownCell.add(downCell.NumberOfWaysSatifyingRightCell.get(i)-downCell.costOfCurrentCell);
					}
				}//end of loop

				for(int i=0; i<sizeOfDownCellsDown; i++) {
					if(downCell.NumberOfWaysSatifyingDownCell.get(i) >= downCell.costOfCurrentCell) {
						NumberOfWaysSatifyingDownCell.add(downCell.NumberOfWaysSatifyingDownCell.get(i)-downCell.costOfCurrentCell);
					}
				}//end of loop
			}//end of method

	}//end of class

	public static class SingleNode {
		private int value;
		private SingleNode next;

	public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public SingleNode getNext() {
			return next;
		}

		public void setNext(SingleNode next) {
			this.next = next;
		}

	@Override
	public String toString() {
		return  value + "";
	}

	}

	public static class WeightedNode implements Comparable<WeightedNode> {
		public String name;

		private ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
		private HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
		private boolean isVisited = false;
		private WeightedNode parent;
		private int distance;
		//private DisjointSet set; //used in DisjointSet Algorithm

		public WeightedNode(String name) {
			this.name = name;
			distance = Integer.MAX_VALUE;
		}

		/*public DisjointSet getSet() {
			return set;
		}

		public void setSet(DisjointSet set) { //used in DisjointSet Algorithm
			this.set = set;
		}*/

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<WeightedNode> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(ArrayList<WeightedNode> neighbors) {
			this.neighbors = neighbors;
		}

		public HashMap<WeightedNode, Integer> getWeightMap() {
			return weightMap;
		}

		public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
			this.weightMap = weightMap;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public WeightedNode getParent() {
			return parent;
		}

		public void setParent(WeightedNode parent) {
			this.parent = parent;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(WeightedNode o) {
			return this.distance - o.distance;
		}

	}

	public static class WeightedNode2 implements Comparable<WeightedNode2> {
		public String name;

		private ArrayList<WeightedNode2> neighbors = new ArrayList<WeightedNode2>();
		private HashMap<WeightedNode2, Integer> weightMap = new HashMap<>();
		private boolean isVisited = false;
		private WeightedNode2 parent;
		private int distance;
		//private DisjointSet set;

		public WeightedNode2(String name) {
			this.name = name;
			distance = Integer.MAX_VALUE;
		}

		/*public DisjointSet getSet() {
			return set;
		}

		public void setSet(DisjointSet set) {
			this.set = set;
		}*/

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<WeightedNode2> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(ArrayList<WeightedNode2> neighbors) {
			this.neighbors = neighbors;
		}

		public HashMap<WeightedNode2, Integer> getWeightMap() {
			return weightMap;
		}

		public void setWeightMap(HashMap<WeightedNode2, Integer> weightMap) {
			this.weightMap = weightMap;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public WeightedNode2 getParent() {
			return parent;
		}

		public void setParent(WeightedNode2 parent) {
			this.parent = parent;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int compareTo(WeightedNode2 o) {
			return this.distance - o.distance;
		}

	}
}
