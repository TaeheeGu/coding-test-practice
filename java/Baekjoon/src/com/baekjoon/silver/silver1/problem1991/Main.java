package com.baekjoon.silver.silver1.problem1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			tree.createNode(split[0].charAt(0), split[1].charAt(0), split[2].charAt(0));
		}

		tree.result = new StringBuilder();
		
		tree.preOrder(tree.root);
		sb.append(tree.result.toString()).append("\n");

		tree.result = new StringBuilder();

		tree.inOrder(tree.root);
		sb.append(tree.result.toString()).append("\n");

		tree.result = new StringBuilder();

		tree.postOrder(tree.root);
		sb.append(tree.result.toString());

		out.write(sb.toString());
		out.close();
	}
}

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
	}
}

class Tree {
	public Node root;
	public StringBuilder result;

	public void createNode(char data, char leftData, char rightData) {
		if (root == null) { // 초기 상태 - 루트 노드 생성
			root = new Node(data);
			
			// 왼쪽 자식 값이 있는 경우, 노드 생성
			if (leftData == '.') {
				root.left = null;
			} else {
				root.left = new Node(leftData);
			}

			// 오른쪽 자식 값이 있는 경우, 노드 생성
			if (rightData == '.') {
				root.right = null;
			} else {
				root.right = new Node(rightData);
			}
		} 
		
		// 초기 상태가 아니라면, 루트 노드 생성 이후 만들어진 노드 중 입력할 노드를 찾아 해당 노드에 자식을 추가한다.
		else {
			searchNode(root, data, leftData, rightData);
		}
	}

	// 매개변수로 들어온 root 노드를 시작으로 data와 같은 값을 가진 node를 찾는다.
	// 찾을 때 까지 root 노드에서 왼쪽, 오른쪽 재궈적으로 탐색
	public void searchNode(Node node, char data, char leftData, char rightData) {
		
		// 도착한 노드가 null 이면 재귀 종료, 삽입할 노드를 찾을 수 없다.
		if (node == null) {
			return;
		}
		
		// 둘어갈 위치를 찾았다면
		else if (node.data == data) {
			
			// 왼쪽 자식 값이 있는 경우, 노드 생성
			if (leftData == '.') {
				node.left = null;
			} else {
				node.left = new Node(leftData);
			}

			// 오른쪽 자식 값이 있는 경우, 노드 생성
			if (rightData == '.') {
				node.right = null;
			} else {
				node.right = new Node(rightData);
			}
		}
		
		// 찾이 못한 상태에서 탐색할 노드가 남아 있다면
		else {
			searchNode(node.left, data, leftData, rightData);
			searchNode(node.right, data, leftData, rightData);
		}
	}

	// 전위순회 Preorder : Root -> Left -> Right
	public void preOrder(Node node) {

		if (node != null) {
			result.append(node.data);
//			System.out.print(node.data);

			if (node.left != null) {
				preOrder(node.left);
			}
			if (node.right != null) {
				preOrder(node.right);
			}
		}
	}

	// 중위순회 Inorder : Left -> Root -> Right
	public void inOrder(Node node) {

		if (node != null) {
			if (node.left != null) {
				inOrder(node.left);
			}
			result.append(node.data);
//			System.out.print(node.data);
			if (node.right != null) {
				inOrder(node.right);
			}
		}
	}

	// 후위순회 Postorder : Left -> Right -> Root
	public void postOrder(Node node) {
		
		if (node != null) {
			if (node.left != null) {
				postOrder(node.left);
			}
			if (node.right != null) {
				postOrder(node.right);
			}
			result.append(node.data);
//			System.out.print(node.data);
		}
	}
}