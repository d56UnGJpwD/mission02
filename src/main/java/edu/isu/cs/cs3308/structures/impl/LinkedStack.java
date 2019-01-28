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
        if(element != null) {
            Node<E> old = first;
            first = new Node(element, old);
            size++;
        }
    }


    public E peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return first.getElement();
        }
    }

    public E pop(){
        if(isEmpty()){
            return null;
        }
        E value = first.getElement();
        first = first.next;
        size--;
        return value;
    }

    public Node<E> getFirst(){
        return first;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(first == null) {
            return true;
        }
        else{return false;}
    }

    public void transfer(Stack<E> to){
        if(to != null) {
            Node<E> current = first;
            while (current != null) {
                to.push(current.getElement());

                current = current.next;
                pop();
            }
        }
    }

    public void reverse(){
        if(size > 0)
        {
            Node<E> top = first;
            pop();
            reverse();

            addToBot(top);

        }
    }

    private void addToBot(Node<E> node){
        if(size == 0){
            push(node.getElement());
        }
        else{
            Node<E> top = first;
            pop();
            addToBot(top);
        }
    }

    public void merge(Stack<E> other){

        if(other != null){
            Stack<E> temp = other;
            temp.reverse();
            temp.transfer(this);


        }





    }


    public void printStack(){
        Node<E> current = first;
        while(current != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }
}
