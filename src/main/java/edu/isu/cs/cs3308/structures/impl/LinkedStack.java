package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {


    public class Node<E> {
        private E element;
        private Node<E> next;

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getElement(){
            return element;
        }

        public Node(E e, Node<E> next){
            this.element = e;
            this.next = next;
        }
    }


    private int size;
    private Node<E> first;

    public LinkedStack(){
        first = null;
        size = 0;
    }

    public void push(E element){
        Node<E> old = first;
        first = new Node(element, old);
    }


    public E peek(){
        return null;
    }

    public E pop(){
        return null;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        if(first == null) {
            return true;
        }
        else{return false;}
    }

    public void transfer(Stack<E> to){

    }

    public void reverse(){

    }

    public void merge(Stack<E> other){

    }

    public void printStack(){

    }
}
