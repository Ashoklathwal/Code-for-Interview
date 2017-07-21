Node removeOutsideRange(Node root, int min, int max) {
	if(root == null)
		return null;
	if(root.data >= min && root.data <= max) {
		root.left = removeOutsideRange(root.left, min, max);
		root.right = removeOutsideRange(root.right, min, max);
		return root;
	}
	else if(root.data <= min) {
		return removeOutsideRange(root.right, min, max);
	}
	else {
		return removeOutsideRange(root.left, min, max);
	}
}