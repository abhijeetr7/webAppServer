package com.backend.webappserver.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webappserver.payload.Node;
import com.backend.webappserver.payload.Node1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * 
 * Tree to be created 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class ListToTree {

	public static void main(String[] args) {
		Node node6 = new Node("Six", "6", 5, 1, true);
		Node node1 = new Node("Five", "5", 4, 1, true);

		Node node2 = new Node("Four", "4", 3, 1, true);
		Node node3 = new Node("Two", "2", 1, 1, true);
		Node node4 = new Node("Three", "3", 2, 1, true);
		Node node5 = new Node("One", "1", null, 1, true);
		
		List<Node> nodes = new ArrayList<>();
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);

		
		
		createTree(nodes);
		

	}

	

	public static List<Node1> createTree1(List<Node1> nodes) {

		Map<Integer, Node1> mapTmp = new HashMap<>();

		// Save all nodes to a map
		for (Node1 current : nodes) {
			mapTmp.put((current.getId()), current);
//			mapTmp.put(current.getParentId(), current);
		}

		// loop and assign parent/child relationships
		for (Node1 current : nodes) {
			Integer parentId = current.getParentId();

			if (parentId != null) {
				Node1 parent = mapTmp.get(parentId);
				if (parent != null) {
					current.setParent(parent);
					parent.addChild(current);
					mapTmp.put(parentId, parent);
					mapTmp.put((current.getId()), current);
				}
			}

		}

		// get the root
		Node1 root1 = null;
		for (Node1 node1 : mapTmp.values()) {
			if (node1.getParent() == null) {
				root1 = node1;
				break;
			}
		}

		// List<Node> test = new ArrayList<>();
		// test.add(root);
		Gson g = new Gson();
		ObjectMapper Obj = new ObjectMapper();
		try {
			List<Node1> result1 = new ArrayList<>();
			result1.add(root1);
			// System.out.println(g.toJson(test));
			// List<Node> result = flatten(root);

			// get Oraganisation object as a json string
			String jsonStr = Obj.writeValueAsString(result1);
			// Displaying JSON String
			return result1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public static List<Node> createTree(List<Node> nodes) {

		Map<Integer, Node> mapTmp = new HashMap<>();

		// Save all nodes to a map
		for (Node current : nodes) {
			mapTmp.put(Integer.parseInt(current.getId()), current);
//			mapTmp.put(current.getParentId(), current);
		}

		// loop and assign parent/child relationships
		for (Node current : nodes) {
			Integer parentId = current.getParentId();

			if (parentId != null) {
				Node parent = mapTmp.get(parentId);
				if (parent != null) {
					current.setParent(parent);
					parent.addChild(current);
					mapTmp.put(parentId, parent);
					mapTmp.put(Integer.parseInt(current.getId()), current);
				}
			}

		}

		// get the root
		Node root = null;
		for (Node node : mapTmp.values()) {
			if (node.getParent() == null) {
				root = node;
				break;
			}
		}

		// List<Node> test = new ArrayList<>();
		// test.add(root);
		Gson g = new Gson();
		ObjectMapper Obj = new ObjectMapper();
		try {
			List<Node> result = new ArrayList<>();
			result.add(root);
			// System.out.println(g.toJson(test));
			// List<Node> result = flatten(root);

			// get Oraganisation object as a json string
			String jsonStr = Obj.writeValueAsString(result);
			// Displaying JSON String
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * . Flatten using a Deque - Double ended Queue
	 *
	 **/
	private static List<Node> flatten(Node node) {

		if (node == null) {
			return null;
		}

		List<Node> flatList = new ArrayList<>();

		Deque<Node> q = new ArrayDeque<>();
		q.addLast(node); // add the root

		while (!q.isEmpty()) { // Keep looping until all nodes are traversed
			Node n = q.removeLast();
			if (n.getParentId() == null) {
				flatList.add(new Node(n.getValue(), n.getId(), n.getParentId(), n.getChildren()));
				List<Node> children = n.getChildren();
				if (children != null) {
					for (Node child : children) {
						q.addLast(child);
					}
				}
			}
		}

		return flatList;
	}

}