package com.demo.basics;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BasicLinkedListQueue<E> implements Queue<E> {

	private static class Node<E> {
		public E data;
		public Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;

	@Override
	public boolean add(E e) {
		Node<E> node = new Node<E>(e, null);
		if (isEmpty()) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
		return true;
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove() {
		if (head == null) {
			throw new NoSuchElementException();
		}

		Node<E> currentHead = head;
		Node<E> newHead = head.next;
		head = newHead;
		return currentHead.data;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	// basic ones

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
